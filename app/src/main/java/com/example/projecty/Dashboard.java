package com.example.projecty;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Dashboard extends AppCompatActivity  {

TextView date, name;
TextView time;
ImageView home, message, person, setting;
ConstraintLayout carpool, auto,whole_cab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        name = findViewById(R.id.name);
        Calendar calendar = Calendar.getInstance();
        String current_date = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        date.setText(current_date);


        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    while(!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Calendar calendar = Calendar.getInstance();
                                @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                                String date = simpleDateFormat.format(calendar.getTime());
                                time.setText(date);
                            }
                        });
                    }
                }catch (Exception ignored){

                }
            }
        };
        thread.start();

        home = findViewById(R.id.home);
        message = findViewById(R.id.message);
        person = findViewById(R.id.person);
        setting = findViewById(R.id.setting);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                finish();
            }
        });
        carpool = findViewById(R.id.carpool);
        auto = findViewById(R.id.auto);
        whole_cab = findViewById(R.id.whole_cab);
        carpool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.projecty.carpool.class));
            }
        });
        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.projecty.auto.class));
            }
        });
        whole_cab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), wholecab.class));
            }
        });




    }
}