package cardinfo;

/**
 * Created by zak on 11/18/14.
 */
public enum Suit {
    SPADES("Spades"),
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private final String mText;

    Suit(String text){
        this.mText = text;
    }

    @Override
    public String toString() {
        return this.mText;
    }
}
