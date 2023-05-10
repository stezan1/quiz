package com.stejan.eppybday;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
 MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music=MediaPlayer.create(MainActivity.this,R.raw.music);

        music.start();


    }

    protected void onPause() {
        super.onPause();
        music.stop();
        music.release();
    }




}