package com.ebookfrenzy.activelearninggame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button Easy, Medium, Hard;
    Intent intent;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setSupportActionBar(toolbar);
        setTitle("Home");

        setContentView(R.layout.activity_choose_one);
        intent = getIntent();

        Easy = findViewById(R.id.easy);
        Medium = findViewById(R.id.medium);
        Hard = findViewById(R.id.hard);

        Easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openEasy  = new Intent(HomeActivity.this,Easy.class);
                startActivity(openEasy);
                finish();
            }});

        Medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openMedium  = new Intent(HomeActivity.this,Medium.class);
                startActivity(openMedium);
                finish();


            }
        });

        Hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHard = new Intent(HomeActivity.this,Hard.class);
                startActivity(openHard);
                finish();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater ();
        inflater.inflate (R.menu.menu2, menu);
        return true;}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Help:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setMessage("Game Rules:\n" +
                        "1.only use one language to explain the words.\n" +
                        "2.don't say the same word.\n" +
                        "3.Play in the time limit.\n" +
                        "*Swap to the right when getting right answer.\n" +
                        "*Swap to the left to skip.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Okay",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


                AlertDialog alert11 = builder1.create();
                alert11.show();


                return true;
//            case R.id.Add:
//
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
