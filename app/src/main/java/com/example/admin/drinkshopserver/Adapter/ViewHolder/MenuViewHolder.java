package com.example.admin.drinkshopserver.Adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.drinkshopserver.Interface.IItemClickListener;
import com.example.admin.drinkshopserver.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public ImageView img_product;
    public TextView txt_product;

    IItemClickListener itemClickListener;

    public void setItemClickListener(IItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public MenuViewHolder(View itemView){
        super(itemView);

        img_product = (ImageView)itemView.findViewById(R.id.img_product);
        txt_product = (TextView) itemView.findViewById(R.id.txt_menu_name);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,true);
        return true;
    }
}
