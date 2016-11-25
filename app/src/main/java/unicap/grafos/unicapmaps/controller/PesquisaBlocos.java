package unicap.grafos.unicapmaps.controller;


import android.util.Log;

import unicap.grafos.unicapmaps.dao.InfoBlocos;
import unicap.grafos.unicapmaps.model.ResultadoPesquisa;

import java.util.ArrayList;
/**
 * Created by kilso on 23/11/2016.
 */

public class PesquisaBlocos {

    /**
     * Created by kilson on 20/11/2016.
     */
    ArrayList<ResultadoPesquisa> resultado;
    String[] nomesBlocos;
    ArrayList<String[]> infoBlocos;
    String descricao;

    public PesquisaBlocos() {
        InfoBlocos info = new InfoBlocos();
        nomesBlocos = InfoBlocos.getNomesBlocos();
        infoBlocos = info.getInfoBlocos();
        resultado = new ArrayList();
    }


    public ArrayList<ResultadoPesquisa> pesquisaInfo(String entradaInfo){
        int i,j, tamanho, tamanhoMaximo;
        ResultadoPesquisa pesquisa;
        tamanho = nomesBlocos.length;
        tamanhoMaximo = 10;

        entradaInfo = entradaInfo.toUpperCase();


        //pesquisa pela letra do bloco
        if(entradaInfo.length() == 1){
            int letra = entradaInfo.charAt(0);
            Log.i("ASCII: ", letra+"");
            if(letra >= 65 && letra <= 87){ //se a letra digitada for entre A e W
                letra -= 65;
                pesquisa = new ResultadoPesquisa(letra, nomesBlocos[letra]);
                resultado.add(pesquisa);
            }
        } else{

            //pesquisa nos nosmes do blocos
            String nomeBloco;
            for(i = 0; i < tamanho; i++){
                nomeBloco = nomesBlocos[i].toUpperCase();
                if(nomeBloco.equals(entradaInfo) || nomeBloco.contains(entradaInfo)) {
                    pesquisa = new ResultadoPesquisa(i, nomesBlocos[i]);
                    resultado.add(pesquisa);
                    if(resultado.size() == tamanhoMaximo){
                        return resultado;
                    }
                }
            }
        }


        //pesquisa na descrição dos blocos
        for (i = 0; i < tamanho; i++){
            for(j = 0; j < infoBlocos.get(i).length; j++) {
                descricao = infoBlocos.get(i)[j].toUpperCase();
                if (descricao.contains(entradaInfo)) {
                    pesquisa = new ResultadoPesquisa(i, nomesBlocos[i], infoBlocos.get(i)[j]);
                    resultado.add(pesquisa);
                    if(resultado.size() == tamanhoMaximo){
                        return resultado;
                    }
                }
            }
        }
        return resultado;
    }

}
