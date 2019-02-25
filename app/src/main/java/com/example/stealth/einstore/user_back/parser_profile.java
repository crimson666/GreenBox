package com.example.stealth.einstore.user_back;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class parser_profile extends AsyncTask<Void,Integer,Integer> {

    Context c;
    String data;
    String username="";
    String fname="";
    String lname="";
    String phone="";
    String email="";
    String address="";
    String pin="";
    String city="";


    TextView username_txt,name_txt,phone_txt,email_txt,city_txt,pin_txt,address_txt;






    public parser_profile(Context c, String data, String str_username, TextView username, TextView name, TextView phone, TextView email, TextView address, TextView city, TextView pin) {

        this.c=c;
        this.data=data;
        this.name_txt=name;
        this.username_txt=username;
        this.phone_txt=phone;
        this.email_txt=email;
        this.pin_txt=pin;
        this.city_txt=city;
        this.address_txt=address;
    }


    @Override
    protected Integer doInBackground(Void... voids) {
        return this.parse();
    }


    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        username_txt.setText(username);
        name_txt.setText(fname + " " +lname);
        phone_txt.setText(phone);
        email_txt.setText(email);
        address_txt.setText(address);
        city_txt.setText(city);
        pin_txt.setText(pin);



    }


    private int parse()
    {
        try
        {
            JSONArray ja=new JSONArray(data);
            JSONObject jo=null;

            Log.d("data", data);

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                fname=jo.getString("first_name");
                lname=jo.getString("last_name");
                username=jo.getString("username");
                phone = jo.getString("phone");
                email=jo.getString("email");
                address=jo.getString("address");
                city=jo.getString("city");
                pin=jo.getString("pin");



            }


            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}

