package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by uira on 12/11/16.
 */

public class BuscaBellManFord implements InterfaceBuscaEmGrafo {

    private GrafoController controller;
    private Grafo grafo;
    private ArrayList<Integer> custos;
    private ArrayList<Vertice> anteriores;
    private Vertice chegada;
    private int tamanho;


    public BuscaBellManFord(GrafoController controller){
        this.controller = controller;
        grafo = Grafo.getInstance();

    }

    @Override
    public ArrayList<Aresta> buscar(Vertice partida, Vertice chegada) {
        this.chegada = chegada;
        int i;
        ArrayList<Aresta> arestas = grafo.getArestas();
        iniciar(partida);

        for(i = 1; i < tamanho - 1; i++){
            for (Aresta aresta: arestas){
                    relaxarAresta(aresta.getA(), aresta.getB(), aresta.getCusto());
            }
        }
        for(Aresta aresta: arestas){
            if(custos.get(aresta.getA().getId()) + aresta.getCusto() < custos.get(aresta.getB().getId())){
                return null; //erro;
            }
        }
        return recuperarCaminho();
    }

    private ArrayList<Aresta> recuperarCaminho() {
        ArrayList<Vertice> caminho = new ArrayList<>();

        Vertice anterior = chegada;
        do {
            caminho.add(0, anterior);
            anterior = anteriores.get(anterior.getId());
        }while(anterior != null);

        return controller.getArestasFromVertices(caminho);
    }

    private void relaxarAresta(Vertice A, Vertice B, int custo) {
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
        }
    }

    private void iniciar(Vertice partida) {
        tamanho = grafo.countVertices();

        custos = new ArrayList();
        anteriores = new ArrayList();

        int i;
        for(i = 0; i < tamanho; i++){
            custos.add(Integer.MAX_VALUE);
            anteriores.add(null);
        }
        custos.set(partida.getId(), 0);
    }
}
