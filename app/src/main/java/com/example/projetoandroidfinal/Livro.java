package com.example.projetoandroid;

import java.io.Serializable;

public class Livro implements Serializable {
    private String titulo;
    private String quantidade;
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return
                "titulo= " + titulo + "\n" +
                "quantidade= " + quantidade;
    }
}
