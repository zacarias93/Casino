/**
 * Created by zaclee on 10/1/16.
 */
public class Display {

    UserInput userInput = new UserInput();

    public void homeScreen(){
        System.out.println("Welcome to Zac's Casino!");
    }

    void menuOptions() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1: Deposit Money");
        System.out.println("2: Check Balance");
        System.out.println("3: Play Slot Machine");
        System.out.println("4: Play Black Jack");
    }

    void depositMoneyMessage() {
        System.out.println("How much money would you like to deposit?");
    }

    void displayBalance(int balance) {
        System.out.println("Current balance is: " + balance);
    }

    public void addMoneyMessage() {
        System.out.println("Please go add more money to your account.");
    }



}
