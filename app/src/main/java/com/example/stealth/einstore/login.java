package com.example.stealth.einstore;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stealth.einstore.login_back.login_db;

public class login extends AppCompatActivity {
    TextView title1,title2;
    EditText Username,Password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





        btn_login=(Button)findViewById(R.id.button1);
        Username = (EditText)findViewById(R.id.username);
        Password=(EditText)findViewById(R.id.password);
        title1=(TextView)findViewById(R.id.splash_title1);
        title2=(TextView)findViewById(R.id.splash_title2);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/Jua-Regular.ttf");
        title1.setTypeface(myCustomFont);
        title2.setTypeface(myCustomFont);
        Typeface myCustomFont4 = Typeface.createFromAsset(getAssets(),"fonts/Lobster-Regular.ttf");
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Medium.ttf");
        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");
        btn_login.setTypeface(myCustomFont3);
        Username.setTypeface(myCustomFont2);
        Password.setTypeface(myCustomFont2);

    }

    public void onclick1(View v){
        //login
        btn_login.setEnabled(false);

        String username = Username.getText().toString();
        String password = Password.getText().toString();

        String type = "login";
        login_db backWork = new login_db(this,btn_login);
        backWork.execute(type,username,password);



    }

    public void onclick2(View v){
        //register
        Intent intent = new Intent(this,register.class);
        startActivity(intent);
    }
}
