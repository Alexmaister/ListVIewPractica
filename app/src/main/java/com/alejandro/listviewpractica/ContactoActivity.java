package com.alejandro.listviewpractica;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;


/**
 * Created by Alejandro on 17/10/2017.
 */

public class ContactoActivity extends Activity {
    private  Persona contacto;
    private ImageView imagen;
    public static final int CODIGO_FOTO=1;
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.contacto_actividad);
        contacto=(Persona)getIntent().getParcelableExtra("persona");
        ((TextView)findViewById(R.id.nombre_apellidos_c_a)).setText(contacto.getNombre()+" "+contacto.getApellidos());
        imagen=(ImageView)findViewById(R.id.imagen_c_a);
        if(contacto.imagen==null)
        imagen.setImageDrawable(this.getResources().getDrawable(ControladorPersona.obtenerImagen((Persona)contacto)));
        else
            imagen.setImageURI(contacto.imagen);

    }

    public void hacerFoto(View vista){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri foto=Uri.fromFile(new File(Environment.DIRECTORY_PICTURES+File.separator+"img_"+(System.currentTimeMillis()/1000)+".jpg"));
        i.putExtra(MediaStore.EXTRA_OUTPUT,foto);
        startActivityForResult(i,CODIGO_FOTO);
        ControladorPersona.ponerFoto(foto,contacto);

    }

}
