package com.example.projetoandroidfinal;

import java.io.Serializable;

public class Aluno implements Serializable {
    private int id;
    private String nome;
    private String serie;
    private String escola;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    @Override
    public String toString() {
        return nome;
    }
}
