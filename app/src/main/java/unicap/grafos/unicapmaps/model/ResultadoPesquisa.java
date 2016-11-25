package unicap.grafos.unicapmaps.model;

/**
 * Created by cais on 21/11/16.
 */

public class ResultadoPesquisa{
    private String nomeBloco;
    private String descricao;
    private int idVertice;

    public ResultadoPesquisa(int idVertice, String nomeBloco, String descricao){
        this.nomeBloco = nomeBloco;
        this.descricao = descricao;
        this.idVertice = idVertice;
    }

    public ResultadoPesquisa(int idVertice,String nomeBloco){
        this.nomeBloco = nomeBloco;
        this.idVertice = idVertice;
    }

    public String getNomeBloco() {
        return nomeBloco;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getIdVertice() {
        return idVertice;
    }
}
