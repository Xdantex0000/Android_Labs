package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MP4 extends AppCompatActivity {
    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp4);

        videoView = findViewById(R.id.videoView);

        mediaController = new MediaController(this);

        videoView.setVideoPath("android.resource://com.example.lab4/"+R.raw.video);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.start();
    }
}
