package com.hagitc.paintapplication;

import android.graphics.Bitmap;

public class Paddle extends Figure{

    public Paddle(int x, int y, Bitmap bitmap, int w, int h) {
        super(x, y, bitmap, w, h);
    }


    public void setX(int newX) {
        x = newX - bitmap.getWidth()/2;
    }

    public void setY(int newY) {
        y = newY - bitmap.getHeight()/2;
    }
}
