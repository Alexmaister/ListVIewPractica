package com.alejandro.listviewpractica;

import android.net.Uri;

/**
 * Created by Alejandro on 18/10/2017.
 */

public class ControladorPersona {
    public static int obtenerImagen(Persona p){
        int resource=0;
        if(p.imagen==null){

        if(p.getEdad()<18)
            resource=R.drawable.nino;
        else if(p.getEdad()<30)
            resource=R.drawable.adolescente;
        else if(p.getEdad()<60)
            resource=R.drawable.adulto;
        else
            resource=R.drawable.anciano;}

        return resource;
    }
    public static int obtenerTipo(Persona p){
        int resource=0;
        if(p.imagen==null){

            if(p.getEdad()<18)
                resource=0;
            else if(p.getEdad()<30)
                resource=1;
            else if(p.getEdad()<60)
                resource=0;
            else
                resource=1;}

        return resource;
    }
    public static void establecerURI(Uri uri, Persona p){

        p.imagen=uri;
    }
    public static void ponerFoto(Uri foto,Persona p){
        if(foto instanceof Uri && foto!=null){
            establecerURI(foto,p);


        }
    }

}
