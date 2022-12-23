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
        return cardName + " : " + wert;
    }
}
