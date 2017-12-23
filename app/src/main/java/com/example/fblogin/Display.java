package com.example.fblogin;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Display extends AppCompatActivity {
    MediaController mediaController;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Bundle bundle=getIntent().getExtras();
        final String url = bundle.getString("url");
         videoView = (VideoView)findViewById(R.id.videoView);
        Button play = (Button)findViewById(R.id.playButton);
        mediaController=  new MediaController(this);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videopath=url;
                Uri uri = Uri.parse(videopath);
                videoView.setVideoURI(uri);
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);
                videoView.start();
            }
        });
    }
}
