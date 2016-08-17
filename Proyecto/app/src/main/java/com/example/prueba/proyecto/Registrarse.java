package com.example.prueba.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import java.lang.*;
import java.util.Date;
public class Registrarse extends AppCompatActivity {

    Button btnRegistrarse;
    EditText edtEmail;
    EditText edtContraseña;
    EditText edtRContraseña;
    EditText edtNombre;
    EditText edtApellido;
    EditText edtFechaNac;
    EditText edtDirec;
    EditText edtTelefono;
    EditText edtDNI;
    RadioButton rdbFem;
    RadioButton rdbMasculino;
    CheckBox chbAcepto;
    Toast pass;
    String Email;
    String Contrasena;
    String RContrasena;
    String Nombre;
    String Apellido;
    String FechaNac;
    String Direccion;
    String Telefono;
    String DNI;
    String sexo;
    Boolean Validacion=true;
    DataBaseHelper helper= new DataBaseHelper(this, "BaseDeDatos", null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        ObtenerReferencias();
        Log.d("Entro","OnCreate");

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Email = edtEmail.getText().toString();
                Contrasena = edtContraseña.getText().toString();
                RContrasena = edtRContraseña.getText().toString();
                Nombre = edtNombre.getText().toString();
                Apellido = edtApellido.getText().toString();
                FechaNac = edtFechaNac.getText().toString();
                Direccion = edtDirec.getText().toString();
                Telefono = edtTelefono.getText().toString();
                DNI = edtDNI.getText().toString();
                boolean camposvacios = Camposvacios();
                if (!camposvacios)
                {
                    //no se repita email
                    //VALIDAR QUE EL NOMBRE Y APELLIDO SOLO SEAN LETRAS
                    //VALIDAR QUE EL EMAIL ESTE CORRECTO
                    //VALIDAR QUE
                    // LA FECHA DE NAC ESTE BIEN ESCRITA Y SEA CORRECTA Y NO SEA MENOR DE X EDAD
                    Integer intTest;

                    try {
                        intTest = Integer.parseInt(Telefono);
                        intTest=Integer.parseInt(DNI);
                    }
                    catch (Exception miexcepcion)
                    {
                        Validacion=false;

                    }

                    if (!edtContraseña.getText().toString().equals(edtRContraseña.getText().toString()) || Validacion==false)
                    {
                        pass = Toast.makeText(Registrarse.this, "ERROR! Los datos no son correctos", Toast.LENGTH_SHORT);
                        pass.show();
                    }
                    else
                    {
                        if(rdbFem.isChecked())
                        {
                            sexo="f";
                        }
                        else
                        {sexo="m";}
                        Contact c = new Contact();
                        c.setEmail(Email);
                        c.setContrasena(Contrasena);
                        c.setNombre(Nombre);
                        c.setApellido(Apellido);
                        c.setDireccion(Direccion);
                        c.setFechaNac(FechaNac);
                        c.setSexo(sexo);
                        c.setTelefono(Telefono);
                        c.setDNI(DNI);
                        helper.InsertarUsuario(c);
                        Iniciar4Actividad(c);
                    }
                }
                else
                {
                    pass = Toast.makeText(Registrarse.this, "ERROR! Ha dejado campos vacíos", Toast.LENGTH_SHORT);
                    pass.show();
                }
            }
        });
    }
    public boolean Camposvacios()
    {
        if (Email.isEmpty()||Contrasena.isEmpty()||RContrasena.isEmpty()||Nombre.isEmpty()||Apellido.isEmpty()||FechaNac.isEmpty()||Direccion.isEmpty()||Telefono.isEmpty()||DNI.isEmpty())
        {
            return true;
        }
        else{return false;}
    }
    public void ObtenerReferencias()
    {
        btnRegistrarse= (Button) findViewById(R.id.btnRegistrarse);
        edtEmail= (EditText) findViewById(R.id.edtEmail);
        edtContraseña= (EditText) findViewById(R.id.edtContraseña);
        edtRContraseña= (EditText) findViewById(R.id.edtRContraseña);
        edtNombre= (EditText) findViewById(R.id.edtNombre);
        edtApellido= (EditText) findViewById(R.id.edtApellido);
        edtFechaNac= (EditText) findViewById(R.id.edtFechaNac);
        edtDirec= (EditText) findViewById(R.id.edtDireccion);
        edtTelefono= (EditText) findViewById(R.id.edtTelefono);
        edtDNI= (EditText) findViewById(R.id.edtDNI);
        rdbFem= (RadioButton) findViewById(R.id.rdbFem);
        rdbMasculino= (RadioButton) findViewById(R.id.rdbMasculino);
        chbAcepto=(CheckBox) findViewById(R.id.chbAcepto);
    }
    public void Iniciar4Actividad(Contact c)
    {
        Intent nuevaActivity = new Intent(this, PostRegistracion.class);
        nuevaActivity.putExtra("parametro",c);
        startActivity(nuevaActivity);
    }
}
