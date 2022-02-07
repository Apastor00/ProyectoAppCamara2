package com.example.proyectoappcamara.Actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.proyectoappcamara.Adaptadores.Adaptador;
import com.example.proyectoappcamara.Clases.BaseDeDatos;
import com.example.proyectoappcamara.Clases.Objetos;
import com.example.proyectoappcamara.Fragment.apod_fragment;
import com.example.proyectoappcamara.Fragment.fragment_lista_sistemasolar;
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
        //setContentView(R.layout.activity_planetas);
        setContentView(R.layout.fragment_lista_sistemasolar);
        recyclerView = findViewById(R.id.recyclerViewSistemaSolar);

       /*BaseDeDatos baseDeDatos = new BaseDeDatos(this, "sistemaSolar", null , 1);
        baseDeDatos.getWritableDatabase();*/

        BaseDeDatos baseDeDatos = new BaseDeDatos(this, "sistemaSolar", null , 1);
        SQLiteDatabase sqLiteDatabase = baseDeDatos.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT objeto, imagen FROM sistemaSolar", null);
        if (cursor.moveToFirst()){
            do {
                Objetos objetos = new Objetos();
                String planeta = cursor.getString(0);
                objetos.setObjeto(planeta);
                int imagen = cursor.getInt(1);
                objetos.setImagen(imagen);
                listaObjetos.add(objetos);
            }while (cursor.moveToNext());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        miAdapter  = new Adaptador(listaObjetos);
        recyclerView.setAdapter(miAdapter);




        //fragment_lista_sistemasolar fragment_lista_sistemasolar = new fragment_lista_sistemasolar();
        //getSupportFragmentManager().beginTransaction().replace(R.id.constrainFragmentContenedor, fragment_lista_sistemasolar).commit();




        /*sqLiteDatabase = new BaseDeDatos(this, "sistemaSolar", null , 1).getWritableDatabase();
        sqLiteDatabase = new BaseDeDatos(this, "sistemaSolar", null , 1).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT objeto, imagen FROM sistemaSolar WHERE id=?", null);

        if (cursor.moveToFirst()){
            do {
                objeto.add(cursor.getString(0));
                imagen.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        abrirFragment(objeto);*/

    }

    private void abrirFragment(ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("objeto", arrayList);
        apod_fragment apod_fragment = new apod_fragment();
        apod_fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerViewSistemaSolar, apod_fragment).commit();
    }
}