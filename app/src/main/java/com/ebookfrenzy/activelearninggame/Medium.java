package com.ebookfrenzy.activelearninggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Medium extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_medium);
//    }
ArrayList<String> s;
    ArrayAdapter arrayAdapter;
    HashMap<String, String> words = new HashMap<>();
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s = new ArrayList<String >();
        s.add("Kiwi キウイ");
        s.add("Alcohol アルコール");
        s.add("School 学校");
        s.add("Student 生徒/学生");
        s.add("Exam 試験");
        s.add("Teacher 教師");
        s.add("Window 窓");
        s.add("Garden 庭");
        s.add("House 家");
        s.add("Elevator エレベーター");
        s.add("Letter 手紙");
        s.add("Buy 買う");
        s.add("Diary 日記");
        s.add("Air 空気");
        s.add("Rice 米");
        s.add("Bread パン");
        s.add("Spring 春");
        s.add("Summer 夏");
        s.add("Autumn 秋");
        s.add("Winter 冬");
        s.add("Arm 腕");
        s.add("Hand 手");
        s.add("Leg 脚");
        s.add("Foot 足");
        s.add("Piano ピアノ");
        s.add("Guitar ギター");
        s.add("Forest 森");
        s.add("Book 本");
        s.add("Castel 城");
        s.add("Mirror 鏡");
        s.add("Fire 炎");
        s.add("Water 水");
        s.add("Ice 氷");
        s.add("Glasses 眼鏡");
        s.add("Bubble 泡");
        s.add("Doctor 医者");
        s.add("Practice 練習");
        s.add("Celling 天井");
        s.add("Floor 床");
        s.add("Rural 田舎");
        s.add("Urban 都会");
        s.add("Giraffe キリン");
        s.add("Elephant 象");
        s.add("Bear 熊");
        s.add("Rainbow 虹");
        s.add("Fuel 燃料");
        s.add("DeadLine 締め切り");
        s.add("Draft 下書き");
        s.add("Bitter 苦味");
        s.add("Sweet 甘味");
        s.add("Transparent 透明");
        s.add("Hungry 空腹");
        s.add("Thirsty 喉が渇く");


        Collections.shuffle(s);

        SwipeFlingAdapterView swipeFlingAdapterView = (SwipeFlingAdapterView)findViewById(R.id.card);

        arrayAdapter = new ArrayAdapter<String>(this,R.layout.details,R.id.textView,s);
        swipeFlingAdapterView.setAdapter(arrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                s.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {

            }

            @Override
            public void onRightCardExit(Object o) {

            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) {

            }
        });

    }
}