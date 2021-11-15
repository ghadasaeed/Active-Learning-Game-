package com.ebookfrenzy.activelearninggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//public class ChooseOne extends AppCompatActivity {
//
//    Button Easy, Medium, Hard;
//    Intent intent;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_choose_one);
//
//        intent = getIntent();
//
//        Easy = findViewById(R.id.easy);
//        Medium = findViewById(R.id.medium);
//        Hard = findViewById(R.id.hard);
//
//        Easy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                    Intent openEasy  = new Intent(ChooseOne.this,Easy.class);
//                    startActivity(openEasy);
//                    finish();
//        }});
//
//        Medium.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                    Intent openMedium  = new Intent(ChooseOne.this,Medium.class);
//                    startActivity(openMedium);
//                    finish();
//
//
//            }
//        });
//
//        Hard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                    Intent openHard = new Intent(ChooseOne.this,Hard.class);
//                    startActivity(openHard);
//                    finish();
//            }
//        });
//
//
//    }
//}