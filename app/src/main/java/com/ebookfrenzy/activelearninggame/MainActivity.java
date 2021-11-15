package com.ebookfrenzy.activelearninggame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button Easy, Medium, Hard;
    Intent intent;
    ImageView imageView;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intro);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView7);

        imageView.animate().alpha(0f).setDuration(0);
        textView.animate().alpha(0f).setDuration(0);

        imageView.animate().alpha(1f).setDuration(1000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                textView.animate().alpha(1f).setDuration(800);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
        setContentView(R.layout.activity_choose_one);
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
        },3000);


    }


//    new Handler().postDelayed(new Runnable() {
//        @Override
//        public void run() {
//
//
//                Intent intent = new Intent(MainActivity.this, MainMenu.class);
//                startActivity(intent);
//                finish();
//            }
//
//
//        }
//    },3000);
}