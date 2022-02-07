package com.example.proyectoappcamara.Fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proyectoappcamara.Actividades.Planetas;
import com.example.proyectoappcamara.Adaptadores.Adaptador;
import com.example.proyectoappcamara.Clases.BaseDeDatos;
import com.example.proyectoappcamara.Clases.Objetos;
import com.example.proyectoappcamara.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_lista_sistemasolar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_lista_sistemasolar extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter miAdapter = new Adaptador();
    ArrayList<Objetos> listaObjetos = new ArrayList<Objetos>();
    //Objetos objetos = new Objetos();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "id";
    private static final String ARG_PARAM2 = "objeto";

    // TODO: Rename and change types of parameters
    private String id;
    private String objeto;

    public fragment_lista_sistemasolar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param id Parameter 1.
     * @param objeto Parameter 2.
     * @return A new instance of fragment fragment_lista_sistemasolar.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_lista_sistemasolar newInstance(String id, String objeto) {
        fragment_lista_sistemasolar fragment = new fragment_lista_sistemasolar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, id);
        args.putString(ARG_PARAM2, objeto);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString(ARG_PARAM1);
            objeto = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_sistemasolar, container, false);
        return view;
    }


    private void llenarLista() {
        BaseDeDatos baseDeDatos = new BaseDeDatos(getContext(), "sistemaSolar", null , 1);
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
        /*if (cursor.moveToFirst()){
            do {
                objetos.setObjeto(cursor.getString(0));
                objetos.setImagen(cursor.getInt(1));
                listaObjetos.add(objetos);
                /*listaObjetos.add(new Objetos().setObjeto(cursor.getString(0)));
                listaObjetos.add(new Objetos().setImagen(cursor.getInt(1)));
            }while (cursor.moveToNext());*/
        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewSistemaSolar);

        llenarLista();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        miAdapter  = new Adaptador(listaObjetos);
        recyclerView.setAdapter(miAdapter);


    }
}