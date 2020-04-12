package deck;

public enum Suit {
    HEARTS("hearts"), DIAMONDS("diamonds"), CLUBS("clubs"), SPADES("spades");

    String name;

    Suit(String suitName) {
        name = suitName;
    }

    public String getName() {
        return name;
    }
}
