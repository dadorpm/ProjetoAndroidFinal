package com.example.projetoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText edtNome,edtSerie,edtEscola;
    private Button btnCadastrar;
    private AlunoDAO dao;
    private Aluno aluno = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNome = (EditText) findViewById(R.id.editNome);
        edtSerie = (EditText) findViewById(R.id.editSerie);
        edtEscola = (EditText) findViewById(R.id.editEscola);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar(v);
            }
        });
        dao = new AlunoDAO(this);
        Intent i = getIntent();
        if(i.hasExtra("aluno")){
            aluno = (Aluno) i.getSerializableExtra("aluno");
            edtNome.setText(aluno.getNome());
            edtSerie.setText(aluno.getSerie());
            edtEscola.setText(aluno.getEscola());
        }

    }
    private void salvar(View v){
        if(aluno == null) {
            Aluno a = new Aluno();
            a.setNome(edtNome.getText().toString());
            a.setSerie(edtSerie.getText().toString());
            a.setEscola(edtEscola.getText().toString());
            long id = dao.inserir(a);
            Toast.makeText(this, "Aluno inserido com Sucesso, id= " + id, Toast.LENGTH_SHORT).show();
        }else{
            aluno.setNome(edtNome.getText().toString());
            aluno.setSerie(edtSerie.getText().toString());
            aluno.setEscola(edtEscola.getText().toString());
            dao.atualizar(aluno);
            Toast.makeText(this, "Aluno foi Atualizado com Sucesso", Toast.LENGTH_SHORT).show();
        }
    }
}
