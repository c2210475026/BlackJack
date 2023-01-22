package at.ac.fhcampuswien;

public abstract class Person {
    private String name;
    private Hand currentHand;

    public Person(){
        name ="";
        currentHand = null;
    }

    public Person(String name, Stack stack){
        this.name = name;
        this.currentHand = new Hand(stack);
    }
    public String getName(){
        return name;
    }

    public Hand getCurrentHand(){
        return currentHand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentHand(Hand currentHand) {
        this.currentHand = currentHand;
    }

    // if value of current hand is over 21 a person lost
    public boolean isBusted(){

        if (currentHand.sumOfCards() > 21){
            return true;
        }
        return false;
    }

    // adding a card to hand
    public void hit(){
        getCurrentHand().addgetCardToHand();
    }

    // checking if a person has exactly the value 21.
    public boolean checkIfBlackJack(){
        if(getCurrentHand().sumOfCards()==21 && getCurrentHand().getInHand().size() == 2){
            return true;
        }
        else return false;
    }

    }//end of class)
