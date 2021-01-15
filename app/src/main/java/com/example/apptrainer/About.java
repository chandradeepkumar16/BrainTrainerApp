package com.example.apptrainer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class About extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar!=null;
        actionBar.setTitle("About");

        imageView=findViewById(R.id.aboutimg);
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(About.this , MainMenu.class));

    }
}
