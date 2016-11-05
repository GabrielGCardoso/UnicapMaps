package unicap.grafos.unicapmaps.controller;


import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Stack;

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
    //pega proximo vertice nao visitado
    public Vertice getVeticeProx(Vertice vAT,ArrayList<Boolean> visitados){
        int i,tam = vAT.getAdjacentes().size();
        ArrayList<Vertice> vertices=vAT.getAdjacentes();

        for(i=0;i<tam;i++) {
            vAT=vertices.get(i);
            if (visitados.get(vAT.getId())==false)
                return vAT;
        }
        if(visitados.get(vAT.getId())==false)
            return vAT;
        return null;
    }
    //incia o array de boolean com false
    public void iniciar(ArrayList<Boolean>visitados){
        int i;
        for(i=0;i<grafo.countVertices();i++){visitados.add(i,false);}
    }
    /*Metodo para transformar o stack em arraylist aresta
    /*Está parecido com o outro metodo se quiser pode mudar*/
    public ArrayList<Aresta> BuscaEmProfundidade(Vertice partida, Vertice chegada) {
        int i;
        Vertice atual,prox;
        ArrayList<Aresta>arestas=new ArrayList<>();
        Stack<Vertice>vertices;
        vertices=MetodoBuscaEmProfundidade(partida, chegada);
        for(i=0;i<vertices.size()-1;i++){
            atual=vertices.get(i);
            prox=vertices.get(i+1);
            arestas.add(getArestaFromVertices(atual,prox));
        }
        return arestas;
    }
    //Metodo da busca
    public Stack<Vertice> MetodoBuscaEmProfundidade(Vertice partida, Vertice chegada) {
        boolean flag=false;
        Vertice verticeAtual,verticeProximo;
        Stack<Vertice> verticesDoCaminho= new Stack<>();
        ArrayList<Boolean> visitado= new ArrayList<>();
        iniciar(visitado);

        verticeAtual=partida;

        verticesDoCaminho.push(verticeAtual);//adiciona no caminho
        visitado.set(verticeAtual.getId(),true);//foi visitado

        while (!verticesDoCaminho.isEmpty())
        {
            verticeProximo=getVeticeProx(verticeAtual,visitado);//pega proximo vertice
            if(verticeProximo==null){
                if(flag==false) {
                    verticeProximo = verticesDoCaminho.peek();
                    flag = true;
                }
                else {
                    verticesDoCaminho.pop();//remove
                    verticeProximo = verticesDoCaminho.peek();//recebe ultimo
                    verticeAtual = verticeProximo;
                    flag = false;
                }
            }else if(verticeProximo==chegada){
                verticesDoCaminho.push(verticeProximo);
                return verticesDoCaminho;
            }else{
                verticeAtual=verticeProximo;
                visitado.set(verticeAtual.getId(),true);
                verticesDoCaminho.push(verticeAtual);
            }
        }
        return null;
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
            coordenadas.add(aresta.getCoordTrajeto());
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

    public void logArestas(){
        String TAG = "ARESTA: ";
        ArrayList<Aresta> arestas = grafo.getArestas();
        for(Aresta atual: arestas){
            //if(atual.getA() != atual.getB()) {
            Log.i(TAG, "id:"+ atual.getId() + " (" + atual.getA().getId() + " -> " + atual.getB().getId() +")");
            //}
        }
        TAG.getClass();
    }

    public ArrayList<Vertice> buscaDijkstra(Vertice vInicial, Vertice vFinal){
        /*int menorCusto;
        int custoAcumulado = 0;
        ArrayList<Aresta> caminho = new ArrayList<>();
        Aresta menorAresta;
        while(true) {
            if(vInicial == vFinal){
                return caminho;
            }
            ArrayList<Aresta> arestasAdjacentes;
            arestasAdjacentes = vInicial.getArestas();
            if(arestasAdjacentes != null){
                menorCusto = arestasAdjacentes.get(0).getCusto();
                int idAresta = arestasAdjacentes.get(0).getId();
                for(Aresta atual: arestasAdjacentes){
                    if(atual.getCusto() < menorCusto){
                        menorCusto = atual.getCusto();
                        idAresta = atual.getId();
                    }
                }
                menorAresta = grafo.getAresta(idAresta);
                vInicial = menorAresta.getB();
                caminho.add(menorAresta);
                custoAcumulado += menorCusto;
            }else{
                return null;
            }
        }
        */
        return null;
    }

    public ArrayList<Vertice> buscaLargura(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Vertice> buscaProfundidade(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Vertice> buscaEstrela(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Vertice> buscaGulosa(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public void exibirGrafoCompleto(ImageView arestaView, ArestaPathView pathView) {
        ArrayList<ArrayList<Coordenadas>> coordenadas = new ArrayList<>();
        ArrayList<Aresta> arestas = grafo.getArestas();
        ArrayList<ArrayList<Coordenadas>> coordTemp = new ArrayList<>();
        int cor;
        for(Aresta atual : arestas){
            cor = Color.BLUE;
            coordenadas.add(atual.getCoordTrajeto());
            pathView.addPath(coordenadas, cor);
            coordenadas.clear();
        }
        for(Aresta atual : arestas){
            cor = Color.RED;
            if(atual.getA() == atual.getB()){
                pathView.addCircle(atual.getA().getCoordenadas().getX(), atual.getA().getCoordenadas().getY(), cor);
            }
        }

        arestaView.setImageBitmap(pathView.getBitmap());
    }

    public void exibirCaminho(ImageView arestaView, ArestaPathView pathView, ArrayList<Aresta> arestas, int cor) {
        ArrayList<ArrayList<Coordenadas>> coordenadas = new ArrayList<>();
        Vertice vInicial = arestas.get(0).getA();
        Vertice vFinal = arestas.get(arestas.size()-1).getB();

        for(Aresta atual : arestas){
            coordenadas.add(atual.getCoordTrajeto());
        }
        pathView.addPath(coordenadas, cor);


        pathView.addCircle(vInicial.getCoordenadas().getX(), vInicial.getCoordenadas().getY(), Color.BLACK);
        pathView.addCircle(vFinal.getCoordenadas().getX(), vFinal.getCoordenadas().getY(), Color.BLUE);


        arestaView.setImageBitmap(pathView.getBitmap());
    }
}