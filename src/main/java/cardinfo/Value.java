package cardinfo;

/**
 * Created by zak on 11/18/14.
 */
public enum Value {
    DEUCE(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    TEN(10, "Ten"),
    JACK(11, "Jack"),
    QUEEN(12, "Quuen"),
    KING(13, "King"),
    ACE(14, "Ace");

    private final int mValue;
    private final String mText;

    Value(int value, String text) {
        this.mValue = value;
        this.mText = text;
    }

    public int getValue() {
        return mValue;
    }
    public String getText() {
        return mText;
    }

    @Override
    public String toString() {
        return this.mText;
    }
}
