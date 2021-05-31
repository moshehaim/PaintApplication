package com.hagitc.paintapplication;

import android.graphics.Canvas;
import android.graphics.Paint;

public class RectShape extends Shape{

    public RectShape(float startX, float startY, Paint paint) {
        super(startX, startY,paint);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(startX,startY,stopX,stopY,paint);
    }
}
