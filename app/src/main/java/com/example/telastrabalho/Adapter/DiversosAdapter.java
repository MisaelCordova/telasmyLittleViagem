package com.example.telastrabalho.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.telastrabalho.model.Diversos;
import com.example.telastrabalho.R;

import java.util.ArrayList;

public class DiversosAdapter extends BaseAdapter {
    private ArrayList<Diversos> arlLista;
    private Activity act;

    public DiversosAdapter(final Activity act, final ArrayList<Diversos> arlLista) {
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
            view = act.getLayoutInflater().inflate(R.layout.activity_diversos, viewGroup, false);
        }

        Diversos d = arlLista.get(i);

        TextView nomeDiverso = view.findViewById(R.id.nomeDiverso);
        nomeDiverso.setText(d.getNome());

        TextView valorDiverso = view.findViewById(R.id.valorDiverso);
        valorDiverso.setText(Double.toString(d.getValor()));

        return view;
    }
}
