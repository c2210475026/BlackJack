package at.ac.fhcampuswien;

public abstract class Person {
    private String name;
    private Hand currentHand;

    public Person(){
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
}
