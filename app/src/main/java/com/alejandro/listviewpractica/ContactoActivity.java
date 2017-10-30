package com.alejandro.listviewpractica;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;


/**
 * Created by Alejandro on 17/10/2017.
 */

public class ContactoActivity extends Activity {
    private  Persona contacto;
    private ImageView imagen;
    private String imagenPath;
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
            imagen.setImageBitmap(contacto.imagen);

    }

    public void hacerFoto(View vista){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(i.resolveActivity(getPackageManager())!=null){

            File foto=null;

            foto=crearFicheroImagen();

            if(foto!=null){

                añadirFotoGaleria();
                i.putExtra(MediaStore.EXTRA_OUTPUT,imagenPath);
                startActivityForResult(i,CODIGO_FOTO);
            }
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==CODIGO_FOTO){

            if(resultCode== RESULT_OK){

                Bundle extras=data.getExtras();
                establecerImagen();
                imagen.setImageBitmap((Bitmap)extras.get("data"));




            }
        }
    }
    private File crearFicheroImagen(){

        File foto=null;
        String nombrefoto= System.currentTimeMillis()+"-";
        try {
            foto = File.createTempFile(nombrefoto, ".jpg", (getExternalFilesDir(Environment.DIRECTORY_PICTURES)));
            imagenPath=foto.getAbsolutePath();
        }catch (IOException e){}

        return foto;
    }
    private void añadirFotoGaleria(){

        Intent escanearFichero=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File file = new File(imagenPath);
        Uri fileUri=Uri.fromFile(file);
        escanearFichero.setData(fileUri);
        this.sendBroadcast(escanearFichero);

    }

    private void establecerImagen(){

        contacto.imagen=BitmapFactory.decodeFile(imagenPath);
    }


}
