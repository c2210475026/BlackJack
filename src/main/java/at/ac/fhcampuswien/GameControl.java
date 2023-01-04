package at.ac.fhcampuswien;

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
    public Person resolveWinner(Player player, Dealer dealer) {

        int playersHandSum = player.getCurrentHand().sumOfCards();

        int dealersHandSum = dealer.getCurrentHand().sumOfCards();

        if (playersHandSum > dealersHandSum) {
            System.out.println("Dealer has won!");
            startRound();
            return dealer;
        } else if (playersHandSum < dealersHandSum) {
            System.out.println(player.getName() + " has won!");
            startRound();
            return player;
        } else {
            startRound();
            throw new RuntimeException("It's a Tie");
        }
    }

    //looks if any Person has Blackjack in the beginning
    public void checkBeginningBlackJack() {
        if (dealer.checkIfBlackJack() && player.checkIfBlackJack()) {//if both have Blackjack it's a tie
            System.out.println("Dealer and " + player.getName() + "both have Blackjack");
        } else if (dealer.checkIfBlackJack()) {
            dealer.getCurrentHand(); //Print the hand of the dealer if dealer has Blackjack
            System.out.println("Dealer has Blackjack");
            startRound();//restart
        }

        if (player.checkIfBlackJack()) {
            System.out.println(player.getName() + " has Blackjack ");
            startRound();//restart
        }
    }


    public void startRound() {

        boolean begginingOfRound = true;

        //looks if the beginning of the round and clears the hand of player and dealer
        if (begginingOfRound) {
            dealer.getCurrentHand().clearHand();
            player.getCurrentHand().clearHand();
            begginingOfRound = false;
        }


        //dealer draws hand
        dealer.getCurrentHand().drawHand();

        //player draws hand
        player.getCurrentHand().drawHand();


        //show dealers cards, with the hole card (hidden card)
        dealer.firstHand();

        //show the two cards of the player
        System.out.println(player.getCurrentHand());


        //check for Blackjack
        checkBeginningBlackJack();

        //asking player to hit or stay
        player.decideMove();

        //checks if player is busted after hitting
        if (player.isBusted()) {
            System.out.println(player.getName() + " has busted!");
            startRound();
        }

        //looks at dealers Hand
        dealer.resolveDealerHand();


        //compares the End- Hands of player and dealer nad checks who won
        resolveWinner(this.player, this.dealer);

    }


}//end of class

