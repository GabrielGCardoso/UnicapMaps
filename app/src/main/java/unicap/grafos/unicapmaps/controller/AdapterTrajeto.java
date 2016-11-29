package unicap.grafos.unicapmaps.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.R;

/**
 * Created by cais on 20/11/16.
 */
public class AdapterTrajeto extends ArrayAdapter{

    public AdapterTrajeto(Context context, ArrayList<String> descricao){
        super(context, R.layout.item_lista_trajeto, descricao);
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        String descricao = (String) getItem(position);
        LayoutInflater listaViewInflater = LayoutInflater.from(getContext());
        View customListaView = listaViewInflater.inflate(R.layout.item_lista_trajeto, parent, false);
        TextView titulo = (TextView) customListaView.findViewById(R.id.titulo);
        titulo.setText(descricao);

        customListaView.setFocusable(false);
        customListaView.setOnClickListener(null);

        return customListaView;
    }
}
