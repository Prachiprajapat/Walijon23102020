package com.iwtechnocrat.walijon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.iwtechnocrat.walijon.Adapter.UserListAdapter;
import com.iwtechnocrat.walijon.Model.UserListModel;
import com.iwtechnocrat.walijon.UI.BaseURL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Act_UserList extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView rcycle_user;
    UserListAdapter userListAdapter;
    ArrayList<UserListModel> userListModels = new ArrayList<>();
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__user_list);

        rcycle_user = findViewById(R.id.recycle_user);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("User List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Act_AdminHome.class);
                startActivity(intent);
            }
        });

        progressDialog = new ProgressDialog(Act_UserList.this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Loading Please Wait");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        getuser();
    }

    private  void  getuser(){
        final StringRequest request=new StringRequest(Request.Method.POST, BaseURL.GetUserList, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                // act_session.loginSession(getApplicationContext());
                try {
                     progressDialog.dismiss();
                    JSONObject jsonObject= new JSONObject(response);
                    String respons=jsonObject.getString("error");
                    String message=jsonObject.getString("message");

                    if(respons.equals("true") || message.equals("User Data"))
                    {
                        JSONArray resultObj = jsonObject.getJSONArray("data");

                        for (int i = 0; i < resultObj.length(); i++) {
                            JSONObject jsonObject1 = resultObj.getJSONObject(i);

                            String id = jsonObject1.getString("id");
                            String ContactNumber = jsonObject1.getString("ContactNumber");
                            String Classs = jsonObject1.getString("Class");
                            String fullname = jsonObject1.getString("fullname");

                            userListModels.add(new UserListModel(id,fullname,ContactNumber,Classs));

                            UserListAdapter ad_getSubject =new UserListAdapter(getApplicationContext(),userListModels);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                            rcycle_user.setLayoutManager(layoutManager);
                            rcycle_user.setAdapter(ad_getSubject);



                        }

                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), ""+response, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                }

                Log.d("res","res"+response);
                //    Toast.makeText(CertificationActivity.this, ""+response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("resorde","resse"+error.getMessage());
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map=new HashMap<>();
              //  map.put("classID",class_id);
                //Log.d("id","id"+act_session.userId);

                return  map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(Act_UserList.this);
        requestQueue.add(request);
    }

}