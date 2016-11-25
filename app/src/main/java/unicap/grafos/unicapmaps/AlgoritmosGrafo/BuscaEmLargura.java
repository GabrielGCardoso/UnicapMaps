package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by Cais Automação on 11/11/2016. project UnicapMaps
 */
public class BuscaEmLargura implements InterfaceBuscaEmGrafo {

    private GrafoController controller;

    public BuscaEmLargura(GrafoController controller) {
        this.controller = controller;
    }

    public ArrayList<Aresta> buscar (Vertice inicio,Vertice fim){

        Vertice current, proximoVertice;
        ArrayList<Vertice> prox = new ArrayList<>();
        ArrayList<Boolean> visitados = new ArrayList<>();
        initArrayList(visitados);

        //fila
        ArrayList<Vertice> caminho = new ArrayList<>();

        current = inicio;
        caminho.add(current);
        visitados.set(current.getId(), true);

        while(!caminho.isEmpty()){
            prox.addAll(getProximosVertices(current, visitados, prox));

            // simulando uma fila
            proximoVertice = prox.get(0);

            if(proximoVertice == null || proximoVertice.getId() == fim.getId()){
                caminho.add(current);
                return controller.getArestasFromVertices(caminho);
            }else{
                //removendo para simular fila
                prox.remove(0);

                caminho.add(current);
                visitados.set(current.getId(), true);
                current = proximoVertice;
            }
        }

        return controller.getArestasFromVertices(caminho);
    }


    private ArrayList<Vertice> getProximosVertices(Vertice current, ArrayList<Boolean> visitados, ArrayList<Vertice> proximos){
        ArrayList<Vertice> ret = new ArrayList<>();
        ArrayList<Vertice> adj = current.getAdjacentes();

        for(int i = 0; i<adj.size(); i++){
            Vertice v = adj.get(i);
            // se ele nao foi visitado ou nao esta na lista de proximos
            if(visitados.get(v.getId()) == false && !proximos.contains(v)){
                ret.add(v);
            }
        }

        return ret;
    }

    private void initArrayList(ArrayList<Boolean> visitados){
        for(int i = 0; i < controller.getTotalVertices(); i++){
            visitados.add(i, false);
        }
    }

}