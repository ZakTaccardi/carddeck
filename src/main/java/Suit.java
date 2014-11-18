/**
 * Created by zak on 11/18/14.
 */
public enum Suit {
    HEARTS("Hearts"),
    CLUBS("Clubs"),
    SPADES("Spades"),
    DIAMONDS("Diamonds");

    private final String mText;

    Suit(String text){
        this.mText = text;
    }

    @Override
    public String toString() {
        return this.mText;
    }
}
