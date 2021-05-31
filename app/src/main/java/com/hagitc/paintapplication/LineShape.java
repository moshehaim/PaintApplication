package com.hagitc.paintapplication;

import android.graphics.Canvas;
import android.graphics.Paint;

public class LineShape extends Shape{
    
    public LineShape(float startX, float startY, Paint paint) {
        super(startX, startY,paint);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawLine(startX,startY,stopX,stopY,paint);
    }
}
