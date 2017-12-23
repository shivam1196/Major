package com.example.fblogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by shivam on 05/11/17.
 */

public class AboutAdapter extends BaseAdapter {
    Context mContext;
    String [] names;
    int [] images;
    String abtnaes;
    String abtphotos;
    LayoutInflater mLayoutInflater;
    public AboutAdapter(Context context,String [] names,int [] images)

    {
    mContext=context;
        this.names=names;
        this.images=images;
        mLayoutInflater=(LayoutInflater)mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
    }
    public AboutAdapter(Context context,String names,String images1)
    {
        mContext=context;
        abtnaes=names;
        abtphotos=images1;

    }
    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=mLayoutInflater.inflate(R.layout.displayart,null);
        if(abtphotos!= null)
        {
            ImageView artImgView=(ImageView)convertView.findViewById(R.id.artimgView);
            TextView artTxtView=(TextView)convertView.findViewById(R.id.artTxtView);
            artTxtView.setText(abtnaes);
            Picasso.with(mContext).load(abtphotos).into(artImgView);
        }
        ImageView artImgView=(ImageView)convertView.findViewById(R.id.artimgView);
        TextView artTxtView=(TextView)convertView.findViewById(R.id.artTxtView);
        artImgView.setImageResource(images[position]);
        artTxtView.setText(names[position]);

        return  convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return names.length;
    }
}
