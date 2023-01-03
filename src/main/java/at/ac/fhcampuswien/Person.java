package at.ac.fhcampuswien;

public abstract class Person {
    private String name;
    private Hand currentHand;

    public Person(){

    }

    public Person(String name, Hand currentHand){
        this.name = name;
        this.currentHand = currentHand;
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

    public boolean isBusted(){

        if (currentHand.sumOfCards() > 21){
            return true;
        }
        return false;
    }

    public void hit(){
        getCurrentHand().addgetCardToHand();
    }

    public boolean checkIfBlackJack(){
        if(getCurrentHand().sumOfCards()==21 && getCurrentHand().getInHand().size() == 2){
            System.out.println(name +" has BlackJack!");
            return true;
        }
        else return false;
    }


    }//end of class)
