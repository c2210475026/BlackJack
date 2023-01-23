package at.ac.fhcampuswien;

import java.util.Scanner;

public class GameControl {

    Scanner sc = new Scanner(System.in);


    //Variables
    private Player player;

    private Dealer dealer;

    private Stack stack;


    //Constructor
    public GameControl() {
        initializeGame();
    }
    //Methods

    //compares card values from each hand
    public int resolveWinner(Player player, Dealer dealer) {
        int playersHandSum = player.getCurrentHand().sumOfCards();
        int dealersHandSum = dealer.getCurrentHand().sumOfCards();

        boolean playerBlackJack = player.checkIfBlackJack();
        boolean dealerBlackjack = dealer.checkIfBlackJack();

        boolean playerBusted = player.isBusted();
        boolean dealerBusted = dealer.isBusted();

        int amountCardsPlayer = player.getCurrentHand().getInHand().size();
        int amountCardsDealer = dealer.getCurrentHand().getInHand().size();


        //check if player or dealer has Blackjack

        // Check for Blackjack
        if (playerBlackJack && !dealerBlackjack) {
            printCongratulation();
            System.out.println(player.getName() + " has BlackJack!");
            return 1;
        } else if (!playerBlackJack && dealerBlackjack) {
            System.out.println("Dealer has BlackJack");
            return -1;
        }

        // Check for tie
        if (playersHandSum == dealersHandSum) {
            if (amountCardsPlayer < amountCardsDealer) {
                printCongratulation();
                System.out.println(player.getName() + " has won!");
                return 1;
            } else if (amountCardsPlayer > amountCardsDealer) {
                System.out.println("Dealer has won!");
                return -1;
            }

            System.out.println("It's a Tie");
            return 0;
        }
        // Check if anyone is busted
        if (playerBusted && !dealerBusted) { // player busted but dealer did not
            System.out.println("Dealer has won!");
            return -1;
        } else if (!playerBusted && dealerBusted) { // dealer busted but player did not
            printCongratulation();
            System.out.println(player.getName() + " has won!");
            return 1;
        } else if (playerBusted && dealerBusted) { // both busted
            System.out.println("Dealer has won!");
            return -1;
        }
        // Neither player nor dealer is busted
        if (playersHandSum > dealersHandSum) {
            printCongratulation();
            System.out.println(player.getName() + " has won!");
            return 1;
        } else {
            System.out.println("Dealer has won!");
            return -1;
        }
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

    // Rules of Black Jack
    public void initializeGame() {
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
        System.out.println("Whats your name?"); // asking name
        String playerName = sc.next();
        stack = new Stack();
        player = new Player(playerName, stack);
        dealer = new Dealer(stack);
        System.out.println("How much balance do you have?");//asking for balance
        String balanceInput = sc.next();
        while (!isGoodNumber(balanceInput)){
            balanceInput = sc.next();
        }
        int balance = Integer.parseInt(balanceInput);
        player.setBalance(balance);
        System.out.println("LET'S PLAY!!!!");
        System.out.println("Your current Dealer is " + dealer.getName() + ".");
    }

    // checkt ob der Input eine Nummer ist die >0 und < max Integer ist
    private boolean isGoodNumber(String input){
        if(input==null || input.equals("")){
            System.out.println("There is no input. Please type something.");
            return false;
        }else {
            try {
                int inputInt = Integer.parseInt(input);
                if(inputInt<=0){
                    System.out.println("Please type a number greater than 0.");
                    return false;
                }else {
                    return true;
                }

            }catch (NumberFormatException e){
                System.out.println("Please put in a Number.");
                System.out.println("It should be above 0 & below max Integer(2147483647).");
                return false;
            }
        }
    }

    //checkt ob die Bet eine korrekte Eingabe bekommen hat, ist korrekt wenn es eine goodNumber ist
    // und die Bet > Balance ist
    private boolean isBetValid(int balance, String betInput){
        if (isGoodNumber(betInput)){
            if (Integer.parseInt(betInput)>balance){
                System.out.println("Bet is higher than Balance. Enter valid Bet!");
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }


    public void oneGame() {
        while (player.getBalance() > 0) {
            int balance = player.getBalance();
            System.out.println();
            System.out.println("Starting the Round");
            System.out.println("How much do you wanna bet?"); // betsize

            String betInput = sc.next();

            // if bet is higher than balance, asking for a new bet, should be lower than balance
            while(!isBetValid(balance,betInput)){
                betInput= sc.next();
            }
            int bet = Integer.parseInt(betInput);

            int winner = startRound();

            // switch case, if the money goes to dealer, player or tie
            switch (winner) {
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
            System.out.println("Your current balance is: " + balance);

            if (player.getBalance() <= 0) {
                System.out.println("You have lost all your money");
                break;
            }

            System.out.println("Do you wanna quit? Type: ['y' for yes, 'n' for no].");
            String input = sc.next();

            while (!input.equals("y") && !input.equals("n")) {
                System.out.println("Please enter 'y' for yes OR 'n' for no");
                input = sc.next();
            }
            if (input.equals("y")) {
                System.out.println("Game over!");
                sc.close();
                break;
            } else {
                System.out.println("Game is gonna continue");
            }
            if(!stack.isStackValid()){
                stack.reNewStack();
            }
        }
    }

    private void printCongratulation() {
        System.out.println("    _   _   _   _   _   _   _   _ ");
        System.out.println("   / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\");
        System.out.println("  ( C | O | N | G | R | A | T | S )");
        System.out.println("   \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/");
        System.out.println("    |   |   |   |   |   |   |   |");
        System.out.println("    |   |   |   |   |   |   |   |");
        System.out.println("    |   |   |   |   |   |   |   |");
    }

}//end of class

