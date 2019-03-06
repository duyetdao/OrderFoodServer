package com.example.admin.drinkshopserver.Adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.admin.drinkshopserver.Interface.IItemClickListener;
import com.example.admin.drinkshopserver.R;

public class OrderViewHoder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView txt_order_id,txt_order_price,txt_order_address,txt_order_commnet,txt_order_status,txt_order_payment;
    IItemClickListener iItemClickListener;

    public void setiItemClickListener(IItemClickListener iItemClickListener) {
        this.iItemClickListener = iItemClickListener;
    }

    public OrderViewHoder(View itemView) {
        super(itemView);
        txt_order_id = itemView.findViewById(R.id.txt_order_id);
        txt_order_price = itemView.findViewById(R.id.txt_order_price);
        txt_order_commnet = itemView.findViewById(R.id.txt_order_comment);
        txt_order_status = itemView.findViewById(R.id.txt_order_status);
        txt_order_payment =itemView.findViewById(R.id.txt_order_payment);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        iItemClickListener.onClick(v, false);

    }
}
