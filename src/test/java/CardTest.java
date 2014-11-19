import customdecks.CompleteDeck;
import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertNotEquals(CompleteDeck.aceOfClubs, CompleteDeck.jackOfClubs);
        Assert.assertNotEquals(CompleteDeck.jackOfDiamonds, CompleteDeck.jackOfClubs);
        Assert.assertNotEquals(CompleteDeck.jackOfHearts, CompleteDeck.jackOfClubs);
        Assert.assertNotEquals(CompleteDeck.jackOfSpades, CompleteDeck.jackOfClubs);

        Assert.assertEquals(CompleteDeck.fiveOfClubs, CompleteDeck.fiveOfClubs);
        Assert.assertEquals(CompleteDeck.fiveOfHearts, CompleteDeck.fiveOfHearts);
        Assert.assertEquals(CompleteDeck.fiveOfSpades, CompleteDeck.fiveOfSpades);
        Assert.assertEquals(CompleteDeck.fiveOfDiamonds, CompleteDeck.fiveOfDiamonds);
    }
}
