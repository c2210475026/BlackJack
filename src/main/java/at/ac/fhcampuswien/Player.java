package at.ac.fhcampuswien;

import java.util.Scanner;

public class Player extends Person {

    private int coins;

    Scanner sc = new Scanner(System.in);


    public Player(String name, Hand currentHand) {
        super(name,currentHand);
    }

    public void decideMove(){
        System.out.println("Enter (h) for hit or (s) for stay");

        String in = sc.next().toLowerCase();

        while (true){

            if (in.equals("h")){
                System.out.println( getName() + " decided to hit");
                hit();
                break;
            }else if(in.equals("s")) {
                System.out.println( getName() + " decided to stay");
                break;
            }else {
                System.out.println("Wrong Input, try again.");
            }
        }
    }//end of decideMove

}//end of class

