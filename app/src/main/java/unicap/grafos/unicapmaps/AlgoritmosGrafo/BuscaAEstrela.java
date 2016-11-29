package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import java.util.ArrayList;
import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Vertice;
import unicap.grafos.unicapmaps.util.Util;

/**
 * Created by Cais Automação on 11/11/2016. project UnicapMaps
 */
public class BuscaAEstrela implements InterfaceBuscaEmGrafo {

    private GrafoController controller;
    ArrayList<Vertice> anteriores;//came_from
    ArrayList<Integer> custos;//cost_so_far

    public BuscaAEstrela(GrafoController controller) {
        this.controller = controller;
    }

    @Override
    public ArrayList<Aresta> buscar(Vertice partida, Vertice chegada) {
        FilaOrdenada fila = new FilaOrdenada();
        ArrayList<Vertice> caminho = new ArrayList();
        int custoAtual;
        anteriores = new ArrayList(); //came_from
        custos = new ArrayList();  //cost_so_far

        Vertice atual;

        UtilBuscas.inicializar(anteriores, custos);
        custos.set(partida.getId(), 0);

        fila.add(partida, Integer.MAX_VALUE);

        while(!(fila.isEmpty())){
            atual = fila.peek();

            if(atual == chegada){
                break;
            }

            for(Vertice adj: atual.getAdjacentes()){
                custoAtual = UtilBuscas.acharDistancia(controller, atual, adj);
                if(UtilBuscas.relaxarAresta(custos, atual, adj, custoAtual)){
                    int peso = custos.get(adj.getId()) + heuristica(chegada, adj);
                    fila.add(adj, peso);
                    anteriores.set(adj.getId(), atual);
                }
            }
        }
        caminho = UtilBuscas.varrerAnteriores(anteriores, partida, chegada);
        return controller.getArestasFromVertices(caminho);
    }


    public int heuristica (Vertice a, Vertice b) {
        int x1, x2, y1, y2;

        x1 = a.getCoordenadas().getX();
        y1 = a.getCoordenadas().getY();
        x2 = b.getCoordenadas().getX();
        y2 = b.getCoordenadas().getY();

        //return abs(x1 - x2) + abs(y1 - y2);
        return Util.calculaDistancia(x1, y1, x2, y2);
    }

    private class FilaOrdenada extends ArrayList<Vertice> {
        ArrayList<Integer> pesos;

        public FilaOrdenada() {
            super();
            pesos = new ArrayList();
        }

        public boolean add(Vertice novo, int peso) {
            Vertice verticeTemp;
            if (isEmpty()) {
                pesos.add(peso);
                return super.add(novo);
            } else {
                for (int i = 0; i < size(); i++) {
                    verticeTemp = get(i);
                    if (peso < pesos.get(i)) {
                        super.add(i, novo);
                        pesos.add(i, peso);
                        return true;
                    }
                }
                pesos.add(peso);
                return super.add(novo);

            }
        }

        public Vertice peek() {
            Vertice retorno = get(0);
            remove(0);
            pesos.remove(0);
            return retorno;
        }
    }
}