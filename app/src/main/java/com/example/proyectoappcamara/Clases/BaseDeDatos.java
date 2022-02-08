package com.example.proyectoappcamara.Clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyectoappcamara.R;


public class BaseDeDatos extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE sistemaSolar (id INTEGER, objeto TEXT, imagen INTEGER)";

    public BaseDeDatos (Context contexto, String nombreTabla, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, nombreTabla, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sistemaSolar");
        db.execSQL(sqlCreate);
        datosTabla(db);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        datosTabla(db);

    }
    private void datosTabla (SQLiteDatabase db){
        db.execSQL("INSERT INTO sistemaSolar (id, objeto, imagen) VALUES(0,'El Sol',"+ R.drawable.el_sol +")");
        db.execSQL("INSERT INTO sistemaSolar (id, objeto, imagen) VALUES(1,'Mercurio',"+ R.drawable.mercurio +")");
        db.execSQL("INSERT INTO sistemaSolar (id, objeto, imagen) VALUES(2,'Venus',"+R.drawable.venus+")");
        db.execSQL("INSERT INTO sistemaSolar (id, objeto, imagen) VALUES(3,'Tierra',"+R.drawable.tierra+")");
        db.execSQL("INSERT INTO sistemaSolar (id, objeto, imagen) VALUES(4,'Marte',"+R.drawable.marte+")");
        db.execSQL("INSERT INTO sistemaSolar (id, objeto, imagen) VALUES(5,'Júpiter',"+R.drawable.jupiter+")");
        db.execSQL("INSERT INTO sistemaSolar (id, objeto, imagen) VALUES(6,'Saturno',"+R.drawable.saturno+")");
        db.execSQL("INSERT INTO sistemaSolar (id, objeto, imagen) VALUES(7,'Urano',"+R.drawable.urano+")");
        db.execSQL("INSERT INTO sistemaSolar (id, objeto, imagen) VALUES(8,'Neptuno',"+R.drawable.neptuno+")");
    }
}
