package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class Welcome extends Activity {

    // Declare Variable
    public Button logout,changePass,usefulLinks,weather,music,dynamicalLayout;
    MediaPlayer mediaPlayer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Get the view from singleitemview.xml
        setContentView(R.layout.welcome);

        mediaPlayer = MediaPlayer.create(this, R.raw.lotr);

// Retrieve current user from Parse.com
        ParseUser currentUser = ParseUser.getCurrentUser();

// Convert currentUser into String
        String struser = currentUser.getUsername().toString();

// Locate TextView in welcome.xml
        TextView txtuser = (TextView) findViewById(R.id.txtuser);
        TextView textView = (TextView) findViewById(R.id.textView);

// Set the currentUser String into TextView
        txtuser.setText("You are logged in as " + struser);

// Locate Button in welcome.xml
        logout = (Button) findViewById(R.id.logout);

// Logout Button Click Listener
        logout.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
// Logout current user
                ParseUser.logOut();
                Intent intent = new Intent(Welcome.this,
                        LoginSignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });


        changePass = (Button) findViewById(R.id.button3);
        changePass.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(
                        Welcome.this,
                        ChangePasswordActivity.class);
                startActivity(intent);
                finish();

            }
        });

        usefulLinks = (Button) findViewById(R.id.button);
        usefulLinks.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(
                        Welcome.this,
                        LinksListActivity.class);
                startActivity(intent);


            }
        });


        music = (Button) findViewById(R.id.button2);
        music.setOnClickListener(new OnClickListener() {

            // a boolean value in the names Onclicklistener class.
            // this will help us to know, if the music is playing or not.
            boolean isPlaying = false;


            @Override
            public void onClick(View arg0) {
                if (isPlaying) {
                    mediaPlayer.pause(); //stop the music
                    music.setText("Music On"); //change the buttons text
                } else {
                    mediaPlayer.start(); //start the music
                    music.setText("Music Off"); //change the text
                }
                //changing the boolean value
                isPlaying = !isPlaying;

            }
        });
        dynamicalLayout = (Button) findViewById(R.id.button5);
        dynamicalLayout.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(
                        Welcome.this,
                        DynamicLayoutActivity.class);
                startActivity(intent);

            }
        });

        weather = (Button) findViewById(R.id.button4);
        weather.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(
                        Welcome.this,
                        WeatherActivity.class);
                startActivity(intent);

            }
        });
    }


}

