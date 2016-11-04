package unicap.grafos.unicapmaps.model;

/**
 * Created by Uirá Veríssimo on 12/10/2016.
 */

public class Coordenadas {
    private int x;
    private int y;

    public Coordenadas(){

    }

    public Coordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
