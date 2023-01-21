package at.ac.fhcampuswien;

import java.util.LinkedHashMap;
import java.util.Random;

public class Dealer extends Person {

    private String[] nameOfDealers = {"Doyle Brunson", "Daniel Negreanu", "Dave Ulliott", "Michael Mizrachi", "Chris Ferguson"};

    Random random = new Random();
    int index = random.nextInt(nameOfDealers.length);


    public Dealer(Stapel stapel){
        super();
        super.setName(nameOfDealers[index]);
        Hand hand = new Hand(stapel);
        super.setCurrentHand(hand);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void resolveDealerHand(){
        while (getCurrentHand().sumOfCards() < 17){
            System.out.print("Dealer drew Card: ");
            System.out.println(getCurrentHand().addgetCardToHand());
        }
        printFinalHand();
    }


    @Override
    public boolean checkIfBlackJack(){
        if(getCurrentHand().sumOfCards()==21 && getCurrentHand().getInHand().size() == 2){
            System.out.println("Dealer" + "(" + getName() +") has BlackJack!");
            return true;
        }
        else return false;
    }

    public void firstHand(){
        System.out.println("Dealer hand is " + getCurrentHand().getHandCard(0) + " and [HIDDEN]");
    }

    public void printFinalHand(){
        String returnString="";
        for(Card card : getCurrentHand().getInHand()){
            getCurrentHand().aceLogic();
            returnString = returnString + card+", ";
        }
        System.out.println("Dealers current hand is "+ returnString);
        System.out.println("Dealers hand has the total value of "+getCurrentHand().sumOfCards());

    }




}//end of class
