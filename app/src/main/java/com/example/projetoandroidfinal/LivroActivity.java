package com.example.projetoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LivroActivity extends AppCompatActivity {
    Button btnCalcularLivro;
    EditText txtTitulo,txtQtd;
    Livro livro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livro_layout);
        btnCalcularLivro = (Button) findViewById(R.id.btnCalcularLivro);
        txtTitulo = (EditText) findViewById(R.id.txtLivro);
        txtQtd = (EditText) findViewById(R.id.txtQtd);
        btnCalcularLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                livro = new Livro();
                livro.setTitulo(txtTitulo.getText().toString());
                livro.setQuantidade(txtQtd.getText().toString());
                Intent i = new Intent(LivroActivity.this,ResultadoLivroActivity.class);
                i.putExtra("livro", livro);
                startActivity(i);
            }
        });
    }
}
