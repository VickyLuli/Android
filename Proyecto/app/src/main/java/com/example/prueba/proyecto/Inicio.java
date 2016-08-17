package com.example.prueba.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.net.URL;

public class Inicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static String PARAMETRO_RESULT = "com.example.prueba.proyecto";
    ImageButton imbKravi;
    ImageButton imbApple;
    ImageButton imbBdm;
    ImageButton imbPorto;
    EditText edtBuscar;
    TextView tvNombreApellido;
    TextView tvEmail;
    Contact objeto;
    String NombreApellido ="";
    String mail;
    View hView;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ObtenerReferencias();
        imbPorto.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Iniciar8Actividad();
            }
        });

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        hView =  navigationView.getHeaderView(0);
        ObtenerReferencias2();

        objeto = (Contact)getIntent().getExtras().getSerializable("parametro");
        NombreApellido= objeto.Nombre+ " "+ objeto.Apellido;
        mail = objeto.Email;
        tvNombreApellido.setText(NombreApellido);
        tvEmail.setText(mail);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
           return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_gallery) {
            Iniciar7Actividad();
        } else if (id == R.id.nav_slideshow) {
            Iniciar1Actividad();
        } else if (id == R.id.nav_manage) {
            Iniciar6Actividad(objeto);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void Iniciar1Actividad()
    {
        Intent nuevaActivity = new Intent(this, IniciarSesion.class);
        startActivity(nuevaActivity);
    }
    public void Iniciar8Actividad()
    {
        Intent nuevaActivity = new Intent(this, DetalleEvento.class);
        startActivity(nuevaActivity);
    }
    public void Iniciar7Actividad()
    {
        Intent nuevaActivity = new Intent(this, MisEntradas.class);

        startActivity(nuevaActivity);
    }
    public void Iniciar6Actividad(Contact obj)
    {
        Intent nuevaActivity = new Intent(this, DatosPersonales.class);
        nuevaActivity.putExtra("parametro",obj);
        startActivity(nuevaActivity);
    }
    public void ObtenerReferencias()
    {
        imbApple=(ImageButton) findViewById(R.id.imbApple);
        imbBdm=(ImageButton) findViewById(R.id.imbBdm);
        edtBuscar=(EditText) findViewById(R.id.edtBuscar);
        imbKravi=(ImageButton) findViewById(R.id.imbKravi);
        imbPorto=(ImageButton) findViewById(R.id.imbPorto);



    }
    public void ObtenerReferencias2()
    {
        tvEmail = (TextView)hView.findViewById(R.id.tvEmail);
        tvNombreApellido = (TextView)hView.findViewById(R.id.tvname);
    }
}
