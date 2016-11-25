package unicap.grafos.unicapmaps.model;

import java.util.ArrayList;

/**
 * Created by Cais Automação on 06/10/2016. project Unicap Maps
 */
public class Vertice {
    private int id;
    private String nome;
    private String descricao;
    private ArrayList<Aresta> arestas = null;
    private ArrayList<Vertice> adjacentes = null;
    private Coordenadas coordenadas;

    public Vertice(int id) {
        this.id = id;
        arestas = new ArrayList<>();
        adjacentes = new ArrayList<>();
    }
    public ArrayList<Aresta> getArestas(){
        return arestas;
    }

    public void addAdjacente(Vertice novoAdj) {
        adjacentes.add(novoAdj);
    }

    public void addAdjacenteOrdenado(Vertice novoAdj){
        int posicao = 0;
        for(Vertice atual: adjacentes){
            if(novoAdj.getId() < atual.getId()){
                posicao = adjacentes.indexOf(atual);
                break;
            }
        }
        adjacentes.add(posicao, novoAdj);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addAresta(Aresta aresta) {
        arestas.add(aresta);
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public ArrayList<Vertice> getAdjacentes() {
        return adjacentes;
    }

}
