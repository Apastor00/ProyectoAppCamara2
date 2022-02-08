package com.example.proyectoappcamara.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectoappcamara.R;
import com.example.proyectoappcamara.Fragment.apod_fragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class Apod extends AppCompatActivity {

    EditText editTextFecha;
    DatePickerDialog calendario;
    Calendar c;
    int day, month, year;
    String fecha;

    String api_key = "qz7UevgGponV4Hqctv81KccrRJkauvNd6tNgf0Fr";
    String urlApi = "https://api.nasa.gov/planetary/apod?api_key=";

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
        editTextFecha.setText(day+"/"+(month+1)+"/"+year);
        String url = urlApi+api_key+"&date="+fecha;
        new ClassAsyn().execute(url);
        editTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendario = new DatePickerDialog(Apod.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        editTextFecha.setText(d+"/"+(m+1)+"/"+y);
                        //editTextFecha.setText(y + "-" + (m+1) + "-" + d);
                        fecha = (y + "-" + (m+1) + "-" + d);
                        String url = urlApi+api_key+"&date="+fecha;
                        new ClassAsyn().execute(url);
                    }
                }, year, month, day);
                calendario.show();
            }
        });
    }
    private void abrirFragment(Bundle bundle){
        apod_fragment apod_fragment = new apod_fragment();
        apod_fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerViewApod, apod_fragment).commit();
    }
    private class ClassAsyn extends AsyncTask<String, Void, String[]> {
        @Override
        protected String[] doInBackground(String... strings) {
            return strings;
        }

        @Override
        protected void onPostExecute(String[] s) {
            super.onPostExecute(s);
            StringRequest postRequest = new StringRequest(Request.Method.GET, s[0], new com.android.volley.Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        Bundle result = new Bundle();
                        result.putString("url", jsonObject.getString("url"));
                        result.putString("explicacion", jsonObject.getString("explanation"));
                        abrirFragment(result);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new com.android.volley.Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }

            });
            Volley.newRequestQueue(Apod.this).add(postRequest);
        }
    }
}