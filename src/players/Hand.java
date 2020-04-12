// This class represents a hand of cards in blackjack. The hand is represented using an ArrayList of Card objects

package players;

import deck.Card;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<>();
    private int numberOfCards;

    public Hand() {
        this.numberOfCards = 0;
    }

    // get value of hand
    public int getHandVal() {
        int handVal = 0;
        for (Card c : hand) {
            if (c.isAce() && (handVal + 11) > 21) { // if card is ace and 11 would bust player, ace counts for 1, not 11
                handVal += 1;
                continue;
            } else {
                handVal += c.getRankValue(); // otherwise add value of card to total hand value
            }
        }
        return handVal;
    }

    public void addToHand(Card c) { // add card to hand
        hand.add(c);
        this.numberOfCards++;
    }

    public void clearHand() {
        hand.clear();
    }

    public void printHand() {

        for (Card c : hand) {
            System.out.print(c.getRankName() + " of " + c.getSuit().getName());
            System.out.println();
        }
    }

    public boolean isBust(int handVal) { // check if hand is bust (value over 21)
        if (handVal > 21) {
            return true;
        }
        return false;
    }

    public boolean isBlackjack() { //check for blackjack - whether ace is first or second card in hand
        if ((hand.get(0).getRankName().equals("ace") && (hand.get(1).getRankValue() == 10)) ||
                (hand.get(0).getRankValue() == 10 && (hand.get(1).getRankName().equals("ace")))) {
            return true;
        }
        return false;
    }
}
