package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stapel {
    private List<Card> stapelList;

    public Stapel(){
        stapelList =new ArrayList<>();
        fillStapel();
    }

    private void fillStapel(){
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
                        nCard = new Card(11,currentSymbol, "Ace");
                    }else{
                        nCard = new Card(cardValue,currentSymbol,decideName(cardValue));
                    }
                    stapelList.add(nCard);
                }
                for(int countHighCardNumbers = 1; countHighCardNumbers <= 4; countHighCardNumbers++){
                    Card hCards = new Card(10,currentSymbol,decideHighName(countHighCardNumbers));
                    stapelList.add(hCards);
                }
            }
        }
    }

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

    private String decideHighName(int value){
        String name;

        switch (value){
            case 1:
                name="Ten";
                break;
            case 2:
                name="Jack";
                break;
            case 3:
                name="Queen";
                break;
            case 4:
                name="King";
                break;
            default:
                return "Error with high value name";
        }
        return name;
    }

    public List<Card> getStapelList() {
        return stapelList;
    }

    public Card getStapelCard(int position){
        return stapelList.get(position);
    }

    public void deleteStapelCard(int position){
        stapelList.remove(position);
    }

    public void deleteStapelCard(Card card){
        stapelList.remove(card);
    }

    public Card drawCard(){
        Random random = new Random();
        int randomInt = random.nextInt(stapelList.size())-1;
        Card card = getStapelCard(randomInt);
        deleteStapelCard(randomInt);
        return card;
    }
}
