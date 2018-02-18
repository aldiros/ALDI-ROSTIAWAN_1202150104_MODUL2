package com.example.aldiros.modul2;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMakanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);
//        mengaambil id layout .
        TextView namaMenu = (TextView) findViewById(R.id.namaMenu);
        TextView hargamenu = (TextView) findViewById(R.id.hargaMenu);
        TextView komposisi = (TextView) findViewById(R.id.komposisi);
        ImageView Imagemenu = (ImageView) findViewById(R.id.menuImage);

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);
        gradientDrawable.setSize(100,100);

//        set layout dengan id
        namaMenu.setText(getIntent().getStringExtra("nama"));
        hargamenu.setText(getIntent().getStringExtra("harga"));
        komposisi.setText(getIntent().getStringExtra("komposisi"));
        Glide.with(this).load(getIntent().getIntExtra("image",0))
                .placeholder(gradientDrawable).into(Imagemenu);


    }
}
