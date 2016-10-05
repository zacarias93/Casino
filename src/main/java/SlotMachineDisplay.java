/**
 * Created by zaclee on 10/1/16.
 */
public class SlotMachineDisplay {

    void welcomeScreen() {
        System.out.println("Welcome to the Slot Machine!");
        System.out.println("Every play is 1$");
        System.out.println("If you get the same number for all 3 you win 100$!");
        System.out.println("May the odds be ever in your favor! \n");
    }

    public void slotMachineOptions() {
        System.out.println("\n1: Play!");
        System.out.println("2: Leave Game");
    }

    public void addMoneyMessage() {
        System.out.println("Please go add more money to your account.");
    }

//    public void displayWinMessage() {
//        String message = "You win! \n Your current balance is: "
//    }

}
