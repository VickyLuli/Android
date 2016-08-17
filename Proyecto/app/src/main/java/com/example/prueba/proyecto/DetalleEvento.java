package com.example.prueba.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DetalleEvento extends AppCompatActivity {
    Button btnComprar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_evento);

        btnComprar=(Button)findViewById(R.id.btnComprar);
        btnComprar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Iniciar9Actividad();
            }
        });
    }
    public void Iniciar9Actividad()
    {
        Intent nuevaActivity = new Intent(this, Producto.class);
        startActivity(nuevaActivity);
    }
}
