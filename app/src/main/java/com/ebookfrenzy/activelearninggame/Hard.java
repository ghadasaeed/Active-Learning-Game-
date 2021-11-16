package com.ebookfrenzy.activelearninggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Hard extends AppCompatActivity {

    private static final long COUNTDOWN_IN_MILLIS = 20000;
    private ColorStateList textColorDefaultcd;
    private CountDownTimer countDownTimer;
    private long timeLeftinMillis;
    private TextView textViewCountDown;

    int Score = 0;
    int Total = 0;
ArrayList<String> s;
    ArrayAdapter arrayAdapter;
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s = new ArrayList<String >();

        textViewCountDown = findViewById(R.id.timer);
        textColorDefaultcd = textViewCountDown.getTextColors();


        s.add("Computer コンピューター");
        s.add("Time 時間");
        s.add("Music 音楽");
        s.add("Art 芸術");
        s.add("Science 科学");
        s.add("Light 光");
        s.add("Shadow 影");
        s.add("Peace 平和");
        s.add("Theory 理論");
        s.add("Lie 嘘");
        s.add("Life 人生/生活");
        s.add("Future 未来");
        s.add("Past 過去");
        s.add("Mathematics 数学");
        s.add("Promise 約束");
        s.add("Sound 音");
        s.add("Online オンライン");
        s.add("Tax 税金");
        s.add("Wait 買う");
        s.add("Imagination 想像力");
        s.add("Agreement 合意");
        s.add("Technology 技術");
        s.add("Environment 環境");
        s.add("Experiment 実験");
        s.add("Evidence 証拠");
        s.add("Industry 産業");
        s.add("Agriculture 農業");
        s.add("Economy 経済");
        s.add("Interest 興味");
        s.add("Possibility 可能性");
        s.add("Advantage 利点");
        s.add("Emotion 感情");
        s.add("Personality 個性/性格");
        s.add("Majority 多数派");
        s.add("Minority 少数派");
        s.add("Confidence 自信");
        s.add("Religion 宗教");
        s.add("Diversity 多様性");
        s.add("Routine ルーティン");
        s.add("Duty 義務");
        s.add("Gravity 重力");
        s.add("License 免許");
        s.add("Bias 偏見");
        s.add("Cooperation 協力");
        s.add("Stress ストレス");
        s.add("Random 無作為");
        s.add("Flavor 風味");
        s.add("Ratio 比率");
        s.add("Number 番号");
        s.add("Network ネットワーク");

        Collections.shuffle(s);
        SwipeFlingAdapterView swipeFlingAdapterView = (SwipeFlingAdapterView)findViewById(R.id.card);

        arrayAdapter = new ArrayAdapter<String>(this,R.layout.details,R.id.textView,s);
        swipeFlingAdapterView.setAdapter(arrayAdapter);
        timeLeftinMillis = COUNTDOWN_IN_MILLIS;
        startCountDown();
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                s.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {
                Total++;
                Toast.makeText(getApplicationContext(),":(",Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onRightCardExit(Object o) {
                Total++;
                Score++;
                Toast.makeText(getApplicationContext(),":) Great",Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
              //  gameEnd();

            }

            @Override
            public void onScroll(float v) {

            }
        });

    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftinMillis,1000) {
            @Override
            public void onTick(long milliUntilFinished) {
                timeLeftinMillis= milliUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                timeLeftinMillis = 0;
                updateCountDownText();
                gameEnd();

            }
        }.start();
    }
    private void updateCountDownText(){
        int minutes = (int) (timeLeftinMillis / 1000) / 60;
        int seconds = (int) (timeLeftinMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

        textViewCountDown.setText(timeFormatted);
        if(timeLeftinMillis < 5000) {
            textViewCountDown.setTextColor(Color.RED);
        }else{
            textViewCountDown.setTextColor(textColorDefaultcd);
        }
    }
    private void gameEnd(){
        Intent intent = new Intent(Hard.this,ScoreActivity.class);
        countDownTimer.cancel();
        intent.putExtra("Score",Score);
        intent.putExtra("Total",Total);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer != null){
            countDownTimer.cancel();
        }

    }
}