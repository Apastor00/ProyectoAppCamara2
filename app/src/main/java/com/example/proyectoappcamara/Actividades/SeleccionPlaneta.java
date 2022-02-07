package com.example.proyectoappcamara.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.proyectoappcamara.Clases.Objetos;
import com.example.proyectoappcamara.R;
import com.squareup.picasso.Picasso;

public class SeleccionPlaneta extends AppCompatActivity {

    ImageView imgView;
    WebView webView;
    Objetos objeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_planeta);


        imgView = findViewById(R.id.imageView);
        webView = findViewById(R.id.EditTextApod);

        Bundle bundle = new Bundle();
        Intent i = new Intent();
        String objtoFInal, imagenFinal;
        objtoFInal = getIntent().getExtras().getString("objeto");
        imagenFinal = "file:///android_asset/"+objtoFInal+".html";

        webView.loadUrl(imagenFinal);
        String url ="https://blogs.nasa.gov/solarcycle25/wp-content/uploads/sites/304/2022/01/Full-Disk_171_final.gif";
        Picasso.get().load(url).into(imgView);
    }
}