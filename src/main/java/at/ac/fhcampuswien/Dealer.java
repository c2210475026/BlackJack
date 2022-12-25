package at.ac.fhcampuswien;

import java.util.Random;

public class Dealer extends Person {

    private String[] nameOfDealers = {"Doyle Brunson", "Daniel Negreanu", "Dave Ulliott", "Michael Mizrachi", "Chris Ferguson"};

    Random random = new Random();
    int index = random.nextInt(nameOfDealers.length);

    public Dealer(Hand currentHand){
        this.setName(nameOfDealers[index]);
        this.setCurrentHand(currentHand);
    }

    public void showCard(){

    }




}
