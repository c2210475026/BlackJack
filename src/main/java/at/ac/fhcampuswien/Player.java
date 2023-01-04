package at.ac.fhcampuswien;

import java.util.Scanner;

public class Player extends Person {

    private int coins;

    Scanner sc = new Scanner(System.in);


    public Player(String name, Hand currentHand) {
        super(name,currentHand);
    }




    public void decideMove(){

        while (!isBusted()){

            System.out.println("Enter (h) for hit or (s) for stay");

            String in = sc.next().toLowerCase();

            if (in.equals("h")){
                System.out.println( getName() + " decided to hit");
                hit();
                getCurrentHand().aceLogic();
                System.out.println(getCurrentHand());
                System.out.println(getName() +"s hand has the total value of "+getCurrentHand().sumOfCards());

            }else if(in.equals("s")) {
                System.out.println( getName() + " decided to stay");
                getCurrentHand().aceLogic();
                System.out.println(getCurrentHand());
                System.out.println(getName() +"s hand has the total value of "+getCurrentHand().sumOfCards());
                break;
            }else {
                System.out.println("Wrong Input, try again.");
            }
        }
    }//end of decideMove

}//end of class

