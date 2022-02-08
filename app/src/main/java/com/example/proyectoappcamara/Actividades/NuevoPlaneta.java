package com.example.proyectoappcamara.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.proyectoappcamara.R;

public class NuevoPlaneta extends AppCompatActivity {

    EditText usuario, contraseña;
    Button inicioSesion, registrtoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_planeta);
        getSupportActionBar().hide();

        usuario = findViewById(R.id.editTextTextEmailAddress);
        contraseña = findViewById(R.id.editTextTextPassword);
        inicioSesion = findViewById(R.id.inicioSesion);
        registrtoUsuario = findViewById(R.id.registroNuevoUsuario);

    }

    public void inicSesion (View view){
        Intent i = new Intent(this, CapturarNuevoPlaneta.class);
        startActivity(i);
    }
    public void inicRegistro (View view){
        Intent i = new Intent(this, CapturarNuevoPlaneta.class);
        startActivity(i);
    }
}