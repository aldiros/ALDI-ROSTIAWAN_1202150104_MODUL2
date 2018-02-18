package com.example.aldiros.modul2;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MenuMakan extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Menu> mMenu;
    private MenuAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu_makan);
    mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);     //      mangambil id recycler view
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mMenu = new ArrayList<>();              // membuat objek array list menu untuk menyimpan String dan image
    mAdapter = new MenuAdapter(this, mMenu);    //      membuat adapter untuk recycler view

        initializeData();
}

    private void initializeData() {
//      mengambil array list string
        String[] menuList = getResources().getStringArray(R.array.menu_nama);
        String[] menuHarga = getResources().getStringArray(R.array.harga);
        String[] menuKomposisi = getResources().getStringArray(R.array.komposisi);
        TypedArray menuImageResources = getResources().obtainTypedArray(R.array.menu_images);

        mMenu.clear();

        //memasukkan String dan Image id ke Array list
        for(int i=0; i<menuList.length; i++){
            mMenu.add(new Menu(menuList[i], menuHarga[i], menuKomposisi[i],
                    menuImageResources.getResourceId(i,0)));
        }

        menuImageResources.recycle();

        //notifkasi perubahan pada adapter dan menggunakan adapter pada recycler view
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mAdapter);
    }
}
