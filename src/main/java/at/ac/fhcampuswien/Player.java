package at.ac.fhcampuswien;

import java.util.Scanner;

public class Player extends Person {

    Scanner sc = new Scanner(System.in);


    public Player(String name, Hand currentHand) {
        super(name,currentHand);
    }
    public void hit(){
        getCurrentHand().addgetCardToHand();
    }

    public void decideMove(){
        System.out.println("Enter (h) for hit or (s) for stay");

        String in = sc.next().toLowerCase();

        char ch = in.charAt(0);


        while (ch != 'h' && ch != 's'){
            System.out.println("Wrong Input, try again.");
            System.out.println("Enter (h) for hit or (s) for stay");

            in= sc.next();

            ch = in.charAt(0);

            if (ch == 'h'){
                System.out.println( getName() + " decided to hit");
                hit();
            }else {
                System.out.println( getName() + " decided to stay");
            }
        }
    }




}//end of class

