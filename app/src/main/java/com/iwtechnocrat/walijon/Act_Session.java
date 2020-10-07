package com.iwtechnocrat.thenursingapp;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Base64;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

public class Act_Session {

    public String signupStage = "0";
    public String userId = "", name = "", login = "";
    public  String usr_name ="",mobile_verified="",email="",usr_code = "", usr_mobile = "",otp="",usr_age ="",flag="",usr_gender="",usr_country="",device_id ="",token="";
    String PREF_NAME = "MyPref";
    public String fullname="",Email="",classs="",mobilenumber="",gender="",college_name="",staffid,companyname,profile_pic="",password = "";
    Context _context;

    public static String USER_ID;
    Bitmap bitmap;
    String encodeImage;

    SharedPreferences sharedPreferences;


    public Act_Session(Context context, String signupStage) {
        this.signupStage = signupStage;
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("signupStage", signupStage);
        prefsEditor.commit();
    }






    @SuppressLint("LongLogTag")
    public Act_Session(Context context, JSONObject jsonObject) {
        if (jsonObject != null) {
            flag = (jsonObject.optString("flag"));
            userId = (jsonObject.optString("id"));
            Email=(jsonObject.optString("email"));
            fullname =(jsonObject.optString("fullname"));
            mobilenumber =(jsonObject.optString("ContactNumber"));
            college_name =(jsonObject.optString("CollegeName"));
            otp =(jsonObject.optString("otp"));
            classs =(jsonObject.optString("Class"));
            password =(jsonObject.optString("password"));

            profile_pic =(jsonObject.optString("profile_pic"));



            //session_id = jsonObject.optString("id");

            USER_ID = userId;

            userId(context,userId);
            emilid(context,Email);
            userflag(context,flag);
            userotp(context,otp);
            userEmail(context,Email);
            userCollegename(context,college_name);
            userclass(context,classs);
            userfullname(context,fullname);

            usermobilenumber(context,mobilenumber);
            userpassword(context,password);



            userprofile_pic(context,profile_pic);

        }
    }


    public Act_Session(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        this.fullname = sharedPreferences.getString("fullname", "");
        this.mobilenumber = sharedPreferences.getString("ContactNumber", "");
        this.userId = sharedPreferences.getString("id", "");
        this.flag = sharedPreferences.getString("flag", "");
        this.login = sharedPreferences.getString("login", "");
        this.Email = sharedPreferences.getString("email", "");
        this.otp = sharedPreferences.getString("otp", "");
        this.password = sharedPreferences.getString("password", "");


        this.classs = sharedPreferences.getString("Class", "");

        this.college_name = sharedPreferences.getString("CollegeName", "");
        this.profile_pic = sharedPreferences.getString("profile_pic", "");

        // this.session_id = sharedPreferences.getString("id", "");
    }



    public void userpassword( Context context,String password) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("password", password);
        prefsEditor.commit();
    }

//    public String getuser(String profile_pic)
//    {
//        return sharedPreferences.getString(profile_pic,null);
//    }

    public void userId(Context context, String userId) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("id", userId);
        prefsEditor.commit();
    }
    public void userEmail(Context context, String Email) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("email", Email);
        prefsEditor.commit();
    }
    public String userprofile_pic(Context context, String profile_pic) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        // prefsEditor.putString("profile_pic", profile_pic);
        prefsEditor.putString("profile_pic", profile_pic);
        prefsEditor.commit();
        return profile_pic;
    }
    public void userfullname(Context context, String fullname) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("fullname", fullname);
        prefsEditor.commit();
    }

    private String imageStore(Bitmap bitmap) {
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] imageBytes=stream.toByteArray();
        encodeImage=android.util.Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return  encodeImage;
    }



    public void userstaffid(Context context, String staffid) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("staffid", staffid);
        prefsEditor.commit();
    }

    public void userCollegename(Context context, String college_name) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("CollegeName", college_name);
        prefsEditor.commit();
    }

    public void userotp(Context context, String otp) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("otp", otp);
        prefsEditor.commit();
    }

    public void emilid(Context context, String email) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("login_status", email);
        prefsEditor.commit();
    }


    public void userclass(Context context, String classs) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("Class", classs);
        prefsEditor.commit();
    }

    public void useraddress(Context context, String address) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("address", address);
        prefsEditor.commit();
    }

    public void usermobilenumber(Context context, String mobilenumber) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("ContactNumber", mobilenumber);
        prefsEditor.commit();
    }

    public void profileImage(Context context, String profileImage) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("Pimage", profileImage);
        prefsEditor.commit();
    }

    public void usergender(Context context, String gender) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("gender", gender);
        prefsEditor.commit();
    }



    public void userflag(Context context, String flag) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("flag", flag);
        prefsEditor.commit();
    }


    public void clearPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        /*AccessToken.setCurrentAccessToken(null);
        LoginManager.getInstance().logOut();*/
        prefsEditor.clear();
        prefsEditor.commit();
    }

    public void removePreference(Context context, String login_start) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.remove(login_start);
        editor.apply();
    }


    @Override
    public String toString() {
        return "SessionParam [name=" + "]";
    }


    public void loginSession(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("login", "yes");
        prefsEditor.commit();
    }


    public void editPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        /*AccessToken.setCurrentAccessToken(null);
        LoginManager.getInstance().logOut();*/
        prefsEditor.clear();
        prefsEditor.commit();
    }
}

