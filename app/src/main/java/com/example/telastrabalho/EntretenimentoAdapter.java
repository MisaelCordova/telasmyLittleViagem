package com.example.telastrabalho;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class EntretenimentoAdapter extends BaseAdapter {
    private ArrayList<Entretenimento> arlLista;
    private Activity act;

    public EntretenimentoAdapter(final Activity act, final ArrayList<Entretenimento> arlLista) {
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
            view = act.getLayoutInflater().inflate(R.layout.activity_entretenimento, viewGroup, false);
        }

        Entretenimento e = arlLista.get(i);

        EditText nomePessoa = view.findViewById(R.id.nomeEntretenimento);
        nomePessoa.setText(e.getNome());

        TextView cpfPessoa = view.findViewById(R.id.valorEntretenimento);
        cpfPessoa.setText(e.getValor());

        return view;
    }
}
