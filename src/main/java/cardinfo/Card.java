package cardinfo;

import java.lang.String;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zak on 11/17/14.
 */
public class Card implements Comparable<Card>  {
    public static final Logger log = LoggerFactory.getLogger(Card.class);

    /**
     * The card's suit. HEARTS/SPADES/DIAMONDS/CLUBS
     */
    private final Suit mSuit;

    /**
     * The card's suit. ACE/TWO/THREE/FOUR..../JACK/QUEEN/KING
     */
    private final Value mValue;

    /**
     * @param value The card's mSuit. ACE/TWO/THREE/FOUR..../JACK/QUEEN/KING
     * @param suit The card's mSuit. HEARTS/SPADES/DIAMONDS/CLUBS
     */
    public Card(Value value, Suit suit) {
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
     * In case you want to get the name of a card in a non-static context. Called by cardinfo.Card.java's toString() method
     * @param card the cardinfo.Card object you want to get a string name for
     * @return ex: 'Jack of Clubs'
     */
    private String getName(Card card){
        return card.mValue + " of " + card.mSuit;
    }

    public Suit getmSuit() {
        return mSuit;
    }

    public Value getmValue() {
        return mValue;
    }

    /**
     * Compares the original card (this instance) to a second card.
     * @param o the second card being compared
     * @return 1 if the original card is greater. -1 if the original card is less, 0 if the original card and second card are equal
     */
    @Override
    public int compareTo(Card o) {
        int o1 = this.mValue.getValue();
        int o2 = o.mValue.getValue();
        if (o1 > o2 )
            return 1;
        else if (o1 < o2)
            return -1;
        else //numbers are equal
            return 0;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Card)) return false;

        Card otherCard = (Card) other;
        if (this.mSuit.equals(otherCard.mSuit) &&
                this.mValue.equals(otherCard.mValue))
            return true;
        else
            return false;
    }
}
