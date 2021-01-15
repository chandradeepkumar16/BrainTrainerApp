package com.example.apptrainer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Test extends AppCompatActivity {

    Button goButton;

    ArrayList<Integer> answers= new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    TextView resultTextView ;
    int score =0;
    int numberOfQuestion;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    ConstraintLayout gameLayout ;
    TextView welcomeTetxtView;
    TextView finalTextView;

    public void playAgain(View view ) {

        score=0;
        numberOfQuestion=0;
        timerTextView.setText("30 s");
        scoreTextView.setText(Integer.toString(score) +" / " + Integer.toString(numberOfQuestion));
        playAgainButton.setVisibility(View.INVISIBLE);
        newQuestion();
        resultTextView.setText("");

        new CountDownTimer(31000,1000) {


            @Override
            public void onTick(long l) {
                finalTextView.setVisibility(View.INVISIBLE);
                timerTextView.setText(String.valueOf(l/1000) + "s" );
                sumTextView.setVisibility(View.VISIBLE);
                scoreTextView.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFinish() {
                finalTextView.setVisibility(View.VISIBLE);
                finalTextView.setText(" Your score : "+Integer.toString(score) +" / " + Integer.toString(numberOfQuestion));
                resultTextView.setVisibility(View.INVISIBLE);
                sumTextView.setVisibility(View.INVISIBLE);
                scoreTextView.setVisibility(View.INVISIBLE);

                playAgainButton.setVisibility(View.VISIBLE);



            }
        }.start();


    }


    public void chooseAnswer (View view ) {
        view.getTag().toString();
        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
            resultTextView.setText("  correct");
            score++;
        } else {
            resultTextView.setText("  wrong :(");
        }
        numberOfQuestion++;
        scoreTextView.setText(Integer.toString(score) +" / " + Integer.toString(numberOfQuestion));
        newQuestion();
    }


    /* public void start (View view) {
         goButton.setVisibility(View.INVISIBLE);
         welcomeTetxtView.setVisibility(View.INVISIBLE);
         gameLayout.setVisibility(View.VISIBLE);
         playAgain(findViewById(R.id.timerTextView));


     }
 */
    public void newQuestion() {

        Random rand = new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(30);

        String pcString , choosenvalue;
        String answertoshow;
        String[] strArr = { "+", "-", "*","/"};
        Random rand2 = new Random();
        int res = rand2.nextInt(strArr.length);
        pcString= strArr[res];

        sumTextView.setText(Integer.toString(a) + pcString + Integer.toString(b) + " = ?");

        locationOfCorrectAnswer=rand.nextInt(4);
        answers.clear();

        for (int i=0;i<4;i++) {
            if(i==locationOfCorrectAnswer)
            {
                if (pcString.equals("+")) {
                    answers.add(a+b);
                } else if (pcString.equals("-")){
                    answers.add(a-b);
                } else if (pcString.equals("*")){
                    answers.add(a*b);
                }else if (pcString.equals("/")){
                    if (a > b){
                        answers.add((int) (a / b));
                    } else if (b>a){
                        a=(b-a)+rand.nextInt(10);
                        answers.add((int) (a / b));
                    }
                }

            } else{
                int wrongAnswer = rand.nextInt(90);
                while (wrongAnswer==a+b) {
                    wrongAnswer =rand.nextInt(90);
                }
            }
            answers.add(rand.nextInt(80));
        }



        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView = findViewById(R.id.sumTextView);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar!=null;
        actionBar.setTitle("Test");
/*
        VideoView videoView = (VideoView) findViewById(R.id.videoVieweasy);
        videoView.setVideoPath("android.resource://" + getPackageName() +"/" + R.raw.gamebackground);

        /*MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);*/
        /*        videoView.start(); */


        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        resultTextView= findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView=findViewById(R.id.timerTextView);
        playAgainButton = findViewById(R.id.playAgainButton);
        gameLayout = findViewById(R.id.gameLayout);
        //welcomeTetxtView = findViewById(R.id.welcomeTetxtView);
        finalTextView = findViewById(R.id.finalScoreTextView);


        // goButton = findViewById(R.id.goButton);
        //goButton.setVisibility(View.VISIBLE);
        // welcomeTetxtView.setVisibility(View.VISIBLE);

        gameLayout.setVisibility(View.VISIBLE);
        newQuestion();
        playAgain(findViewById(R.id.timerTextView));




    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Test.this , MainMenu.class));

    }
}
