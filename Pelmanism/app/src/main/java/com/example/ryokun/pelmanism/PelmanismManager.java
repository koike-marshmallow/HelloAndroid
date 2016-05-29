package com.example.ryokun.pelmanism;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taka on 2016/05/29.
 */
public class PelmanismManager {
    private List<PelmanismCard> cards;

    public PelmanismManager(){
        cards = new ArrayList<PelmanismCard>();
    }

    public void addCard(PelmanismCard card){
        cards.add(card);
    }

    public void cardClear(){
        cards.clear();
    }

    public void shuffleCard(int count){
        for(int i=0; i<count; i++){
            int idx1 = (int)(Math.random() * cards.size());
            int idx2 = (int)(Math.random() * cards.size());
            PelmanismCard tmp = cards.get(idx1);
            cards.set(idx1, cards.get(idx2));
            cards.set(idx2, tmp);
        }
    }

    public void shuffleCard(){
        shuffleCard(cards.size() / 2);
    }

    public void init(){
        shuffleCard();
        cardAllClose();
    }

    private boolean onBounds(int idx){
        return idx >= 0 && idx < cards.size();
    }

    public boolean cardOpen(int idx){
        if( onBounds(idx) ){
            PelmanismCard target = cards.get(idx);
            if( !target.isOpen() ) {
                target.setOpen(true);
            }else{
                return false;
            }

            int cnt = 0;
            for(PelmanismCard c : cards){
                if( (c.getNumber() == target.getNumber()) && c.isOpen() ){
                    cnt++;
                }
            }

            return (cnt % 2) == 0;
        }else{
            return false;
        }
    }

    public void cardClose(int idx){
        if( onBounds(idx) ){
            cards.get(idx).setOpen(false);
        }
    }

    public void cardAllClose(){
        for(PelmanismCard card : cards){
            card.setOpen(false);
        }
    }

    public void cardAllOpen(){
        for(PelmanismCard card : cards){
            card.setOpen(true);
        }
    }

    public PelmanismCard getCard(int idx) {
        return onBounds(idx) ? cards.get(idx) : null;
    }

    public int getCardNumber(int idx){
        return onBounds(idx) ? cards.get(idx).getNumber() : null;
    }

    public boolean getCardOpened(int idx){
        return onBounds(idx) ? cards.get(idx).isOpen() : null;
    }

    public void refresh(){
        for(PelmanismCard card : cards){
            if( card.isOpen() ){

            }
        }
    }



}
