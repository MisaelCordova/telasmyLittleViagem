package com.example.telastrabalho;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.telastrabalho.Adapter.ViagemAdapter;
import com.example.telastrabalho.model.Viagem;

import java.util.ArrayList;

import kotlin.jvm.internal.Ref;

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
        registerForContextMenu(listaPersonalizada);
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,final ContextMenu.ContextMenuInfo menuInfo) {
       MenuItem  excluir =  menu.add("Excluir");
        excluir.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Viagem viagem = (Viagem) listaPersonalizada.getItemAtPosition(info.position);
                //Exclui no banco
                Toast.makeText(ListaViagemActivity.this,"Deletar Viagem "+viagem.getNomeViagem(),Toast.LENGTH_SHORT).show();
                return false;

            }
        });
    }
}
