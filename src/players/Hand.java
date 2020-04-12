package players;

import deck.Card;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<>();
    private int numberOfCards;

    public Hand() {
        this.numberOfCards = 0;
    }

    public int getHandVal() {
        int handVal = 0;
        for (Card c : hand) {
            //System.out.println(handVal);
            if (c.isAce() && (handVal + 11) > 21) {
                handVal += 1;
                continue;
            } else {
                handVal += c.getRankValue();
            }
        }

        return handVal;
    }

    public void addToHand(Card c) {
        hand.add(c);
        this.numberOfCards++;
    }

    public void clearHand() {
        hand.clear();
    }

    public void printHand() {

        for(Card c : hand) {
            System.out.print(c.getRankName() + " of " + c.getSuit().getName());
            System.out.println();
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public boolean isBust(int handVal) {
        if (handVal > 21) {
            return true;
        }
        return false;
    }

    public boolean isBlackjack() {
        if ( (hand.get(0).getRankName().equals("ace") && (hand.get(1).getRankValue() == 10)) ||
                (hand.get(0).getRankValue() == 10 && (hand.get(1).getRankName().equals("ace")))) {
            return true;
        }
        return false;
    }
}
