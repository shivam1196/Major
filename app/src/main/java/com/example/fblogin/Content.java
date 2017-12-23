package com.example.fblogin;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class Content extends AppCompatActivity {
    ContentFragment contentFragment;
    String result[];
    String result1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        UrlFetch urlFetch = new UrlFetch();
        urlFetch.execute("http://10.0.2.2/majorshow.php");
        try {
            //split("#123#");
            result1=urlFetch.get().toString();
            result=result1.split("#123#");

            Toast.makeText(this, result1+"", Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        if(savedInstanceState == null)
        {
         if(result[0].contains("Beginner")) {
                String[] courses = {"Introduction to SecureX", "Introduction to Cyber Security"};//, "Data Security", "Application Security", "Network Security"};
                contentFragment = new ContentFragment();
                contentFragment.getString(courses);

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.content, contentFragment).commit();

    }
        else if(result[0].contains("InterMediate"))
         {
             String[] courses = {"Data Security", "Application Security"};//, "Data Security", "Application Security", "Network Security"};
             contentFragment = new ContentFragment();
             contentFragment.getString(courses);

             FragmentManager fragmentManager = getSupportFragmentManager();
             fragmentManager.beginTransaction().add(R.id.content, contentFragment).commit();
         }
         else if(result[0].contains("Expert"))
         {
             String[] courses = {"Network Security"};//, "Data Security", "Application Security", "Network Security"};
             contentFragment = new ContentFragment();
             contentFragment.getString(courses);

             FragmentManager fragmentManager = getSupportFragmentManager();
             fragmentManager.beginTransaction().add(R.id.content, contentFragment).commit();
         }

        }}


//    String [] array = contentFragment.name();
}

