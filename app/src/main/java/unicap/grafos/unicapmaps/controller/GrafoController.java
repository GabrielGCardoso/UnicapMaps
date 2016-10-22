package unicap.grafos.unicapmaps.controller;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;
import unicap.grafos.unicapmaps.view.ArestaView;

import unicap.grafos.unicapmaps.view.ArestaView;
import unicap.grafos.unicapmaps.view.ArestaView;
/**
 * Created by Cais Automação on 06/10/2016. project UnicapMaps
 */

public class GrafoController {

    private Grafo grafo;

    public GrafoController(){
        Grafo.getInstance();
    }

    public StringBuilder exibirArestas(Grafo grafo) {
        StringBuilder lista = new StringBuilder();
        for (Aresta aresta : grafo.getArestas()) {
            lista.append(aresta.getA().getId());
            lista.append(" -> ");
            lista.append(aresta.getB().getId());
            lista.append('\n');
        }
        return lista;
    }
    public ArrayList<Aresta> BuscaEmProfundidade(Vertice partida, Vertice chegada) {
        boolean visitados [] = new boolean [grafo.countVertices()];
        int i;
        ArrayList<Aresta> caminho=new ArrayList<Aresta>();
        for(i=0;i<grafo.countVertices();i++){visitados[i]=false;}//incializa com branco
        return MetodoDaBuscaEmProfundidade(visitados,partida,chegada,caminho);
    }
    public ArrayList<Aresta> MetodoDaBuscaEmProfundidade(boolean visitados[],Vertice raiz, Vertice chegada,ArrayList<Aresta>caminho){
        int i=0;
        visitados[raiz.getId()]=true;
        Vertice vAt = raiz;//Vertice de partida
        Aresta arestaAt;//arestas atual
        ArrayList<Aresta> arestasAdjacentesVat;arestasAdjacentesVat=raiz.getArestas();
        arestaAt = arestasAdjacentesVat.get(i);//pega uma aresta do array
        caminho.add(arestaAt);
        while (!caminho.isEmpty()){
            if(arestaAt.getA() == vAt) {
                if (arestaAt.getB() == chegada)
                    return caminho;
                else {
                    vAt=arestaAt.getB();i++;
                }
            }
            else if(arestaAt.getB() == vAt) {
                if (arestaAt.getA() == chegada) {
                    return caminho;
                }
            }
            else{
                i++;
            }

        }
        return null;
    }

    public void showAresta(Grafo grafo, ArestaView arestaView, int idAresta) {
        Aresta aresta = grafo.getAresta(idAresta);
        arestaView.show(aresta);
    }

    public ArrayList<Aresta> buscaDijkstra(Vertice vInicial, Vertice vFinal){
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

    public ArrayList<Aresta> buscaLargura(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Aresta> buscaProfundidade(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Aresta> buscaEstrela(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Aresta> buscaGulosa(Vertice vInicial, Vertice vFinal){

        return null;
    }

}
