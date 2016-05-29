package com.example.ryokun.helloandroid;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by taka on 2016/05/24.
 */
public class SlotReel {
    public static int DEFAULT_INTERVAL = 100;

    Date startTime;
    Date stopTime;
    int count;
    int interval;
    int gap;


    public SlotReel(int c0, int i0, int g0){
        setGap(g0);
        setCount(c0);
        setInterval(i0);
        init();
    }

    public SlotReel(int c0, int i0){
        this(c0, i0, 0);
    }

    public SlotReel(int c0){
        this(c0, DEFAULT_INTERVAL);
    }

    public void init(){
        startTime = Calendar.getInstance().getTime();
        stopTime = Calendar.getInstance().getTime();
    }

    private void setGap(int g0){
        gap = Math.max(g0, 0);
    }

    public void init(int g0){
        setGap(g0);
        init();
    }

    public boolean isRotate(){
        return stopTime == null;
    }

    public boolean start(){
        if( !isRotate()){
            stopTime = null;
            startTime =Calendar.getInstance().getTime();
            return true;
        }else{
            return false;
        }
    }

    public int stop(){
        if( isRotate() ) {
            stopTime = Calendar.getInstance().getTime();
        }
        return getValue();
    }

    public int getValue(){
        Date ti;
        if( isRotate() ){
            ti = Calendar.getInstance().getTime();
        }else{
            ti = stopTime;
        }

        long diff = ti.getTime() - startTime.getTime();
        return (int)(((diff / interval) + gap) % count);
    }

    public void setInterval(int i0){
        interval = (i0 > 0) ? i0 : DEFAULT_INTERVAL;
    }

    public void setCount(int c0){
        count = (c0 >  0) ? c0 : 1;
    }
}
