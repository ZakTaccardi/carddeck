package cardinfo;

import customdecks.CardDeck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.IllegalStateException;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Represents a card 'cardinfo.Deck' that can deal its cards and shuffle itself.
 * Created by Zak on 11/17/14.
 */
public class Deck {
    public static final Logger log = LoggerFactory.getLogger(Deck.class);
    /**
     * Stack data object to represent the cards in a deck
     */
    private Stack<Card> deck = new Stack<Card>();

    /**
     * Constructs a new deck with every combination of Suits/cardinfo.Value enums. This deck is not shuffled,
     * and the cards are in ordered by suit, then value, based on the order the enums are declared.
     */
    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                deck.push(
                        new Card(value, suit)
                );
            }
        }
    }

    /**
     * Constructs a new deck with a provided list of Cards.
     * @param cards a list of cards
     * @throws IllegalArgumentException when list of cards is null
     */
    public Deck(List<Card> cards) throws IllegalArgumentException {
        constructDeckFromList(cards);
    }

    /**
     * Constructs a new deck with a provided list of Cards.
     * @param cardDeck a class that implements the CardDeck interface. By default, this interface will add all the
     *                 card fields of the class
     * @throws IllegalArgumentException when list of cards is null
     */
    public Deck(CardDeck cardDeck) throws IllegalArgumentException {
        constructDeckFromList(
                cardDeck.getCardList()
        );
    }

    /**
     *
     * @param cards
     */
    private void constructDeckFromList(List<Card> cards){
        if (cards != null)
            for(Card card : cards)
                deck.push(card);
        else
            throw new IllegalArgumentException("Null list was used to try and construct this deck");

    }
    /**
     * Randomly permutes the cards in the deck.
     */
    public void shuffle(){
        Random rand = new Random();
        for (int i = deck.size() - 1; i > 0; i--){
            //randomly generate K
            int k = rand.nextInt(i + 1);
            //swap card at index 'k' with card at index 'i'
            Card x = deck.get(k);
            deck.set(k, deck.get(i));
            deck.set(i, x);
        }
    }

    /**
     * This function should return one card from the deck to the caller. Specifically, a call to shuffle followed by 52
     * calls to dealOneCard() should result in the caller being provided all 52 cards of the deck in a random
     * order. If the caller then makes a 53rd call dealOneCard(), no card is dealt (and an exception is thrown).
     * @return a card from the top of the deck
     * @throws IllegalStateException when the deck is empty
     */
    public Card dealOneCard() throws IllegalStateException {
        if (deck != null && deck.size() !=0) {
            Card dealtCard = deck.pop();
            log.info("dealt card: " + dealtCard);
            return dealtCard;
        }
        else
            throw new IllegalStateException("The deck is empty");
    }

    /**
     * Deals all the remaining cards in the deck.
     */
    public void dealAllCards(){
        while(deck.size() != 0){
            dealOneCard();
        }
    }

    /**
     * Getter for the deck
     * @return the stack data type object representing the deck
     */
    public Stack<Card> getDeck() {
        return deck;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Deck)) return false;
        Stack<Card> otherDeck = ((Deck) other).getDeck();

        int i = 0;
        for (Card otherCard : otherDeck){
            Card thisCard = this.deck.get(i);
            if (!thisCard.equals(otherCard))
                return false; //at least one of the cards is not equal ot the other deck's card at the same position
            i++;
        }
        return true;
    }
}
