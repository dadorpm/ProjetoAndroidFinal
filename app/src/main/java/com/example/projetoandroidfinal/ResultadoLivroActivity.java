package com.example.projetoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoLivroActivity extends AppCompatActivity {
    TextView txtResultado;
    Button button;
    Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_livro_layout);
        txtResultado =(TextView)findViewById(R.id.lblResultadoLivro);
        button = (Button)findViewById(R.id.btnVoltar);
        Intent i = getIntent();
        livro = new Livro();
        livro =(Livro) i.getSerializableExtra("livro");
        int total = Integer.parseInt(livro.getQuantidade())*25;
        txtResultado.setText("O que você escolheu é o: "+livro.getTitulo()+"\n"+"Valor do emprestimo = R$"+String.valueOf(total)+",00");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ResultadoLivroActivity.this,CardViewActivity.class);
                startActivity(it);
            }
        });
    }
}
