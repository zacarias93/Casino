import org.junit.Before;
import org.junit.Test;

/**
 * Created by zaclee on 10/3/16.
 */
public class BlackJackTest {


    BlackJack blackJack;
    Player player;
    Deck deck;

    @Before
    public void setUpTest() {
        blackJack = new BlackJack();
        player = new Player();
        deck = new Deck();
    }

    @Test
    public void showHandTest() {
        BlackJack blackJack = new BlackJack();
        blackJack.dealerHand.add(deck.dealOneCard());
        blackJack.playerHand.add(deck.dealOneCard());
        blackJack.playerHand.add(deck.dealOneCard());
        blackJack.showHandStatus();
    }


}
