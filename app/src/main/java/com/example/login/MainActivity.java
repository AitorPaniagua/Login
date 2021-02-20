package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    RadioButton create, login;
    Button action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        create = findViewById(R.id.create);
        login = findViewById(R.id.login);
        action = findViewById(R.id.action);

        action.setOnClickListener(v -> {
            SharedPreferences cuentas = getSharedPreferences("cuentas",MODE_PRIVATE);
            String usuario = user.getText().toString();
            String pass = user.getText().toString();

            if (create.isChecked()){
                System.out.println("Hola mundo");
                SharedPreferences.Editor editor = cuentas.edit();
                editor.putString(usuario,pass);
                editor.commit();

            }else {
                String passwordCorrecta = cuentas.getString(usuario,null);
                System.out.println(usuario + pass + passwordCorrecta);
                if(pass.equals(passwordCorrecta)){
                    Intent login = new Intent(this,Loged.class);
                    login.putExtra("usuario",usuario);
                    startActivity(login);
                }

            }
        });
    }



}