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
                        nCard = new Card(11,currentSymbol);
                    }else{
                        nCard = new Card(cardValue,currentSymbol);
                    }
                    stapelList.add(nCard);
                }
                for(int countHighCardNumbers = 1; countHighCardNumbers <= 4; countHighCardNumbers++){
                    Card hCards = new Card(10,currentSymbol);
                    stapelList.add(hCards);
                }
            }
        }
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
        int randomInt = random.nextInt(52)-1;
        Card card = getStapelCard(randomInt);
        deleteStapelCard(randomInt);
        return card;
    }
}
