package com.iwtechnocrat.waljon.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.iwtechnocrat.waljon.Act_Classes;
import com.iwtechnocrat.waljon.Act_Courses;
import com.iwtechnocrat.waljon.Act_PremiumUserList;
import com.iwtechnocrat.waljon.Act_Test;
import com.iwtechnocrat.waljon.R;

public class HomeFrag extends Fragment {

    LinearLayout userlay,premium_userlay,classeslay,testlay,courses_lay;
    public  HomeFrag(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.home_frag, container, false);
        userlay = view.findViewById(R.id.userlay);
        premium_userlay = view.findViewById(R.id.premium_userlay);
        classeslay = view.findViewById(R.id.classeslay);
        testlay = view.findViewById(R.id.testlay);
        courses_lay = view.findViewById(R.id.courses_lay);




        premium_userlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Act_PremiumUserList.class);
                startActivity(intent);
            }
        });


        classeslay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Act_Classes.class);
                startActivity(intent);
            }
        });

        testlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Act_Test.class);
                startActivity(intent);
            }
        });


        courses_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Act_Courses.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
