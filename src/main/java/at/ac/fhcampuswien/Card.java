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
                cardName = "♠";
                break;
            case 'D':
                cardName = "♦";
                break;
            case 'H':
                cardName = "♥";
                break;
            case 'C':
                cardName = "♣";
                break;
            default:
                return "Card has wrong symbol";
        }
        return name +" Of "+cardName + " : " + wert;
    }
}


