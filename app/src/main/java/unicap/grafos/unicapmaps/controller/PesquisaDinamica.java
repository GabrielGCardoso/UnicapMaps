package unicap.grafos.unicapmaps.controller;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.ResultadoPesquisa;
import unicap.grafos.unicapmaps.model.Rota;

/**
 * Created by cais on 19/11/16.
 */

public class PesquisaDinamica implements TextWatcher {

    private String stringInput;
    private Context context;
    private ListView listView;
    private EditText editTextSource;
    private ArrayList<ResultadoPesquisa> resultado;
    private AdapterResultadoPesquisa adapter;
    private RelativeLayout listViewContainer;
    private Rota rota;
    private int alvo;
    private PesquisaBlocos buscador;


    public PesquisaDinamica(Context context, ListView listView, EditText source, Rota rota, int alvo) {
        this.context = context;
        this.listView = listView;
        this.editTextSource = source;
        listViewContainer = (RelativeLayout) listView.getParent();
        this.rota = rota;
        this.alvo = alvo;
        //buscador = new BuscaInfo();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (editTextSource.hasFocus()) {
        stringInput = s.toString();

            // is only executed if the EditText was directly changed by the user
            rota.set(alvo, -1);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        if(stringInput != null && editTextSource.hasFocus() && !stringInput.isEmpty()){
            buscador = new PesquisaBlocos();
            resultado = buscador.pesquisaInfo(stringInput);
            //resultado = criarResultadosFalsos();
            if(resultado == null){
                //nenhum resultado encontrado
                resetListView();
            } else{
                //passar adapter com resultado para o listview
                startListView();
            }
        } else{
            resetListView();
        }
    }

    private void resetListView() {
        listViewContainer.setVisibility(View.INVISIBLE);
    }

    private void startListView() {
        adapter = new AdapterResultadoPesquisa(context, resultado, editTextSource, rota, alvo);
        listView.setAdapter(adapter);
        posicionaListView();

        listViewContainer.setVisibility(View.VISIBLE);
    }

    private void posicionaListView() {
        int top;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        top = editTextSource.getBottom() + 2;
        listViewContainer.setLayoutParams(params);

        params.setMargins(0, top,0,0);

    }



}
