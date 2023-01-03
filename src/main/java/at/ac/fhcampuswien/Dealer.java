package at.ac.fhcampuswien;

import java.util.Random;

public class Dealer extends Person {

    private String[] nameOfDealers = {"Doyle Brunson", "Daniel Negreanu", "Dave Ulliott", "Michael Mizrachi", "Chris Ferguson"};

    Random random = new Random();
    int index = random.nextInt(nameOfDealers.length)-1;


    public Dealer(Hand currentHand){
        super.setName(nameOfDealers[index]);
        super.setCurrentHand(currentHand);
    }

    @Override
    public boolean checkIfBlackJack(){
        if(getCurrentHand().sumOfCards()==21){
            System.out.println("Dealer" + "(" + getName() +") has BlackJack!");

            return true;
        }
        else return false;
    }

    public void firstHand(){
        System.out.println("Dealer hand is : " + getCurrentHand().getHandCard(0) + " and [HIDDEN]");
    }



}//end of class
