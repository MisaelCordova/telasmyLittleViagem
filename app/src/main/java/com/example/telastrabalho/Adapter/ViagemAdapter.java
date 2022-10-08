package com.example.telastrabalho.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.telastrabalho.R;
import com.example.telastrabalho.model.Viagem;

import java.util.ArrayList;

public class ViagemAdapter extends BaseAdapter {
    private ArrayList<Viagem> arlLista;
    private Activity act;

    public ViagemAdapter(final Activity act, final ArrayList<Viagem> arlLista) {
        this.act = act;
        this.arlLista = arlLista;
    }

    @Override
    public int getCount() {
        return arlLista.size();
    }

    @Override
    public Object getItem(int i) {
        return arlLista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = act.getLayoutInflater().inflate(R.layout.listviagens, viewGroup, false);
        }

        Viagem v = arlLista.get(i);

        TextView nomePessoa = view.findViewById(R.id.nomeViagem);
        nomePessoa.setText(v.getNomeViagem());

        return view;
    }
}
