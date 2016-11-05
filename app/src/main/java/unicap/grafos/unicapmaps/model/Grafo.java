package unicap.grafos.unicapmaps.model;

import java.util.ArrayList;

/**
 * Created by Cais Automação on 06/10/2016. project UnicapMaps
 */

public class Grafo {
    private ArrayList<Vertice> vertices = null;
    private ArrayList<Aresta> arestas = null;

    private static Grafo grafo = null;

    private Grafo() {
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
    }

    public static Grafo getInstance(){
        if(grafo == null){
            grafo = new Grafo();
        }
        return grafo;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public Vertice getVertice(int idVertice) {
        Vertice busca = null;
        if(idVertice < vertices.size() && idVertice >= 0) {
            busca = vertices.get(idVertice);
        }
        return busca;
    }

    public void addVertice(Vertice novoVertice) {
        vertices.add(novoVertice);
    }

    public Aresta addAresta(Vertice v1, Vertice v2) {
        Aresta novaAresta = new Aresta(v1, v2);
        novaAresta.setId(arestas.size());
        arestas.add(novaAresta);
        return novaAresta;
    }

    public int countVertices() {
        return vertices.size();
    }

    public int countArestas() {
        return arestas.size();
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public Aresta getAresta(int idAresta) {
        Aresta busca = null;
        if(idAresta < arestas.size() && idAresta >= 0) {
            busca = arestas.get(idAresta);
        }
        return busca;
    }
}
