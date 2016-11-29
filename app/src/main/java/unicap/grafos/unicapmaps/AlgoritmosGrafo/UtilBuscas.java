package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import java.util.ArrayList;
import java.util.Collections;

import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by uira on 27/11/16.
 */

class UtilBuscas {

    static void inicializar (ArrayList<Vertice> anteriores, ArrayList<Integer> custos){
        Grafo grafo = Grafo.getInstance();
        int tamanhoGrafo = grafo.countVertices(), i;
        for (i = 0; i < tamanhoGrafo; i++) {
            anteriores.add(null);
            custos.add(Integer.MAX_VALUE);
        }
    }

    static void inicializar (ArrayList<Vertice> anteriores){
        Grafo grafo = Grafo.getInstance();
        int tamanhoGrafo = grafo.countVertices(), i;
        for (i = 0; i < tamanhoGrafo; i++) {
            anteriores.add(null);
        }
    }

    static int acharDistancia(GrafoController controller, Vertice node, Vertice alvo) {
        Aresta aresta;
        aresta = controller.getArestaFromVertices(node,alvo);
        return aresta.getCusto();
    }

    static ArrayList<Vertice> varrerAnteriores(ArrayList<Vertice> anteriores, Vertice partida, Vertice chegada){
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

    static boolean relaxarAresta(ArrayList<Integer> custos, Vertice A, Vertice B, int custo) {
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
            return true;
        } else{
            return false;
        }
    }
}
