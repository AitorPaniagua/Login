package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Loged extends AppCompatActivity {

    TextView logeado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged);

        logeado = findViewById(R.id.logeado);

        Bundle bundle = getIntent().getExtras();

        String usuario = bundle.getString("usuario");

        logeado.setText("Bienvenido usuario " + usuario);
    }
}