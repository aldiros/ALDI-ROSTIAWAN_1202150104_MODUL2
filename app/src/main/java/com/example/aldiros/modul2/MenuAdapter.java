package com.example.aldiros.modul2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by aldiros on 18/02/2018.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{

    // membuat array, kontainer gambar dan kontex aktivitas untuk konstruktor
    private GradientDrawable mGradientDrawable;
    private ArrayList<Menu> mMenuData;
    private Context mContext;

    MenuAdapter(Context mContext, ArrayList<Menu> mMenuData) {
        this.mMenuData = mMenuData;
        this.mContext = mContext;
//        set conatainer untuk gambar
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setSize(70,70);
    }

    //    mengemmbalikan MenuvVewHolder
    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MenuViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false), mGradientDrawable);
    }

    //    mengisi item recycler view
    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        Menu current = mMenuData.get(position);
        holder.bindTo(current);
    }

    @Override
    public int getItemCount() {
        return mMenuData.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mNama;
        private TextView mHarga;
        private ImageView mMenuImage;
        private Context mContext;
        private Menu mCurrentMenu;
        private GradientDrawable mGradientDrawable;

        // mencari sesuai id pada layout list_item
        MenuViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);
            mNama = (TextView)itemView.findViewById(R.id.namaMenu);
            mHarga = (TextView)itemView.findViewById(R.id.hargaMenu);
            mMenuImage = (ImageView)itemView.findViewById(R.id.menuImage);
            mContext = context;
            mGradientDrawable = gradientDrawable;

            itemView.setOnClickListener(this);
        }

        //        set semua layout dengan nilai string dan gambar dari objek menu
        public void bindTo(Menu current) {
            mNama.setText(current.getNama());
            mHarga.setText(current.getHargaMenu());
            mCurrentMenu = current;

//          gunakan glide untuk load gambar
            Glide.with(mContext).load(current.getImageMenu()).placeholder(mGradientDrawable).into(mMenuImage);
        }

        // membuka detail menu dengan intent dari menu.
        @Override
        public void onClick(View view) {
            Intent detailIntent = Menu.starter(mContext, mCurrentMenu.getNama(),
                    mCurrentMenu.getHargaMenu(), mCurrentMenu.getKomposisi(),
                    mCurrentMenu.getImageMenu());

            mContext.startActivity(detailIntent);
        }


    }
}
