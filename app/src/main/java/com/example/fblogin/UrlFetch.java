package com.example.fblogin;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by shivam on 27/11/17.
 */

public class UrlFetch extends AsyncTask<String ,Void,String> {
    String result[];
    String valuereturn;


    @Override
    protected String doInBackground(String... strings) {
        String result = null;
        String url = strings[0];
        OkHttpClient client = new OkHttpClient();
        Request request1 = new Request.Builder().url(url).build();
        Response response1 = null;
        try {
            response1=client.newCall(request1).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            result=response1.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        if(s != null)
        {
            result= s.split("#123#");
            valuereturn=result[0];


        }
    }

}
