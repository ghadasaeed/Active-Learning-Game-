package com.ebookfrenzy.activelearninggame;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button Easy, Medium, Hard;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_one);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        imageView = findViewById(R.id.imageView);
//        textView = findViewById(R.id.textView7);
//
//        imageView.animate().alpha(0f).setDuration(0);
//        textView.animate().alpha(0f).setDuration(0);
//
//        imageView.animate().alpha(1f).setDuration(1000).setListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                textView.animate().alpha(1f).setDuration(800);
//            }
//        });


        intent = getIntent();

        Easy = findViewById(R.id.easy);
        Medium = findViewById(R.id.medium);
        Hard = findViewById(R.id.hard);

        Easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openEasy  = new Intent(MainActivity.this,Easy.class);
                startActivity(openEasy);
                finish();
            }});

        Medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openMedium  = new Intent(MainActivity.this,Medium.class);
                startActivity(openMedium);
                finish();


            }
        });

        Hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHard = new Intent(MainActivity.this,Hard.class);
                startActivity(openHard);
                finish();
            }
        });


    }
}