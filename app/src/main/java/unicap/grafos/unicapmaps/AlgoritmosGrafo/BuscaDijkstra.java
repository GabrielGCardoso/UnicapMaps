package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import java.util.ArrayList;
import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by Cais Automação on 11/11/2016. project UnicapMaps
 */
public class BuscaDijkstra implements InterfaceBuscaEmGrafo {

    private GrafoController controller;
    private Grafo grafo;
    private ArrayList<Integer> custos;
    private ArrayList<Vertice> anteriores;

    public BuscaDijkstra(GrafoController controller) {
        this.controller = controller;
        grafo = Grafo.getInstance();
    }

    @Override
    public ArrayList<Aresta> buscar(Vertice partida, Vertice chegada) {
        ArrayOrdenado fila = new ArrayOrdenado();
        int custoAtual;
        ArrayList<Vertice> caminho;
        anteriores = new ArrayList();
        Vertice u;
        custos = new ArrayList();
        UtilBuscas.inicializar(anteriores,custos);
        custos.set(partida.getId(),0);
        fila.add(partida);

        while (!fila.isEmpty()) {
            u = fila.get(0);
            fila.remove(0);

            if(u == chegada){
                break;
            }

            for (Vertice adjacente : u.getAdjacentes()){
                custoAtual = UtilBuscas.acharDistancia(controller, u,adjacente);
                if(UtilBuscas.relaxarAresta(custos, u, adjacente, custoAtual)) {
                    anteriores.set(adjacente.getId(), u);
                    fila.add(adjacente);
                }
            }
        }
        caminho = UtilBuscas.varrerAnteriores(anteriores, partida,chegada);
        return controller.getArestasFromVertices(caminho);
    }

    private class ArrayOrdenado extends ArrayList<Vertice>{
        public ArrayOrdenado() {
            super();
        }

        @Override
        public boolean add(Vertice novo) {
            Vertice verticeTemp;
            if(isEmpty()){
                return super.add(novo);
            }
            else{
                for (int i = 0; i < size();i++){
                    verticeTemp = grafo.getVertice(i);
                    if(custos.get(novo.getId()) < custos.get(verticeTemp.getId())){
                        super.add(i,novo);
                        return true;
                    }
                }
                return super.add(novo);
            }
        }
    }
}