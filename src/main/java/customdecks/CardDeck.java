package customdecks;

import cardinfo.Card;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * This interface allows you to create a deck of cards from a pre-determined set of cards by implementing this interface.
 * The deck of cards will be created from all the 'Card' type member variables of the class that implements this method.
 * See cardinfo.CompleteDeck for an example.
 * Created by zak on 11/18/14.
 */
public abstract class CardDeck {
    public List<Card> getCardList(){
        ArrayList<Card> cardList = new ArrayList<Card>();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (Card.class.isAssignableFrom(field.getType())){ //alow subclasses of classes implementing CardDeck too
                try {
                    cardList.add((Card) field.get(this));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return cardList;
    }
}
