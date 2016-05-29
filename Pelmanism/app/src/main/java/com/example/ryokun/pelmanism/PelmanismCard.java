package com.example.ryokun.pelmanism;

/**
 * Created by taka on 2016/05/29.
 */
public class PelmanismCard {
    private int number;
    private boolean isOpen;

    public PelmanismCard(){
        number = 0;
        isOpen = false;
    }

    public PelmanismCard(int n0){
        this();
        setNumber(n0);
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int n0){
        number = n0;
    }

    public boolean isOpen(){
        return isOpen;
    }

    public void setOpen(boolean o0){
        isOpen = o0;
    }

    public String toString(){
        return "[PelmanismCard: (" + number +
                (isOpen ? ") opened]" : ")]");
    }
}
