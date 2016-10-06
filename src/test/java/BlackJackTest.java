import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zaclee on 10/3/16.
 */
public class BlackJackTest {


    BlackJack blackJack;
    Player player;
    Card card;
    Deck deck;
    List<Card> dealerHand;
    List<Card> playerHand;
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
    boolean playerBust;
    boolean playerStand;
    boolean dealerBust;
    boolean dealerStand;

    @Before
    public void setUpTest() {
        blackJack = new BlackJack();
        player = new Player();
        deck = new Deck();
        dealerHand = new ArrayList<Card>();
        playerHand = new ArrayList<Card>();
        playerBust = false;
        playerStand = false;
        dealerBust = false;
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
    public void showHandTest() {
        blackJack.dealerHand.add(deck.dealOneCard());
        blackJack.playerHand.add(deck.dealOneCard());
        blackJack.playerHand.add(deck.dealOneCard());
        blackJack.showHandStatus();
        System.out.println("Dealer should have one card - Player has two");
    }

    @Test
    public void getHandValue() {
        blackJack.playerHand.add(ace);
        blackJack.playerHand.add(ace2);
        blackJack.playerHand.add(nine);
        blackJack.playerHand.add(six);
        blackJack.showHandStatus();
        System.out.println("Result should be 17");
    }

    @Test
    public void playerWinTest() {
        blackJack.dealerHand.add(king);
        blackJack.dealerHand.add(seven);
        blackJack.playerHand.add(ace);
        blackJack.playerHand.add(eight);
        blackJack.showHandStatus();
        Assert.assertEquals("check ace works",true,blackJack.playerWin(player));
    }

    @Test
    public void checkBustDealerTest() {
        blackJack.dealerHand.add(king);
        blackJack.dealerHand.add(seven);
        blackJack.dealerHand.add(five);
        blackJack.checkBustDealer(blackJack.dealerHand);
        Assert.assertEquals("dealer should bust", true, blackJack.dealerBust);
    }

    @Test
    public void checkPlayerBustTest() {
        blackJack.playerHand.add(king);
        blackJack.playerHand.add(seven);
        blackJack.playerHand.add(five);
        blackJack.checkBustDealer(blackJack.playerHand);
        Assert.assertEquals("dealer should bust", true, blackJack.playerBust);
    }

    @Test
    public void playerWinTest1() {
        blackJack.dealerHand.add(king);
        blackJack.dealerHand.add(seven);
        blackJack.dealerHand.add(five);
        blackJack.playerHand.add(ace);
        blackJack.playerHand.add(eight);
        blackJack.showHandStatus();
        blackJack.checkBustDealer(blackJack.dealerHand);
        blackJack.checkBustPlayer(blackJack.playerHand);
        Assert.assertEquals("player should win - dealer bust - 22/19",true,blackJack.playerWin(player));
    }

    @Test
    public void playerWinTest2() {
        blackJack.dealerHand.add(king);
        blackJack.dealerHand.add(ace);
        blackJack.dealerHand.add(four);
        blackJack.playerHand.add(ace);
        blackJack.playerHand.add(eight);
        blackJack.playerHand.add(ace);
        blackJack.playerHand.add(ace);
        blackJack.playerHand.add(king);
        blackJack.showHandStatus();
        blackJack.checkBustDealer(blackJack.dealerHand);
        blackJack.checkBustPlayer(blackJack.playerHand);
        Assert.assertEquals("player should win - checking aces work - 15/21",true,blackJack.playerWin(player));
    }

    @Test
    public void playerWinTest3() {
        blackJack.dealerHand.add(king);
        blackJack.dealerHand.add(ace);
        blackJack.playerHand.add(ace);
        blackJack.playerHand.add(king);
        blackJack.showHandStatus();
        blackJack.checkBustDealer(blackJack.dealerHand);
        blackJack.checkBustPlayer(blackJack.playerHand);
        Assert.assertEquals("Dealer should win a tie - 21/21",false,blackJack.playerWin(player));
    }

    @Test
    public void dealInitialHandTest() {
        blackJack.dealInitialHand();
        Assert.assertEquals("dealer should have one card", 1, blackJack.dealerHand.size());
    }

    @Test
    public void dealInitialHandTest2() {
        blackJack.dealInitialHand();
        Assert.assertEquals("player should have two cards", 2, blackJack.playerHand.size());
    }





}
