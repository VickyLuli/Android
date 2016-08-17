package com.example.prueba.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by TOSHIBA on 27/06/2016.
 */

@SuppressWarnings("serial")
public class Contact implements Serializable
{

    String Email,Contrasena,Nombre,Apellido,Direccion;
    String FechaNac,Telefono,DNI;
    String Sexo;
    public void setEmail(String Email)
    {
        this.Email=Email;
    }
    public String getEmail()
    {
        return this.Email;
    }
    public void setContrasena(String Contrasena)
    {
        this.Contrasena=Contrasena;
    }
    public String getContrasena()
    {
        return this.Contrasena;
    }
    public void setNombre(String Nombre)
    {
        this.Nombre=Nombre;
    }
    public String getNombre()
    {
        return this.Nombre;
    }
    public void setApellido(String Apellido)
    {
        this.Apellido=Apellido;
    }
    public String getApellido()
    {
        return this.Apellido;
    }
    public void setFechaNac(String FechaNac)
    {
        this.FechaNac=FechaNac;
    }
    public String getFechaNac()
    {
        return this.FechaNac;
    }
    public void setSexo(String Sexo)
    {
        this.Sexo=Sexo;
    }
    public String getSexo()
    {
        return this.Sexo;
    }
    public void setDireccion(String Direccion)
    {
        this.Direccion=Direccion;
    }
    public String getDireccion()
    {
        return this.Direccion;
    }
    public void setTelefono(String Telefono)
    {
        this.Telefono=Telefono;
    }
    public String getTelefono()
    {
        return this.Telefono;
    }
    public void setDNI(String DNI)
    {
        this.DNI=DNI;
    }
    public String getDNI()
    {
        return this.DNI;
    }



}
