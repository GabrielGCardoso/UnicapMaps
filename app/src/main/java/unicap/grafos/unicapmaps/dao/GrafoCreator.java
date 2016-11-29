package unicap.grafos.unicapmaps.dao;
import java.util.ArrayList;

import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Coordenadas;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Trajeto;
import unicap.grafos.unicapmaps.model.Vertice;
import unicap.grafos.unicapmaps.util.Util;

/**
 * Created by Cais Automação on 10/11/2016. project UnicapMaps
 */

public class GrafoCreator {

    private Grafo grafo;
    private int matrizAdjacencias[][];
    private int coordenadas[][];
    private int grauMatriz;
    private int coordenadasComplementares[][][];
    private String nomesBlocos[];
    private ArrayList<Trajeto> trajetos;

    private GrafoController grafoController;

    GrafoCreator(){
        grafoController = new GrafoController();
    }

    void construirGrafo(){
        grafo = Grafo.getInstance();

        carregarDados();
        criarVertices();
        estabelecerAdjacencias();
        configCoordArestas();
        espelharGrafo();
        atribuirTrajetos();
    }

    private void atribuirTrajetos() {
        Vertice A, B;
        Aresta aresta;
        for(Trajeto trajeto: trajetos){
            A = grafo.getVertice(trajeto.getIdA());
            B = grafo.getVertice(trajeto.getIdB());
            aresta = grafoController.getArestaFromVertices(A, B);
            aresta.setDescricao(trajeto.getDescricao());
        }
    }

    private void carregarDados() {
        matrizAdjacencias = Dados.getMatrizAdjacencias();
        coordenadas = Dados.getCoordenadasVertices();
        coordenadasComplementares = Dados.getCoordenadasComplementares();
        nomesBlocos = InfoBlocos.getNomesBlocos();
        grauMatriz = matrizAdjacencias.length;
        trajetos = DadosTrajetosArestas.getTrajetos();
    }


    private void criarVertices(){
        //criar vértices
        int id;

        for(id = 0; id < grauMatriz; id++){
            Vertice novo = new Vertice(id);
            Coordenadas ponto = new Coordenadas();
            ponto.setX(coordenadas[id][0]);
            ponto.setY(coordenadas[id][1]);
            novo.setCoordenadas(ponto);
            novo.setNome(nomesBlocos[id]);

            grafo.addVertice(novo);
        }
    }

    private void estabelecerAdjacencias() {
        int i;
        int id;
        Vertice adj;
        Aresta aresta;

        //verifica cada vertice se tem adjacencias, a partir da matriz de adjacencias
        for(Vertice atual: grafo.getVertices()){
            id = atual.getId();

            for(i = 0; i < grauMatriz; i++){
                if(matrizAdjacencias[id][i] == 1){ //se tiver adjacencia, o "i" é o id do vértice adjacente
                    //busca o vertice pelo id "i" e adiciona como adjacente no Vertice atual
                    adj = grafo.getVertice(i);
                    atual.addAdjacente(adj);

                    //cria aresta direcionada e adiciona tanto no grafo quanto no vertice
                    aresta = grafo.addAresta(atual, adj);
                    atual.addAresta(aresta);
                }
            }
        }
    }

    private void configCoordArestas(){
        int i = 0, custoTotal = 0, x1, x2, y1, y2;
        int k, tamanho;
        Coordenadas p;
        ArrayList<Coordenadas> pontos;
        for(Aresta aresta: grafo.getArestas()){

            //primeira coordenada
            p = aresta.getA().getCoordenadas();
            aresta.addCoord(p.getX(), p.getY());

            //coordenadas do meio
            tamanho = coordenadasComplementares[i].length;
            for(k = 0; k < tamanho; k++) {
                aresta.addCoord(coordenadasComplementares[i][k][0], coordenadasComplementares[i][k][1]);
            }

            //ultima coordenada
            p = aresta.getB().getCoordenadas();
            aresta.addCoord(p.getX(), p.getY());

            //calcular os custos
            pontos = aresta.getCoordenadas();
            for(k = 1; k < pontos.size(); k++){
                x1 = pontos.get(k-1).getX();
                y1 = pontos.get(k-1).getY();
                x2 = pontos.get(k).getX();
                y2 = pontos.get(k).getY();
                custoTotal += Util.calculaDistancia(x1, y1, x2, y2);
            }
            aresta.setCusto(custoTotal);

            custoTotal = 0;
            i++;
        }
    }


    private void espelharGrafo(){
        int i, tamanho;
        Vertice A, B;
        tamanho = grafo.getArestas().size();
        Aresta aresta, novaAresta;
        for(i = 0; i < tamanho; i++){
            aresta = grafo.getAresta(i);
            A = aresta.getA();
            B = aresta.getB();

            if(A != B){
                B.addAdjacenteOrdenado(A);
                novaAresta = grafo.addAresta(B, A);
                B.addAresta(novaAresta);
                ArrayList<Coordenadas> coordenadasInvertidas = inverterCoordenadas(aresta);
                novaAresta.setCoordenadas(coordenadasInvertidas);
                novaAresta.setCusto(aresta.getCusto());
            }
        }
    }

    private ArrayList<Coordenadas> inverterCoordenadas(Aresta aresta){
        ArrayList<Coordenadas> coordenadasOriginais = aresta.getCoordenadas();
        ArrayList<Coordenadas> coordenadasInvertidas = new ArrayList<>();

        int i;
        int tamanho = coordenadasOriginais.size() - 1;

        for(i = tamanho; i >= 0; i--){
            coordenadasInvertidas.add(coordenadasOriginais.get(i));
        }
        return coordenadasInvertidas;
    }

    public Grafo getGrafo() {
        return grafo;
    }
}
