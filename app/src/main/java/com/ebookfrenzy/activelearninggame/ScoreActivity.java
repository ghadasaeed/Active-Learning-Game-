package com.ebookfrenzy.activelearninggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class ScoreActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView scoreView;
    int Score,Total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Score = getIntent().getIntExtra("Score",0);
        Total = getIntent().getIntExtra("Total",0);
        circularProgressBar = findViewById(R.id.circularProgressBar);
        scoreView = findViewById(R.id.score);

        circularProgressBar.setProgressMax(Total);
        circularProgressBar.setProgress(Score);

        scoreView.setText(Score+"/"+Total);




    }
}