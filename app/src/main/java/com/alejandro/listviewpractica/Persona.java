package com.alejandro.listviewpractica;

import java.io.Serializable;

/**
 * Created by Alejandro on 16/10/2017.
 */

public class Persona implements Serializable{

    static final long SerialVersionUID=1l;
    private String nombre;
    private String apellidos;
    private int edad;




    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }



    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }




    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

}
