package at.ac.fhcampuswien;

import java.util.List;
import java.util.Scanner;

public class GameControl {

    Scanner sc = new Scanner(System.in);


    //Variables
    private Player player;

    private Dealer dealer;


    //Constructor
    public GameControl(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    //Getter and Setter
    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    //Methods

    //compares card values from each hand
    public void resolveWinner(Player player, Dealer dealer) {
        int playersHandSum = player.getCurrentHand().sumOfCards();
        int dealersHandSum = dealer.getCurrentHand().sumOfCards();


        //tie
        if (playersHandSum == dealersHandSum) {
            System.out.println("It's a Tie");
        }

        //no one busted
        if (!player.isBusted() && !dealer.isBusted()) {
            if (playersHandSum > dealersHandSum) {
                System.out.println(player.getName() + " has won! (case 1)");
            } else {
                System.out.println("Dealer has won! (case 1)");
            }
        }
        else if (!player.isBusted() && dealer.isBusted()) { //dealer busted but player did not
            System.out.println(player.getName() + " has won! (case 2)");
        }
        else if (player.isBusted() && !dealer.isBusted()) { //player busted but dealer did not
            System.out.println("Dealer has won! (case 2)");
        }
        else if (player.isBusted() && dealer.isBusted()) { //both busted
            if (playersHandSum < dealersHandSum) {
                System.out.println(player.getName() + " has won! (case 3)");
            } else {
                System.out.println("Dealer has won! (case 3)");
            }
        }
    }//end of resolveWinner


    public void startRound() {

        boolean beginningOfRound = true;

        //looks if the beginning of the round and clears the hand of player and dealer
        if (beginningOfRound) {
            dealer.getCurrentHand().clearHand();
            player.getCurrentHand().clearHand();
            beginningOfRound = false;
        }


        //dealer draws hand
        dealer.getCurrentHand().drawHand();

        //player draws hand
        player.getCurrentHand().drawHand();


        //show dealers cards, with the hole card (hidden card)
        dealer.firstHand();


        //show the two cards of the player
        player.getCurrentHand().aceLogic();
        System.out.println(player.getCurrentHand());


        System.out.println(player.getName() + "s hand has the total value of " + player.getCurrentHand().sumOfCards());

        //asking player to hit or stay
        player.decideMove();


        //looks at dealers Hand
        dealer.resolveDealerHand();


        //compares the End-Hands of player and dealer nad checks who won
        resolveWinner(this.player, this.dealer);

    }


}//end of class

