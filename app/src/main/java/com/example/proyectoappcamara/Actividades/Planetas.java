package com.example.proyectoappcamara.Actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.proyectoappcamara.Adaptadores.Adaptador;
import com.example.proyectoappcamara.Clases.BaseDeDatos;
import com.example.proyectoappcamara.Clases.Objetos;
import com.example.proyectoappcamara.R;

import java.util.ArrayList;

public class Planetas extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase = null;
    ArrayList<String> objeto, imagen;

    RecyclerView.Adapter miAdapter = new Adaptador();
    RecyclerView recyclerView;
    ArrayList<Objetos> listaObjetos = new ArrayList<Objetos>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_planetas);
        recyclerView = findViewById(R.id.recyclerViewSistemaSolar);

        BaseDeDatos baseDeDatos = new BaseDeDatos(this, "sistemaSolar", null, 1);
        SQLiteDatabase sqLiteDatabase = baseDeDatos.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT objeto, imagen FROM sistemaSolar", null);
        if (cursor.moveToFirst()) {
            do {
                Objetos objetos = new Objetos();
                String planeta = cursor.getString(0);
                objetos.setObjeto(planeta);
                int imagen = cursor.getInt(1);
                objetos.setImagen(imagen);
                listaObjetos.add(objetos);
            } while (cursor.moveToNext());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        miAdapter = new Adaptador(listaObjetos);
        recyclerView.setAdapter(miAdapter);
    }
}