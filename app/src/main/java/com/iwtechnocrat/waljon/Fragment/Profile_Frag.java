package com.iwtechnocrat.waljon.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.iwtechnocrat.waljon.R;

public class Profile_Frag extends Fragment {

    public  Profile_Frag(){

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profile_frag, container, false);
        return view;
    }
}
