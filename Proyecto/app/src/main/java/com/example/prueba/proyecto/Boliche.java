package com.example.prueba.proyecto;

import java.io.Serializable;

/**
 * Created by 41470134 on 6/7/2016.
 */
public class Boliche implements Serializable
{
    String Nombre,Direccion,Telefono,Estilo,Capacidad,Apertura,Edad,Imagen;
    public String getNombre()
    {
        return this.Nombre;
    }
    public String getDireccion()
    {
        return this.Direccion;
    }
    public String getTelefono()
    {
        return this.Telefono;
    }
    public String getEstilo()
    {
        return this.Estilo;
    }
    public String getCapacidad()
    {
        return this.Capacidad;
    }
    public String getApertura()
    {
        return this.Apertura;
    }
    public String getEdad()
    {
        return this.Edad;
    }
    public String getImagen()
    {
        return this.Imagen;
    }

}
