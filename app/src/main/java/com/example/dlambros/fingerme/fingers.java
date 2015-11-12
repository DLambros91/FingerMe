package com.example.dlambros.fingerme;

import android.graphics.Paint;

import java.util.Objects;

/**
 * Created by dlambros on 11/1/15.
 */
public class fingers
{
    private float x;
    private float y;
    private float fingersize;
    private int eventID;
    private Paint color;
    private boolean isActive;
    private Paint paint;

    public fingers()
    {
        isActive = false;
    }

    /**
     * Sets the x-coordinate of the current finger event.
     * @param xNew - X-coordinate value
     */
    public void setX(float xNew)
    {
        x = xNew;
    }

    /**
     * Sets the y-coordinate of the current finger event.
     * @param yNew - Y-coordinate value
     */
    public void setY(float yNew)
    {
        y = yNew;
    }

    /**
     * Sets the finger size of the current finger event.
     * @param finger - finger size
     */
    public void setFingersize(float finger)
    {
        fingersize = finger;
    }

    /**
     * Sets the pointer ID for the current finger event.
     * @param ID - current pointer ID
     */
    public void setEventID(int ID)
    {
        eventID = ID;
    }

    /**
     * Sets the Paint for the current finger event.
     * @param paint - Paint color characteristics
     */
    public void setColor(Paint paint)
    {
        color = paint;
    }

    /**
     * Sets the current state of the finger event.
     * @param active - is the current state active
     */
    public void setActive(boolean active)
    {
        isActive = active;
    }

    /**
     * Sets the current paint for the finger event.
     * @param paint - Current paint color to draw
     */
    public void setPaint(Paint paint)
    {
        this.paint = paint;
    }

    /**
     * This function returns the current stored x-coordinate
     * @return x
     */
    public float getX()
    {
        return x;
    }

    /**
     * This function returns the current stored y-coordinate
     * @return y
     */
    public float getY()
    {
        return y;
    }

    /**
     * This function returns the current finger size
     * @return fingersize
     */
    public float getFingersize()
    {
        return fingersize;
    }

    /**
     * This functions returns the current pointer ID
     * @return eventID
     */
    public int getEventID()
    {
        return eventID;
    }

    /**
     * This function returns the current color of the finger event
     * @return color
     */
    public Paint getColor()
    {
        return color;
    }

    /**
     * This function returns the current status of the finger event
     * @return isActive
     */
    public boolean getisActive()
    {
        return isActive;
    }

    public Paint getPaint()
    {
        return paint;
    }
}
