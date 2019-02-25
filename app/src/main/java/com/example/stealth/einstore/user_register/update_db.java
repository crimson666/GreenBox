package com.example.stealth.einstore.user_register;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import com.example.stealth.einstore.edit_profile;
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

public class update_db extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    String name,username;

    link obj_link=new link();
    String primary_link=obj_link.host_link();
    String login_url=primary_link+"edit.php";

    public update_db(Context c) {
        context = c;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        // String login_url = "https://4c58912a.ngrok.io/nexval/edit.php";
        // String login_url = "http://pentelican-thing.000webhostapp.com/nexval/edit.php";

        if (type.equals("update")) {

            try {
                username=params[1];
                String phone = params[2];
                String email = params[3];
                String address = params[4];
                String city = params[5];
                String pin = params[6];
                name=params[7];
                String result="";


                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&"
                        + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8")+"&"
                        + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8")+"&"
                        + URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8")+"&"
                        + URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode(city, "UTF-8")+"&"
                        + URLEncoder.encode("pin", "UTF-8") + "=" + URLEncoder.encode(pin, "UTF-8");

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

        if(result.equals("success")) {
            alertDialog.setMessage("successfully updated");
            alertDialog.show();
            Intent intent = new Intent(context,home.class);
            intent.putExtra("KEY",username);
            intent.putExtra("KEY2",name);
            context.startActivity(intent);



        }
        else {
            alertDialog.setMessage("update failed.Please try again later");
            alertDialog.show();

        }

    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}

