// This class represents blackjack player. Player money is held in this class, as well as if player is dealer

package players;

public class Player {
    private Hand hand;
    private int money;
    private boolean dealer;

    public Player() {
        money = 50;
        dealer = false;
        hand = new Hand();
    }

    public Player(boolean dealer) {
        money = 200;
        dealer = true;
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void printHand() {
        hand.printHand();
    }

    public boolean isDealer() {
        return dealer;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void decrementMoney() {
        this.money--;
    }

    public void incrementMoney() {
        this.money++;
    }
}
