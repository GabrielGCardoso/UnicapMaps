package unicap.grafos.unicapmaps.dao;

import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Coordenadas;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by Cais Automação on 06/10/2016. project Unicap Maps
 */
public class GrafoDao {

    private Grafo grafo;
    private int matrizAdjacencias[][];
    private int coordenadas[][];
    private int grauMatriz;
    private int coordenadasComplementares[][][];
    private ArrayList<String> nomesBlocos;


    public GrafoDao() {
        matrizAdjacencias = Dados.getMatrizAdjacencias();
        coordenadas = Dados.getCoordenadasVertices();
        grauMatriz = matrizAdjacencias[0].length;
        coordenadasComplementares = Dados.getCoordenadasComplementares();
        nomesBlocos = Dados.getNomesBlocos();
    }

    public void montarGrafo(){
        grafo = Grafo.getInstance();
        criarVertices();
        estabelecerAdjacencias();
        configArestas();
    }

    private void estabelecerAdjacencias() {
        int i;
        int id;
        Vertice adj;
        Aresta aresta;

        //verifica cada vertice se tem adjacencias, a partir da matriz de adjacencias
        for(Vertice atual: grafo.getVertices()){
            id = atual.getId();
            //atual.addAdjacente(atual);  //caso considerar laços, descomentar essa linha
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

    private void criarVertices(){
        //criar vértices
        int i;

        for(i = 0; i < grauMatriz; i++){
            Vertice novo = new Vertice(i);
            Coordenadas ponto = new Coordenadas();
            ponto.setX(coordenadas[i][0]);
            ponto.setY(coordenadas[i][1]);
            novo.setCoordenadas(ponto);
            novo.setNome(nomeBlocos.get(i));
            //novo.setDescricao(descricoes[i]);

            grafo.addVertice(novo);
        }
    }

    private void configArestas(){
        int i = 0;
        int k, tamanho;

        for(Aresta aresta: grafo.getArestas()){
            Coordenadas p;
            p = aresta.getA().getCoordenadas();
            aresta.addCoord(p.getX(), p.getY());
            /*
            inserir aqui as coordenadas meio
            */
            tamanho = coordenadasComplementares[i].length;
            for(k = 0; k < tamanho; k++) {
                aresta.addCoord(coordenadasComplementares[i][k][0], coordenadasComplementares[i][k][1]);
            }


            p = aresta.getB().getCoordenadas();
            aresta.addCoord(p.getX(), p.getY());
            i++;
        }
    }






}

