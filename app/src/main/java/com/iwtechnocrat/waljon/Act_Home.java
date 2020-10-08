package com.iwtechnocrat.waljon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.iwtechnocrat.waljon.Activities.Act_Search;
import com.iwtechnocrat.waljon.Activities.Act_Wishlist;
import com.iwtechnocrat.waljon.Fragment.HommeeFragment;
import com.iwtechnocrat.waljon.Fragment.Profile_Frag;
import com.iwtechnocrat.waljon.Fragment.Categories_Frag;
import com.iwtechnocrat.waljon.GoogleMap.SearchCity;

public class Act_Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {

    DrawerLayout dLayout;
    Toolbar  toolbar;
    SearchView mSearchView;
    BottomNavigationView navigation;
    ImageView search,wishlist,map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__admin_home);
        toolbar = findViewById(R.id.toolbar);

        loadFragment(new HommeeFragment());


      navigation = findViewById(R.id.navigation);
        wishlist = findViewById(R.id.wishlist);
        navigation.setOnNavigationItemSelectedListener(this);
        search = findViewById(R.id.search);
        map = findViewById(R.id.map);

        Menu a = navigation.getMenu();
        MenuItem b = a.findItem(R.id.nav_home);
        navigation.setItemIconTintList(null);
       // BVMenu.setItemIconTintList(null);
        b.setIcon(R.drawable.wlogo11);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_Search.class);
                startActivity(intent);
            }
        });


        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_Wishlist.class);
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchCity.class);
                startActivity(intent);
            }
        });

    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.nav_home:
                fragment = new HommeeFragment();
                break;

            case R.id.nav_profile:
                fragment = new Profile_Frag();
                break;
   case R.id.nav_categories:
                fragment = new Categories_Frag();
                break;


        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commitAllowingStateLoss();
            return true;
        }
        return false;
    }

    private void setUpHomeFragment(){
        HommeeFragment homeFrag =new HommeeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame, homeFrag);
        ft.addToBackStack(null);
        ft.commit();
    }






    @Override
    public void onBackPressed() {
        super.onBackPressed();
        HommeeFragment homeFrag =new HommeeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame, homeFrag);
        ft.addToBackStack(null);
        ft.commit();

    }








}