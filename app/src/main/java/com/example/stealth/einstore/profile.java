package com.example.stealth.einstore;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stealth.einstore.user_back.profile_db;

public class profile extends AppCompatActivity {
    TextView name,username,phone,email,pin,city,address;
    String str_username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            str_username= extras.getString("KEY");

        }

        name=(TextView)findViewById(R.id.name);
        username=(TextView)findViewById(R.id.username);
        phone=(TextView)findViewById(R.id.phone);
        email=(TextView)findViewById(R.id.email);
        pin=(TextView)findViewById(R.id.pin);
        city=(TextView)findViewById(R.id.city);
        address=(TextView)findViewById(R.id.address);


        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/Lobster-Regular.ttf");
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Medium.ttf");
        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");

        name.setTypeface(myCustomFont2);
        username.setTypeface(myCustomFont2);
        phone.setTypeface(myCustomFont2);
        email.setTypeface(myCustomFont2);
        pin.setTypeface(myCustomFont2);
        city.setTypeface(myCustomFont2);
        address.setTypeface(myCustomFont2);

        Toast.makeText(getApplicationContext(),str_username,Toast.LENGTH_LONG).show();

        profile_db d=new profile_db(profile.this, str_username,name,username,phone,email,address,pin,city);
        d.execute();

    }

    public void edit_profile(View view) {
        Intent intent = new Intent(profile.this,edit_profile.class);
        intent.putExtra("USERNAME",username.getText());
        intent.putExtra("NAME",name.getText());
        intent.putExtra("PHONE",phone.getText());
        intent.putExtra("EMAIL",email.getText());
        intent.putExtra("ADDRESS",address.getText());
        intent.putExtra("CITY",city.getText());
        intent.putExtra("PIN",pin.getText());
        profile.this.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(profile.this,home.class);
        intent.putExtra("KEY",username.getText());
        intent.putExtra("KEY2",name.getText());
        profile.this.startActivity(intent);
    }
}
