package at.ac.fhcampuswien;

public class Card {
    private int wert;
    private char symbol;

    public Card(int wert,char symbol){
        this.wert=wert;
        this.symbol=symbol;
    }

    public int getWert(){
        return wert;
    }

    public char getSymbol(){
        return symbol;
    }
}
