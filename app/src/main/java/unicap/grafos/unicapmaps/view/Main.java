package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;
import unicap.grafos.unicapmaps.util.ZoomLayout;

public class Main extends AppCompatActivity {

    private Grafo grafo = Grafo.getInstance();
    private Context context;

    private GrafoController grafoController;
    private float escalaInicial;
    private int windowWidth;
    private int windowHeight;
    private int mapaWidth;
    private int mapaHeight;
    private int larguraOriginal = 600;
    private boolean toggle = true;

    int idVerticeInicial = -1;
    int idVerticeFinal = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        grafoController = new GrafoController();

        // TUDO DAQUI PRA BAIXO AINDA É TESTE

        RelativeLayout mainActivity = (RelativeLayout) findViewById(R.id.root);
        String larguraMapa = Integer.toString(mainActivity.getWidth());
//        Toast.makeText(context, ""+escala, Toast.LENGTH_LONG).show();

        /* TESTES DE GABRIEL*/
        ArrayList<Aresta> caminho;

        caminho = grafoController.BuscaEmProfundidade(0, 2);
        StringBuilder caminhoString = grafoController.exibirArestas(caminho);
        //Toast.makeText(context, caminhoString, Toast.LENGTH_LONG).show();
        /*FIM DOS TESTES DE GABRIEL*/

        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCaminho();
            }
        });

        Button clearButton = (Button) findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparTela();
            }
        });


    }



    private void mostrarCaminho() {
        EditText inputPartida = (EditText) findViewById(R.id.edit_text_partida);
        EditText inputDestino = (EditText) findViewById(R.id.edit_text_destino);

        String inputTextPartida = inputPartida.getText().toString().trim();
        String inputTextDestino = inputDestino.getText().toString().trim();

        if(inputTextPartida.length() > 0 && inputTextDestino.length() > 0){
            idVerticeInicial = Integer.parseInt(inputTextPartida);
            idVerticeFinal = Integer.parseInt(inputTextDestino);
        } else{
            idVerticeInicial = -1;
            idVerticeFinal = -1;
        }

        ImageView arestaView = (ImageView) findViewById( R.id.arestaConteiner);

        ArestaPathView pathView = new ArestaPathView(mapaWidth, mapaHeight, escalaInicial);
        ArrayList<Aresta> caminho = grafoController.BuscaEmProfundidade(idVerticeInicial, idVerticeFinal);

        //caminho = buscaEscolhida;
        if(caminho != null){
            grafoController.exibirCaminho(arestaView, pathView, caminho, Color.BLUE);
        } else{
            idVerticeInicial = -1;
            idVerticeFinal = -1;
            Toast.makeText(context, "Vértices inválidos", Toast.LENGTH_SHORT).show();
            return;
        }

        esconderViews();
        arestaView.setVisibility(View.VISIBLE);

    }

    private void limparTela() {
        EditText inputPartida = (EditText) findViewById(R.id.edit_text_partida);
        EditText inputDestino = (EditText) findViewById(R.id.edit_text_destino);
        Button submitButton = (Button) findViewById(R.id.submit_button);
        Button clearButton = (Button) findViewById(R.id.clear_button);
        ImageView arestaView = (ImageView) findViewById( R.id.arestaConteiner);

        inputPartida.setText("");
        inputDestino.setText("");
        inputDestino.clearFocus();
        inputPartida.clearFocus();

        inputPartida.setVisibility(View.VISIBLE);
        inputDestino.setVisibility(View.VISIBLE);
        submitButton.setVisibility(View.VISIBLE);
        clearButton.setVisibility(View.INVISIBLE);
        arestaView.setVisibility(View.INVISIBLE);

    }

    private void esconderViews() {
        EditText inputPartida = (EditText) findViewById(R.id.edit_text_partida);
        EditText inputDestino = (EditText) findViewById(R.id.edit_text_destino);
        Button submitButton = (Button) findViewById(R.id.submit_button);
        Button clearButton = (Button) findViewById(R.id.clear_button);

        inputDestino.setVisibility(View.INVISIBLE);
        inputPartida.setVisibility(View.INVISIBLE);
        submitButton.setVisibility(View.INVISIBLE);
        clearButton.setVisibility(View.VISIBLE);

    }

    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);

        /*Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        windowWidth = size.x;
        windowHeight = size.y;*/

        ImageView img = (ImageView) findViewById(R.id.imagem_mapa);
        mapaHeight = img.getHeight();
        mapaWidth = img.getWidth();

        escalaInicial = mapaWidth*1.0f/larguraOriginal;

        ZoomLayout mapaViewPort = (ZoomLayout) findViewById(R.id.mapaViewPort);
        mapaViewPort.ajustScale();

    }
}