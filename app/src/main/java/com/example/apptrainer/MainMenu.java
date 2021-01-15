package com.example.apptrainer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainMenu extends AppCompatActivity {
    Button buttonP , buttonT;

    public void practice(View view){
        startActivity(new Intent(MainMenu.this,LevelMenu.class));
    }

    public void test (View view){
        startActivity(new Intent(MainMenu.this,Test.class));
    }

    public void about(View view){
        startActivity(new Intent(MainMenu.this,About.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar!=null;
        actionBar.setTitle("Main Menu");

        buttonP = findViewById(R.id.buttonPractice);
        buttonT = findViewById(R.id.buttonTest);

        VideoView videoView = (VideoView) findViewById(R.id.videoViewwelcome);
        videoView.setVideoPath("android.resource://" + getPackageName() +"/" + R.raw.welcome);

        /*MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);*/
        videoView.start();


    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainMenu.this , WelcomeScreen.class));

    }
    
}
