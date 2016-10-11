import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*** Created by zaclee on 10/6/16. ***/
public class HandTest {

    BlackJack blackJack;
    Player player;
    Deck deck;
    Card ace;
    Card ace2;
    Card ace3;
    Card two;
    Card three;
    Card four;
    Card five;
    Card six;
    Card seven;
    Card eight;
    Card nine;
    Card ten;
    Card jack;
    Card queen;
    Card king;
    boolean playerStand;
    boolean dealerStand;

    @Before
    public void setUpTest() {
        blackJack = new BlackJack();
        player = new Player();
        deck = new Deck();
        blackJack.dealerHand = new Hand();
        playerStand = false;
        dealerStand = false;
        ace = new Card(1,1);
        ace2 = new Card(1,2);
        ace3 = new Card(1,3);
        two = new Card(2,1);
        three = new Card(3,1);
        four = new Card(4,1);
        five = new Card(5,1);
        six = new Card(6,1);
        seven = new Card(7,1);
        eight = new Card(8,1);
        nine = new Card(9,1);
        ten = new Card(10,1);
        jack = new Card(11,1);
        queen = new Card(12,1);
        king = new Card(13,1);
    }

    @Test
    public void calcHandValueTest() {
        Deck d = new Deck();
        Hand hand = new Hand();
        hand.cards.add(ace);
        hand.cards.add(king);
        Assert.assertEquals("hand value should be 21", 21, hand.calcHandValue());
    }

    @Test
    public void calcHandValueTest2() {
        Deck d = new Deck();
        Hand hand = new Hand();
        hand.cards.add(ace);
        hand.cards.add(king);
        hand.cards.add(ace);
        hand.cards.add(ace);
        hand.cards.add(ace);
        Assert.assertEquals("hand value ", 14, hand.calcHandValue());
    }
}
