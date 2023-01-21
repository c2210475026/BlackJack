package at.ac.fhcampuswien;

public class Card {
    //VARIABLES
    private int wert;
    private char symbol;

    private String name;

    //CONSTRUCTOR
    public Card(int wert,char symbol, String name){
        this.wert=wert;
        this.symbol=symbol;
        this.name=name;
    }


    //GETTER AND SETTER
    public int getWert(){
        return wert;
    }

    public String getName() {
        return name;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    public char getSymbol(){
        return symbol;
    }

    public String toString(){
        String cardName;
        switch (symbol){
            case 'S':
                cardName = "Spades";
                break;
            case 'D':
                cardName = "Diamonds";
                break;
            case 'H':
                cardName = "Hearts";
                break;
            case 'C':
                cardName = "Clubs";
                break;
            default:
                return "Card have wrong symbol";
        }
        return name +" Of "+cardName + " : " + wert;
    }
}


