import cardinfo.Card;
import cardinfo.Deck;
import cardinfo.Suit;
import cardinfo.Value;
import customdecks.CompleteDeck;
import customdecks.EmptyDeck;
import org.junit.*;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Test class for the cardinfo.Deck class.
 * Created by zak on 11/18/14.
 */
@RunWith(Theories.class)
public class DeckTest {
    static final int mValueSize = Value.class.getEnumConstants().length;
    static final int mSuitSize = Suit.class.getEnumConstants().length;

    static final List<Card> mCardsFull = new CompleteDeck().getCardList();
    static final List<Card> mCardsEmpty = new EmptyDeck().getCardList();
    /**
     * Use multiple desks to test
     */
    @DataPoints
    public static Deck[] decks() {
        return new Deck[]{
                new Deck(),
                new Deck(new CompleteDeck().getCardList()),
                new Deck(new EmptyDeck().getCardList())
        };
    }

    /**
     * Tests that the deck deals one card correctly with the default deck.
     * @throws Exception
     */
    @Test
    public void testDealOneCardWithDefaultDeck() throws Exception {
        Deck deck = new Deck();
        Card expectedFirstCard = getExpectedTopCardFromFreshDefaultDeck();
        Card actualFirstCard = deck.dealOneCard();
        Assert.assertEquals(expectedFirstCard, actualFirstCard);
    }

    /**
     * Tests that the deck deals one card correctly with a custom deck.
     * @throws Exception
     */
    @Test
    public void testDealOneCardWithCustomDeck() throws Exception {
        List<Card> cards = new CompleteDeck().getCardList();
        Deck customDeck = new Deck(cards);
        Card expectedFirstCard = getExpectedTopCardFromFreshCustomDeck(cards);
        Card actualFirstCard = customDeck.dealOneCard();
        Assert.assertEquals(expectedFirstCard, actualFirstCard);
    }

    /**
     * Tests that all cards can be dealt, and that an exception is thrown when all cards have been dealt
     * @throws Exception
     */
    @Theory
    public void testDealAllCards(Deck deck) throws Exception {
        deck.dealAllCards();
        assert (deck.getDeck().size() == 0); //ensure deck is now empty
    }

    /**
     * Tests that an exception is thrown when all cards have been dealt (deck is empty).
     * @throws Exception
     */
    @Theory
    public void testDealOneCardWhenDeckEmpty(Deck deck) throws Exception {
        deck.dealAllCards();
        try {
            deck.dealOneCard(); //trigger deck is empty exception
            assert false; //deck is empty exception did not occur
        } catch (IllegalStateException e) {
            assert true; //deck is empty exception did occur
        }
    }

    /**
     * Tests that an exception is thrown when a deck is created using a null list
     * @throws Exception
     */
    @Test(expected=IllegalArgumentException.class)
    public void testExceptionWhenNullListIsUsedToCreateCardDeck() throws Exception {
        List<Card> cards= null;
        new Deck(cards);
    }

    /**
     * Tests that the default deck created is the correct size, based on the number possible card values
     * @throws Exception
     */
    @Test
    public void testDeckSizeWithDefaultDeck() throws Exception {
        Deck deck = new Deck();
        int actualSize = deck.getDeck().size();
        int expectedSize = mValueSize * mSuitSize;
        assert (actualSize == expectedSize);
    }

    /**
     * Tests that the custom deck created is the correct size, based on the number of cardinfo.Card
     * variables in the customdecks.CompleteDeck interface
     * @throws Exception
     */
    @Test
    public void testDeckSizeWithCustomDeck() throws Exception {
        Deck deck = new Deck(new CompleteDeck());
        int actualSize = deck.getDeck().size();
        int expectedSize = (CompleteDeck.class.getDeclaredFields()).length;
        assert (actualSize == expectedSize);
    }
    /**
     * Tests that the deck shuffles correctly, and that the equals method was successfully overridden.
     * While we cannot test for randomness, we can at least check that two equal decks have a different order
     * after shuffling one of them.
     *
     * Note: There is a 1/52! chance that a shuffled deck could be exactly the same as the unshuffled deck.
     * @throws Exception
     */
    @Test
    public void testEqualsAndShuffle() throws Exception {
        //TODO improve this method by implementing clonable interface in Deck so we can parameterize
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        assertEqualsAndShuffle(deck1, deck2);

        deck1 = new Deck(mCardsFull);
        deck2 = new Deck(mCardsFull);
        assertEqualsAndShuffle(deck1, deck2);
    }
    static private void assertEqualsAndShuffle(Deck deck1, Deck deck2){
        Assert.assertEquals(deck1, deck2); //check that they're equal before shuffle.
        deck2.shuffle();
        Assert.assertNotEquals(deck1, deck2); //check that they're now no longer equal after shuffling
    }

    /**
     * Tests that a empty deck can be shuffled without error.
     * @throws Exception
     */
    @Test
    public void testEmptyDeckShuffleDeck() throws Exception {
        Deck deck = new Deck(mCardsEmpty);
        deck.shuffle(); //test that empty deck does not throw error
    }

    /**
     * Gets the expected card object that would be on top of a fresh deck. This is based on the order the cardinfo.Suit/cardinfo.Value enums
     * were declared in in their respective classes.
     * @return the expected card object that would be on top of a fresh deck.
     */
    private Card getExpectedTopCardFromFreshDefaultDeck(){
        /**
         * To add the cards to the deck, we loop the each of the suits,
         * and nested inside there we loop through each of the values to add cards to the deck.
         * So, the top card of a fresh deck will be the last declared enum field for both suit/value enums
         *
         * Note: the associated test method relies on how the deck is logically created, which is an inherent flaw.
         * A better approach to this would be to implement a comparator to sort the whole deck, and
         * draw the top card from the sorted deck
         */
        final Value value = Value.class.getEnumConstants()[mValueSize-1];
        final Suit suit = Suit.class.getEnumConstants()[mSuitSize-1];

        return new Card(value, suit);
    }

    /**
     * Gets the expected card object that would be on top of a fresh CUSTOM deck. This is based on the order the cards
     * are declared in the custom deck CardDeck interface.
     * @param cards list of cards in a deck
     * @return the expected card object that would be on top of a fresh deck.
     */
    private Card getExpectedTopCardFromFreshCustomDeck(List<Card> cards){
        return cards.get(cards.size() - 1);
    }
}
