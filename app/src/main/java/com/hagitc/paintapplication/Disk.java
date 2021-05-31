package com.hagitc.paintapplication;

import android.graphics.Bitmap;

import java.util.Random;

public class Disk extends Figure{
    private int dx = 20;
    private int dy = 20;

    public Disk(int x, int y, Bitmap bitmap, int w, int h) {
        super(x, y, bitmap, w, h);
    }

    @Override
    public void move()
    {
        x+=dx;
        y+=dy;
        if(x<0 && dx<0) // left limit
            initdX();
        if(getXr() > width && dx>0) // right limit
            initdX();
        if(y<0 && dy<0) //up limit
            initdy();
        if (getYd()>height&& dy>0) // down Limit
            initdy();
    }

    public void initdX()
    {
        int d = dx < 0? 1:-1;
        dx = d*(10+random.nextInt(20));
      //  init();
    }

    public void initdy()
    {
        int d = dy < 0? 1:-1;
        dy = d*(10+random.nextInt(20));
       // init();
    }
}
