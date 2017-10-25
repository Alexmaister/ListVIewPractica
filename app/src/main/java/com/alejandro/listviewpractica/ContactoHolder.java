package com.alejandro.listviewpractica;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aortiz on 24/10/17.
 */

public class ContactoHolder {



    private ImageView img;
    private TextView nombre;
    private TextView apellidos;
    private TextView edad;

    public ContactoHolder(View v) {
        this.img        =       (ImageView) v.findViewById(R.id.imagen);
        this.nombre     =       (TextView) v.findViewById(R.id.nombre);
        this.apellidos  =       (TextView) v.findViewById(R.id.apellidos);
        this.edad       =       (TextView) v.findViewById(R.id.edad);
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img.setImageResource(img);
    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.setText(nombre);
    }

    public TextView getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos.setText(apellidos);
    }

    public TextView getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad.setText(String.valueOf(edad));
    }

}
