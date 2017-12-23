package com.example.fblogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shivam on 10/10/17.
 */

public class MainMenuAdapter extends BaseAdapter {
    Context context;
    ImageView imgView;
    TextView txtView;
    LayoutInflater layoutInflater;
    String names[]={"Profile","Your Videos","Courses","Wall of Fame","Articles","About Us"};
    int images[]={R.drawable.major_videos,R.drawable.ic_menu_gallery,R.drawable.ic_menu_manage,R.drawable.ic_menu_share,R.drawable.ic_menu_send,R.drawable.ic_menu_gallery};
    MainMenuAdapter(Context context)
    {
        this.context=context;
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=layoutInflater.inflate(R.layout.gridviewadapter,null);
        imgView=(ImageView)view.findViewById(R.id.imgView);
        txtView=(TextView)view.findViewById(R.id.txtView);
        imgView.setImageResource(images[position]);
        txtView.setText(names[position]);
        return view;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
