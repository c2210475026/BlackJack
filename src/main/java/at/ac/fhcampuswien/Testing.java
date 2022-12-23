package at.ac.fhcampuswien;

public class Testing {
    public static void main(String[] args) {
        Stapel james = new Stapel();
        Hand jamesi = new Hand(james);

        System.out.println(james.getStapelList());
        System.out.println(james.getStapelCard(2));
        james.deleteStapelCard(0);
        System.out.println(james.getStapelList());

        System.out.println(jamesi.getInHand());
        System.out.println(jamesi);
        jamesi.clearHand();
        System.out.println(jamesi);
        System.out.println(jamesi.addgetCardToHand());
        System.out.println(jamesi);
        System.out.println(jamesi.sumOfCards());
    }
}
