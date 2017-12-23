package com.example.fblogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by shivam on 16/10/17.
 */

public class ContentAdapter extends BaseAdapter {
    private Context context;
    private String [] names;
  private  LayoutInflater layoutInflater;
    public ContentAdapter(Context context,String[] names)
    {
        this.context=context;
        this.names=names;
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= layoutInflater.inflate(R.layout.contentlist,null);
        TextView lsttxtView= (TextView)convertView.findViewById(R.id.lsttxtView);
        lsttxtView.setText(names[position]);
        return  convertView;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
