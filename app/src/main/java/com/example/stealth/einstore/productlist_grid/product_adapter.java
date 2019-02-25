package com.example.stealth.einstore.productlist_grid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stealth.einstore.R;
import com.example.stealth.einstore.products;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class product_adapter extends BaseAdapter {
    Context c;
    String name;
    String username;
    ArrayList<User> users;
    ImageView product_img;

    public product_adapter(Context c, String name, String username, ArrayList<User> users) {

        this.c = c;
        this.name = name;
        this.username = username;
        this.users = users;
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(c).inflate(R.layout.grid_product,viewGroup,false);
        }

        TextView productname_txt= (TextView) view.findViewById(R.id.product_title);
        TextView productprice_txt= (TextView) view.findViewById(R.id.product_price);
        TextView productcompant_txt=(TextView) view.findViewById(R.id.product_company);
        product_img=(ImageView)view.findViewById(R.id.product_image);

        User user= (User) this.getItem(i);

        final String product_name=user.getProduct_name();
        final String product_price=user.getProduct_price();
        final String product_company=user.getProduct_company();
        final String product_id=user.getProduct_id();
        final String product_category=user.getProduct_category();
        final String product_info=user.getProduct_info();



        final String image_url=user.getImage_url();


        productname_txt.setText(product_name);
        productprice_txt.setText("₹"+product_price);
        productcompant_txt.setText("By "+product_company);
        //Picasso.get().load(image_url).into(product_img);
        loadImageFromUrl(image_url);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //OPEN DETAIL ACTIVITY

                openDetailActivity(name, username, product_id, product_name, product_category, product_price, product_info, product_company, image_url);
            }
        });




        return view;

    }


    private void loadImageFromUrl(String image_url) {

        /*
        Picasso.get().load(image_url).placeholder(R.mipmap.ic_launcher)//mitmap
        .error(R.mipmap.ic_launcher).into(product_img,new Callback(){

            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        };*/

        Picasso.get()
                .load(image_url)
                .placeholder(R.drawable.noimage)
                .error(R.drawable.noimage)
                .into(product_img);
    }



    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(c,products.class);
        i.putExtra("NAME_KEY",details[0]);
        i.putExtra("USERNAME_KEY",details[1]);
        i.putExtra("PRODUCT_ID",details[2]);
        i.putExtra("PRODUCT_NAME",details[3]);
        i.putExtra("PRODUCT_CATEGORY",details[4]);
        i.putExtra("PRODUCT_PRICE",details[5]);
        i.putExtra("PRODUCT_INFO",details[6]);
        i.putExtra("PRODUCT_COMPANY",details[7]);
        i.putExtra("PRODUCT_IMAGE",details[8]);


        c.startActivity(i);

    }




    }

