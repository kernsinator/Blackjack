package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        loadDeck();
    }

    public Card dealCard() {
        return deck.remove(0);
    }

    public void shuffleDeck() {
        Random random = new Random();

        for(int i = 0; i < deck.size() - 1; i++) {

            // each loop uses a random from (i + 1) to 51
            int targetIndex = random.nextInt(deck.size() -1 - i) + (i + 1); // i is subtracted to avoid index out of bounds error

            //System.out.println(targetIndex);
            Collections.swap(deck, i, targetIndex);
        }
    }

    public void loadDeck() {
        deck.clear();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                Card card = new Card(s, r);
                deck.add(new Card(s, r));
            }
        }
    }

    public void printDeck() {
        for (Card c : deck) {
            System.out.println(c);
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public int remainingCards() {
        return deck.size();
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
}
