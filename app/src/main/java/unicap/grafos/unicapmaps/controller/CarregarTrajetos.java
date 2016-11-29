package unicap.grafos.unicapmaps.controller;

import unicap.grafos.unicapmaps.model.Aresta;
import java.util.ArrayList;


public class CarregarTrajetos {

    public ArrayList<String> buscarTrajeto (ArrayList<Aresta> returnBuscas) {
        ArrayList<String> trajetoFinal = new ArrayList();;
        int i;
        String[] descricaoAtual;

        for(Aresta arestaAtual: returnBuscas){
            descricaoAtual = arestaAtual.getDescricao();
            for(i = 0; i < descricaoAtual.length; i++){
                trajetoFinal.add(descricaoAtual[i]);
            }
        }

        return trajetoFinal;
    }
}