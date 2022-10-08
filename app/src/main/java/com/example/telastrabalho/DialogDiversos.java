package com.example.telastrabalho;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogDiversos extends AppCompatDialogFragment {
    private EditText nomeEntretenimento;
    private EditText valorEntretenimento;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_diversos, null);
        builder.setView(view)
                .setTitle("Adicionar Gasto Diverso")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nomeDiversoDigitado = nomeEntretenimento.getText().toString();
                        String valorDiversoDigitado = valorEntretenimento.getText().toString();
                        double valorDiversoBanco;
                        if(nomeDiversoDigitado.isEmpty()){
                            Toast.makeText(getActivity(), "Preencha o nome do Custo!", Toast.LENGTH_LONG).show();
                        } else if(valorDiversoDigitado.isEmpty()){
                            Toast.makeText(getActivity(), "Preencha o valor do Custo!", Toast.LENGTH_LONG).show();
                        }else{
                            valorDiversoBanco = Double.parseDouble(valorDiversoDigitado);
                            //salva no banco

                        }



                    }
                });
        nomeEntretenimento = view.findViewById(R.id.nomeDiverso);
        valorEntretenimento = view.findViewById(R.id.valorDiverso);
        return builder.create();
    }
}
