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

        grafo = Grafo.getInstance();
    }

    public StringBuilder exibirArestas(Grafo grafo, ArrayList<Aresta> arestas) {
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

    public ArrayList<Aresta> BuscaEmProfundidade(Vertice partida, Vertice chegada) {
        boolean visitados [] = new boolean [grafo.countVertices()];
        int i;
        ArrayList<Aresta> caminho=new ArrayList<Aresta>();
        for(i=0;i<grafo.countVertices();i++){visitados[i]=false;}//incializa com branco
        return MetodoDaBuscaEmProfundidade(visitados,partida,chegada,caminho);
    }

    public ArrayList<Aresta> MetodoDaBuscaEmProfundidade(boolean visitados[],Vertice raiz, Vertice chegada,ArrayList<Aresta>caminho){
        int i=0;
        visitados[raiz.getId()]=true;//matriz da cor cinza
        Vertice vAt = raiz,vProx;//vAt 'A' vProx 'B'
        Aresta arestaAt;//arestas atual
        ArrayList<Aresta> arestasAdjacentesVat;arestasAdjacentesVat=raiz.getArestas();//arestas adjacentes
        Stack<Vertice>vertices = new Stack<Vertice>();//vertices para retornar
        arestaAt = arestasAdjacentesVat.get(0);//pega uma aresta do array
        caminho.add(arestaAt);//caminho para retornar
        vertices.push(vAt);//carrega primeiro vertice na pilha
        vProx=arestaAt.getB();//inicializa o 'B'

        while (!vertices.isEmpty()){//enquanto nao estiver vazio

            /*Considerando que existe aresta do vertice para ele mesmo
            * Vertice 'a' de partida Vertice 'b' de chegada
            * metodo sendo testado*/

            if (vProx == chegada)//testa se encontrou chegada
                    return caminho;
            else {
                if(visitados[vProx.getId()] == false){//caso padrao pega proximo
                    vAt=vProx;
                    visitados[vAt.getId()]=true;
                    arestasAdjacentesVat=vAt.getArestas();
                    arestaAt=arestasAdjacentesVat.get(0);
                    vertices.push(vAt);
                    vProx=arestaAt.getB();
                    caminho.add(arestaAt);
                }
                else{
                    for (i = 0; i < arestasAdjacentesVat.size(); i++) {//procura vertice adjacente nao visitado
                        if (visitados[vProx.getId()] == true) {//pega proxima aresta do vertice atual
                            arestaAt = arestasAdjacentesVat.get(i);
                            vProx = arestaAt.getB();
                            if(vProx==chegada){
                                caminho.add(arestaAt);
                                return caminho;
                            }
                        //}else if(vProx == chegada){
                        //    caminho.add(arestaAt);
                        } else  {//se nao foi visitado
                            arestaAt = arestasAdjacentesVat.get(i);
                            vAt = vProx;
                            vertices.push(vAt);
                            vProx=arestaAt.getB();
                            break;
                        }
                    }
                    if(visitados[vAt.getId()] == true){//caso nao tenha aresta
                        vAt=vertices.pop();
                        arestasAdjacentesVat=vAt.getArestas();
                        arestaAt=arestasAdjacentesVat.get(0);
                        vProx=arestaAt.getB();
                        caminho.remove(caminho.size()-1);
                    }
                    else{
                        caminho.add(arestaAt);
                    }
                    visitados[vAt.getId()]=true;
                }
            }//fecha else

        }//fecha while
        return caminho;
    }//Fim do método

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
