package com.example.proyectoappcamara.Clases;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AccesoGet {

    private String urlApi, keyApi, parametroApi;
    private Context contextApi;
    private DatePickerDialog.OnDateSetListener contexOnDateSetListener;
    private Bundle bundleResultado;


    public AccesoGet(String url, String key, String parametro, Context context) {
        urlApi = url;
        keyApi = key;
        parametroApi = parametro;
        contextApi = context;
    }

    public Bundle Apod() {

        String fecha = parametroApi;
        String urlfinal = urlApi + keyApi + "&date=" + fecha;
        //Bundle result = new Bundle();

        StringRequest postRequest = new StringRequest(Request.Method.GET, urlfinal, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    bundleResultado.putString("url", jsonObject.getString("url"));
                    bundleResultado.putString("explicacion", jsonObject.getString("explanation"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        Volley.newRequestQueue(contextApi).add(postRequest);
        return bundleResultado;
    }
}
