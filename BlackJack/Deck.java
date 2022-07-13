package BlackJack;

import java.util.*;

public class Deck {
    private List<Card> cards;
    Deck(){
        cards = new ArrayList<>();
        for(int i = 1; i<=13; i++){
            for(Suit s: Suit.values()){
                cards.add(new Card(s, i));
            }
        }
    }

    Card dealCard(){
        return cards.remove(cards.size()-1);
    }

    int deckSize(){
        return cards.size();
    }

    void shuffle(){
        int size = cards.size();
        for(int i = 0; i<size; i++){
            int j = (int) (size * Math.random());
            Card a = cards.get(i);
            Card b = cards.get(j);
            cards.set(i, b);
            cards.set(j, a);
        }
    }
}
