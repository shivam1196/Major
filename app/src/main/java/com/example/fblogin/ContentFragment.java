package com.example.fblogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by shivam on 15/10/17.
 */

public class ContentFragment extends Fragment {

    ListView lstView;
    String [] courses ;
    public ContentFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.videos_listview,container,false);
        lstView=(ListView)mview.findViewById(R.id.lstView);
        ContentAdapter ca = new ContentAdapter(getContext(),courses);
        lstView.setAdapter(ca);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    Intent intent = new Intent(getContext(),Display.class);
                    intent.putExtra("url","http://10.0.2.2/video1.mp4");
                    startActivity(intent);
                }
                if (position==1)
                {
                    Intent intent = new Intent(getContext(),Display.class);
                    intent.putExtra("url","http://10.0.2.2/video2.mp4");
                    startActivity(intent);
                }
                if(position ==2)
                {
                    Intent intent = new Intent(getContext(),Display.class);
                    intent.putExtra("url","http://10.0.2.2/video3.mp4");
                    startActivity(intent);
                }
            }
        });

        return  mview;
    }
    public void getString(String [] courses)
    {
        this.courses=courses;
    }
}
