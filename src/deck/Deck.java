// This class represents a deck of cards. Methods are included to load the deck, shuffle the deck, or deal a card

package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() { // when constructor is called, fill deck with 52 sorted cards
        loadDeck();
    }

    public Card dealCard() { // deal one card from the top of the deck
        return deck.remove(0);
    }

    public void shuffleDeck() {
        Random random = new Random();

        for (int i = 0; i < deck.size() - 1; i++) {

            // each loop uses a random from (i + 1) to 51
            int targetIndex = random.nextInt(deck.size() - 1 - i) + (i + 1); // i is subtracted to avoid index out of bounds error

            Collections.swap(deck, i, targetIndex);
        }
    }

    public void loadDeck() { // load deck with 52 sorted cards
        deck.clear();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
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
