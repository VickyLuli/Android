package com.example.prueba.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Reservar extends AppCompatActivity {

    EditText edtEmail;
    EditText edtNombre;
    EditText edtTelefono;
    Button btnReservar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);
        ObtenerReferencias();
        btnReservar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Iniciar12Actividad();
            }
        });

    }
    public void Iniciar12Actividad()
    {
        Intent nuevaActivity = new Intent(this, QR.class);
        startActivity(nuevaActivity);
    }
    public void ObtenerReferencias()
    {
        edtEmail=(EditText) findViewById(R.id.edtEeemail);
        edtNombre=(EditText) findViewById(R.id.edtNnombre);
        edtTelefono=(EditText) findViewById(R.id.edtTelefoono);
        btnReservar=(Button) findViewById(R.id.btnRreservar);
    }
}
