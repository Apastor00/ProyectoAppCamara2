package com.example.proyectoappcamara;

import android.content.Context;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AccesoGet  {

    private String urlApi, keyApi, parametroApi;


    public AccesoGet(String url, String key, String parámetro) {
        urlApi = url;
        keyApi = key;
        parametroApi = parámetro;
    }

    public Bundle Apod() {

        String fecha = parametroApi;
        String urlfinal = urlApi+keyApi+"&date="+fecha;
        Bundle result = new Bundle();

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
                    //Bundle result = new Bundle();
                    result.putString("url", jsonObject.getString("url"));
                    result.putString("explicacion", jsonObject.getString("explanation"));

                    /*apod_fragment apod__fragment = new apod_fragment();
                    apod__fragment.setArguments(result);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, apod__fragment).commit();*/

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        Volley.newRequestQueue(g).add(postRequest);
        return result;
    }
}
