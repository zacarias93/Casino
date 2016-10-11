import java.util.ArrayList;
import java.util.List;

/*** Created by zaclee on 10/6/16. ***/
public class Hand {

    boolean bust = false;
    int handValue = 0;
    List<Card> cards;

    Hand() {
        cards = new ArrayList<Card>();
    }




    int calcHandValue() { // if card = 2-10 value = value if JQK = 10 if A = 11
        this.handValue = 0;
        for(Card x : this.cards) {
            this.handValue += x.getBlackJackValue();
        }
        if(this.handValue > 21) {
            for(Card x : this.cards) {
                if(x.getValueAsString().equalsIgnoreCase("ace")){
                    this.handValue-= 10;
                }
            }
        }
        return this.handValue;
    }


    public int getValue() {
        return handValue;
    }

    public boolean isBust() {
        return bust;
    }

    public void setBust(boolean bust) {
        this.bust = bust;
    }
}
