package com.example.apptrainer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class LevelMenu extends AppCompatActivity {
    Button button1,button2 ,button3,button4;
    Timer timer;
    public void level1(View view) {
        startActivity(new Intent(LevelMenu.this,MainActivity.class));
    }
    public void level2(View view) {
        startActivity(new Intent(LevelMenu.this,LevelSecond.class));
    }
    public void level3(View view) {
        startActivity(new Intent(LevelMenu.this , LevelThird.class));
    }
    public void level4(View view) {
        startActivity(new Intent(LevelMenu.this, LevelFourth.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_menu);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar!=null;
        actionBar.setTitle("Start Practicing");
        button1=findViewById(R.id.level1);
        button2=findViewById(R.id.level2);
        button3=findViewById(R.id.level3);
        button4=findViewById(R.id.level4);

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                VideoView videoView = (VideoView) findViewById(R.id.videoViewlevel);
                videoView.setVideoPath("android.resource://" + getPackageName() +"/" + R.raw.levelselect);

        /*MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);*/
                videoView.start();


            }
        },1);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LevelMenu.this , MainMenu.class));

    }
}
