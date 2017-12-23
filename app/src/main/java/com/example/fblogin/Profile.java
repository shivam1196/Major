package com.example.fblogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    ImageView mImageView;
    TextView mTextView,mTextView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle b = getIntent().getExtras();
        String s = b.getString("id");
        String l = b.getString("level");
        mImageView=(ImageView)findViewById(R.id.ProfileImgView);
        mTextView=(TextView)findViewById(R.id.txtView1);
        mTextView1=(TextView)findViewById(R.id.txtViewLevel);
        mTextView.setText("NAME: "+s);
        mTextView1.setText("LEVEL: "+l);

    }
}
