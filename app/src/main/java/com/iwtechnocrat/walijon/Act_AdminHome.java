package com.iwtechnocrat.walijon;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.iwtechnocrat.walijon.Fragment.HomeFrag;
import com.iwtechnocrat.walijon.Fragment.Profile_Frag;
import com.iwtechnocrat.walijon.Fragment.User_Frag;

public class Act_AdminHome extends AppCompatActivity {

    DrawerLayout dLayout;
    Toolbar  toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__admin_home);
        toolbar = findViewById(R.id.toolbar);
        setNavigationDrawer();

        dLayout.closeDrawers();
        setUpHomeFragment();

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,dLayout,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close

        );

        dLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
    }

    private void setUpHomeFragment(){
        HomeFrag homeFrag =new HomeFrag();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame, homeFrag);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void setNavigationDrawer() {
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // initiate a DrawerLayout
        NavigationView navView = (NavigationView) findViewById(R.id.navigation); // initiate a Navigation View
// implement setNavigationItemSelectedListener event on NavigationView
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment frag = null; // create a Fragment Object
                int itemId = menuItem.getItemId(); // get selected menu item's id
// check selected menu item's id and replace a Fragment Accordingly
                if (itemId == R.id.home) {
                    frag = new HomeFrag();

                }else if (itemId == R.id.profile) {
                    frag = new Profile_Frag();
                } else if (itemId == R.id.user) {
                    frag = new User_Frag();
                }else  if(itemId == R.id.logout)
// display a toast message with menu item's title
                Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag); // replace a Fragment with Frame Layout
                    transaction.commit(); // commit the changes
                    dLayout.closeDrawers(); // close the all open Drawer Views

                    return true;
                }
                return false;
            }
        });
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        HomeFrag homeFrag =new HomeFrag();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame, homeFrag);
        ft.addToBackStack(null);
        ft.commit();

    }
}