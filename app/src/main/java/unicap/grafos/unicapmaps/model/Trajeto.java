package unicap.grafos.unicapmaps.model;

/**
 * Created by uira on 12/11/16.
 */

public class Trajeto {
    private int idAresta;
    private String[] descricao;
    private int idA;
    private int idB;

    public Trajeto(int idA, int idB, String[] desc){
        this.idA = idA;
        this.idB = idB;
        descricao = desc;
    }

    public void setIdAresta(int idAresta){
        this.idAresta = idAresta;
    }

    public int getIdAresta(){
        return idAresta;
    }

    public void setDescricao(String[] desc){
        descricao = desc;
    }

    public String[] getDescricao(){
        return descricao;
    }

    public int getIdA() {
        return idA;
    }

    public int getIdB() {
        return idB;
    }
}
