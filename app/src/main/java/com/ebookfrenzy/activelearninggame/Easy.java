package com.ebookfrenzy.activelearninggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Easy extends AppCompatActivity {

    private static final long COUNTDOWN_IN_MILLIS = 181000;
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
        setTitle("");




        textViewCountDown = findViewById(R.id.timer);
        textColorDefaultcd = textViewCountDown.getTextColors();



        s = new ArrayList<String >();
        s.add("Apple りんご(林檎)");
        s.add("Strawberry いちご(苺)");
        s.add("Orange みかん");
        s.add("Egg 卵");
        s.add("Wood (Timber) 木材");
        s.add("Tree 木");
        s.add("Paper 紙");
        s.add("Umbrella 傘/雨傘");
        s.add("Stone 石");
        s.add("Red 赤");
        s.add("Green 緑");
        s.add("Blue 青");
        s.add("Sunday 日曜日");
        s.add("Dog 犬");
        s.add("Cat 猫");
        s.add("Breakfast 朝食");
        s.add("Lunch 昼食");
        s.add("Dinner 夜食");
        s.add("Desk　机");
        s.add("Chair 椅子");
        s.add("Car 車");
        s.add("Bicycle 自転車");
        s.add("Train 電車");
        s.add("Bus バス");
        s.add("Baseball 野球");
        s.add("Soccer サッカー");
        s.add("Birthday 誕生日");
        s.add("Library 図書館");
        s.add("Eye 目");
        s.add("Nose 鼻");
        s.add("Mouth 口");
        s.add("Ear 耳");
        s.add("Sea 海");
        s.add("Beach 浜");
        s.add("River 川");
        s.add("Fish 魚");
        s.add("Bird 鳥");
        s.add("Holiday 休日");
        s.add("Chocolate チョコレート");
        s.add("Moon 月");
        s.add("Sun 太陽");
        s.add("Plane 飛行機");
        s.add("Shoes 靴");
        s.add("Rain 雨");
        s.add("Snow 雪");
        s.add("Cake ケーキ");
        s.add("Tomato トマト");
        s.add("Onion たまねぎ");
        s.add("Carrot ニンジン");
        s.add("Potato じゃがいも");




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
                //gameEnd();

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

        Intent intent = new Intent(Easy.this,ScoreActivity.class);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater ();
        inflater.inflate (R.menu.menu, menu);
        return true;}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                gameEnd();
                return true;

            case R.id.back:
                Intent openMedium  = new Intent(Easy.this,HomeActivity.class);
                startActivity(openMedium);
                finish();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}