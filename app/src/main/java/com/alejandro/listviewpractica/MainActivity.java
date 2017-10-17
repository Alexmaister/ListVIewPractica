package com.alejandro.listviewpractica;

import android.app.ListActivity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    private Persona[] personas={new Persona("Alejandro","Ortiz Zurita", 16),new Persona("Manuel","Fernandez", 25),new Persona("Antonino","Perez Villar",50),new Persona("Ambrosio","Lacardo" ,78)};
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new MiAdaptador(this,personas));
    }
}
