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
}
