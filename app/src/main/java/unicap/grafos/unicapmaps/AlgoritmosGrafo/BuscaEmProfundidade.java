package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import java.util.ArrayList;
import java.util.Stack;

import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by Cais Automação on 11/11/2016. project UnicapMaps
 */

public class BuscaEmProfundidade implements InterfaceBuscaEmGrafo {

    private GrafoController controller;

    public BuscaEmProfundidade(GrafoController controller) {
        this.controller = controller;
    }

    /*Metodo para transformar o stack em arraylist aresta
    /*Está parecido com o outro metodo se quiser pode mudar*/

    @Override
    public ArrayList<Aresta> buscar(Vertice partida, Vertice chegada) {
        ArrayList<Aresta> arestas = null;
        Stack<Vertice> vertices;

        if(partida == chegada){
            arestas.add(controller.getArestaFromVertices(partida,chegada));
        } else{
            vertices = MetodoBuscaEmProfundidade(partida, chegada);
            arestas = controller.getArestasFromVertices(vertices);
        }

        return arestas;
    }

    //Metodo da busca
    private Stack<Vertice> MetodoBuscaEmProfundidade(Vertice partida, Vertice chegada) {
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
            verticeProximo = getVeticeProx(verticeAtual,visitado);//pega proximo vertice
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

    //pega proximo vertice nao visitado
    private Vertice getVeticeProx(Vertice vAT,ArrayList<Boolean> visitados){
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
        for(i=0;i<controller.getTotalVertices();i++){visitados.add(i,false);}
    }
}
