package com.hagitc.paintapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToPaint(View view) {
        Intent intent = new Intent(this, PaintActivity.class);
        startActivity(intent);
    }

    public void goToHockey(View view) {
        Intent intent = new Intent(this, HockeyActivity.class);
        startActivity(intent);
    }
}