package com.hagitc.paintapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class PaintView extends View { // Step #1

    private Context context;
    private Paint paint;
    private Paint bgPaint;
    private Bitmap bmp;
    float startX=0, startY=0, stopX=0,stopY=0;
    private ArrayList<Shape> shapes;

    private String shapeName="Line";

    public PaintView(Context context) {
        super(context);
        this.context = context;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bgPaint = new Paint();
        bgPaint.setColor(Color.rgb(100,100,100));
        paint.setColor(Color.BLUE);
        //paint.setColor(Color.parseColor("#ff1288"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.paint);
        shapes = new ArrayList<>();
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // canvas.drawColor(Color.rgb(100,100,100)); // background
        canvas.drawPaint(bgPaint); // background

        for (int i = 0;i< shapes.size(); i++)
            shapes.get(i).draw(canvas);
    }

    private Shape shape;// ************
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if(shapeName.equalsIgnoreCase("line"))
                shape = new LineShape(x,y, paint);
            else
                shape = new RectShape(x,y, paint);

            shapes.add(shape);
            invalidate(); // refresh onDraw()
        }
        if(event.getAction() == MotionEvent.ACTION_MOVE)
        {
            shape.setStopX(x);
            shape.setStopY(y);
            //shapes.get(shapes.size()-1).setStopY(y);
            invalidate(); // refresh onDraw()
        }

        return true;
    }

    public void delete() {
        shapes.clear();
        invalidate();
    }

    public void undo() {
        if(shapes.size()>0)
        {
            shapes.remove(shapes.size()-1);
            invalidate();
        }
    }

    public void changeWidth(int i) {
        paint.setStrokeWidth(i);
    }

    public void changeColor(String color) {
        paint.setColor(Color.parseColor(color));
    }
}
