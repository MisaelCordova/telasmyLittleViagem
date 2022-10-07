package com.example.telastrabalho;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaViagemActivity extends AppCompatActivity {
    private ListView listaPersonalizada;
    private ViagemAdapter adapter;
    private ArrayList<Viagem> arl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_viagem);

        listaPersonalizada = findViewById(R.id.listviagens);
        arl = new ArrayList<Viagem>();
        arl.add(new Viagem("Pomerode"));
        arl.add(new Viagem("barranca"));
        arl.add(new Viagem("Maldivas"));
        arl.add(new Viagem("Quebec"));

        adapter = new ViagemAdapter(ListaViagemActivity.this, arl);
        listaPersonalizada.setAdapter(adapter);
    }
}
