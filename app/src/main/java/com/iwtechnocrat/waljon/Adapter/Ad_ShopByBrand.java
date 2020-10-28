package com.iwtechnocrat.waljon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iwtechnocrat.waljon.Model.Shop_by_Brand_model;
import com.iwtechnocrat.waljon.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Ad_ShopByBrand extends RecyclerView.Adapter<Ad_ShopByBrand.ViewHolder> {
    Context context;
    List<Shop_by_Brand_model> shop_by_brand_models;

    public Ad_ShopByBrand(Context context, List<Shop_by_Brand_model> shop_by_brand_models) {
        this.context = context;
        this.shop_by_brand_models = shop_by_brand_models;
    }

    @NonNull
    @Override
    public Ad_ShopByBrand.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_custum,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Ad_ShopByBrand.ViewHolder holder, int position) {
        Shop_by_Brand_model userListModel = shop_by_brand_models.get(position);

        holder.tv_milk_product.setText(userListModel.getName());

        Picasso.get().load(userListModel.getImage()).error(R.mipmap.ic_launcher).into(holder.topcat_img_1);


    }

    @Override
    public int getItemCount() {
        return shop_by_brand_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_milk_product;
        ImageView topcat_img_1;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_milk_product = itemView.findViewById(R.id.tv_milk_product);
            topcat_img_1 = itemView.findViewById(R.id.topcat_img_1);

        }
    }
}
