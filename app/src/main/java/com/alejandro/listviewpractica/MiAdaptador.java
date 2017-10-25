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
        //utilizamos la vista reciclada
        ContactoHolder holder;
        View view= convertView;
        if(view==null) {

            switch (getItemViewType(position)){
                case 0: view = inflater.inflate(R.layout.vista_persona, parent, false);
                    break;
                case 1:view = inflater.inflate(R.layout.vista_persona_mayor, parent, false);
            }
            holder=new ContactoHolder(view);
        }else{

                holder=(ContactoHolder) view.getTag();
            }


            holder.setNombre(p.getNombre());
            holder.setApellidos(p.getApellidos());
            holder.setEdad(p.getEdad());
            holder.setImg(ControladorPersona.obtenerImagen(p));



        view.setTag(holder);

        return view;
    }

    @Override
    public int getItemViewType(int position) {
        return ControladorPersona.obtenerTipo(array[position]);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
