import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zaclee on 9/28/16.
 */
public class Deck {

    public List<Card> deck;

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
        int randomNumber = (int) Math.floor(Math.random()*deck.size());
        return deck.remove(randomNumber);
    }
}
