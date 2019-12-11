package com.example.projetoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TelaLogin extends AppCompatActivity implements EditText.OnEditorActionListener {
    EditText txtLogin,txtSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        getSupportActionBar().hide();
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtSenha.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        String login = txtLogin.getText().toString();
        String senha = txtSenha.getText().toString();
        if (txtSenha == v && EditorInfo.IME_ACTION_DONE == actionId){
            if (!login.equals("Senai")){
                txtLogin.setError("Login Inválido");
            }else  if (!senha.equals("senai")){
                txtSenha.setError("Senha Inválida");
            }else {
                Intent i = new Intent(TelaLogin.this,CardViewActivity.class);
                startActivity(i);
            }
        }
        return false;
    }
}
