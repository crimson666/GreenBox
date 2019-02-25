package com.example.stealth.einstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class products extends AppCompatActivity {

    String name,username,product_id,product_name,product_info,product_category,product_price,product_company,product_image;
    TextView txt_productname,txt_productprice,txt_productcompany,txt_productabout,txt_productcategory;
    ImageView productimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);


        //GET INTENT
        Intent i=this.getIntent();

        //RECEIVE DATA
         name=i.getExtras().getString("NAME_KEY");
         username=i.getExtras().getString("USERNAME_KEY");
        product_id=i.getExtras().getString("PRODUCT_ID");
        product_name=i.getExtras().getString("PRODUCT_NAME");
        product_info=i.getExtras().getString("PRODUCT_INFO");
        product_category=i.getExtras().getString("PRODUCT_CATEGORY");
        product_price=i.getExtras().getString("PRODUCT_PRICE");
        product_company=i.getExtras().getString("PRODUCT_COMPANY");
        product_image=i.getExtras().getString("PRODUCT_IMAGE");


        //Toast.makeText(this,product_id,Toast.LENGTH_LONG).show();


        txt_productname=(TextView)findViewById(R.id.title);
        txt_productprice=(TextView)findViewById(R.id.price);
        txt_productcompany=(TextView)findViewById(R.id.brand);
        txt_productabout=(TextView)findViewById(R.id.about);
        txt_productcategory=(TextView)findViewById(R.id.category);
        productimage=(ImageView)findViewById(R.id.product_image);

        txt_productname.setText(product_name);
        txt_productprice.setText("₹ "+product_price);
        txt_productcompany.setText("By "+product_company);
        txt_productabout.setText(product_info);
        txt_productcategory.setText(product_category);

        Picasso.get()
                .load(product_image)
                .placeholder(R.drawable.noimage)
                .error(R.drawable.noimage)
                .into(productimage);
    }


    public void onclick1(View view) {
    }

    public void onclick2(View view) {
    }
}
