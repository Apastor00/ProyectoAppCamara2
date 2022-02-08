package com.example.proyectoappcamara.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.proyectoappcamara.Clases.Objetos;
import com.example.proyectoappcamara.R;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class SeleccionPlaneta extends AppCompatActivity {

    ImageView imgView;
    WebView webView;
    Objetos objeto;
    ArrayList<Objetos> objetosArrayList = new ArrayList<Objetos>();
    String urlApiFoto = "";
    String textoFinal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_planeta);
        getSupportActionBar().hide();


        imgView = findViewById(R.id.imageView);
        webView = findViewById(R.id.EditTextApod);

        String objtoFInal = getIntent().getExtras().getString("objeto");
        urlsFinales(objtoFInal);
        webView.loadUrl(textoFinal);
        Picasso.get().load(urlApiFoto).into(imgView);
    }

    private void urlsFinales(String parametro) {
        switch (parametro) {
            case "El Sol":
                urlApiFoto = "https://blogs.nasa.gov/solarcycle25/wp-content/uploads/sites/304/2022/01/Full-Disk_171_final.gif";
                textoFinal = "file:///android_asset/Sol.html";
                break;
            case "Mercurio":
                urlApiFoto = "https://www.nasa.gov/sites/default/files/thumbnails/image/pia16853.jpg";
                textoFinal = "file:///android_asset/Mercurio.html";
                break;
            case "Venus":
                urlApiFoto = "https://www.nasa.gov/sites/default/files/thumbnails/image/imagesvenus20191211venus20191211-16.jpeg";
                textoFinal = "file:///android_asset/venus.html";
                break;
            case "Marte":
                urlApiFoto = "https://www.nasa.gov/sites/default/files/thumbnails/image/m15-145.jpg";
                textoFinal = "file:///android_asset/Marte.html";
                break;
            case "Júpiter":
                urlApiFoto = "https://www.nasa.gov/sites/default/files/thumbnails/image/hubble_opal_jupiter.jpg";
                textoFinal = "file:///android_asset/Júpiter.html";
                break;
            case "Tierra":
                urlApiFoto = "https://www.nasa.gov/sites/default/files/styles/full_width_feature/public/thumbnails/image/iss065e086377.jpg";
                textoFinal = "file:///android_asset/Tierra.html";
                break;
            case "Saturno":
                urlApiFoto = "https://www.nasa.gov/sites/default/files/thumbnails/image/hubble_opal_saturn.jpg";
                textoFinal = "file:///android_asset/Saturno.html";
                break;
            case "Neptuno":
                urlApiFoto = "https://www.nasa.gov/sites/default/files/thumbnails/image/hubble_opal_neptune.jpg";
                textoFinal = "file:///android_asset/Neptuno.html";
                break;
            case "Urano":
                urlApiFoto = "https://www.nasa.gov/sites/default/files/thumbnails/image/hubble_opal_uranus.jpg";
                textoFinal = "file:///android_asset/urano.html";
                break;
            default:
                break;
        }
    }

    /*public void leerApi(String url) {
        try {
            ClassAsyn claseAsyn = new ClassAsyn();
            claseAsyn.execute(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/

    /*private class ClaseAsyn extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            HttpClient httpclient = new DefaultHttpClient();
            String resultado = null, urlFinal = null;
            HttpGet httpget = new HttpGet(urls[0]);
            HttpResponse respuesta = null;
            InputStream stream = null;
            try {
                respuesta = httpclient.execute(httpget);
                HttpEntity entity = respuesta.getEntity();

                if (entity != null) {
                    stream = entity.getContent();
                    resultado = convertirInputToString(stream);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (stream != null) {
                        stream.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            try {
                //JSONArray jsonArray = new JSONArray(resultado);
                JSONObject jsonObject = new JSONObject(resultado);
                //String url = jsonArray.getJSONObject(0).optString("fotoPlaneta").toString();
                urlFinal = jsonObject.optString("fotoPlaneta").toString();
                Picasso.get().load(urlFinal).into(imgView);
                return urlFinal;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return urlFinal;
        }

        @Override
        protected void onPostExecute(String urlFinal) {
            super.onPostExecute(urlFinal);
        }
        private String convertirInputToString (InputStream inputStream) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String resultado = "";
            while ((line = bufferedReader.readLine()) != null)
                resultado += line;
            inputStream.close();
            return resultado;
        }
    }*/

    /*private class ClassAsyn extends AsyncTask<String, Void, String[]> {
        @Override
        protected String[] doInBackground(String... strings) {
            return strings;
        }

        @Override
        protected void onPostExecute(String[] s) {
            super.onPostExecute(s);
            final String[] urlFinal = {""};
            StringRequest postRequest = new StringRequest(Request.Method.GET, s[0], new com.android.volley.Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    JSONObject jsonObject = null;
                    urlFinal[0] = jsonObject.optJSONObject("fotoPlaneta").toString();
                    urlApiFoto = urlFinal[0];
                }
            }, new com.android.volley.Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }

            });
            Volley.newRequestQueue(SeleccionPlaneta.this).add(postRequest);

        }
    }*/

}