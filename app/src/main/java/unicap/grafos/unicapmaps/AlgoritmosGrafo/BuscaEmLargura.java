package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by Cais Automação on 11/11/2016. project UnicapMaps
 */
public class BuscaEmLargura implements InterfaceBuscaEmGrafo {

    private GrafoController controller;
    private Grafo grafo;

    public BuscaEmLargura(GrafoController controller) {
        grafo = Grafo.getInstance();
        this.controller = controller;
    }

    @Override
    public ArrayList<Aresta> buscar (Vertice partida,Vertice chegada){

        Vertice current;
        Queue<Vertice> fila = new LinkedList();
        ArrayList<Vertice> visitados = new ArrayList();
        ArrayList<Vertice> anteriores = new ArrayList();

        UtilBuscas.inicializar(anteriores);
        fila.add(partida);

        while(!fila.isEmpty()){
            current = fila.poll();
            visitados.add(current);

            if(current == chegada){
                break;
            }

            for(Vertice adjAtual: current.getAdjacentes()){
                if(!visitados.contains(adjAtual) && !fila.contains(adjAtual)){
                    fila.add(adjAtual);
                    anteriores.set(adjAtual.getId(), current);
                }
            }
        }

        ArrayList<Vertice> caminhoFinal = UtilBuscas.varrerAnteriores(anteriores, partida, chegada);
        return controller.getArestasFromVertices(caminhoFinal);
    }

}