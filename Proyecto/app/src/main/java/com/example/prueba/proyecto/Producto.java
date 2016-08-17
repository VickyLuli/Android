package com.example.prueba.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Producto extends AppCompatActivity {
    EditText edtEntradas;
    Button btnReserva;
    Button btnCompra;
    TextView lblPrecio;
    Spinner spnTragos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        ObtenerReferencias();
        btnReserva.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Iniciar11Actividad();
            }
        });
        btnCompra.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Iniciar10Actividad();
            }
        });
    }

    public void ObtenerReferencias()
    {
        edtEntradas= (EditText) findViewById(R.id.edtEntradas);
        btnCompra= (Button) findViewById(R.id.btnCompra);
        btnReserva= (Button) findViewById(R.id.btnReserva);
        lblPrecio= (TextView) findViewById(R.id.lblPrecio);
        spnTragos= (Spinner) findViewById(R.id.spnTragos);
    }
    public void Iniciar10Actividad()
    {
        Intent nuevaActivity = new Intent(this, Comprar.class);
        startActivity(nuevaActivity);
    }
    public void Iniciar11Actividad()
    {
        Intent nuevaActivity = new Intent(this, Reservar.class);
        startActivity(nuevaActivity);
    }
}
