package com.example.projetoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sobre_layout);
        getSupportActionBar().hide();
    }
}
