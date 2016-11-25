package unicap.grafos.unicapmaps.model;

/**
 * Created by cais on 21/11/16.
 */
public class Rota {
    public int partida;
    public int destino;
    private boolean complete;

    public Rota() {
        partida = -1;
        destino = -1;
        complete = false;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getPartida() {
        return partida;
    }

    public void setPartida(int partida) {
        this.partida = partida;
    }

    public void set(int alvo, int id) {
        if(alvo == 0){
            setPartida(id);
        }else if(alvo == 1){
            setDestino(id);
        }
        verificarComplete();
    }

    private void verificarComplete() {
        if(partida >= 0 && destino >= 0){
            complete = true;
        } else{
            complete = false;
        }
    }

    public boolean isComplete() {
        return complete;
    }

    public void reset() {
        partida = -1;
        destino = -1;
        complete = false;
    }
}
