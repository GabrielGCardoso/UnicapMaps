package unicap.grafos.unicapmaps.dao;

import unicap.grafos.unicapmaps.model.Grafo;

/**
 * Created by Cais Automação on 06/10/2016. project Unicap Maps
 */
public class GrafoDao {

    private GrafoCreator grafoCreator;


    public GrafoDao() {

        grafoCreator = new GrafoCreator();
    }

    public Grafo getGrafo(){
        grafoCreator.construirGrafo();
        return grafoCreator.getGrafo();
    }

}

