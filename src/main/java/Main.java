import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.String;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Deck deck = new Deck();
        log.info("Deck size is: " + deck.getDeck().size());
        deck.shuffle();
        log.info("Shuffled the deck!");
        deck.dealAllCards();
        try {
            deck.dealOneCard(); //deal one more card when deck is empty to see the exception
        } catch (IllegalStateException e) {
            log.error("Dealt a card when the deck is empty", e);
        }
    }
}
