package com.example.prueba.proyecto;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.camera2.params.Face;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class IniciarSesion extends AppCompatActivity {
    Button btnIngresar;
    Button btnRegis;
    Button btnFB;
    EditText edtEmail;
    EditText edtContra;
    CheckBox chbRecordar;
    DataBaseHelper helper;
    Toast pass;
    Contact obj=new Contact();
    String strEmail,strContra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        ObtenerReferencias();
        helper=new DataBaseHelper(this, "BaseDeDatos", null,1);
        btnIngresar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                 strEmail = edtEmail.getText().toString();
                 strContra = edtContra.getText().toString();
                boolean camposvacios = Camposvacios();
                if (!camposvacios) {
                    String contra = helper.BuscoContrasena(strEmail);
                    if (contra.equals(strContra))
                    {
                        obj =helper.Obtener(strEmail);

                        Iniciar5Actividad(obj);
                    }
                    else
                    {
                        pass = Toast.makeText(IniciarSesion.this, "ERROR! Email o Contrasena no válidos", Toast.LENGTH_SHORT);
                        pass.show();
                    }
                }
                else
                {
                    pass = Toast.makeText(IniciarSesion.this, "ERROR! Ha dejado campos vacíos", Toast.LENGTH_SHORT);
                    pass.show();
                }
            }
        });
        btnFB.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Iniciar3Actividad();
            }
        });
        btnRegis.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Iniciar2Actividad();
            }
        });
    }
    public void ObtenerReferencias()
    {
        btnIngresar=(Button) findViewById(R.id.btnIngresar);
        btnRegis=(Button) findViewById(R.id.btnRegis);
        btnFB=(Button) findViewById(R.id.btnFB);
        edtEmail= (EditText) findViewById(R.id.edtEmail);
        edtContra= (EditText) findViewById(R.id.edtContra);
        chbRecordar= (CheckBox) findViewById(R.id.chbRecordar);
    }
    public void Iniciar2Actividad()
    {
        Intent nuevaActivity = new Intent(this, Registrarse.class);
        startActivity(nuevaActivity);
    }
    public void Iniciar3Actividad()
    {
        Intent nuevaActivity = new Intent(this, Facebook.class);
        startActivity(nuevaActivity);
    }
    public void Iniciar5Actividad(Contact obj)
    {
        Intent nuevaActivity = new Intent(this, Inicio.class);
        nuevaActivity.putExtra("parametro",obj);
        startActivity(nuevaActivity);
    }
    public boolean Camposvacios()
    {
        if (strEmail.isEmpty()||strContra.isEmpty())
        {
            return true;
        }
        else
        {return false;}
    }
}
