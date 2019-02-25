package com.example.stealth.einstore.productlist_grid;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class productlist_parse extends AsyncTask<Void,Integer,Integer> {

    Context c;
    String data,name,username;
    GridView gridView;
    ProgressDialog pd;

    ArrayList<User> users=new ArrayList<>();


    public productlist_parse(Context c, String data, String name, String username, GridView gridView) {
    this.c=c;
    this.name=name;
    this.username=username;
    this.gridView=gridView;
    this.data=data;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse Data");
        pd.setMessage("Parsing...Please Wait!");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parse();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        pd.dismiss();

        if(integer==1)
        {

            gridView.setAdapter(new product_adapter(c,name,username,users));
            //adapter=new product_adapter(c,name,username,product_id,product_name,product_info,product_price,product_category,product_company);
            //GridView.Set(adapter);
            //http://camposha.info/source/android-native-json-gridview-master-detail-downloadparseshow-open-detail-activity-source
        }else {
            Toast.makeText(c,"Unable to parse data",Toast.LENGTH_SHORT).show();
        }
    }

    private int parse()
    {

        try
        {
            JSONArray ja=new JSONArray(data);
            JSONObject jo=null;

            users.clear();
            User user;



            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                String product_id=jo.getString("product_id");
                String product_name=jo.getString("product_name");
                String product_info=jo.getString("description");
                String product_category=jo.getString("category");
                String product_price=jo.getString("price");
                String product_company=jo.getString("company");
                String image_url=jo.getString("image");

                user=new User();

                user.setProduct_id(product_id);
                user.setProduct_name(product_name);
                user.setProduct_category(product_category);
                user.setProduct_info(product_info);
                user.setProduct_price(product_price);
                user.setProduct_company(product_company);
                user.setImage_url(image_url);

                users.add(user);




            }



            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}



