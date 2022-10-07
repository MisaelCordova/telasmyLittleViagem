package com.example.telastrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listaEntretenimento;
    private EntretenimentoAdapter adapter;
   // private Button btnAdiconarDiversos;
    private ArrayList<Entretenimento> arl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnAdiconarDiversos = findViewById(R.id.adicionardiversos);
//
//        arl = new ArrayList<Entretenimento>();
//        arl.add(new Entretenimento("Matheus Leandro Ferreira", "teste"));
//
//
//        adapter = new EntretenimentoAdapter(MainActivity.this, arl);
//        listaEntretenimento.setAdapter(adapter);
    }
}