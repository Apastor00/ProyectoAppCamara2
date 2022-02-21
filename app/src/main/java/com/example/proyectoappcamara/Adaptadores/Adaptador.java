package com.example.proyectoappcamara.Adaptadores;

import static com.example.proyectoappcamara.Clases.CompressImage.*;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoappcamara.Actividades.SeleccionPlaneta;
import com.example.proyectoappcamara.Clases.CompressImage;
import com.example.proyectoappcamara.Clases.Objetos;
import com.example.proyectoappcamara.R;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Holder> {

    private ArrayList<Objetos> listaObjetos;

    public Adaptador (ArrayList<Objetos> lista){
        listaObjetos = lista;
    }

    public Adaptador() {

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_planetas, parent, false);
        Holder holder = new Holder (view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String objeto = listaObjetos.get(position).getObjeto(); //Creo el objeto string del tipo listaObjetos.
        holder.textView.setText(objeto); //Llamamos a Holder donde tenemos identificado nuestro textView y le asignamos el objto que hemos capturado
        int imagen = listaObjetos.get(position).getImagen();//Idem con imagen.
        //CompressImage compressImage = new CompressImage(holder.imageView.getContext(), imagen);
        //Bitmap imagenFinal = new CompressImage.decodeSampledBitmapFromResource(holder.imageView.getResources(), imagen, 150, 150);

        Bitmap imagenFinal = new CompressImage(holder.imageView.getContext(), imagen).decodeSampledBitmapFromResource(holder.imageView.getResources(), imagen,150, 150); //Creámos una variable Bitmap mediante el constructor de la clase
        //CompressImage con el método decodeSample.... Los valores numéricos que le damos son los tamaños que quermos ajustar la iamgen, para
        //que consuma menos recursos.

        holder.imageView.setImageBitmap(imagenFinal); //Cargamos el bitmap resultado en el imageview del holder.

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objetos objetos = listaObjetos.get(position);
                Intent i = new Intent(holder.imageView.getContext(), SeleccionPlaneta.class);
                Bundle bundle = new Bundle();
                bundle.putString("objeto", listaObjetos.get(position).getObjeto());
                bundle.putString("imagen", String.valueOf(listaObjetos.get(position).getImagen()));
                i.putExtras(bundle);
                holder.itemView.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaObjetos.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;
        private CardView cardView;
        public Holder (View view){
            super (view);
            textView = view.findViewById(R.id.textViewPlaneta);
            imageView = view.findViewById(R.id.imagViewPlaneta);
            cardView = view.findViewById(R.id.cardViewPlaneta);
        }
    }

}
