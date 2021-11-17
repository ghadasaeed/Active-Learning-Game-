package com.ebookfrenzy.activelearninggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class ScoreActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView scoreView;
    int Score,Total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams. FLAG_FULLSCREEN);
//        getSupportActionBar().hide(); //This Line hides the action bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        setTitle("");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Score = getIntent().getIntExtra("Score",0);
        Total = getIntent().getIntExtra("Total",0);
        circularProgressBar = findViewById(R.id.circularProgressBar);
        scoreView = findViewById(R.id.score);

        circularProgressBar.setProgressMax(Total);
        circularProgressBar.setProgress(Score);

        scoreView.setText(Score+"/"+Total);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater ();
        inflater.inflate (R.menu.menu3, menu);
        return true;}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                Intent openMedium  = new Intent(ScoreActivity.this,HomeActivity.class);
                startActivity(openMedium);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}