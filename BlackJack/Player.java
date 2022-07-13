package BlackJack;

import java.util.*;

public class Player {
    List<Card> cardInHand;
    String playerName;

    Player(String name){
        cardInHand = new ArrayList<>();
        this.playerName = name;
    }
    public Action decideAction(Deck d){
        int seed = score();
        if(seed <= 11){
            hit(d);
            return Action.Hit;
        }
        double rSeed = Math.random();
        if(rSeed > ((seed - 8)/10)){ //在分数为12~17时 动态决定抽卡概率 12: 60%抽牌，13:50%抽牌..
            hit(d);
            return Action.Hit;
        } else {
            stand();
            return Action.Stand;
        }
    }

    public void hit(Deck d){
        cardInHand.add(d.dealCard());
    }

    public void stand(){}

    public int score(){
        int res = 0;
        int numberOfAce = 0;
        for(int i = 0; i < cardInHand.size(); i++){
            if(cardInHand.get(i).isAce()){
                numberOfAce++;
                continue;
            }
            if(cardInHand.get(i).isFace()){
                res+=10;
            } else {
                res+=cardInHand.get(i).getValue();
            }
        }
        for(int i = 0; i<numberOfAce; i++){
            if(res<=10){
                res+=11;
            } else {
                res++;
            }
        }
        if(res>21){
            return -1;
        }
        if(cardInHand.size() >= 5) {
            return 21 + res;
        }
        return res;
    }

    public boolean isBusted(){
        return score() == -1;
    }

    public boolean isBlackJack(){
        if(cardInHand.size()!=2){
            return false;
        }
        Card a = cardInHand.get(0);
        Card b = cardInHand.get(1);
        return (a.isAce() && b.isFace()) || (b.isAce() && a.isFace());
    }

    public void currentStatus(){
        System.out.println("Current Score: " + score());
        for(Card c: cardInHand){
            System.out.println(c.showCard());
        }
    }
}
