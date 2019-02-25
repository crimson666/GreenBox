package com.example.stealth.einstore.user_back;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stealth.einstore.link;
import com.example.stealth.einstore.profile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class profile_db extends AsyncTask<Void,Integer,String> {

    Context c;
    private link obj_link=new link();
    private String primary_link=obj_link.host_link();
    String urlAddress=primary_link+"profile.php";

    public String str_username="";
    ProgressDialog pd;
    TextView username,name,phone,email,address,pin,city;


    public profile_db(Context c,String str_username, TextView name, TextView username, TextView phone, TextView email, TextView address, TextView pin, TextView city) {

        this.c = c;
        this.str_username = str_username;
        this.phone=phone;
        this.address=address;
        this.email=email;
        this.username=username;
        this.name=name;
        this.pin=pin;
        this.city=city;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Download Data");
        pd.setMessage("Downloading...Pease wait!");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {

        String data=this.downloadData();
        return data;

    }


    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);

        pd.dismiss();

        if(data != null)
        {
            parser_profile p_exp=new parser_profile(c,data,str_username,username,name,phone,email,address,city,pin);
            p_exp.execute();

        }else {
            Toast.makeText(c,"Unable to download",Toast.LENGTH_SHORT).show();
        }

    }


    private String downloadData()
    {
        InputStream is=null;
        String line=null;

        try
        {
            Log.d("employee id in try", str_username);
            URL url=new URL(urlAddress+"?Type="+str_username);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            is=new BufferedInputStream(con.getInputStream());

            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuffer sb=new StringBuffer();

            if(br != null)
            {
                while ((line=br.readLine()) != null)
                {
                    sb.append(line+"\n");
                }
            }else
            {
                return null;
            }

            return sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null)
            {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
