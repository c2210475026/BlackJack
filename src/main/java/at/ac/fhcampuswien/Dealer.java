package at.ac.fhcampuswien;

import java.util.Random;

public class Dealer extends Person {

    private String[] nameOfDealers = {"Doyle Brunson", "Daniel Negreanu", "Dave Ulliott", "Michael Mizrachi", "Chris Ferguson"};

    Random random = new Random();
    int index = random.nextInt(nameOfDealers.length);


    public Dealer(Stack stack){
        super();
        super.setName(nameOfDealers[index]);
        Hand hand = new Hand(stack);
        super.setCurrentHand(hand);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    //If total value of Cards is less than 17, dealer draws a Card.
    public void resolveDealerHand(){
        while (getCurrentHand().sumOfCards() < 17){
            System.out.print("Dealer drew Card: ");
            System.out.println(getCurrentHand().addgetCardToHand());
        }
        printFinalHand();
    }


    //looking if at the start Dealer has Black Jack.
    @Override
    public boolean checkIfBlackJack(){
        if(getCurrentHand().sumOfCards()==21 && getCurrentHand().getInHand().size() == 2){
            return true;
        }
        else return false;
    }

    // Shows first card and second card is hidden.
    public void firstHand(){
        System.out.println("Dealer hand is " + getCurrentHand().getHandCard(0) + " and [HIDDEN]");
    }

    //prints the current hand and total value of the dealer.
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
