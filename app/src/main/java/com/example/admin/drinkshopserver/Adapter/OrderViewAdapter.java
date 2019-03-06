package com.example.admin.drinkshopserver.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.drinkshopserver.Adapter.ViewHolder.OrderViewHoder;
import com.example.admin.drinkshopserver.Interface.IItemClickListener;
import com.example.admin.drinkshopserver.Model.Order;
import com.example.admin.drinkshopserver.R;
import com.example.admin.drinkshopserver.Utils.Common;
import com.example.admin.drinkshopserver.ViewOrderDetail;

import java.util.List;

public class OrderViewAdapter extends RecyclerView.Adapter<OrderViewHoder> {

    Context context;
    List<Order> orderList;

    public OrderViewAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHoder onCreateViewHolder(@io.reactivex.annotations.NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.order_layout,parent,false);
        return new OrderViewHoder(itemView);
    }

    @Override
    public void onBindViewHolder(@io.reactivex.annotations.NonNull OrderViewHoder holder, final int position) {
        holder.txt_order_id.setText(new StringBuilder("#").append(orderList.get(position).getOrderId()));
        holder.txt_order_price.setText(new StringBuilder("$").append(orderList.get(position).getOrderPrice()));
        holder.txt_order_commnet.setText(new StringBuilder("Comment: ").append(orderList.get(position).getOrderComment()));
        holder.txt_order_status.setText(new StringBuilder("Order Status: ").append(Common.convertCodeToSatus(orderList.get(position).getOrderStatus())));
        holder.setiItemClickListener(new IItemClickListener() {

            @Override
            public void onClick(View view, boolean isLongClick) {
                Common.currentOrder = orderList.get(position);

                context.startActivity(new Intent(context, ViewOrderDetail.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
