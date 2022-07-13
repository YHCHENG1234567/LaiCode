package BlackJack;

public class HostPlayer extends Player{
    //子类field 默认继承全部父类field
    private int popularity;
    public HostPlayer(String name){
        super(name);
    }
    public HostPlayer(String name, int popularity){
        super(name);
        this.popularity = popularity;
    }

    @Override
    public Action decideAction(Deck d){
        if(score() <= 16){
            hit(d);
            return Action.Hit;
        } else {
            stand();
            return Action.Stand;
        }
    }
}

//    public MountainBike(int gear, int speed,
//                        int startHeight)
//    {
//        // invoking base-class(Bicycle) constructor
//        super(gear, speed);
//    }
