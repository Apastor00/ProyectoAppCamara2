package com.example.proyectoappcamara.Clases;




import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.example.proyectoappcamara.R;

import java.io.Serializable;

public class Objetos implements Serializable {

    private String objeto;
    private int imagen;
    private int dato;

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
        /*this.dato = dato;
        try {
            byte[] byteCode = Base64.decode(String.valueOf(dato), Base64.DEFAULT);
            int alto = 100;
            int ancho = 100;
            Bitmap foto = BitmapFactory.decodeByteArray(byteCode, 0, byteCode.length);
            imagen = Bitmap.createScaledBitmap(foto, alto, ancho, true);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        return null;
    }
    /*public static int calculateInSampleSize (BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }*/
}
