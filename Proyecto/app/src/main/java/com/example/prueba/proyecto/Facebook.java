package com.example.prueba.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Facebook extends AppCompatActivity {

    EditText edtEmail;
    EditText edtContra;
    Button btnRegist;
    CheckBox chbAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        ObtenerReferencias();
        btnRegist.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Iniciar4Actividad();
            }
        });
    }
    public void ObtenerReferencias()
    {
        edtEmail=(EditText) findViewById(R.id.edtmailFB);
        edtContra=(EditText) findViewById(R.id.edtcontraFB);
        btnRegist=(Button) findViewById(R.id.btnRegisFB);
        chbAceptar=(CheckBox) findViewById(R.id.chbAceptar);
    }
    public void Iniciar4Actividad()
    {
        Intent nuevaActivity = new Intent(this, PostRegistracion.class);
        startActivity(nuevaActivity);
    }
}
