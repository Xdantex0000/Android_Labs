package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MP3 extends AppCompatActivity {
    MediaPlayer player;
    String track = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3);

        ListView listView = findViewById(R.id.listView);
        final String[] songNames = new String[] {
                "song1", "song2"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, songNames);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                track = ((TextView) itemClicked).getText().toString();
            }
        });
    }
    public void play(View v){
        if(player==null){
            switch (track){
                case "song1":{
                    player = MediaPlayer.create(this,R.raw.song1);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            stopPlayer();
                        }
                    });
                    player.start();
                    Toast.makeText(getApplicationContext(),"Song 1 is played",Toast.LENGTH_SHORT).show();
                    break;
                }
                case "song2":{
                    player = MediaPlayer.create(this,R.raw.song2);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            stopPlayer();
                        }
                    });
                    player.start();
                    Toast.makeText(getApplicationContext(),"Song 2 is played",Toast.LENGTH_SHORT).show();
                    break;
                }
                default:
                    Toast.makeText(getApplicationContext(),"Choose the song",Toast.LENGTH_SHORT).show();
            }

        }
        else{
            player.start();
        }
    }

    public void pause(View v){
        if(player!=null){
            player.pause();
        }
    }

    public void stop(View v){
        stopPlayer();
    }

    private void stopPlayer(){
        if(player!=null){
            player.release();
            player = null;
            Toast.makeText(this,"MediaPlayer released",Toast.LENGTH_SHORT);
        }
    }
}
