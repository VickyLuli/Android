package com.example.prueba.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostRegistracion extends AppCompatActivity {

    Button btnInicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_registracion);
        btnInicio=(Button) findViewById(R.id.btnInicio);
        btnInicio.setOnClickListener(new View.OnClickListener()
        {
            Contact objeto = (Contact)getIntent().getExtras().getSerializable("parametro");
            public void onClick(View v) {

                Iniciar5Actividad(objeto);
            }
        });
    }
    public void Iniciar5Actividad(Contact objeto)
    { //hacer intent
        Intent nuevaActivity = new Intent(this, Inicio.class);
        nuevaActivity.putExtra("parametro",objeto);
        startActivity(nuevaActivity);
    }
}
