package game;

import deck.Deck;
import players.Player;

public class GameRules {

    private Player p;
    private Player d;

    public GameRules() {
        this.p = new Player();
        this.d = new Player(true);
    }

    public static boolean gameOver(Player p, Player d, Deck deck) {
        if(p.getMoney() <= 0 || d.getMoney() <= 0 || deck.remainingCards() < 4) {
            return true;
        }
        return false;
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public Player getD() {
        return d;
    }

    public void setD(Player d) {
        this.d = d;
    }
}
