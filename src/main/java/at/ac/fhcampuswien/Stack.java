package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stack {
    private List<Card> stackList;

    public Stack(){
        stackList =new ArrayList<>();
        fillStack();
    }

    // filling the stack with 6 decks.
    private void fillStack(){
        for(int decks=0; decks<6;decks++){
            for(int symbolNumbers=0; symbolNumbers<4;symbolNumbers++){
                char currentSymbol;
                if(symbolNumbers==0){
                    currentSymbol='H';
                }else if(symbolNumbers==1){
                    currentSymbol ='C';
                }else if(symbolNumbers==2){
                    currentSymbol='S';
                }else{
                    currentSymbol='D';
                }
                for(int cardValue = 1; cardValue<=9;cardValue++) {
                    Card nCard;
                    if(cardValue==1){
                        nCard = new Card(11,currentSymbol, "A");
                    }else{
                        nCard = new Card(cardValue,currentSymbol,Integer.toString(cardValue));
                    }
                    stackList.add(nCard);
                }
                for(int countHighCardNumbers = 1; countHighCardNumbers <= 4; countHighCardNumbers++){
                    Card hCards = new Card(10,currentSymbol,decideHighName(countHighCardNumbers));
                    stackList.add(hCards);
                }
            }
        }
    }

    // deciding name for number cards except 10.
    private String decideName(int value){
        String name;

        switch(value){
            case 2:
                name="Two";
                break;
            case 3:
                name ="Three";
                break;
            case 4:
                name ="Four";
                break;
            case 5:
                name ="Five";
                break;
            case 6:
                name ="Six";
                break;
            case 7:
                name ="Seven";
                break;
            case 8:
                name ="Eight";
                break;
            case 9:
                name ="Nine";
                break;
            default:
                return "Error with name";
        }
        return name;
    }

    //deciding name for face cards and 10.
    private String decideHighName(int value){
        String name;

        switch (value){
            case 1:
                name="10";
                break;
            case 2:
                name="J";
                break;
            case 3:
                name="Q";
                break;
            case 4:
                name="K";
                break;
            default:
                return "Error with high value name";
        }
        return name;
    }

    public List<Card> getStackList() {
        return stackList;
    }


    // show card at chosen index from list.
    public Card getStapelCard(int position){
        return stackList.get(position);
    }

    //remove card at chosen index from list.
    public void deleteStapelCard(int position){
        stackList.remove(position);
    }

    //same not used
    public void deleteStapelCard(Card card){
        stackList.remove(card);
    }

    //draw random card
    public Card drawCard(){
        Random random = new Random();
        int randomInt = random.nextInt(stackList.size())-1;
        Card card = getStapelCard(randomInt);
        deleteStapelCard(randomInt);
        return card;
    }

    public boolean isStackValid(){
        return stackList.size() >= 156;
    }

    public void reNewStack(){
        stackList.clear();
        fillStack();
    }
}
