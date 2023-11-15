package com.example.myapplication13;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_chongtouPlay;
    Button button_playorplance;
    Button button_stop;

    MediaPlayer mediaPlayer;
    boolean isplay=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_chongtouPlay=findViewById(R.id.button);
        button_playorplance=findViewById(R.id.button2);
        button_stop=findViewById(R.id.button3);

        button_chongtouPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer==null){
                    mediaPlayer=MediaPlayer.create(MainActivity.this, R.raw.audio);

                }else{
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=MediaPlayer.create(MainActivity.this, R.raw.audio);

                }
                mediaPlayer.start();
            }
        });

        button_playorplance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isplay&&mediaPlayer!=null){
                    isplay=false;
                    mediaPlayer.start();
                }else if(mediaPlayer!=null){
                    isplay=true;
                    mediaPlayer.pause();
                }
            }
        });

        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=null;
                }
            }
        });


    }
}