package unicap.grafos.unicapmaps.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.AlgoritmosGrafo.ColoracaoWelshPowell;
import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.controller.AdapterTrajeto;
import unicap.grafos.unicapmaps.controller.CarregarTrajetos;
import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.controller.PesquisaDinamica;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Rota;
import unicap.grafos.unicapmaps.model.Vertice;

public class Main extends AppCompatActivity {

    private Grafo grafo = Grafo.getInstance();
    private Context context;
    private GrafoController grafoController;
    private float escalaInicial;
    private int mapaWidth;
    private int mapaHeight;
    private final int larguraOriginal = 1200;
    private String metodoBusca = "dijkstra";
    private Toolbar toolbar;
    private EditText inputPartida;
    private EditText inputDestino;
    private ImageView arestaView;
    private String modo = "busca";
    private RelativeLayout listaBuscaContainer;
    private Rota rota = new Rota();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.toolbar = toolbar;
        toolbar.setSubtitle("Busca Dijsktra");

        context = getApplicationContext();
        grafoController = new GrafoController();

        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tracarRota();
            }
        });

        Button clearButton = (Button) findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparTela();
            }
        });

        inputPartida = (EditText) findViewById(R.id.edit_text_partida);
        inputDestino = (EditText) findViewById(R.id.edit_text_destino);
        arestaView = (ImageView) findViewById( R.id.arestaConteiner);

        listaBuscaContainer = (RelativeLayout) findViewById(R.id.lista_busca_container);
        ListView listViewBusca = (ListView) findViewById(R.id.listaBusca);

        inputPartida.addTextChangedListener(new PesquisaDinamica(context, listViewBusca, inputPartida, rota, 0));
        inputDestino.addTextChangedListener(new PesquisaDinamica(context, listViewBusca, inputDestino, rota, 1));
    }

    public void tracarRota() {
        if(!rota.isComplete()){
            Toast.makeText(context, "Escolha os locais de partida e destino", Toast.LENGTH_LONG).show();
            return;
        }

        ArrayList<Aresta> caminho = mostrarCaminho();
        if(caminho != null) {
            posicionarBalao();
            showInfo(caminho);
        } else{
            limparTela();
            return;
        }

        esconderViews(false);
        arestaView.setVisibility(View.VISIBLE);
    }

    private void showInfo(ArrayList<Aresta> caminho) {
        LinearLayout infoTrajeto = (LinearLayout) findViewById(R.id.info_trajeto);
        TextView infoPartida = (TextView) infoTrajeto.getChildAt(0);
        TextView infoDestino = (TextView) infoTrajeto.getChildAt(1);
        TextView infoDistancia = (TextView) infoTrajeto.getChildAt(2);
        Button botaoTrajeto = (Button) infoTrajeto.getChildAt(3);

        String nomePartida = grafo.getVertice(rota.getPartida()).getNome();
        String nomeDestino = grafo.getVertice(rota.getDestino()).getNome();
        int distancia = grafoController.calcularDistancia(caminho);

        infoPartida.setText("Partida: "+ nomePartida);
        infoDestino.setText("> Destino: "+ nomeDestino);
        infoDistancia.setText("Distância: " + distancia + " metros");

        final Dialog trajetoDialog = new Dialog(this);
        trajetoDialog.setContentView(R.layout.dialog_trajeto);

        if(caminho == null || caminho.size() == 0){
            trajetoDialog.setTitle("Fique onde está.");
        } else{
            trajetoDialog.setTitle("Descrição do trajeto");
            preencherDialogTrajeto(caminho, trajetoDialog);
        }

        botaoTrajeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trajetoDialog.show();
            }
        });

    }

    private void preencherDialogTrajeto(ArrayList<Aresta> caminho, Dialog trajetoDialog) {
        CarregarTrajetos carregarTrajetos = new CarregarTrajetos();
        ArrayList<String> infoTrajeto = carregarTrajetos.buscarTrajeto(caminho);
        ListView listViewTrajeto = (ListView) trajetoDialog.findViewById(R.id.list_view_trajeto);
        AdapterTrajeto adapter = new AdapterTrajeto(this, infoTrajeto);
        listViewTrajeto.setAdapter(adapter);
    }

    private ArrayList<Aresta> mostrarCaminho() {
        //caminho = buscaEscolhida;
        ArrayList<Aresta> caminho = grafoController.buscar(rota.getPartida(), rota.getDestino(), metodoBusca);
        if(caminho == null){
            return caminho;
        }
        ArestaPathView pathView = new ArestaPathView(mapaWidth, mapaHeight, escalaInicial, 5);
        if(caminho.size() > 0) {
            grafoController.exibirCaminho(arestaView, pathView, caminho, Color.RED);
        } else{
            //caso o início seja o mesmo que o final
            Vertice destino = grafo.getVertice(rota.getDestino());
            grafoController.exibirCaminho(arestaView, pathView, destino);
        }
        return caminho;
    }

    private void posicionarBalao() {
        int left, top;
        Vertice destino = grafo.getVertice(rota.getDestino());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout balao = (RelativeLayout)findViewById(R.id.balao_local);

        left = (int) (destino.getCoordenadas().getX()*escalaInicial) - balao.getWidth() - 5;
        top = (int) (destino.getCoordenadas().getY()*escalaInicial) - balao.getHeight() - 5;
        balao.setLayoutParams(params);

        params.setMargins(left, top,0,0);
    }

    private void limparTela() {
        RelativeLayout layoutInputs = (RelativeLayout) findViewById(R.id.layout_inputs);
        LinearLayout infoTrajeto = (LinearLayout) findViewById(R.id.info_trajeto);
        TextView infoPartida = (TextView) infoTrajeto.getChildAt(0);
        TextView infoDestino = (TextView) infoTrajeto.getChildAt(1);
        TextView infoDistancia = (TextView) infoTrajeto.getChildAt(2);

        RelativeLayout balao = (RelativeLayout) findViewById(R.id.balao_local);
        EditText inputPartida = (EditText) findViewById(R.id.edit_text_partida);
        EditText inputDestino = (EditText) findViewById(R.id.edit_text_destino);
        Button submitButton = (Button) findViewById(R.id.submit_button);
        Button clearButton = (Button) findViewById(R.id.clear_button);
        ImageView arestaView = (ImageView) findViewById( R.id.arestaConteiner);

        RelativeLayout layout_botoes = (RelativeLayout) findViewById(R.id.layout_botoes);
        RelativeLayout layout_info = (RelativeLayout) findViewById(R.id.layout_info);

        layout_botoes.setVisibility(View.VISIBLE);
        layout_info.setVisibility(View.VISIBLE);

        rota.reset();

        inputDestino.clearFocus();
        inputPartida.clearFocus();
        inputPartida.setText("");
        inputDestino.setText("");
        infoPartida.setText("");
        infoDestino.setText("");
        infoDistancia.setText("");

        infoTrajeto.setVisibility(View.INVISIBLE);
        balao.setVisibility(View.INVISIBLE);
        layoutInputs.setVisibility(View.VISIBLE);
        submitButton.setVisibility(View.INVISIBLE);
        clearButton.setVisibility(View.INVISIBLE);
        arestaView.setVisibility(View.INVISIBLE);

    }

    private void esconderViews(boolean esconderTudo) {
        LinearLayout infoTrajeto = (LinearLayout) findViewById(R.id.info_trajeto);
        RelativeLayout layoutInputs = (RelativeLayout) findViewById(R.id.layout_inputs);

        RelativeLayout balao = (RelativeLayout) findViewById(R.id.balao_local);
        Button submitButton = (Button) findViewById(R.id.submit_button);
        Button clearButton = (Button) findViewById(R.id.clear_button);

        layoutInputs.setVisibility(View.INVISIBLE);
        submitButton.setVisibility(View.INVISIBLE);

        if(esconderTudo){
            RelativeLayout layout_botoes = (RelativeLayout) findViewById(R.id.layout_botoes);
            RelativeLayout layout_info = (RelativeLayout) findViewById(R.id.layout_info);

            layout_botoes.setVisibility(View.INVISIBLE);
            layout_info.setVisibility(View.INVISIBLE);
            clearButton.setVisibility(View.INVISIBLE);
            balao.setVisibility(View.INVISIBLE);
            infoTrajeto.setVisibility(View.INVISIBLE);
        } else{
            clearButton.setVisibility(View.VISIBLE);
            balao.setVisibility(View.VISIBLE);
            infoTrajeto.setVisibility(View.VISIBLE);
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);

        ImageView img = (ImageView) findViewById(R.id.imagem_mapa);
        mapaHeight = img.getHeight();
        mapaWidth = img.getWidth();

        escalaInicial = mapaWidth*1.0f/larguraOriginal;

        ZoomLayout mapaViewPort = (ZoomLayout) findViewById(R.id.mapaViewPort);
        mapaViewPort.ajustScale();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dijkstra:
                modoBusca("dijkstra");
                toolbar.setSubtitle("Busca Dijkstra");
                break;

            case R.id.profundidade:
                modoBusca("profundidade");
                toolbar.setSubtitle("Busca em Profundidade");
                break;

            case R.id.largura:
                modoBusca("largura");
                toolbar.setSubtitle("Busca em Largura");
                break;

            case R.id.a_estrela:
                modoBusca("a_estrela");
                toolbar.setSubtitle("Busca A*");
                break;

            case R.id.gulosa:
                modoBusca("gulosa");
                toolbar.setSubtitle("Busca Gulosa");
                break;

            case R.id.bellman_ford:
                modoBusca("bellman_ford");
                toolbar.setSubtitle("Busca Bellman-Ford");
                break;

            case R.id.coloracao_welsh_powell:
                modoColoracao();
                toolbar.setSubtitle("Coloração Welsh-Powell");
                break;

            case R.id.sobre:
                startActivitySobre();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    private void modoColoracao() {
        if(modo == "busca") {
            metodoBusca = "";
            limparTela();
            esconderViews(true);
            colorir();
        }
        modo = "coloracao";
    }

    private void colorir() {
        ColoracaoWelshPowell coloracaoWelshPowell = new ColoracaoWelshPowell();
        ArrayList<ArrayList> verticesComCores = coloracaoWelshPowell.colorir();
        ArestaPathView pathView = new ArestaPathView(mapaWidth, mapaHeight, escalaInicial, 2);
        grafoController.exibirGrafoCompleto(arestaView, pathView, true);
        arestaView.setVisibility(View.VISIBLE);
        grafoController.colorirVertices(verticesComCores, arestaView, pathView);
    }

    private void modoBusca(String metodoBusca){
        this.metodoBusca = metodoBusca;
        if(modo == "coloracao"){
            limparTela();
        }else {
            this.metodoBusca = metodoBusca;
            tracarRota();
        }
        modo = "busca";
    }

    protected void startActivitySobre() {
        Intent mainIntent = new Intent(this, Sobre.class);
        startActivity(mainIntent);
    }

    @Override
    public void onBackPressed() {
        if(inputPartida.hasFocus() || inputDestino.hasFocus() || listaBuscaContainer.getVisibility() == View.VISIBLE){
            inputPartida.clearFocus();
            inputDestino.clearFocus();
            listaBuscaContainer.setVisibility(View.INVISIBLE);
        }else {
            super.onBackPressed();
        }
    }
}
