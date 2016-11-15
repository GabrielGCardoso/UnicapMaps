package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by uira on 14/11/16.
 */

public class ColoracaoWelshPowell {
    Grafo grafo;

    public ColoracaoWelshPowell() {
        grafo = Grafo.getInstance();
    }

    public ArrayList<Integer> colorir(){
        ArrayList<Vertice> dependencias = new ArrayList<>();
        ArrayList<Vertice> paraRemover = new ArrayList<>();
        Queue<Vertice> filaVertices = ordenarVertices();
        ArrayList<Integer> corVertices = iniciarArrayCores();
        Queue<Integer> cores = iniciarCores();
        Vertice atual;
        int corAtual;

        while(!filaVertices.isEmpty()){
            corAtual = cores.poll();
            atual = filaVertices.poll();
            corVertices.set(atual.getId(), corAtual);
            dependencias.addAll(atual.getAdjacentes());

            for(Vertice vertice: filaVertices){
                if (!dependencias.contains(vertice)){
                    corVertices.set(vertice.getId(), corAtual);
                    dependencias.addAll(vertice.getAdjacentes());
                    paraRemover.add(vertice);
                }
            }

            filaVertices.removeAll(paraRemover);
            paraRemover.clear();
            dependencias.clear();
        }
        return corVertices;
    }

    private Queue<Integer> iniciarCores(){
        Queue<Integer> cores = new LinkedList<>();
        cores.add(Color.RED);
        cores.add(Color.BLUE);
        cores.add(Color.GREEN);
        cores.add(Color.YELLOW);
        cores.add(Color.MAGENTA);
        cores.add(Color.CYAN);
        cores.add(Color.GRAY);
        cores.add(Color.WHITE);
        cores.add(Color.BLACK);
        return cores;
    }

    private ArrayList<Integer> iniciarArrayCores(){
        ArrayList<Integer> cores = new ArrayList<>();
        int i;
        for(i = 0; i < grafo.countVertices(); i++){
            cores.add(0);
        }
        return cores;
    }

    private Queue<Vertice> ordenarVertices() {
        ComparadorMaiorGrau comparador = new ComparadorMaiorGrau();
        Queue<Vertice> filaVertices = new LinkedList<>();
        ArrayOrdenado fila = new ArrayOrdenado();
        for(Vertice vertice: grafo.getVertices()){
            fila.add(vertice);
        }
        filaVertices.addAll(fila);
        return filaVertices;
    }

    private class ComparadorMaiorGrau implements Comparator<Vertice> {
        @Override
        public int compare(Vertice A, Vertice B) {
            if(A.getAdjacentes().size() > B.getAdjacentes().size()){
                return -1;
            }
            if(A.getAdjacentes().size() < B.getAdjacentes().size()){
                return 1;
            }
            return 0;
        }
    }

    private class ArrayOrdenado extends ArrayList<Vertice>{

        public ArrayOrdenado(){
            super();
        }

        @Override
        public boolean add(Vertice novo) {
            int i;
            Vertice atual;
            for(i = 0; i < this.size(); i++){
                atual = get(i);
                if(novo.getAdjacentes().size() >= atual.getAdjacentes().size()){
                    super.add(i, novo);
                    return true;
                }
            }
            return super.add(novo);
        }
    }
}
