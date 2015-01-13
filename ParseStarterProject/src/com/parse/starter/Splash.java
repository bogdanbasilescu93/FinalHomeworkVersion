package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {

    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ourSong = MediaPlayer.create(Splash.this,R.raw.splash_sound);
        ourSong.start();

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(6000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    // Class class;
                    Intent openstartingPoint = new Intent(Splash.this,
                            MainActivity.class);
                    startActivity(openstartingPoint);
                }
            }
        };

        timer.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        ourSong.release();
        finish();
    }



}
