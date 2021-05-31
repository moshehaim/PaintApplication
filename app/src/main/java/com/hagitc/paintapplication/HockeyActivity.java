package com.hagitc.paintapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

public class HockeyActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private HockeyView hockeyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hockey);
        frameLayout = findViewById(R.id.frm); //step #1
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus)
        {
            //step#2
            hockeyView = new HockeyView(this,frameLayout.getWidth(),frameLayout.getHeight());
            //step #3 - connect framelayout to canvas
            frameLayout.addView(hockeyView);
           /* Log.d("TAG", "onWindowFocusChanged: "+ frameLayout.getHeight());
            Log.d("TAG", "onWindowFocusChanged: "+ frameLayout.getWidth());*/
        }
    }

    public void changeState(View view) {

        hockeyView.changeState();

    }
}