package unicap.grafos.unicapmaps.controller;


import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import unicap.grafos.unicapmaps.AlgoritmosGrafo.FactoryBuscas;
import unicap.grafos.unicapmaps.AlgoritmosGrafo.InterfaceBuscaEmGrafo;
import unicap.grafos.unicapmaps.dao.InfoBlocos;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Coordenadas;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;
import unicap.grafos.unicapmaps.view.ArestaPathView;

/**
 * Created by Cais Automação on 06/10/2016. project UnicapMaps
 */

public class GrafoController {

    private Grafo grafo;

    public GrafoController(){
        grafo = Grafo.getInstance();
    }

    public ArrayList<Aresta> buscar(int idVerticeInicial, int idVerticeFinal, String nomeBusca) {
        Vertice partida = grafo.getVertice(idVerticeInicial);
        Vertice chegada = grafo.getVertice(idVerticeFinal);

        if(partida == null || chegada == null){
            return null;
        }
        if(partida == chegada){
            return new ArrayList<>();
        }

        InterfaceBuscaEmGrafo metodoBusca = FactoryBuscas.getInstance(this, nomeBusca);
        if(metodoBusca == null){
            return null;
        }

        return metodoBusca.buscar(partida, chegada);
    }

    public StringBuilder exibirArestas( ArrayList<Aresta> arestas) {
        StringBuilder lista = new StringBuilder();
        if(arestas == null) {
            arestas = grafo.getArestas();
        }
        for (Aresta aresta : arestas) {
            lista.append(aresta.getA().getId());
            lista.append(" -> ");
            lista.append(aresta.getB().getId());
            lista.append('\n');
        }
        return lista;
    }

    public ArrayList<Aresta> getArestasFromVertices(List vertices) {
        ArrayList<Aresta> arestas = new ArrayList<>();
        Vertice atual, prox;
        int i;
        for(i = 0; i < vertices.size() - 1; i++){
            atual = ((Vertice) vertices.get(i));
            prox = ((Vertice) vertices.get(i + 1));
            arestas.add(getArestaFromVertices(atual,prox));
        }

        return arestas;
    }

    public ArrayList<ArrayList<Coordenadas>> buscarCoordenadas(ArrayList<Integer> idsVertices) {
        ArrayList<ArrayList<Coordenadas>> coordenadas = new ArrayList<>();
        ArrayList<Aresta> arestas = new ArrayList<>();
        int i;
        for(i = 0; i < idsVertices.size() - 1; i++){
            Vertice vA = grafo.getVertice(idsVertices.get(i));
            Vertice vB = grafo.getVertice(idsVertices.get(i+1));
            arestas.add(getArestaFromVertices(vA,vB));
        }
        for(Aresta aresta: arestas){
            coordenadas.add(aresta.getCoordenadas());
        }
        return coordenadas;

    }

    public Aresta getArestaFromVertices(Vertice A, Vertice B){
        Aresta aresta = null;
        ArrayList<Vertice> adjacentes = A.getAdjacentes();
        if(adjacentes.contains(B)){
            ArrayList<Aresta> arestas = A.getArestas();
            for(Aresta atual: arestas){
                if(atual.getB() == B){
                    aresta = atual;
                    break;
                }
            }
        } else{
            //exceção
            return null;
        }
        return aresta;
    }

    public void logArestas(){ //metodo pra debug
        String TAG = "ARESTA: ";
        ArrayList<Aresta> arestas = grafo.getArestas();
        int i = 0;
        Aresta atual1, atual2;
        Vertice A;
        Vertice B;
        String nomeA;
        String nomeB;
        char a;
        char b;
        //for(Aresta atual: arestas){
        for(i = 0; i< arestas.size()/2; i++){
            atual1 = arestas.get(i);
            atual2 = arestas.get(i+47);
            A = atual1.getA();
            B = atual1.getB();
            nomeA = A.getNome();
            nomeB = B.getNome();
            a = nomeA.charAt(nomeA.length()-1);
            b = nomeB.charAt(nomeB.length()-1);

            //if(atual.getA() != atual.getB()) {
            //Log.i(TAG, "id:"+ atual.getId() + " (" + atual.getA().getId() + " -> " + atual.getB().getId() +")");
            //Log.i(TAG, "id:"+ atual.getId() + " (" + atual.getA().getNome() + " -> " + atual.getB().getNome() +")");

            Log.i(TAG, "trajetos.add(new Trajeto("+ A.getId() +", "+ B.getId() +", "+ a +"_"+ b +"));");

            A = atual2.getA();
            B = atual2.getB();
            nomeA = A.getNome();
            nomeB = B.getNome();
            a = nomeA.charAt(nomeA.length()-1);
            b = nomeB.charAt(nomeB.length()-1);

            Log.i(TAG, "trajetos.add(new Trajeto("+ A.getId() +", "+ B.getId() +", "+ a +"_"+ b +"));");

            ///trajetos.add(new Trajeto(0, 1, A_B));
            //}
        }
        //TAG.getClass();
    }

