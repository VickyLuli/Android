package com.example.prueba.proyecto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.io.SerializablePermission;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by TOSHIBA on 27/06/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BaseDeDatos.db";
    private static final String TABLE_NAME = "Usuario";
    private static final String COLUMN_ID = "IdUsuario";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_CONTRASENA = "Contrasena";
    private static final String COLUMN_NOMBRE = "Nombre";
    private static final String COLUMN_APELLIDO = "Apellido";
    private static final String COLUMN_FECHANAC = "FechadeNacimiento";
    private static final String COLUMN_SEXO = "Sexo";
    private static final String COLUMN_DIRECCION = "Direccion";
    private static final String COLUMN_TELEFONO = "Telefono";
    private static final String COLUMN_DNI = "DNI";

    private static final String TABLE_BOLI = "Boliches";
    private static final String COLUMN_IDB = "IdBoliche";
    private static final String COLUMN_NOMBREB = "Nombre";
    private static final String COLUMN_DIRECCIONB = "Direccion";
    private static final String COLUMN_TELEFONOB = "Telefono";
    private static final String COLUMN_ESTILO = "Estilo";
    private static final String COLUMN_CAPACIDAD = "Capacidad";
    private static final String COLUMN_APERTURA= "Apertura";
    private static final String COLUMN_EDAD = "Edad";
    private static final String COLUMN_IMG = "Imagen";
    SQLiteDatabase db;
    private static final String TABLE_CREATE="CREATE TABLE `Usuario` (\n" +
            "\t`IdUsuario`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`Email`\tTEXT NOT NULL,\n" +
            "\t`Contrasena`\tTEXT NOT NULL,\n" +
            "\t`Nombre`\tTEXT NOT NULL,\n" +
            "\t`Apellido`\tTEXT NOT NULL,\n" +
            "\t`FechadeNacimiento`\tTEXT NOT NULL,\n" +
            "\t`Sexo`\tTEXT NOT NULL,\n" +
            "\t`Direccion`\tTEXT,\n" +
            "\t`Telefono`\tTEXT NOT NULL,\n" +
            "\t`DNI`\tTEXT NOT NULL\n" +
            ");";
    private static final String TABLE_CREATE2="CREATE TABLE `Boliches` (\n" +
            "\t`IdBoliche`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`Nombre`\tTEXT NOT NULL,\n" +
            "\t`Direccion`\tTEXT NOT NULL,\n" +
            "\t`Telefono`\tTEXT NOT NULL,\n" +
            "\t`Estilo`\tTEXT NOT NULL,\n" +
            "\t`Capacidad`\tTEXT NOT NULL,\n" +
            "\t`Apertura`\tTEXT NOT NULL,\n" +
            "\t`Edad`\tTEXT,\n" +
            "\t`Imagen`\tTEXT NOT NULL\n" +
            ");";

    public DataBaseHelper(Context context, String DATABASE_NAME, CursorFactory factory, int DATABASE_VERSION)
    {
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE2);
        //db = this.getWritableDatabase();
        //db.execSQL("INSERT INTO Usuario\n" + "VALUES (null,'luli@ort.edu.ar','luli','Luciana','Borzone','18061999','f','caca',14263245321,42011873);");
        //db.close();
        this.db=db;

    }
    public void InsertarUsuario(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_CONTRASENA,c.getContrasena());
        values.put(COLUMN_NOMBRE,c.getNombre());
        values.put(COLUMN_APELLIDO,c.getApellido());
        values.put(COLUMN_FECHANAC,c.getFechaNac());
        values.put(COLUMN_SEXO,c.getSexo());
        values.put(COLUMN_DIRECCION,c.getDireccion());
        values.put(COLUMN_TELEFONO,c.getTelefono());
        values.put(COLUMN_DNI,c.getDNI());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public void ListarImagenesb()
    {
        db = this.getReadableDatabase();
        String query = "select Imagen.Boliches from Boliches";
        Cursor cursor= db.rawQuery(query,null);
int contar = cursor.getCount();
        int i;
        for(i=0;i<contar;i++)
        {

        }
    }
    public Contact Obtener(String mail)
    {
        String b;
        Integer hola;
        Contact contac = new Contact();
        db = this.getReadableDatabase();
        String query = "select * from Usuario WHERE Email='"+mail+"'";
        Cursor cursor= db.rawQuery(query,null);
        cursor.moveToFirst();
        contac.setEmail(mail);
        b =(cursor.getString(2));
        contac.setContrasena(b);
        b =(cursor.getString(3));
        contac.setNombre(b);
        b=(cursor.getString(4));
        contac.setApellido(b);
        b=(cursor.getString(5));
        contac.setFechaNac(b);
        b=(cursor.getString(6));
        contac.setSexo(b);
        b=(cursor.getString(7));
        contac.setDireccion(b);
        b=(cursor.getString(8));
        contac.setTelefono(b);
        b=(cursor.getString(9));
        contac.setDNI(b);
        db.close();
        return contac;
    }
    public String BuscoContrasena(String Email)
    {
        db=this.getWritableDatabase();
        db.execSQL("INSERT INTO Usuario\n" +
                "VALUES (null,'luli@ort.edu.ar','luli','Luciana','Borzone','18061999','f','caca','14263245321','42011873');");
        db.close();
        db = this.getReadableDatabase();
        String query = "SELECT Contrasena from Usuario WHERE Email='"+Email+"'";
        Cursor cursor=db.rawQuery(query,null);
        String b;
        b="not found";
        try {
            cursor.moveToFirst();
            if (cursor != null && cursor.getCount() >0) {

                b = cursor.getString(0);
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
        db.close();
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query= "DROP TABLE IF EXISTS"+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
        query= "DROP TABLE IF EXISTS"+ TABLE_BOLI;
        db.execSQL(query);
        this.onCreate(db);
    }
}
