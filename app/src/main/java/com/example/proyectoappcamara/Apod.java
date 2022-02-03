package com.example.proyectoappcamara;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class Apod extends AppCompatActivity {

    EditText editTextFecha;
    DatePickerDialog calendario;
    Calendar c;
    int day, month, year;
    String fecha;
    String urlfinal, explicacion;

    String api_key = "qz7UevgGponV4Hqctv81KccrRJkauvNd6tNgf0Fr";
    String url = "https://api.nasa.gov/planetary/apod?api_key=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apod);
        getSupportActionBar().hide();

        editTextFecha = findViewById(R.id.editTextFecha);

        c = Calendar.getInstance();
        day = c.get(Calendar.DAY_OF_MONTH);
        month = c.get(Calendar.MONTH);
        year = c.get(Calendar.YEAR);

        fecha = (year + "-" + (month+1) + "-" + day);
        AccesoGet accesoGet = new AccesoGet(url, api_key, fecha);
        Bundle bundle = new Bundle();
        bundle=accesoGet.Apod();

        apod_fragment apod__fragment = new apod_fragment();
        apod__fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, apod__fragment).commit();

        editTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendario = new DatePickerDialog(Apod.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        editTextFecha.setText(y + "-" + (m+1) + "-" + d);
                        fecha = (y + "-" + (m+1) + "-" + d);
                        Apod();
                    }
                }, year, month, day);
                calendario.show();
            }
        });

    }
    /*public void Apod() {

        String api_key = "qz7UevgGponV4Hqctv81KccrRJkauvNd6tNgf0Fr";
        String url = "https://api.nasa.gov/planetary/apod?api_key="+api_key+"&date="+fecha;

        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    String urlNasa = jsonObject.getString("url");
                    String explanation = jsonObject.getString("explanation");
                    explicacion = explanation;
                    urlfinal = urlNasa;
                    Bundle result = new Bundle();
                    //result.putString("url", urlfinal);
                    //result.putString("explicacion", explicacion);
                    result.putString("url", jsonObject.getString("url"));
                    result.putString("explicacion", jsonObject.getString("explanation"));

                    apod_fragment apod__fragment = new apod_fragment();
                    apod__fragment.setArguments(result);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, apod__fragment).commit();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        Volley.newRequestQueue(this).add(postRequest);
    }*/
}