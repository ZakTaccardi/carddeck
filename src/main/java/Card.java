import java.lang.Integer;
import java.lang.String;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zak on 11/17/14.
 */
public class Card {
    public static final Logger log = LoggerFactory.getLogger(Card.class);

    public static class Suit {
        public final static int HEARTS = 1;
        public final static int SPADES = 2;
        public final static int DIAMONDS = 3;
        public final static int CLUBS = 4;

        public final static int NUMBER_OF_SUITS = 4;
    }

    public static class Value {
        public final static int ACE = 1;
        public final static int TWO = 2;
        public final static int THREE = 3;
        public final static int FOUR = 4;
        public final static int FIVE = 5;
        public final static int SIX = 6;
        public final static int SEVEN = 7;
        public final static int EIGHT = 8;
        public final static int NINE = 9;
        public final static int TEN = 10;
        public final static int JACK = 11;
        public final static int QUEEN = 12;
        public final static int KING = 13;
    }

    /**
     * The card's mSuit. HEARTS/SPADES/DIAMONDS/CLUBS
     */
    private final int mSuit;
    /**
     * The card's mSuit. ACE/TWO/THREE/FOUR..../JACK/QUEEN/KING
     */
    private final int mValue;


    /**
     * @param value The card's mSuit. ACE/TWO/THREE/FOUR..../JACK/QUEEN/KING
     * @param suit The card's mSuit. HEARTS/SPADES/DIAMONDS/CLUBS
     */
    public Card(int value, int suit) {
        this.mSuit = suit;
        this.mValue = value;
        log.info("Added " + this + " to deck.");
    }

    /**
     * @return The string representation of a card - ex: 'King of Hearts'
     */
    @Override
    public String toString() {
        return getName(this);
    }

    /**
     * Returns a string representation of the cards value (ex- 'Jack', 'Queen', 'Ace', etc)
     * @param value the integer value of the card. Use the static reference Card.Value.* here
     * @return card's value: '1', 'Ace', 'King', '10', etc
     * @throws IllegalStateException occurs when the specified value does not exist
     */
    public static String getValueString(int value) throws IllegalStateException {
        if (value == Card.Value.ACE)
            return "Ace";
        else if (value >= Card.Value.TWO && value <= Card.Value.TEN)
            return Integer.toString(value);
        else if (value == Card.Value.JACK)
            return "Jack";
        else if (value == Card.Value.QUEEN)
            return "Queen";
        else if (value == Card.Value.KING)
            return "King";
        else
            throw new IllegalStateException("Specified suit type of '" + value +"' does not exist!");
    }

    /**
     * Returns a string representation of the cards suit (ex- 'Hearts', 'Clubs', 'Spades', etc)
     * @param suit the suit of the card. Use the static reference Card.SUIT.* here
     * @return card's value: '1', 'Ace', 'King', '10', etc
     * @throws IllegalStateException occurs when the specified suit does not exist
     */
    public static String getSuitString(int suit) throws IllegalStateException {
        if (suit == Card.Suit.HEARTS)
            return "Hearts";
        else if (suit == Card.Suit.SPADES)
            return "Spades";
        else if (suit == Card.Suit.CLUBS)
            return "Clubs";
        else if (suit == Card.Suit.DIAMONDS)
            return "Diamonds";
        else
            throw new IllegalStateException("Specified suit type of '" + suit + "' does not exist!");
    }



    /**
     * In case you want to get the name of a card in a static context. Called by Card.java's toString() method
     * @param card the Card object you want to get a string name for
     * @return ex: 'Jack of Clubs'
     */
    private static String getName(Card card){
        return getValueString(card.getValue()) + " of " + getSuitString(card.getSuit());
    }

    private int getSuit() {
        return mSuit;
    }

    private int getValue() {
        return mValue;
    }

}
