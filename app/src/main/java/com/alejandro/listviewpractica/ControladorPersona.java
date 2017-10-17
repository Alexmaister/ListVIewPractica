package com.alejandro.listviewpractica;

/**
 * Created by Alejandro on 18/10/2017.
 */

public class ControladorPersona {
    public static int obtenerImagen(Persona p){
        int resource=0;
        if(p.getEdad()<18)
            resource=R.drawable.nino;
        else if(p.getEdad()<30)
            resource=R.drawable.adolescente;
        else if(p.getEdad()<60)
            resource=R.drawable.adulto;
        else
            resource=R.drawable.anciano;
        return resource;
    }
}
