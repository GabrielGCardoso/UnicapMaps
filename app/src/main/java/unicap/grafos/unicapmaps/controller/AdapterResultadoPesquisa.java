package unicap.grafos.unicapmaps.controller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.model.ResultadoPesquisa;
import unicap.grafos.unicapmaps.model.Rota;
import unicap.grafos.unicapmaps.util.Util;

/**
 * Created by cais on 20/11/16.
 */
public class AdapterResultadoPesquisa extends ArrayAdapter{

    private Context context;
    private Rota rota;
    private int alvo;
    private Activity activity;
    private RelativeLayout listaBuscaContainer;
    private ViewGroup rootView;
    EditText editTextSource;


    public AdapterResultadoPesquisa(Context context, ArrayList<ResultadoPesquisa> resultados, EditText editTextSource, Rota rota, int alvo){
        super(context, R.layout.item_resultado_busca, resultados);
        this.context = context;
        this.rota = rota;
        this.alvo = alvo;
        this.editTextSource = editTextSource;
        rootView = (ViewGroup) editTextSource.getRootView();

        TextView nenhumResultado = (TextView) rootView.findViewById(R.id.nenhum_resultado);
        if(resultados.size() == 0){
            nenhumResultado.setVisibility(View.VISIBLE);
        } else{
            nenhumResultado.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        listaBuscaContainer = (RelativeLayout) rootView.findViewById(R.id.lista_busca_container);

        final ResultadoPesquisa resultadoAtual = (ResultadoPesquisa) getItem(position);
        String stringNomeBloco = resultadoAtual.getNomeBloco();
        String stringDescricao = resultadoAtual.getDescricao();

        LayoutInflater listaViewInflater = LayoutInflater.from(getContext());
        View customListaView = listaViewInflater.inflate(R.layout.item_resultado_busca, parent, false);

        TextView nomeBLoco = (TextView) customListaView.findViewById(R.id.nome_bloco);
        TextView descricao = (TextView) customListaView.findViewById(R.id.descricao);

        nomeBLoco.setText(stringNomeBloco);
        if(stringDescricao == null || stringDescricao.isEmpty()){
            ((ViewGroup) descricao.getParent()).removeView(descricao);
        } else{
            descricao.setText(resultadoAtual.getDescricao());
        }

        customListaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button submitButton = (Button) rootView.findViewById(R.id.submit_button);
                rootView.clearFocus();

                rota.set(alvo, resultadoAtual.getIdVertice());
                editTextSource.setText(resultadoAtual.getNomeBloco());
                listaBuscaContainer.setVisibility(View.INVISIBLE);

                Util.esconderTeclado(context, rootView);

                if(rota.isComplete()){
                    submitButton.setVisibility(View.VISIBLE);
                } else {
                    submitButton.setVisibility(View.INVISIBLE);
                }
            }
        });

        return customListaView;
    }
}
