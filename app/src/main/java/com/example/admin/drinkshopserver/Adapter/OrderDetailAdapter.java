package com.example.admin.drinkshopserver.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.drinkshopserver.Model.Cart;
import com.example.admin.drinkshopserver.R;
import com.example.admin.drinkshopserver.Utils.Common;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.List;


public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.OrderDetailkViewHolder> {

    Context context;
    List<Cart> itemList;

    public OrderDetailAdapter(Context context) {
        this.context = context;
        this.itemList = new Gson().fromJson(Common.currentOrder.getOrderDetail(), new TypeToken<List<Cart>>(){}.getType());
    }

    @NonNull
    @Override
    public OrderDetailkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_detail_layout,parent,false);
        return new OrderDetailkViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailkViewHolder holder, int position) {

        holder.txt_drink_amount.setText(""+itemList.get(position).getAmount());
        holder.txt_drink_name.setText(new StringBuilder(itemList.get(position).getName()));
        holder.txt_size.setText(itemList.get(position).getSize() == 0?"Size M":"Size L");
        holder.txt_sugar_ice.setText(new StringBuilder("Sugar: ").append(itemList.get(position).getSugar())
        .append(", Ice: ").append(itemList.get(position).getIce()));


        if (itemList.get(position).getToppingExtras() != null &&
                !itemList.get(position).getToppingExtras().isEmpty()){
            String topping_format = itemList.get(position).getToppingExtras().replaceAll("\\n",",");
            topping_format = topping_format.substring(0,topping_format.length()-1);

            holder.txt_topping.setText(topping_format);
        }
        else
        {
            holder.txt_topping.setText("None");
        }


        Picasso.with(context).load(itemList.get(position).getLink()).into(holder.img_order_item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class OrderDetailkViewHolder extends RecyclerView.ViewHolder{
        ImageView img_order_item;
        TextView txt_drink_name, txt_drink_amount, txt_sugar_ice, txt_size, txt_topping;

        public OrderDetailkViewHolder(View itemView) {
            super(itemView);

            img_order_item = (ImageView)itemView.findViewById(R.id.img_order_item);
            txt_drink_amount = (TextView)itemView.findViewById(R.id.txt_drink_amount);
            txt_sugar_ice = (TextView)itemView.findViewById(R.id.txt_sugar_ice);
            txt_size = (TextView)itemView.findViewById(R.id.txt_size);
            txt_topping = (TextView)itemView.findViewById(R.id.txt_topping);
            txt_drink_name = (TextView)itemView.findViewById(R.id.txt_drink_name);

        }
    }
}
