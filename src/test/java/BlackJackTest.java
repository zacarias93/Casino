import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zaclee on 10/3/16.
 */
public class BlackJackTest {
//
//
//    BlackJack blackJack;
//    Player player;
//    Deck deck;
//    Card ace;
//    Card ace2;
//    Card ace3;
//    Card two;
//    Card three;
//    Card four;
//    Card five;
//    Card six;
//    Card seven;
//    Card eight;
//    Card nine;
//    Card ten;
//    Card jack;
//    Card queen;
//    Card king;
//    boolean playerStand;
//    boolean dealerStand;
//
//    @Before
//    public void setUpTest() {
//        blackJack = new BlackJack();
//        player = new Player();
//        deck = new Deck();
//        blackJack.dealerHand = new Hand();
//        playerStand = false;
//        dealerStand = false;
//        ace = new Card(1,1);
//        ace2 = new Card(1,2);
//        ace3 = new Card(1,3);
//        two = new Card(2,1);
//        three = new Card(3,1);
//        four = new Card(4,1);
//        five = new Card(5,1);
//        six = new Card(6,1);
//        seven = new Card(7,1);
//        eight = new Card(8,1);
//        nine = new Card(9,1);
//        ten = new Card(10,1);
//        jack = new Card(11,1);
//        queen = new Card(12,1);
//        king = new Card(13,1);
//    }
//
//    @Test
//    public void showHandTest() {
//        blackJack.dealerHand.cards.add(deck.dealOneCard());
//        player.hand.cards.add(deck.dealOneCard());
//        player.hand.cards.add(deck.dealOneCard());
//        blackJack.showHandStatus(player);
//        System.out.println("Dealer should have one card - Player has two");
//    }
//
//    @Test
//    public void getHandValue() {
//        blackJack.player.hand.cards.add(ace);
//        blackJack.player.hand.cards.add(ace2);
//        blackJack.player.hand.cards.add(nine);
//        blackJack.player.hand.cards.add(six);
//        blackJack.showHandStatus(player);
//        System.out.println("Result should be 17");
//    }
//
//    @Test
//    public void playerWinTest() {
//        blackJack.dealerHand.cards.add(king);
//        blackJack.dealerHand.cards.add(seven);
//        blackJack.player.hand.cards.add(ace);
//        blackJack.player.hand.cards.add(eight);
//        blackJack.showHandStatus(player);
//        Assert.assertEquals("check ace works",true,blackJack.playerWin(player));
//    }
//
//    @Test
//    public void checkBustDealerTest() {
//        blackJack.dealerHand.cards.add(king);
//        blackJack.dealerHand.cards.add(seven);
//        blackJack.dealerHand.cards.add(five);
//        blackJack.checkBust(blackJack.dealerHand);
//        Assert.assertEquals("dealerHand should bust", true, blackJack.dealerHand.bust);
//    }
//
//    @Test
//    public void checkPlayerBustTest() {
//        blackJack.player.hand.cards.add(king);
//        blackJack.player.hand.cards.add(seven);
//        blackJack.player.hand.cards.add(five);
//        blackJack.checkBust(blackJack.player.hand);
//        Assert.assertEquals("dealerHand should bust", true, blackJack.player.hand.cards);
//    }
//
//    @Test
//    public void playerWinTest1() {
//        blackJack.dealerHand.cards.add(king);
//        blackJack.dealerHand.cards.add(seven);
//        blackJack.dealerHand.cards.add(five);
//        blackJack.player.hand.cards.add(ace);
//        blackJack.player.hand.cards.add(eight);
//        blackJack.showHandStatus(player);
//        blackJack.checkBust(blackJack.dealerHand);
//        blackJack.checkBust(blackJack.player.hand);
//        Assert.assertEquals("player should win - dealerHand bust - 22/19",true,blackJack.playerWin(player));
//    }
//
//    @Test
//    public void playerWinTest2() {
//        blackJack.dealerHand.cards.add(king);
//        blackJack.dealerHand.cards.add(ace);
//        blackJack.dealerHand.cards.add(four);
//        player.hand.cards.add(ace);
//        player.hand.cards.add(eight);
//        player.hand.cards.add(ace);
//        player.hand.cards.add(ace);
//        player.hand.cards.add(king);
//        blackJack.showHandStatus();
//        blackJack.checkBust(blackJack.dealerHand);
//        blackJack.checkBust(blackJack.player.hand);
//        Assert.assertEquals("player should win - checking aces work - 15/21",true,blackJack.playerWin(player));
//    }
//
//    @Test
//    public void playerWinTest3() {
//        blackJack.dealerHand.cards.add(king);
//        blackJack.dealerHand.cards.add(ace);
//        blackJack.player.hand.cards.add(ace);
//        blackJack.player.hand.cards.add(king);
//        blackJack.showHandStatus();
//        blackJack.checkBust(blackJack.dealerHand);
//        blackJack.checkBust(player.hand);
//        Assert.assertEquals("Dealer should win a tie - 21/21",false,blackJack.playerWin(player));
//    }
//
//
//



}
