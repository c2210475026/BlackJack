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
        System.out.println(jamesi.sumOfCards());


        Player lind = new Player("Lind", jamesi);
        System.out.println(lind.getName());
        System.out.println(lind.getCurrentHand());
        lind.hit();
        System.out.println(lind.getCurrentHand());
        System.out.println(lind.getCurrentHand().sumOfCards());


        Hand handOfDealer = new Hand(james);
        Dealer dealer1 = new Dealer(handOfDealer);

        System.out.println(dealer1.getName());


    }
}
