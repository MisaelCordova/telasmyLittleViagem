package com.example.telastrabalho;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.telastrabalho.Adapter.ViagemAdapter;
import com.example.telastrabalho.model.Viagem;

import java.util.ArrayList;

public class ListaViagemActivity extends AppCompatActivity {
    private ListView listaPersonalizada;
    private ViagemAdapter adapter;
    private ArrayList<Viagem> arl;
    private Button addViagem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_viagem);
        listaPersonalizada = findViewById(R.id.listviagens);
        addViagem = findViewById(R.id.addViagem);
        addViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        arl = new ArrayList<Viagem>();
        arl.add(new Viagem("Pomerode"));
        arl.add(new Viagem("barranca"));
        arl.add(new Viagem("Maldivas"));
        arl.add(new Viagem("Quebec"));

        adapter = new ViagemAdapter(ListaViagemActivity.this, arl);
        listaPersonalizada.setAdapter(adapter);

    }
    public void openDialog(){
        DialogViagem dialogViagem = new DialogViagem();
        dialogViagem.show(getSupportFragmentManager(),"Adicionar Viagem");
    }
}
