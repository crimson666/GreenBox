package com.example.stealth.einstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.GridView;

import com.example.stealth.einstore.productlist_grid.productlist_db;

public class product_list extends AppCompatActivity {
    public  String name,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            name = extras.getString("KEY");
            username = extras.getString("ID");
        }
        final GridView gridView=(GridView)findViewById(R.id.grid_list);
        productlist_db d=new productlist_db(product_list.this,name,username,gridView);
        d.execute();
        getSupportActionBar().setTitle("PRODUCTS");


    }
}
