package com.example.proyectoappcamara.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.proyectoappcamara.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;

public class NuevoPlaneta extends AppCompatActivity {

    EditText usuario, contraseña;
    Button inicioSesion, registrtoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_planeta);
        getSupportActionBar().hide();

        usuario = findViewById(R.id.editTextTextEmailAddress);
        contraseña = findViewById(R.id.editTextTextPassword);
        //inicioSesion = findViewById(R.id.inicioSesion);
        registrtoUsuario = findViewById(R.id.registroNuevoUsuario);
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    @Override
    protected void onStart() {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
        super.onStart();
    }
    private void updateUI(GoogleSignInAccount account) {
        if (account!=null){
            Intent i = new Intent(this, CapturarNuevoPlaneta.class);
            startActivity(i);
        }
    }


    public void inicSesion (View view){
        Intent i = new Intent(this, CapturarNuevoPlaneta.class);
        startActivity(i);
    }
    public void inicRegistro (View view){
        Intent i = new Intent(this, CapturarNuevoPlaneta.class);
        startActivity(i);
    }
}