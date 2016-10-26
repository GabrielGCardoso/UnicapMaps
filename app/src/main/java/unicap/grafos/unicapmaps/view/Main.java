package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

public class Main extends AppCompatActivity {

    private Grafo grafo = Grafo.getInstance();
    Context context;
    ZoomLayout mapaViewPort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        // TUDO DAQUI PRA BAIXO AINDA É TESTE
        GrafoController grafoController = new GrafoController();
        Vertice a = grafo.getVertice(0);
        Vertice b = grafo.getVertice(2);
        ArrayList<Aresta> caminho;

        caminho = grafoController.BuscaEmProfundidade(a, b);
        StringBuilder caminhoString = grafoController.exibirArestas(grafo, caminho);
        Toast.makeText(context, caminhoString, Toast.LENGTH_LONG).show();



        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ArestaView arestaView = (ArestaView) inflater.inflate(R.layout.aresta_view, null);
        //arestaView.setOriginByView(findViewById(R.id.imagem_mapa));

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.arestaConteiner);
        insertPoint.addView(arestaView);

        grafoController.showAresta(grafo, arestaView, 0);


        mapaViewPort = (ZoomLayout) findViewById(R.id.mapaViewPort);
        mapaViewPort.ajustScaleByParent(insertPoint);
        //mapaViewPort.removeView(mapaConteudo);
        //mapaViewPort.addFilho(mapaConteudo);


        GrafoController gController = new GrafoController();


    }
}
