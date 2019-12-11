package com.example.projetoandroidfinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListarAlunosActivity extends AppCompatActivity {
    private ListView listViewAluno;
    private AlunoDAO dao;
    private List<Aluno> alunos;
    private List<Aluno> alunosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_alunos);
        listViewAluno = (ListView) findViewById(R.id.listViewAluno);
        dao = new AlunoDAO(this);
        alunos = dao.obterTodos();
        alunosFiltrados.addAll(alunos);
        AlunoAdapter adapter = new AlunoAdapter(alunosFiltrados,this);
        listViewAluno.setAdapter(adapter);
        registerForContextMenu(listViewAluno);


    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);
        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                procuraAluno(newText);
                return false;
            }
        });
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_contexto, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemCadastrar:
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        alunos = dao.obterTodos();
        alunosFiltrados.clear();
        alunosFiltrados.addAll(alunos);
        listViewAluno.invalidateViews();
    }

    public void procuraAluno(String nome){
        alunosFiltrados.clear();
        for(Aluno a : alunos){
            if(a.getNome().toLowerCase().contains(nome.toLowerCase())){
                alunosFiltrados.add(a);
            }
        }
        listViewAluno.invalidateViews();
    }
    public void excluirAluno(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Aluno alunoExcluir = alunosFiltrados.get(menuInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this).
                setTitle("Atenção").setMessage("Deseja Exlcuir?").
                setNegativeButton("cancelar",null).
                setPositiveButton("apagar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alunosFiltrados.remove(alunoExcluir);
                alunos.remove(alunoExcluir);
                dao.excluir(alunoExcluir);
                listViewAluno.invalidateViews();
            }
        }).create();
        dialog.show();
    }
    public void atualizarAluno(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Aluno alunoEditar = alunosFiltrados.get(menuInfo.position);
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("aluno", alunoEditar);
        startActivity(i);
    }
}
