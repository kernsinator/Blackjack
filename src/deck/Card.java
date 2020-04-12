// This class represents an individual playing card. Suit and rank are stored in Card class. Also in this class are
// methods to check whether card is an ace, and find name and value of individual card.

package deck;

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public boolean isAce() {
        if (rank.getName().equals("ace")) {
            return true;
        }
        return false;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getRankValue() {
        return rank.getValue();
    }

    public String getRankName() {
        return rank.getName();
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        // rank of suit
        return rank.getName() + " of " + suit.getName();
    }
}
