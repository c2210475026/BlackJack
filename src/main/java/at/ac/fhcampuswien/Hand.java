package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {
    private List<Card> inHand;
    private Stapel stapel;

    public Hand(Stapel stapel){
        inHand=new ArrayList<>();
        this.stapel=stapel;
        drawHand();
    }

    public List<Card> getInHand(){
        return inHand;
    }

    public void drawHand(){
        for (int i=0;i<2;i++){
           inHand.add(stapel.drawCard());
        }
    }

    public Card getHandCard(int index){
        return inHand.get(index);
    }

    public void clearHand(){
        inHand.clear();
    }

    public Card addgetCardToHand(){
        Card card = stapel.drawCard();
        inHand.add(card);
        return card;
    }

    public void addCardToHand(){
        inHand.add(stapel.drawCard());
    }

    public int sumOfCards(){
        int sum = 0;
        for(int i=0; i<inHand.size();i++){
            Card card = inHand.get(i);
            sum = sum + card.getWert();
        }
        return sum;
    }


}
