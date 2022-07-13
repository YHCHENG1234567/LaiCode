package BlackJack;

public class Card {
    private final Suit suit;
    private final int value;
    private final boolean isFace;

    Card(Suit suit, int value){
        this.suit = suit;
        this.value = value;
        this.isFace = value > 10 ? true : false;
    }

    public int getValue(){
        return value;
    }

    public Suit getSuit(){
        return suit;
    }

    public boolean isAce(){
        return value == 1;
    }

    public boolean isFace(){
        return isFace;
    }

    public String showCard(){
        Character c = null;
        switch(value){
            case 1:
                c = 'A';
                break;
            case 11:
                c = 'J';
                break;
            case 12:
                c = 'Q';
                break;
            case 13:
                c = 'K';
                break;
        }
        if(c!=null){
            return suit + " " + c;
        }
        return suit + " " +value;
    }
}
