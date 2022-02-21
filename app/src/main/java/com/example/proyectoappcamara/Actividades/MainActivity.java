package com.example.proyectoappcamara.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.proyectoappcamara.R;

public class MainActivity extends AppCompatActivity {

    ImageButton imgButton1,imgButton2, imgButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Theme_AppCompat);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); //Con esta línea ocultamos la barra con el nombre de la app

        imgButton1 = findViewById(R.id.imageButton);
        imgButton2 = findViewById(R.id.imageButton2);
        imgButton3 = findViewById(R.id.imageButton3);
    }

    public void Apod(View view){
        Intent intent_apod = new Intent(this, Apod.class);
        startActivity(intent_apod);
    }
    public void Planetas (View view){
        Intent intent_planetas =new Intent(this, Planetas.class);
        startActivity(intent_planetas);
    }
    public void GuardarPlaneta (View view){
        Intent intent_nuevo_planeta = new Intent(this, NuevoPlaneta.class);
        startActivity(intent_nuevo_planeta);

    }
}