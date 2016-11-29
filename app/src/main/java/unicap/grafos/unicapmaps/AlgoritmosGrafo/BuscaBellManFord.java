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
        ArrayList<Vertice> caminho;
        custos = new ArrayList();
        anteriores = new ArrayList();
        UtilBuscas.inicializar(anteriores, custos);
        custos.set(partida.getId(), 0);
        tamanho = grafo.countVertices();

        for(i = 1; i < tamanho - 1; i++){
            for (Aresta aresta: arestas){
                if(UtilBuscas.relaxarAresta(custos, aresta.getA(), aresta.getB(), aresta.getCusto())){
                    anteriores.set(aresta.getB().getId(), aresta.getA());
                }
            }
        }
        for(Aresta aresta: arestas){
            if(custos.get(aresta.getA().getId()) + aresta.getCusto() < custos.get(aresta.getB().getId())){
                return null; //erro;
            }
        }
        caminho = UtilBuscas.varrerAnteriores(anteriores, partida, chegada);
        return controller.getArestasFromVertices(caminho);
    }

}
