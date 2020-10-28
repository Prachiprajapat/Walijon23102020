package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.iwtechnocrat.waljon.Act_Home;
import com.iwtechnocrat.waljon.Adapter.Ad_WishList;
import com.iwtechnocrat.waljon.Model.WishListModel;
import com.iwtechnocrat.waljon.R;

import java.util.ArrayList;

public class Act_Wishlist extends AppCompatActivity {
    ImageView back;
    ArrayList<WishListModel> wishListModels = new ArrayList<>();
    RecyclerView recycle_wishlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__wishlist);

        back = findViewById(R.id.back);
        recycle_wishlist = findViewById(R.id.recycle_wishlist);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_Home.class);
                startActivity(intent);
            }
        });

        wishListModels.add(new WishListModel("Fossil","250","50",R.drawable.watch));
        wishListModels.add(new WishListModel("Fossil","250","50",R.drawable.watch));
        Ad_WishList ad_wishList = new Ad_WishList(getApplicationContext(),wishListModels);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recycle_wishlist.setLayoutManager(gridLayoutManager);
        recycle_wishlist.setAdapter(ad_wishList);
    }
}