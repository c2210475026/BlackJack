package at.ac.fhcampuswien;

public abstract class Person {
    private String name;
    private Hand currentHand;

    public Person(){
    }
    public String getName(){
        return name;
    }

    public Hand getCurrentHand(){
        return currentHand;
    }

}
