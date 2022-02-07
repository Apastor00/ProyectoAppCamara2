package com.example.proyectoappcamara.Clases;

import java.io.Serializable;

public class Objetos implements Serializable {

    private String objeto;
    private int imagen;

    public void objetos (){}

    public String getObjeto() {
        return objeto;
    }

    public Objetos setObjeto(String objeto) {
        this.objeto = objeto;
        return null;
    }

    public int getImagen() {
        return imagen;
    }

    public Objetos setImagen(int imagen) {
        this.imagen = imagen;
        return null;
    }
}
