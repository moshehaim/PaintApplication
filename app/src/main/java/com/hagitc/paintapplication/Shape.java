package com.hagitc.paintapplication;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public abstract class Shape {
    protected float startX;
    protected float startY;
    protected float stopX;
    protected float stopY;
    protected Paint paint;
    /*private Point startPoint;
    private Point endPoint;*/

    public Shape(float startX, float startY, Paint paint) {
        this.startX = startX;
        this.startY = startY;
        this.stopX = startX;
        this.stopY = startY;
        this.paint = new Paint(paint); // aliasing
      //  this.paint.setStrokeWidth(paint.getStrokeWidth());
    }


    public void setStopX(float stopX) {
        this.stopX = stopX;
    }
    public void setStopY(float stopY) {
        this.stopY = stopY;
    }

    public abstract void draw(Canvas canvas);
}
