package com.alejandro.listviewpractica;

import android.Manifest;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends ListActivity {
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 1;
    private Persona[] personas = {new Persona("Alejandro", "Ortiz Zurita", 16), new Persona("Manuel", "Fernandez", 25), new Persona("Antonino", "Perez Villar", 50), new Persona("Ambrosio", "Lacardo", 78)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permissionCheck2 = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);


        setListAdapter(new MiAdaptador(this, personas));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        lanzarContactoActivity(personas[position]);

    }

    public void lanzarContactoActivity(Persona p) {
        Intent i = new Intent(this, ContactoActivity.class);
        i.putExtra("persona", p);
        startActivity(i);

    }

/*Para listas heterogeneas se usan getViewTypeCount cuantos tipos de vistas hay
* y getItemViewType entrada posicion , nos dice que tipo de fila corresponde con esa posicion*/
}
