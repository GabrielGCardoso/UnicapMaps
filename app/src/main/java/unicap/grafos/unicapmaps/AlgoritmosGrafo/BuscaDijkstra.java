package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

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
        ArrayList<Vertice> retorno;
        anteriores = new ArrayList();
        Vertice u;
        custos = new ArrayList();
        inicializar(anteriores,custos);
        custos.set(partida.getId(),0);
        fila.add(partida);

        while (!fila.isEmpty()) {
            u = fila.get(0);
            fila.remove(0);

            for (Vertice adjacente : u.getAdjacentes()){
                if(relaxarAresta(u,adjacente,acharDistancia(u,adjacente))) {
                    fila.add(adjacente);
                }
            }
        }
        retorno = varrerAnteriores(partida,chegada);
        return controller.getArestasFromVertices(retorno);
    }

    private ArrayList<Vertice> varrerAnteriores(Vertice partida,Vertice chegada){
        ArrayList<Vertice> caminho = new ArrayList();
        Vertice temp = chegada;
        while(temp != partida){
            caminho.add(temp);
            temp = anteriores.get(temp.getId());
        }
        caminho.add(partida);
        Collections.reverse(caminho);
        return caminho;
    }

    private boolean relaxarAresta(Vertice A, Vertice B, int custo) {
        int idA, idB, novoCusto;
        idA = A.getId();
        idB = B.getId();
        if(custos.get(idA) == Integer.MAX_VALUE){
            novoCusto = custos.get(idA);
        } else{
            novoCusto = custos.get(idA) + custo;
        }
        if(novoCusto < custos.get(idB)){
            custos.set(idB, novoCusto);
            anteriores.set(idB, A);
            return true;
        } else{
            return false;
        }
    }


    private void inicializar (ArrayList<Vertice> anteriores, ArrayList<Integer> custo){
        int tamanhoGrafo = grafo.countVertices(), i;
        for (i = 0; i < tamanhoGrafo; i++) {
            anteriores.add(null);
            custo.add(Integer.MAX_VALUE);
        }
    }


    private int acharDistancia(Vertice node, Vertice alvo) {
        Aresta aresta;
        aresta = controller.getArestaFromVertices(node,alvo);
        return aresta.getCusto();
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