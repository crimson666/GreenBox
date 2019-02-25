package com.example.stealth.einstore;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stealth.einstore.user_register.update_db;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class edit_profile extends AppCompatActivity {
    EditText phone,email,address,username,city,pin;
    TextView name,txt_mobile,txt_email,txt_address,txt_username,txt_city,txt_pin;
    String username_str,name_str,phone_str,emial_str,address_str,city_str,pin_str;
    Button update;
    final int CODE_GALLERY_REQUEST=999;
    ImageView profile_pic;
    ImageButton pic_edit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            username_str = extras.getString("USERNAME");
            name_str = extras.getString("NAME");
            phone_str = extras.getString("PHONE");
            emial_str = extras.getString("EMAIL");
            address_str = extras.getString("ADDRESS");
            city_str = extras.getString("CITY");
            pin_str = extras.getString("PIN");
        }

        //edit text
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        address=(EditText)findViewById(R.id.address);
        username=(EditText)findViewById(R.id.username);
        city=(EditText)findViewById(R.id.city);
        pin=(EditText)findViewById(R.id.pin);
        //textviews
        txt_mobile=(TextView)findViewById(R.id.txt_mobile);
        txt_email=(TextView)findViewById(R.id.txt_email);
        txt_address=(TextView)findViewById(R.id.txt_address);
        txt_username=(TextView)findViewById(R.id.txt_username);
        txt_pin=(TextView)findViewById(R.id.txt_pin);
        txt_city=(TextView)findViewById(R.id.txt_City);
        name=(TextView)findViewById(R.id.name);

        profile_pic=(ImageView)findViewById(R.id.profile_image);
        pic_edit=(ImageButton)findViewById(R.id.edit_pic);

        update=(Button)findViewById(R.id.button1);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/Lobster-Regular.ttf");
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Medium.ttf");
        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");

        name.setTypeface(myCustomFont2);
        txt_mobile.setTypeface(myCustomFont2);
        txt_email.setTypeface(myCustomFont2);
        txt_address.setTypeface(myCustomFont2);
        txt_username.setTypeface(myCustomFont2);
        txt_pin.setTypeface(myCustomFont2);
        txt_city.setTypeface(myCustomFont2);

        update.setTypeface(myCustomFont3);

        username.setText(username_str);
        name.setText(name_str);
        phone.setText(phone_str);
        email.setText(emial_str);
        address.setText(address_str);
        city.setText(city_str);
        pin.setText(pin_str);




    }

    public void update(View view) {
        update.setEnabled(false);

        update_db backWork = new update_db(this);
        backWork.execute("update",username.getText().toString(),phone.getText().toString(),email.getText().toString(),address.getText().toString(),city.getText().toString(),pin.getText().toString(),name_str);
    }


    public void choose(View view) {
    }
}
