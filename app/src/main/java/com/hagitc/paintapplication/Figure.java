package com.hagitc.paintapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Random;

public abstract class Figure {
    protected int x;
    protected int y;
    protected Rect rect = new Rect();
    protected Bitmap bitmap;
    protected static int width; // Screen
    protected static int height; // Screen
    protected static Random random = new Random();

    public Figure(int x, int y, Bitmap bitmap, int w, int h) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
        width = w;
        height = h;

    }

    public int getXr() {
        return x + bitmap.getWidth();
    }

    public int getYd() {
        return y + bitmap.getHeight();
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap,x,y,null);
    }

    public void move()
    {
    }

    public void init(){
        int num = random.nextInt(50)+50; // 50-100
        bitmap = Bitmap.createScaledBitmap(bitmap,num,num,false);
    }



    public boolean inRange(int xTouch, int yTouch)
    {
        rect.set(x,y,getXr(),getYd());
        return rect.contains(xTouch,yTouch);
    }

    public boolean inRange(Rect other)
    {
        rect.set(x,y,getXr(),getYd());
        return rect.intersect(other);
    }

    public Rect getRect() {
        rect.set(x,y,getXr(),getYd());
        return rect;
    }
}
