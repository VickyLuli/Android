package com.example.prueba.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Compartir extends AppCompatActivity {

    Button btnAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartir);
        btnAceptar= (Button) findViewById(R.id.btnAaceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Iniciar5Actividad();
            }
        });
    }
    public void Iniciar5Actividad()
    {
        Intent nuevaActivity = new Intent(this, Inicio.class);
        startActivity(nuevaActivity);
    }
}
