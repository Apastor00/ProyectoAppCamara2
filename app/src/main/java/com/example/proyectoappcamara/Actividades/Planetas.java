package com.example.proyectoappcamara.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.example.proyectoappcamara.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class Planetas extends AppCompatActivity {

    ImageView imgView;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planetas);

        imgView = findViewById(R.id.imageView);
        webView = findViewById(R.id.webView);

        webView.loadUrl("file:///android_asset/venus.html");
        String url ="https://blogs.nasa.gov/solarcycle25/wp-content/uploads/sites/304/2022/01/Full-Disk_171_final.gif";
        Picasso.get().load(url).into(imgView);
    }
}