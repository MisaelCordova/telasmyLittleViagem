package com.example.telastrabalho;

public class Entretenimento {
    private String nome;
    private String valor;

    public Entretenimento(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }
}
