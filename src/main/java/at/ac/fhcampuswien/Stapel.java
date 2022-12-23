package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class Stapel {
    List<Card> stapelList;

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
}
