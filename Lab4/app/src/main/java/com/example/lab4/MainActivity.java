package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openMP3(View v){
        Intent i = new Intent(this, MP3.class);
        startActivity(i);
    }
    public void openMP4(View v){
        Intent i = new Intent(this, MP4.class);
        startActivity(i);
    }
}
