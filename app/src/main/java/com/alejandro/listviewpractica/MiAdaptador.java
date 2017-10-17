package com.alejandro.listviewpractica;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Alejandro on 16/10/2017.
 */

public class MiAdaptador extends BaseAdapter{
    private Activity actividad;
    private Persona[] array;
    public MiAdaptador(Activity actividad,Persona[] array) {
        super();
        this.actividad=actividad;
        this.array=array;
    }

    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public Persona getItem(int position) {
        return array[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Persona p=array[position];
        LayoutInflater inflater=actividad.getLayoutInflater();
        //adjuntamos el recurso vista_persona, null(a nadie ya que la lista va a pantalla completa, true(indica si el recurso que se adjuntara al viewGroup debe adjuntar todas sus vistas , en este caso si))
        View view= inflater.inflate(R.layout.vista_persona,null,true);
        TextView nombre=(TextView) view.findViewById(R.id.nombre);
        TextView apellidos=(TextView) view.findViewById(R.id.apellidos);
        TextView edad=(TextView) view.findViewById(R.id.edad);
        nombre.setText(p.getNombre());
        apellidos.setText(p.getApellidos());
        edad.setText(String.valueOf(p.getEdad()));

       if(array[position].getEdad()<18)
            ((ImageView) view.findViewById(R.id.imagen)).setImageDrawable(((ImageView) view.findViewById(R.id.imagen)).getResources().getDrawable(R.drawable.nino));
        else if(array[position].getEdad()<30)
            ((ImageView) view.findViewById(R.id.imagen)).setImageDrawable(((ImageView) view.findViewById(R.id.imagen)).getResources().getDrawable(R.drawable.adolescente));
        else if(array[position].getEdad()<60)
            ((ImageView) view.findViewById(R.id.imagen)).setImageDrawable(((ImageView) view.findViewById(R.id.imagen)).getResources().getDrawable(R.drawable.adulto));
        else
            ((ImageView) view.findViewById(R.id.imagen)).setImageDrawable(((ImageView) view.findViewById(R.id.imagen)).getResources().getDrawable(R.drawable.anciano));

        return view;
    }
}
