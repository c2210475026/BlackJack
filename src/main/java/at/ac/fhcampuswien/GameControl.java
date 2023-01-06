package at.ac.fhcampuswien;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
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
        }else if (!player.isBusted() && !dealer.isBusted()) { //no one busted
            if (playersHandSum > dealersHandSum) {
                System.out.println(player.getName() + " has won! (case 1)");
            } else if (playersHandSum < dealersHandSum){
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
        //player.getCurrentHand().aceLogic();
        System.out.println(player.getCurrentHand());


        System.out.println(player.getName() + "s hand has the total value of " + player.getCurrentHand().sumOfCards());

        //asking player to hit or stay
        player.decideMove();


        //looks at dealers Hand
        dealer.resolveDealerHand();


        //compares the End-Hands of player and dealer nad checks who won
        resolveWinner(this.player, this.dealer);

    }
        public void initializeGame(){
            System.out.println("Welcome to BlackJack!");
            System.out.println("");
            System.out.println("BlackJack rules : ");
            System.out.println("");
            System.out.println("The players get two cards. The Dealer gets two cards as well.");
            System.out.println("One face up and the other face down.");
            System.out.println("Cards 2 through 10 are worth their face value,");
            System.out.println(" and face cards (jack, queen, king) are also worth 10. ");
            System.out.println("An ace's value is 11 unless this would cause the player to bust,");
            System.out.println(  " in which case it is worth 1");
            System.out.println("Blackjack hands are scored by their point total.");
            System.out.println(" The hand with the highest total wins as long as it doesn't exceed 21. ");
            System.out.println("a hand with a higher total than 21 is said to bust. ");
            System.out.println("The goal of each player is to beat the dealer by having the higher, unbusted hand.");
            System.out.println("If the player busts he loses, even if the dealer also busts.");
            System.out.println(" If both the player and the dealer have the same point value, it is called a push, ");
            System.out.println("and neither player nor dealer wins the hand.");
            System.out.println("Each player has an independent game with the dealer,");
            System.out.println(" so it is possible for the dealer to lose to one player,");
            System.out.println(" but still beat the other players in the same round.");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Whats your name?");
            String playername = sc.next();
            Stapel stapel = new Stapel();
            player = new Player(playername,stapel);
            dealer = new Dealer(stapel);
            System.out.println("How much balance do you have?");
            int balance = sc.nextInt();
            player.setBalance(balance);
            System.out.println("LET'S PLAY!!!!");
            System.out.println("Your current Dealer is "+dealer.getName()+".");
        }


    public void oneGame(){
        int balance = player.getBalance();
        int pot = 0;

        initializeGame();

        while(player.getBalance()> 0){
            System.out.println();
            System.out.println("Starting the Round");

            startRound();

            if(player.getBalance() <= 0){
                System.out.println("You have lost all your money");
                break;
            }

            if(player has won){
                balance= player.getBalance() + pot;
            }

        }
    }


}//end of class

