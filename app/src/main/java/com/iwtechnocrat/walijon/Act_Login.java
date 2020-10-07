package com.iwtechnocrat.walijon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.iwtechnocrat.thenursingapp.Act_Session;
import com.iwtechnocrat.walijon.UI.BaseURL;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Act_Login extends AppCompatActivity {

    Button btn_Login,signup;
    EditText et_email,et_password;
    String email,password;
     ProgressDialog progressDialog;
     com.iwtechnocrat.thenursingapp.Act_Session act_session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_login);
        btn_Login = findViewById(R.id.btn_Login);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        act_session = new Act_Session(getApplicationContext());






        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(Act_Login.this);
                progressDialog.setCancelable(false);
                progressDialog.setTitle("Loading Please Wait");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
                email = et_email.getText().toString();
                password = et_password.getText().toString();
                if (email.equals("")){
                    Toast.makeText(Act_Login.this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
                }else if(password.equals("")){
                    Toast.makeText(Act_Login.this, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
                }else {
                    login();
                }

            }
        });
    }

    private  void login(){
        final StringRequest request=new StringRequest(Request.Method.POST, BaseURL.login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                act_session.loginSession(getApplicationContext());
                try {

                   progressDialog.dismiss();
                    JSONObject jsonObject= new JSONObject(response);
                    String respons=jsonObject.getString("respons");
                    String message=jsonObject.getString("msg");

                    if(respons.equals("True") || message.equals("login Successfully"))
                    {
                        JSONObject resultObj = jsonObject.getJSONObject("details");
                        act_session = new Act_Session(getApplicationContext(), resultObj);


                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        Intent intent11 = new Intent(getApplicationContext(),Act_AdminHome.class);
                        startActivity(intent11);
                        finish();

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
                map.put("Email", email);
                map.put("password", password);
                return  map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(Act_Login.this);
        requestQueue.add(request);
    }

}