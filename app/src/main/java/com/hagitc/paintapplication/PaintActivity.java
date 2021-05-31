package com.hagitc.paintapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class PaintActivity extends AppCompatActivity {

    private PaintView paintView;
    private Button btnLine,btnRect;
    private SeekBar sbWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint); // #step 3
        RelativeLayout relativeLayout = findViewById(R.id.mainPaint);
        paintView = new PaintView(this); // step #2
        relativeLayout.addView(paintView);
        btnLine = findViewById(R.id.button2);
        btnRect = findViewById(R.id.button);
        sbWidth = findViewById(R.id.sbWidth);
        sbWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                paintView.changeWidth(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void rect(View view) {
        btnRect.setAlpha(0.3f);
        btnLine.setAlpha(1f);
        paintView.setShapeName("rect");
    }

    public void line(View view) {
        btnRect.setAlpha(1f);
        btnLine.setAlpha(0.3f);
        paintView.setShapeName("line");
    }

    public void delete(View view) {
        paintView.delete();
    }

    public void undo(View view) {
        paintView.undo();
    }

    public void changeColor(View view) {
        String tag =  view.getTag().toString();
        Toast.makeText(this, "Tag: "+tag, Toast.LENGTH_SHORT).show();
        paintView.changeColor(tag);
    }
}