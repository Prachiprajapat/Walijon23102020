package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.iwtechnocrat.waljon.Act_Home;
import com.iwtechnocrat.waljon.Adapter.ListViewAdapter;
import com.iwtechnocrat.waljon.Model.AnimalNames;
import com.iwtechnocrat.waljon.R;

import java.util.ArrayList;

public class Act_Search extends AppCompatActivity implements SearchView.OnQueryTextListener{

    ImageView backarrow;
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] animalNameList;
    ArrayList<AnimalNames> arraylist = new ArrayList<AnimalNames>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__search);

        backarrow = findViewById(R.id.backarrow);

        editsearch = findViewById(R.id.search);

        editsearch.onActionViewExpanded();
        editsearch.setIconified(true);
        //editsearch.setLayoutParams(new ActionBar.LayoutParams(Gravity.RIGHT));


        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_Home.class);
                startActivity(intent);
            }
        });

        editsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editsearch.onActionViewExpanded();
            }
        });

        animalNameList = new String[]{"Lion", "Tiger", "Dog",
                "Cat", "Tortoise", "Rat", "Elephant", "Fox",
                "Cow","Donkey","Monkey"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < animalNameList.length; i++) {
            AnimalNames animalNames = new AnimalNames(animalNameList[i]);
            // Binds all strings into an array
            arraylist.add(animalNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if( ! editsearch.isIconified()) {
            editsearch.setIconified(true);
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }


}




