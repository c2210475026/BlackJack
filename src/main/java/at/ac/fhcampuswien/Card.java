package at.ac.fhcampuswien;

public class Card {
    //VARIABLES
    private int value;
    private char symbol;

    private String name;

    //CONSTRUCTOR
    public Card(int value,char symbol, String name){
        this.value=value;
        this.symbol=symbol;
        this.name=name;
    }


    //GETTER AND SETTER
    public int getValue(){
        return value;
    }

    public String getName() {
        return name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // NOT USED
    public char getSymbol(){

        return symbol;
    }

    // CASE SWITCH FOR SYMBOLS
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
        //return name +" Of "+cardName + " : " + value;
        String outputSmallNumber = ".-------."+ "\n"+
                "| %1s    |"+ "\n"+
                "|       |"+ "\n"+
                "|  %2s   |"+ "\n"+
                "|       |"+ "\n"+
                "|    %1s |"+ "\n"+
                "'-------'"+ "\n";

        String outputBigNumber = ".-------."+ "\n"+
                "| %1s    |"+ "\n"+
                "|       |"+ "\n"+
                "|  %2s   |"+ "\n"+
                "|       |"+ "\n"+
                "|    %1s |"+ "\n"+
                "'-------'"+ "\n";
        if (value <10){
            return String.format(outputSmallNumber,cardName,value,cardName);
        }else{
            return String.format(outputBigNumber,cardName,value,cardName);
        }
    }
}


