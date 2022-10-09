package com.example.telastrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telastrabalho.Adapter.DiversosAdapter;
import com.example.telastrabalho.model.Diversos;
import com.example.telastrabalho.model.Viagem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText totalEstimadoKm;
    private EditText custoMedioLitro;
    private EditText mediaKmLitro;
    private EditText totalVeiculos;
    private TextView totalGasolina;
    private Switch addGasolina;

    private EditText custoEstimadoPessoa;
    private EditText aluguelVeiculo;
    private TextView totalTarifaAerea;
    private Switch addTarifaAerea;

    private EditText custoEstimadoRefeicao;
    private EditText refeicoesDia;
    private TextView totalRefeicoes;
    private Switch addRefeicao;

    private EditText custoEstimadoNoite;
    private EditText totalNoites;
    private TextView totalHospedagem;
    private Switch addHospedagem;

    private ListView listaDiversos;
    private TextView totalDiversos;
    private DiversosAdapter adapter;
    private ArrayList<Diversos> arl;
    private Button btnAdiconarDiversos;
    private Button btnSalvarGastos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalEstimadoKm = findViewById(R.id.totalEstimadoKm);
        mediaKmLitro = findViewById(R.id.mediaKmLitro);
        custoMedioLitro = findViewById(R.id.custoMedioLitro);
        totalVeiculos = findViewById(R.id.totalVeiculos);
        totalGasolina = findViewById(R.id.totalGasolina);
        addGasolina = findViewById(R.id.addGasolina);
        custoEstimadoPessoa = findViewById(R.id.custoEstimadoPessoa);
        aluguelVeiculo = findViewById(R.id.aluguelVeiculo);
        totalTarifaAerea = findViewById(R.id.totalTarifaAerea);
        addGasolina = findViewById(R.id.addTarifaEarea);
        custoEstimadoRefeicao = findViewById(R.id.custoEstimadoRefeicao);
        refeicoesDia = findViewById(R.id.refeicoesDia);
        totalRefeicoes = findViewById(R.id.totalRefeicoes);
        addRefeicao = findViewById(R.id.addRefeicao);
        custoEstimadoNoite = findViewById(R.id.custoEstimadoNoite);
        totalNoites = findViewById(R.id.totalNoites);
        totalHospedagem = findViewById(R.id.totalHospedagem);
        addHospedagem = findViewById(R.id.addHospedagem);
        btnAdiconarDiversos = findViewById(R.id.adicionardiversos);
        totalDiversos = findViewById(R.id.totalDiversos);
        listaDiversos = findViewById(R.id.listDiversos);
        btnSalvarGastos = findViewById(R.id.salvar);
        registerForContextMenu(listaDiversos);

        btnAdiconarDiversos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

       // alimenta array de diversos
        arl = new ArrayList<Diversos>();
        arl.add(new Diversos("pomerode",84.5));
        arl.add(new Diversos("zoo ",810.5));

        adapter = new DiversosAdapter(MainActivity.this, arl);
        listaDiversos.setAdapter(adapter);
    }
    public void openDialog(){
        DialogDiversos dialogDiversos = new DialogDiversos();
        dialogDiversos.show(getSupportFragmentManager(),"Adicionar Entretenimento");
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem excluir = menu.add("Exluir");
        excluir.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Viagem viagem = (Viagem) listaDiversos.getItemAtPosition(info.position);
                //Exclui no banco
                Toast.makeText(MainActivity.this,"Deletar gasto diverso "+viagem.getNomeViagem(),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}