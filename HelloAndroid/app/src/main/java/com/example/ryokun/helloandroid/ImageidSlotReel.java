package com.example.ryokun.helloandroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taka on 2016/05/24.
 */
public class ImageidSlotReel extends SlotReel{
    List<Integer> symbols;

    public ImageidSlotReel(){
        super(0);
        symbols = new ArrayList<Integer>();
    }

    public ImageidSlotReel(int[] s0){
        this();
        addSymbols(s0);
    }

    public ImageidSlotReel(int gap) {
        super(0, DEFAULT_INTERVAL, gap);
        symbols = new ArrayList<Integer>();
    }

    public ImageidSlotReel(int[] s0, int gap){
        this(gap);
        addSymbols(s0);
    }

    public void addSymbol(int iid){
        symbols.add(iid);
        setCount(symbols.size());
    }

    public void addSymbols(int[] iid){
        for(int v : iid){
            addSymbol(v);
        }
    }

    public void clearSymbols(){
        symbols.clear();
        setCount(symbols.size());
    }

    public int getSymbolId(int defaultValue){
        if( !symbols.isEmpty() ){
            return symbols.get(getValue());
        }else{
            return defaultValue;
        }
    }

    public int getSymbolId(){
        return getSymbolId(-1);
    }
}
