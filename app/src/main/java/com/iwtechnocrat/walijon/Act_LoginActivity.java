package com.iwtechnocrat.walijon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Act_LoginActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__login);

        btn_Login = findViewById(R.id.btn_Login);

        toolbar = findViewById(R.id.toolbar1);



        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Act_AdminHome.class);
                startActivity(intent);
            }
        });
    }
}