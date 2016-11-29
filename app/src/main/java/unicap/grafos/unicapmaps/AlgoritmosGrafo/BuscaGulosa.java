package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;


public class BuscaGulosa implements InterfaceBuscaEmGrafo {
    private GrafoController controller;
    private Grafo grafo;

    public BuscaGulosa(GrafoController controller) {
        this.controller = controller;
        grafo = Grafo.getInstance();
    }

    @Override
    public ArrayList<Aresta> buscar(Vertice partida, Vertice chegada) {
        ArrayList<Vertice> visitados = new ArrayList<>();
        ArrayList<Vertice> caminho = new ArrayList();
        ArrayList<Vertice> adjacentesPermitidos = new ArrayList<>();
        ArrayList<Vertice> anteriores = new ArrayList<>();
        Queue<Vertice> fila = new LinkedList<>();

        UtilBuscas.inicializar(anteriores);
        fila.add(partida);

        Vertice v, menorVertice, volta;

        while(!fila.isEmpty()){
            v = fila.poll();
            visitados.add(v);

            if(v == chegada){
                break;
            }

            adjacentesPermitidos.addAll(v.getAdjacentes());
            adjacentesPermitidos.removeAll(visitados);

            if(adjacentesPermitidos.isEmpty()){
                volta = anteriores.get(v.getId());
                visitados.remove(volta);
                fila.add(volta);
            } else{
                menorVertice = encontrarMenor(v, adjacentesPermitidos);
                anteriores.set(menorVertice.getId(), v);
                fila.add(menorVertice);
            }
            adjacentesPermitidos.clear();
        }

        caminho = UtilBuscas.varrerAnteriores(anteriores, partida, chegada);

        return controller.getArestasFromVertices(caminho);
    }


    private Vertice encontrarMenor(Vertice v, ArrayList<Vertice> adjacentes) {
        Vertice menor = adjacentes.get(0);
        int menorCusto, custoAtual;

        menorCusto = Integer.MAX_VALUE;

        for(Vertice adj: adjacentes){
            custoAtual = UtilBuscas.acharDistancia(controller, v, adj);
            if(custoAtual < menorCusto){
                menorCusto = custoAtual;
                menor = adj;
            }
        }

        return menor;
    }


}