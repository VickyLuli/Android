package com.example.prueba.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QR extends AppCompatActivity {

    Button btnCompartir;
    Button btnIncio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        ObtenerReferencias();
        btnCompartir.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Iniciar13Actividad();
            }
        });
        btnIncio.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Iniciar5Actividad();
            }
        });
    }

    public void ObtenerReferencias()
    {
        btnCompartir=(Button) findViewById(R.id.btnCompartir);
        btnIncio=(Button) findViewById(R.id.btnIinicio);
    }
    public void Iniciar13Actividad()
    {
        Intent nuevaActivity = new Intent(this, Compartir.class);
        startActivity(nuevaActivity);
    }
    public void Iniciar5Actividad()
    {
        Intent nuevaActivity = new Intent(this, Inicio.class);
        startActivity(nuevaActivity);
    }
}
