package com.example.fblogin;

import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by shivam on 26/11/17.
 */

public class UrlSend extends AsyncTask<String,Void,Void> {
    @Override
    protected Void doInBackground(String... strings) {
        String url = strings[0];
        try {
            URL preurl = new URL(url);
            HttpURLConnection con = (HttpURLConnection)preurl.openConnection();
            con.setRequestMethod("GET");
            int response = con.getResponseCode();
            if (response==200)
            {
                System.out.println("Data Loaded Successfully");
            }
        }catch (Exception ex
                )
        {
            Log.i("Exceptiion", ex.toString());
        }

        return null;
    }

}

