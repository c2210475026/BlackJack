package at.ac.fhcampuswien;

public class Player extends Person {

    public Player(String name, Hand currentHand) {
        this.setName(name);
        this.setCurrentHand(currentHand);
    }

    public void hit() {
        getCurrentHand().addgetCardToHand();
    }
}

