import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for the Deck class.
 * Created by zak on 11/18/14.
 */
public class DeckTest {
    /**
     * Tests that the deck deals one card correctly.
     * @throws Exception
     */
    @Test
    public void testDealOneCard() throws Exception {
        Deck deck = new Deck();
        Card expectedFirstCard = getExpectedTopCardFromFreshDeck();
        Card actualFirstCard = deck.dealOneCard();
        boolean b = expectedFirstCard.equals(actualFirstCard);
        Assert.assertEquals(expectedFirstCard, actualFirstCard);
    }

    /**
     * Tests that all cards can be dealt, and that an exception is thrown when all cards have been dealt
     * @throws Exception
     */
    @Test
    public void testDealAllCards() throws Exception {
        Deck deck = new Deck();
        deck.dealAllCards();
        assert (deck.getDeck().size() == 0); //ensure deck is now empty
    }

    /**
     * Tests that an exception is thrown when all cards have been dealt (deck is empty).
     * @throws Exception
     */
    @Test(expected=IllegalStateException.class)
    public void testDealOneCardWhenDeckEmpty() throws Exception {
        Deck deck = new Deck();
        deck.dealAllCards();
        deck.dealOneCard(); //trigger deck is empty exception
    }

    /**
     * Tests that the deck created is the correct size, based on the number of Card variables in the CompleteDeck.java class
     * @throws Exception
     */
    @Test
    public void testDeckSize() throws Exception {
        Deck deck = new Deck();
        int actualSize = deck.getDeck().size();
        int expectedSize = (CompleteDeck.class.getDeclaredFields()).length;
        assert (actualSize == expectedSize);
    }

    /**
     * Tests that that the equals method is overidden successfully.
     * @throws Exception
     */
    @Test
    public void testEquals() throws Exception {

    }

    /**
     * Tests that the equals method is overridden successfully and that the deck shuffles correctly.
     * While we cannot test for randomness, we can at least check that two equal decks have a different order
     * after shuffling one of them.
     *
     * Note: There is a 1/52! chance that a shuffled deck could be exactly the same as the unshuffled deck.
     * @throws Exception
     */
    @Test
    public void testEqualsAndShuffle() throws Exception {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Assert.assertEquals(deck1, deck2);
        deck2.shuffle();
        Assert.assertNotEquals(deck1, deck2);
    }

    /**
     * Gets the expected card object that would be on top of a fresh deck. This is based on the order the Suit/Value enums
     * were declared in in their respective classes.
     * @return the expected card object that would be on top of a fresh deck.
     */
    private Card getExpectedTopCardFromFreshDeck(){
        /**
         * To add the cards to the deck, we loop the each of the suits,
         * and nested inside there we loop through each of the values to add cards to the deck.
         * So, the top card of a fresh deck will be the last declared enum field for both suit/value enums
         *
         * Note: the associated test method relies on how the deck is logically created, which is an inherent flaw.
         * A better approach to this would be to implement a sort functionality to sort the whole deck, and
         * draw the top card from the sorted deck
         */
        int valueSize = Value.class.getEnumConstants().length;
        int suitSize = Suit.class.getEnumConstants().length;
        Value value = Value.class.getEnumConstants()[valueSize-1];
        Suit suit = Suit.class.getEnumConstants()[suitSize-1];

        return new Card(value, suit);
    }
}
