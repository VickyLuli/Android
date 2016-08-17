package com.example.prueba.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DatosPersonales extends AppCompatActivity {
    TextView tvNombreApellido,tvEmail,tvFecha,tvSexo,tvDireccion,tvTel,tvDNI;
    String NombreApellido,Email,Fecha,Sexo,Direccion,Telefono,DNI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);
        Contact objeto = (Contact)getIntent().getExtras().getSerializable("parametro");
        ObtenerReferencias();
        NombreApellido= objeto.Nombre.toString() + " " + objeto.Apellido.toString();
        tvNombreApellido.setText(NombreApellido);
        Email= "Mi dirección de correo: "+ objeto.Email.toString();
        tvEmail.setText(Email);
        Fecha= "Mi fecha de nacimiento: "+ objeto.FechaNac.toString();
        tvFecha.setText(Fecha);
        if(objeto.Sexo=="f")
        {Sexo= "Sexo: Femenino";}
        else
        {{Sexo= "Sexo: Masculino";}}
        tvSexo.setText(Sexo);
        Direccion= "Mi Dirección: "+ objeto.Direccion.toString();
        tvDireccion.setText(Direccion);
        Telefono= "Mi Teléfono: "+ objeto.Telefono.toString();
        tvTel.setText(Telefono);
        DNI= "Mi DNI: "+ objeto.DNI.toString();
        tvDNI.setText(DNI);
    }
    public void ObtenerReferencias()
    {
        tvNombreApellido = (TextView)findViewById(R.id.txtNombreApellido);
        tvEmail = (TextView)findViewById(R.id.txtEmail);
        tvFecha = (TextView)findViewById(R.id.txtFecha);
        tvSexo = (TextView)findViewById(R.id.txtSexo);
        tvDireccion = (TextView)findViewById(R.id.txtDir);
        tvTel = (TextView)findViewById(R.id.txtTel);
        tvDNI = (TextView)findViewById(R.id.txtDNI);


    }
}
