package BlackJack;

public class Main {
    private Deck deck;
    private Player player;
    private Player hostPlayer;

    public Main(){
        this.deck = new Deck();
        this.player = new Player("SongGeGe");
        this.hostPlayer = new HostPlayer("SongGeGe2", 5);
        deck.shuffle();
        player.hit(deck);
        player.hit(deck);
        hostPlayer.hit(deck);
        hostPlayer.hit(deck);
        System.out.println("Game start, initial status:");
        System.out.println("Player's hand: ");
        player.currentStatus();
        System.out.println();
        System.out.println("Host's hand: ");
        hostPlayer.currentStatus();
        System.out.println();
    }

    private void currentStats(){
        System.out.println("Player's hand: ");
        player.currentStatus();
        System.out.println();
        System.out.println("Host's hand: ");
        hostPlayer.currentStatus();
        System.out.println();
    }

    public void gameStart(){
        if(player.isBlackJack() && hostPlayer.isBlackJack()){
            System.out.println("----- Draw -----");
            currentStats();
            return;
        } else if(player.isBlackJack()){
            System.out.println("--- Player Win ---");
            currentStats();
            return;
        } else if(hostPlayer.isBlackJack()){
            System.out.println("--- Host Win ---");
            currentStats();
            return;
        }

        System.out.println("---------- Player Round ----------");
        while(player.decideAction(deck) == Action.Hit){
            if(player.isBusted()) {
                player.currentStatus();
                System.out.println("---------- Host Win ----------");
                return;
            }
        }
        player.currentStatus();

        System.out.println("---------- Host Round ----------");
        while(hostPlayer.decideAction(deck) == Action.Hit){
            if(hostPlayer.isBusted()){
                hostPlayer.currentStatus();
                System.out.println("---------- Player Win ----------");
                return;
            }
        }
        hostPlayer.currentStatus();

        int ps = player.score();
        int hs = hostPlayer.score();
        if(ps == hs){
            System.out.println("---------- Draw ----------");
        } else if(ps > hs) {
            System.out.println("---------- Player Win ----------");
        } else {
            System.out.println("---------- Host Win ----------");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.gameStart();
    }
}