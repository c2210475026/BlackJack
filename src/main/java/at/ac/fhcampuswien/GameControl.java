package at.ac.fhcampuswien;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GameControl {

    Scanner sc = new Scanner(System.in);


    //Variables
    private Player player;

    private Dealer dealer;


    //Constructor
    public GameControl() {
        initializeGame();
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
    public int resolveWinner(Player player, Dealer dealer) {
        int playersHandSum = player.getCurrentHand().sumOfCards();
        int dealersHandSum = dealer.getCurrentHand().sumOfCards();


        //tie
        if (playersHandSum == dealersHandSum) {
            System.out.println("It's a Tie");
            return 0;
        }else if (!player.isBusted() && !dealer.isBusted()) { //no one busted
            if (playersHandSum > dealersHandSum) {
               printCongratulation();
                System.out.println(player.getName() + " has won! (case 1)");
                return 1;
            } else if (playersHandSum < dealersHandSum){
                printCongratulation();
                System.out.println("Dealer has won!");
                return -1;
            }
        }
        else if (!player.isBusted() && dealer.isBusted()) { //dealer busted but player did not
            printCongratulation();
            System.out.println(player.getName() + " has won!");
            return 1;
        }
        else if (player.isBusted() && !dealer.isBusted()) { //player busted but dealer did not
            printCongratulation();
            System.out.println("Dealer has won!");
            return -1;
        }
        else if (player.isBusted() && dealer.isBusted()) { //both busted
            if (playersHandSum < dealersHandSum) {
                printCongratulation();
                System.out.println(player.getName() + " has won! ");
                return 1;
            } else {
                printCongratulation();
                System.out.println("Dealer has won!");
                return -1;
            }
        }
        return 999999;
    }//end of resolveWinner


    public int startRound() {

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
        return resolveWinner(this.player, this.dealer);

    }
        public void initializeGame(){
            System.out.println("\033[1m\033[36mWelcome to BlackJack!");
            System.out.println("\033[0m"); //Reset the font to the default
            System.out.println("\033[36mBlackJack rules : ");
            System.out.println("The players get two cards. The Dealer gets two cards as well.");
            System.out.println("One face up and the other face down.");
            System.out.println("Cards 2 through 10 are worth their face value,");
            System.out.println("and face cards (jack, queen, king) are also worth 10. ");
            System.out.println("An ace's value is 11 unless this would cause the player to bust,");
            System.out.println("in which case it is worth 1");
            System.out.println("Blackjack hands are scored by their point total.");
            System.out.println("The hand with the highest total wins as long as it doesn't exceed 21. ");
            System.out.println("a hand with a higher total than 21 is said to bust. ");
            System.out.println("The goal of each player is to beat the dealer by having the higher, unbusted hand.");
            System.out.println("If the player busts he loses, even if the dealer also busts.");
            System.out.println("If both the player and the dealer have the same point value, it is called a push, ");
            System.out.println("and neither player nor dealer wins the hand.");
            System.out.println("Each player has an independent game with the dealer,");
            System.out.println("so it is possible for the dealer to lose to one player,");
            System.out.println("but still beat the other players in the same round.");
            System.out.println("Are you ready?");
            
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
        while(player.getBalance()> 0){
            int balance = player.getBalance();
            System.out.println();
            System.out.println("Starting the Round");
            System.out.println("How much do you wanna bet?");

            int bet = sc.nextInt();

            while(bet > balance){
                    System.out.println("Enter again, bet is higher than balance!");
                    bet = sc.nextInt();
            }

            int winner = startRound();

            switch (winner){
                case 1:
                    balance = balance + bet;
                    break;
                case -1:
                    balance = balance - bet;
                    break;
                case 0:
                    balance = balance;
                    break;
                default:
                    System.out.println("Error: Winner determination");
            }

            player.setBalance(balance);
            System.out.println("Your current balance is: "+ balance);

            if(player.getBalance() <= 0){
                System.out.println("You have lost all your money");
                break;
            }

            System.out.println("Do you wanna quit?[Type: y]");
            String input = sc.next();

            if(input.equals("y")){
                System.out.println("Game over!");
                break;
            }else{
                System.out.println("Game is gonna continue");
            }

        }
    }

    private void printCongratulation(){
        System.out.println("    _   _   _   _   _ ");
        System.out.println("   / \\ / \\ / \\ / \\ / \\");
        System.out.println("  ( C | O | N | G | R )");
        System.out.println("   \\_/ \\_/ \\_/ \\_/ \\_/");
        System.out.println("    A   T   U   L   A");
        System.out.println("    T   I   O   T   I");
        System.out.println("    I   O   N   N   O");
    }

}//end of class

