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

    private void printCards(){

        System.out.println(" _____ \n|A    |\n|  ♠  |\n|    A|\n ‾‾‾‾‾ ");
        System.out.println(" _____ \n|A    |\n|  ♦  |\n|    A|\n ‾‾‾‾‾ ");
        System.out.println(" _____ \n|A    |\n|  ♥  |\n|    A|\n ‾‾‾‾‾ ");
        System.out.println(" _____ \n|A    |\n|  ♣  |\n|    A|\n ‾‾‾‾‾ ");
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
        String outputSmallNumber = " _____ \n|%s   |\n|  %s |\n|   %s|\n ‾‾‾‾‾ "+"\n";
          String outputBigNumber = " _____ \n|%s   |\n|  %s |\n|   %s|\n ‾‾‾‾‾ "+"\n";

        if (name.equals("10")){
            return String.format(outputBigNumber,name,cardName,name);
        }else{
            return String.format(outputSmallNumber,name,cardName,name);
        }
    }
}


