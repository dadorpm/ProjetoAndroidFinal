package com.example.projetoandroid;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CardViewActivity extends AppCompatActivity {

    RecyclerView recyclerAlunos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view_layout);
        recyclerAlunos = findViewById(R.id.recyclerMenu);
        //recyclerAlunos.setLayoutManager(new LinearLayoutManager(this));
        recyclerAlunos.setLayoutManager(new GridLayoutManager(this,2));
        MenuAdapter adapter = new MenuAdapter( getMenu(),this);
        recyclerAlunos.setAdapter(adapter);
    }
    private ArrayList<Menu> getMenu(){
        ArrayList<Menu> menus = new ArrayList<>();
        Menu m = new Menu("Bem Vindo","Aqui um pouco sobre o App", R.drawable.bv);
        menus.add(m);
        m = new Menu("Livraria Online","Alugue seu livro Aqui", R.drawable.livro);
        menus.add(m);
        m = new Menu("Cadastrar","Cadastro dos Alunos", R.drawable.bd);
        menus.add(m);
        m = new Menu("Cep","Buscar o Cep da sua Escola ", R.drawable.localizacao);
        menus.add(m);



        return menus;
    }
}
