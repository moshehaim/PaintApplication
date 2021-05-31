package com.hagitc.paintapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class HockeyView extends SurfaceView implements Runnable{
    private int height;
    private Bitmap imgDisk;
    private Bitmap paddleDisk;
    private Paint bgPaint;
    private Disk disk;
    private Paddle up;
    private Paddle down;
    private SurfaceHolder holder;
    private Canvas canvas;
    private Thread thread; //#1
    private int interval = 50;
    private boolean isRunning = true;

    public HockeyView(Context context, int width, int height) {
        super(context);
        this.height = height;
        holder = getHolder();
        //load image
        imgDisk = BitmapFactory.decodeResource(getResources(),R.drawable.medicine_ball);
        imgDisk = Bitmap.createScaledBitmap(imgDisk,100,100,false);
        bgPaint = new Paint();
        bgPaint.setColor(Color.WHITE);
        disk = new Disk(0,height/2,imgDisk,width,height);

        paddleDisk = BitmapFactory.decodeResource(getResources(),R.drawable.paddle);
        paddleDisk = Bitmap.createScaledBitmap(paddleDisk,100,100,false);

        up = new Paddle(width/2,200,paddleDisk,width,height);
        down = new Paddle(width/2,height-300,paddleDisk,width,height);

        thread = new Thread(this);// #2
        thread.start(); // execute run function
    }

    public void drawCanvas()
    {
        if(holder.getSurface().isValid())
        {
            canvas = holder.lockCanvas();

            canvas.drawPaint(bgPaint); // background
            disk.draw(canvas);
            up.draw(canvas);
            down.draw(canvas);
            holder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            disk.move();
            drawCanvas();
            logicTest();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
            }
        }
    }

    public boolean changeState()
    {
        isRunning = !isRunning;
        if(isRunning){
            thread = new Thread(this);
            thread.start();
        }

        return isRunning;
    }

    private void logicTest() {
        if(disk.inRange(up.getRect())) {
            disk.initdy();
            disk.initdX();
        }
        else if(disk.inRange(down.getRect())) {
            disk.initdy();
            disk.initdX();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_MOVE) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (y < height / 3) {
                if(up.inRange(x,y)) {
                    up.setX(x);
                    up.setY(y);
                }
            }
            else if (y > 2* height / 3) {
                if(down.inRange(x,y)) {
                    down.setX(x);
                    down.setY(y);
                }
            }
        }
        return true;
    }
}
