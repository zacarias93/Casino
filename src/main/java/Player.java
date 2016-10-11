import java.util.ArrayList;
import java.util.List;

/**
 * Created by zaclee on 10/1/16.
 */
public class Player {

    int balance=0;
    boolean stand = false;
    Hand hand = new Hand();



    public boolean isStand() {
        return stand;
    }

    public void setStand(boolean stand) {
        this.stand = stand;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String addToBalance(int number) throws IllegalArgumentException {

        if(number < 0) {
            throw new IllegalArgumentException("You can only enter positive numbers.");
        }
        this.balance += number;
        String message = "Your balance is now: " + getBalance();
        System.out.println(message);
        return message;
    }
}
