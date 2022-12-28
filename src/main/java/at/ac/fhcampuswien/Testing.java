package at.ac.fhcampuswien;

import java.util.Collections;

public class Testing {
    public static void main(String[] args) {
        Stapel james = new Stapel();
        System.out.println(james.getStapelList().size());
        System.out.println(james.getStapelList());
        Hand jamesi = new Hand(james);
//
//        System.out.println(james.getStapelList());
//        System.out.println(james.getStapelCard(2));
//        james.deleteStapelCard(0);
//        System.out.println(james.getStapelList());
//
//        System.out.println(jamesi.getInHand());
//        System.out.println(jamesi);
//        System.out.println(jamesi.sumOfCards());


        Player lind = new Player("Lind", jamesi);


        Hand handOfDealer = new Hand(james);
        Dealer dealer1 = new Dealer(handOfDealer);

//        System.out.println("LINE BREAK!!!!!!!!");
//        System.out.println(dealer1.getName());
//        System.out.println(dealer1.getCurrentHand());
//
//        System.out.println(dealer1.getCurrentHand());
//        System.out.println(dealer1.isBusted());
//
//        System.out.println(lind.getCurrentHand());
//
//        System.out.println(lind.getCurrentHand());

//        dealer1.firstHand();

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");

        System.out.println(lind.getCurrentHand());

        lind.decideMove();


        System.out.println(lind.getCurrentHand());

    }
}
