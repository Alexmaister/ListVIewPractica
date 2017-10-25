package com.alejandro.listviewpractica;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aortiz on 24/10/17.
 */

public class ContactoHolder {

    private ImageView img;
    private TextView txt;

    public ContactoHolder(ImageView img, TextView txt) {
        this.img = img;
        this.txt = txt;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public TextView getTxt() {
        return txt;
    }

    public void setTxt(TextView txt) {
        this.txt = txt;
    }


}
