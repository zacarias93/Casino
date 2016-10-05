import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zaclee on 10/3/16.
 */
public class DeckTest {

    @Test
    public void dealOneCardTest() {
        Deck d = new Deck();
        String expected = d.deck.remove(0).getCardName();
        String actual = d.dealOneCard().getCardName();
        Assert.assertEquals("returns a card", expected,actual);
    }
}
