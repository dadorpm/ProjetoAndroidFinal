package com.example.projetoandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutionException;

public class WebServicesActivity extends AppCompatActivity {

    private Button botao;
    private EditText etCep;
    private TextView txtCep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_service_layout);

        botao = (Button) findViewById(R.id.btnCep);
        etCep = (EditText) findViewById(R.id.edtCep);
        txtCep = (TextView) findViewById(R.id.txtResposta);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    HTTPService service = new HTTPService(etCep.getText().toString());
                    try {
                        CEP retorno =  service.execute().get();
                        txtCep.setText(retorno.toString());
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });


    }
}
