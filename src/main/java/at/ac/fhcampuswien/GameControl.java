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


    public Person resolveWinner(Player player, Dealer dealer){

        int playersHandSum = player.getCurrentHand().sumOfCards();

        int dealersHandSum = dealer.getCurrentHand().sumOfCards();

        if (playersHandSum > dealersHandSum){
            return player;
        }else if (playersHandSum < dealersHandSum){
            return dealer;
        }else {
            throw new RuntimeException("It's a Tie");
        }
    }


    public void playRound(){

        //Output the Cards of the Persons
        System.out.println(player.getCurrentHand());
        dealer.firstHand();

        if (dealer.checkIfBlackJack() || player.checkIfBlackJack()){

        }




    }



}//end of class

