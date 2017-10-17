package com.alejandro.listviewpractica;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Alejandro on 17/10/2017.
 */

public class ContactoActivity extends Activity {
    private  Persona contacto;
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.contacto_actividad);
        contacto=(Persona)getIntent().getSerializableExtra("persona");
        ((TextView)findViewById(R.id.nombre_apellidos_c_a)).setText(contacto.getNombre()+" "+contacto.getApellidos());
        ((ImageView)findViewById(R.id.imagen_c_a)).setImageDrawable(this.getResources().getDrawable(ControladorPersona.obtenerImagen((Persona)contacto)));
    }
}