    public int calcularDistancia(ArrayList<Aresta> caminho){
        int distancia = 0;
        for(Aresta atual: caminho){
            distancia += atual.getCusto();
        }
        return distancia;
    }

    public void exibirGrafoCompleto(ImageView arestaView, ArestaPathView pathView, boolean arestasSimples) {
        ArrayList<ArrayList<Coordenadas>> coordenadas = new ArrayList<>();
        ArrayList<Aresta> arestas = grafo.getArestas();
        int cor;
        if(arestasSimples){
            cor = Color.BLACK;
        } else{
            cor = Color.BLUE;
        }

        for(Aresta atual : arestas){
            if(arestasSimples){
                cor = Color.BLACK;
                ArrayList<Coordenadas> coordSimples = new ArrayList<>();
                coordSimples.add(atual.getA().getCoordenadas());
                coordSimples.add(atual.getB().getCoordenadas());
                coordenadas.add(coordSimples);
            } else{
                coordenadas.add(atual.getCoordenadas());
            }
            pathView.addPath(coordenadas, cor);
            coordenadas.clear();
        }

        for(Aresta atual : arestas){
            cor = Color.RED;
            if(atual.getA() == atual.getB()){
                pathView.addCircle(atual.getA().getCoordenadas().getX(), atual.getA().getCoordenadas().getY(), cor, 5);
            }
        }
        arestaView.setImageBitmap(pathView.getBitmap());
    }

    public void colorirVertices(ArrayList<ArrayList> verticesComCores, final ImageView arestaView, final ArestaPathView pathView) {
        Vertice vertice;

        ArrayList<Vertice> verticesOrdenados = verticesComCores.get(0);
        ArrayList<Integer> coresOrdenadas = verticesComCores.get(1);
        int i, cor;
        final Handler handler = new Handler();
        int tempo = 500;

        //primeiro deixa todos os vertices pretos
        for(Vertice v: verticesOrdenados){
            pathView.addCircle(v.getCoordenadas().getX(), v.getCoordenadas().getY(), Color.BLACK, 8);
            arestaView.setImageBitmap(pathView.getBitmap());
        }

        //colorir cada vértice na ordem das cores esolhidas no algoritmo
        for(i = 0; i < verticesOrdenados.size(); i++){
            vertice = verticesOrdenados.get(i);
            cor = coresOrdenadas.get(i);
            final int finalCor = cor;
            final Vertice finalVertice = vertice;

            //coloração com delay de 500ms entre cada vertice
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    pathView.addCircle(finalVertice.getCoordenadas().getX(), finalVertice.getCoordenadas().getY(), finalCor, 9);
                    arestaView.setImageBitmap(pathView.getBitmap());
                }
            }, tempo);
            tempo += 500;
        }

    }

    public void exibirCaminho(ImageView arestaView, ArestaPathView pathView, ArrayList<Aresta> arestas, int cor) {
        ArrayList<ArrayList<Coordenadas>> coordenadas = new ArrayList<>();
        Vertice vInicial = arestas.get(0).getA();
        Vertice vFinal = arestas.get(arestas.size()-1).getB();

        for(Aresta atual : arestas){
            coordenadas.add(atual.getCoordenadas());
        }
        pathView.addPath(coordenadas, cor);

        pathView.addCircle(vInicial.getCoordenadas().getX(), vInicial.getCoordenadas().getY(), Color.BLACK, 5);
        pathView.addCircle(vFinal.getCoordenadas().getX(), vFinal.getCoordenadas().getY(), Color.BLUE, 5);

        arestaView.setImageBitmap(pathView.getBitmap());
    }

    public void exibirCaminho(ImageView arestaView, ArestaPathView pathView, Vertice vertice) {
        pathView.addCircle(vertice.getCoordenadas().getX(), vertice.getCoordenadas().getY(), Color.BLUE, 5);
        arestaView.setImageBitmap(pathView.getBitmap());
    }

    public int getTotalVertices() {
        return grafo.countVertices();
    }

    public ArrayList<String[]> getInfoBlocos(){
        InfoBlocos infoBlocos = new InfoBlocos();
        return infoBlocos.getInfoBlocos();
    }

}