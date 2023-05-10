package com.stezan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String [] qsn={"In programming, the equal sign (=) is used for comparison.",
            "C is an object-oriented programming language.",
            "The 'if' statement can only have a single 'else' block.",
            "A variable declared inside a function in C is accessible outside that function.",
            "The 'break' statement is used to terminate the current iteration of a loop.",
            "C supports method overloading.",
            " In C, the '++' operator increments the value of a variable by 1.",
            " C supports multiple inheritance.",
            "The 'sizeof' operator returns the size of a data type in bytes.",
            "C does not support exception handling."
    };

    private boolean [] ans={false,
            false,
            false,
            false,
            true,
            false,
            true,
            false,
            true,
            true};
    private int scores=0;
    private int index=0;
    private int attempts=0;
    private String scoretxt;
    private String attemptxt;

    Button yes;
    Button no;
    TextView qsns;
    TextView score;
    TextView attempt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        qsns=findViewById(R.id.qsns);
        score=findViewById(R.id.score);
        attempt=findViewById(R.id.attempt);
        qsns.setText(qsn[index]);
        scoretxt= "score = "+String.valueOf(scores)+"/"+qsn.length;
        score.setText(scoretxt);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(index<=qsn.length-1){
                    attempts++;
                    attemptxt= "QSN = "+String.valueOf(attempts)+"/"+qsn.length;
                    attempt.setText(attemptxt);
                     if(ans[index])
                     {
                         scores++;
                         scoretxt= "SCORE = "+String.valueOf(scores)+"/"+qsn.length;
                         score.setText(scoretxt);
                     }
                     index++;
                    if(index<=qsn.length-1) {
                        qsns.setText(qsn[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "questions finished "+scores, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<=qsn.length-1){
                    attempts++;
                    attemptxt= "QSN = "+String.valueOf(attempts)+"/"+qsn.length;
                    attempt.setText(attemptxt);
                    if(!ans[index])
                    {
                        scores++;
                        scoretxt= "SCORE = "+String.valueOf(scores)+"/"+qsn.length;
                        score.setText(scoretxt);
                    }
                    index++;
                    if(index<=qsn.length-1) {
                        qsns.setText(qsn[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "questions finished "+scores, Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}