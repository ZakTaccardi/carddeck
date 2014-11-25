import cardinfo.Card;
import cardinfo.Suit;
import cardinfo.Value;
import customdecks.CompleteDeck;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

/**
 * Test class for the cardinfo.Card class.
 * Created by zak on 11/18/14.
 */
public class CardTest {
    /**
     * Test that the compareTo() method was overridden successfully
     * @throws Exception
     */
    @Test
    public void testComparable() throws Exception {
        assert(CompleteDeck.jackOfClubs.compareTo(CompleteDeck.deuceOfClubs) > 0);
        assert(CompleteDeck.jackOfClubs.compareTo(CompleteDeck.tenOfHearts) > 0);
        assert(CompleteDeck.jackOfClubs.compareTo(CompleteDeck.tenOfSpades) > 0);
        assert(CompleteDeck.jackOfClubs.compareTo(CompleteDeck.tenOfDiamonds) > 0);
        assert(CompleteDeck.jackOfClubs.compareTo(CompleteDeck.jackOfDiamonds) == 0);
        assert(CompleteDeck.jackOfClubs.compareTo(CompleteDeck.jackOfSpades) == 0);
        assert(CompleteDeck.jackOfClubs.compareTo(CompleteDeck.jackOfHearts) == 0);
        assert(CompleteDeck.jackOfClubs.compareTo(CompleteDeck.kingOfClubs) < 0);
        assert(CompleteDeck.jackOfClubs.compareTo(CompleteDeck.kingOfHearts) < 0);
        assert(CompleteDeck.jackOfClubs.compareTo(CompleteDeck.kingOfDiamonds) < 0);
    }

    /**
     * Tests that the equals() method was overridden successfully
     * @throws Exception
     */
    @Test
    public void testEquals() throws Exception {
        //compare cards that do NOT match
        Assert.assertNotEquals(CompleteDeck.aceOfClubs, CompleteDeck.jackOfClubs);
        Assert.assertNotEquals(CompleteDeck.jackOfDiamonds, CompleteDeck.jackOfClubs);
        Assert.assertNotEquals(CompleteDeck.jackOfHearts, CompleteDeck.jackOfClubs);
        Assert.assertNotEquals(CompleteDeck.jackOfSpades, CompleteDeck.jackOfClubs);
        //compare cards that do match
        Assert.assertEquals(CompleteDeck.fiveOfClubs, CompleteDeck.fiveOfClubs);
        Assert.assertEquals(CompleteDeck.fiveOfHearts, CompleteDeck.fiveOfHearts);
        Assert.assertEquals(CompleteDeck.fiveOfSpades, CompleteDeck.fiveOfSpades);
        Assert.assertEquals(CompleteDeck.fiveOfDiamonds, CompleteDeck.fiveOfDiamonds);
    }

    /**
     * Tests that the hashcode() method was overridden successfully.
     * @throws Exception
     */
    @Test
    public void testHashcode() throws Exception {
        //compare the hash of cards that do NOT match
        hashTestMethod(CompleteDeck.aceOfClubs, CompleteDeck.jackOfClubs);
        hashTestMethod(CompleteDeck.jackOfDiamonds, CompleteDeck.jackOfClubs);
        hashTestMethod(CompleteDeck.jackOfHearts, CompleteDeck.jackOfClubs);
        hashTestMethod(CompleteDeck.jackOfSpades, CompleteDeck.jackOfClubs);
        //compare the hash of cards that do match
        hashTestMethod(CompleteDeck.fiveOfClubs, CompleteDeck.fiveOfClubs);
        hashTestMethod(CompleteDeck.fiveOfHearts, CompleteDeck.fiveOfHearts);
        hashTestMethod(CompleteDeck.fiveOfSpades, CompleteDeck.fiveOfSpades);
        hashTestMethod(CompleteDeck.fiveOfDiamonds, CompleteDeck.fiveOfDiamonds);

        //hashMap stores apple type and its quantity
        HashMap<Card, Integer> m = new HashMap<Card, Integer>();
        m.put(CompleteDeck.aceOfClubs, 10);
        m.put(CompleteDeck.jackOfDiamonds, 20);
        Integer n = m.get(new Card(Value.ACE, Suit.CLUBS));
        assert n != null;
    }
    //if a.equals(b), then a.hashCode() must be same as b.hashCode()
    private void hashTestMethod(Card a, Card b){
        if (a.equals(b))
            if (a.hashCode() == b.hashCode())
                assert true;
            else
                assert false;
        else //a != b
            if (a.hashCode() != b.hashCode())
                assert true;
            else
                assert false;
    }
}
