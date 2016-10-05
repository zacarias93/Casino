import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zaclee on 9/28/16.
 */
public class Deck {

    public List<Card> deck;
    private int suit;
    private int cardsUsed;

//    public Map<Integer, Card> deck = new HashMap<Integer, Card>();

    Deck() {
        deck = new ArrayList<Card>();
        for(int suit=0; suit<4; suit++) {
            for(int value = 1; value < 14; value++) {
                deck.add(new Card(value, suit));
            }
        }
    }

    Card dealOneCard() {
        int randomNumber = (int) Math.floor(Math.random()*deck.size()-2);
        return deck.remove(randomNumber);
    }



    //method to get new card from list of 52 cards that generates random number between 0 and size of deck of cards that remain
    //and then repopulate deck at end of hand. (or reshuffle).

}
