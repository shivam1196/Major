package com.example.fblogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ArandAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arand_about);
        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("pos");
        String profile = bundle.getString("id");
        if(position == 5) {
            String[] names = {"SHUBHRIKA MAURYA", "TANUPRIYA BHASIN", "ARJUN DHALL", "MUKUL KASHIV", "ROUSHAN JHA", "SHIVAM SRIVASTAVA"};
            int[] images = {R.drawable.securex, R.drawable.securex, R.drawable.securex, R.drawable.securex, R.drawable.securex, R.drawable.securex};
            AboutAdapter arandAbout = new AboutAdapter(getApplicationContext(), names, images);
            ListView lstAbout = (ListView) findViewById(R.id.lstAbout);
            lstAbout.setAdapter(arandAbout);
        }
        if(position == 4)
        {
            String[] names = {"Article 1", "Article 2", "Article 3", "Article 4", "Article 5", "Article 6"};
            int[] images = {R.drawable.securex, R.drawable.securex, R.drawable.securex, R.drawable.securex, R.drawable.securex, R.drawable.securex};
            AboutAdapter arandAbout = new AboutAdapter(getApplicationContext(), names, images);
            ListView lstAbout = (ListView) findViewById(R.id.lstAbout);
            lstAbout.setAdapter(arandAbout);
        }
        if(position ==0)
        {
            String name="Shivam";
            AboutAdapter aboutAdapter = new AboutAdapter(getApplicationContext(),name,profile);
            ListView lstAbout = (ListView) findViewById(R.id.lstAbout);
            lstAbout.setAdapter(aboutAdapter);

        }
    }
}
