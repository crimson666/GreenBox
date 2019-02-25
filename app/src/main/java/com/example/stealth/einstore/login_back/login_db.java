package com.example.stealth.einstore.login_back;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.Button;

import com.example.stealth.einstore.home;
import com.example.stealth.einstore.link;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class login_db extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    public String log;
    Button b1;

    link obj_link=new link();
    String primary_link=obj_link.host_link();

    String login_url=primary_link+"login.php";
    public String id;
    public login_db(Context ctx, Button b1) {
        context = ctx;
        this.b1=b1;
    }



    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
            if (type.equals("login")) {

            try {
                String username = params[1];
                String password = params[2];

                String result="";
                id=username;


                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("procedure status");
    }

    @Override
    protected void onPostExecute(String result) {

        if(result.equals("log_no")) {
            alertDialog.setMessage("Sorry wrong password or user id");
            alertDialog.show();

        }
        else {
            b1.setEnabled(false);
            alertDialog.setMessage("welcome " + result);
            alertDialog.show();
            Intent intent = new Intent(context,home.class);
            intent.putExtra("KEY",id);
            intent.putExtra("KEY2",result);
            context.startActivity(intent);
            //System.out.print("db_login"+ token);
        }

    }


    }
