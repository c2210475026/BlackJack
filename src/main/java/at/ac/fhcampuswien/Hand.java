package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> inHand;
    private Stack stack;

    // Constructor
    public Hand(Stack stack){
        inHand=new ArrayList<>();
        this.stack = stack;
    }

    public List<Card> getInHand(){
        return inHand;
    }

    //at the beginning of a round drawing two cards.
    public void drawHand(){
        for (int i=0;i<2;i++){
           inHand.add(stack.drawCard());
        }
    }

    //from list seeing card depending on index
    public Card getHandCard(int index){
        return inHand.get(index);
    }

    // no cards
    public void clearHand(){
        inHand.clear();
    }

    // drawing from stack and adding to Hand and showing
    public Card addgetCardToHand(){
        Card card = stack.drawCard();
        inHand.add(card);
        return card;
    }

    public void addCardToHand(){
        inHand.add(stack.drawCard());
    }

    // counting the value of cards in hand
    public int sumOfCards(){
        int sum = 0;
        for(int i=0; i<inHand.size();i++){
            Card card = inHand.get(i);
            sum = sum + card.getValue();
        }
        return sum;
    }



    public void aceLogic() {
        //reset the value of all aces to 11
        for (Card card : inHand) {
            if (card.getName() == "A") {
                card.setValue(11);
            }
        }

        //iterate inHand and change the value of any ace so the handValue is not over 21
        int handValue = sumOfCards();
        for (Card card : inHand) {
            if (card.getName() == "A" && handValue > 21) {
                card.setValue(1);
                handValue = sumOfCards();
            }
        }
    }


    @Override
    public String toString(){
         StringBuilder returnString = new StringBuilder();
        for(int i = 0; i < inHand.size(); i++){
            returnString.append(inHand.get(i));
            //if(i < inHand.size() - 1) {
            //    returnString.append(", ");
            //}
        }
        return "Your current hand is:\n"+ returnString;
    }

}
