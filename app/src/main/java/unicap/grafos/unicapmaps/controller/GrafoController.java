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