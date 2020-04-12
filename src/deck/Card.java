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
