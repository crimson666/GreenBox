package com.example.stealth.einstore;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView title1,title2;
        ImageView img;

        title1=(TextView)findViewById(R.id.splash_title1);
        title2=(TextView)findViewById(R.id.splash_title2);
        img=(ImageView) findViewById(R.id.logo);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/Jua-Regular.ttf");
        title1.setTypeface(myCustomFont);
        title2.setTypeface(myCustomFont);

        Animation myamin= AnimationUtils.loadAnimation(this,R.anim.anim);
        title1.setAnimation(myamin);
        title2.setAnimation(myamin);
        img.setAnimation(myamin);
        final Intent intent = new Intent(this,login.class);
        Thread timer= new Thread(){
            public void run(){
                try {
                    sleep(5000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();


                }
            }


        };

        timer.start();



    }
}
