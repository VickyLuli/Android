package com.example.prueba.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Comprar extends AppCompatActivity {
    EditText edtEmail;
    EditText edtNTitu;
    EditText edtNTarj;
    Button btnComprar;
    EditText edtPago;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);
        ObtenerReferencias();
        btnComprar.setOnClickListener(new View.OnClickListener() {

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
        edtEmail= (EditText) findViewById(R.id.edtEemail);
        edtNTitu= (EditText) findViewById(R.id.edtNTitu);
        edtNTarj= (EditText) findViewById(R.id.edtNTarj);
        edtPago= (EditText) findViewById(R.id.edtPago);
        btnComprar= (Button) findViewById(R.id.btnCcomprar);
    }
}
