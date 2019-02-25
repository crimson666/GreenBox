package com.example.stealth.einstore.user_register;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.Button;

import com.example.stealth.einstore.home;
import com.example.stealth.einstore.link;
import com.example.stealth.einstore.login;

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

public class register_db extends AsyncTask<String,Void,String> {

    Context context;

    AlertDialog alertDialog;

    link obj_link=new link();
    String primary_link=obj_link.host_link();
    String register_url=primary_link+"register.php";

    public register_db(Context ctx) {
        context = ctx;

    }




    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        if (type.equals("register")) {

            try {
                String firstname = params[1];
                String lastname = params[2];
                String username = params[3];
                String password = params[4];
                String city = params[5];
                String pin = params[6];
                String address = params[7];
                String phone = params[8];
                String email = params[9];



                String result="";



                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("firstname", "UTF-8") + "=" + URLEncoder.encode(firstname, "UTF-8") + "&"
                        + URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(lastname, "UTF-8")+"&"+
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8")+"&"+
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")+"&"+
                        URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode(city, "UTF-8")+"&"+
                        URLEncoder.encode("pin", "UTF-8") + "=" + URLEncoder.encode(pin, "UTF-8")+"&"+
                        URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8")+"&"+
                        URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8")+"&"+
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");

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
        alertDialog.setTitle("New User Registration");
    }
    @Override
    protected void onPostExecute(String result) {
        if(result.equals("success")) {
            alertDialog.setMessage("Thanks for signing up at green basket, Welcome aboard");
            alertDialog.show();
            Intent intent = new Intent(context, login.class);
            context.startActivity(intent);
        }
        else{

            alertDialog.setMessage("Username taken");
            alertDialog.show();

        }
    }
    }

