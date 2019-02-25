package com.example.stealth.einstore;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stealth.einstore.login_back.login_db;
import com.example.stealth.einstore.user_register.register_db;

public class register extends AppCompatActivity {
    TextView title;
    Button submit;
    EditText firstname,lastname,username,password,repassword,city,pin,address,phone,email;
    AlertDialog alertDialog;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        title=(TextView)findViewById(R.id.title_register);
        submit=(Button)findViewById(R.id.submit);
        firstname=(EditText)findViewById(R.id.firstname);
        lastname=(EditText)findViewById(R.id.lastname);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        repassword=(EditText)findViewById(R.id.repassword);
        city=(EditText)findViewById(R.id.city);
        pin=(EditText)findViewById(R.id.pin);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        address=(EditText)findViewById(R.id.address);

        Typeface myCustomFont4 = Typeface.createFromAsset(getAssets(),"fonts/Lobster-Regular.ttf");
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Medium.ttf");
        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");

        submit.setTypeface(myCustomFont3);
        title.setTypeface(myCustomFont3);
    }

    public void onclick1(View view) {
        String firstname_str = firstname.getText().toString();
        String lastname_str = lastname.getText().toString();
        String username_str = username.getText().toString();
        String password_str = password.getText().toString();
        String repassword_str = repassword.getText().toString();
        String city_str = city.getText().toString();
        String pin_str = pin.getText().toString();
        String phone_str = phone.getText().toString();
        String email_str = email.getText().toString();
        String address_str = address.getText().toString();

        if(password_str.equals(repassword_str)){

            register_db backWork = new register_db(this);
            backWork.execute("register",firstname_str,lastname_str,username_str,password_str,city_str,pin_str,address_str,phone_str,email_str);


        }

        else {

            //toast
            Toast.makeText(context,"Please check both entered passwords.",Toast.LENGTH_LONG).show();

        }


    }
}
