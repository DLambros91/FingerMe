package com.example.dlambros.fingerme;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dlambros on 10/29/15.
 */
public class myView extends View
{
    private Paint paint[] = new Paint[10];
    private Paint circle[] = new Paint[10];
    private Paint text = new Paint();
    private fingers finger[] = new fingers[10];
    private Path path[] = new Path[10];
    private int count;

    public myView(Context context, AttributeSet attrs)
    {
        super(context, attrs);



        for(int i = 0; i < 10; i++)
        {
            circle[i] = new Paint();
            paint[i] = new Paint();
            paint[i].setStrokeWidth(6f);
            paint[i].setStyle(Paint.Style.STROKE);
        }



        circle[0].setColor(Color.GREEN);
        paint[0].setColor(Color.GREEN);
        circle[1].setColor(Color.BLUE);
        paint[1].setColor(Color.BLUE);
        circle[2].setColor(Color.MAGENTA);
        paint[2].setColor(Color.MAGENTA);
        circle[3].setColor(Color.CYAN);
        paint[3].setColor(Color.CYAN);
        circle[4].setColor(Color.GRAY);
        paint[4].setColor(Color.GRAY);
        circle[5].setColor(Color.RED);
        paint[5].setColor(Color.RED);
        circle[6].setColor(Color.DKGRAY);
        paint[6].setColor(Color.DKGRAY);
        circle[7].setColor(Color.LTGRAY);
        paint[7].setColor(Color.LTGRAY);
        circle[8].setColor(Color.YELLOW);
        paint[8].setColor(Color.YELLOW);
        circle[9].setColor(Color.BLACK);
        paint[9].setColor(Color.BLACK);

        for(int i = 0; i < 10; i++)
        {
            finger[i] = new fingers();
            finger[i].setColor(circle[i]);
            finger[i].setPaint(paint[i]);
            path[i] = new Path();
        }

        text.setAntiAlias(true);
        text.setColor(Color.BLACK);
        text.setTextSize(40);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        for(int i = 0; i < 10; i++)
        {
            if (finger[i].getisActive())
            {

                canvas.drawCircle(finger[i].getX(), finger[i].getY(), 550 * finger[i].getFingersize(), finger[i].getColor());
            }
            canvas.drawPath(path[i], finger[i].getPaint());

            if (finger[i].getisActive())
            {
                canvas.drawText("PointerID: " + finger[i].getEventID() + " Current X: " + (int) finger[i].getX() + " Current Y: " + (int) finger[i].getY(), 65, (65 + 60*finger[i].getEventID()), text);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int pointerId = event.getPointerId(event.getActionIndex());
        finger[pointerId].setEventID(pointerId);
        finger[pointerId].setX(event.getX(event.getActionIndex()));
        finger[pointerId].setY(event.getY(event.getActionIndex()));

        count = event.getPointerCount();
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN: {
                finger[pointerId].setFingersize(event.getSize(pointerId));
                finger[pointerId].setActive(true);
                path[pointerId].moveTo(finger[pointerId].getX(), finger[pointerId].getY());
                break;
            }
            case MotionEvent.ACTION_MOVE: {
              /*  for(int i = 0; i < count; i++)
                {
                    if(finger[i].getisActive())
                    {
                        finger[i].setX(event.getX(i));
                        finger[i].setY(event.getY(i));
                        path[i].lineTo(finger[i].getX(), finger[i].getY());
                    }
                }*/
                for (int count = event.getPointerCount(), i = 0; i < count; i++)
                {
                    if(finger[event.getPointerId(i)].getisActive())
                    {
                        finger[event.getPointerId(i)].setX(event.getX(i));
                        finger[event.getPointerId(i)].setY(event.getY(i));
                        path[event.getPointerId(i)].lineTo(finger[event.getPointerId(i)].getX(), finger[event.getPointerId(i)].getY());
                    }
                }
                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                finger[pointerId].setActive(false);
                break;
            }
            case MotionEvent.ACTION_POINTER_UP:
                finger[pointerId].setActive(false);
                break;
            case MotionEvent.ACTION_UP:
                finger[pointerId].setActive(false);
                break;
        }
        // Schedules a repaint.
        invalidate();
        return true;
    }

}
