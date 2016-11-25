package unicap.grafos.unicapmaps.AlgoritmosGrafo;

import unicap.grafos.unicapmaps.controller.GrafoController;

/**
 * Created by Cais Automação on 11/11/2016. project UnicapMaps
 */

public class FactoryBuscas {

    public static InterfaceBuscaEmGrafo getInstance(GrafoController controller, String nomeBusca) {
        if(nomeBusca.isEmpty()){
            return null;
        }

        if( nomeBusca.equalsIgnoreCase("profundidade")){
            return new BuscaEmProfundidade(controller);
        } else if (nomeBusca.equalsIgnoreCase("largura")) {
            return new BuscaEmLargura(controller);
        }else if (nomeBusca.equalsIgnoreCase("dijkstra")) {
            return new BuscaDijkstra(controller);
        }else if (nomeBusca.equalsIgnoreCase("gulosa")) {
            return new BuscaGulosa(controller);
        }else if (nomeBusca.equalsIgnoreCase("a_estrela")) {
            return new BuscaAEstrela(controller);
        }else if (nomeBusca.equalsIgnoreCase("bellman_ford")) {
            return new BuscaBellManFord(controller);
        }
        return null;
    }
}
