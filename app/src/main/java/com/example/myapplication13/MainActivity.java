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
                    mediaPlayer=MediaPlayer.create(MainActivity.this, Uri.parse("http://m701.music.126.net/20231115121452/f55639f52307b86396f5a2e173047c6a/jdymusic/obj/wo3DlMOGwrbDjj7DisKw/30806266771/b0b4/3fb4/b5f5/f1a75aaac2e9f9fe74befa03073dc773.mp3"));

                }else{
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=MediaPlayer.create(MainActivity.this, Uri.parse("http://m701.music.126.net/20231115121452/f55639f52307b86396f5a2e173047c6a/jdymusic/obj/wo3DlMOGwrbDjj7DisKw/30806266771/b0b4/3fb4/b5f5/f1a75aaac2e9f9fe74befa03073dc773.mp3"));

                }
                mediaPlayer.start();
            }
        });

        button_playorplance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isplay){
                    isplay=false;
                    mediaPlayer.start();
                }else{
                    isplay=true;
                    mediaPlayer.pause();
                }
            }
        });

        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.release();
                mediaPlayer=null;
            }
        });


    }
}