package com.example.telastrabalho;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogViagem extends AppCompatDialogFragment {
    private EditText nDias;
    private EditText qntdPesssoas;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_viagem, null);
        builder.setView(view)
                .setTitle("Adicionar Viagem")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nDiasDigitado = nDias.getText().toString();
                        String qntdPessoasDigitado = qntdPesssoas.getText().toString();
                        if(nDiasDigitado.isEmpty()){
                            Toast.makeText(getActivity(), "Preencha de quantos dias será a viagem!", Toast.LENGTH_LONG).show();
                        } else if(qntdPessoasDigitado.isEmpty()){
                            Toast.makeText(getActivity(), "Preencha quantas pessoas vão na viagem!", Toast.LENGTH_LONG).show();
                        } else{
                            int nDiasBanco = Integer.parseInt(nDiasDigitado);
                            int qntdPesssoasBanco = Integer.parseInt(qntdPessoasDigitado);
                            ///Salva no banco(acho que é int)
                            Toast.makeText(getActivity(), "Viagem Salva!", Toast.LENGTH_LONG).show();
                            Intent it = new Intent(getActivity(),MainActivity.class);
                            startActivity(it);
                        }


                    }
                });
        nDias = view.findViewById(R.id.nDias);
        qntdPesssoas = view.findViewById(R.id.qntdPessoas);
        return builder.create();

    }

    public static class DialogEntretenimento {
    }
}
