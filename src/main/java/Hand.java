import java.util.ArrayList;
import java.util.List;

/*** Created by zaclee on 10/6/16. ***/
public class Hand {

    boolean bust = false;
    int value = 0;
    List<Card> hand = new ArrayList<Card>();


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isBust() {
        return bust;
    }

    public void setBust(boolean bust) {
        this.bust = bust;
    }
}
