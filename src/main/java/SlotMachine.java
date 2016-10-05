/**
 * Created by zaclee on 10/1/16.
 */
public class SlotMachine {

    int num1;
    int num2;
    int num3;
    private boolean power = true;
    private boolean eligbleToPlay = false;
    SlotMachineDisplay slotMachineDisplay = new SlotMachineDisplay();
    UserInput userInput = new UserInput();

    public void setNumbers() {
        num1 = (int) Math.ceil(Math.random()*9);
        num2 = (int) Math.ceil(Math.random()*9);
        num3 = (int) Math.ceil(Math.random()*9);
    }

    void run(Player player) {
        slotMachineDisplay.welcomeScreen();
        power = true;

        while(power) {
            if(!playerHasMoney(player)){
                slotMachineDisplay.addMoneyMessage();
                power = false;
                return;
            }
            slotMachineDisplay.slotMachineOptions();
            int response = userInput.promptInt();
            switch (response) {
                case 1: play(player);
                    break;
                case 2: power = false;
                    break;
                default:
                    System.out.println("Try another option.");
            }
        }
    }

    void play(Player player) {
        this.setNumbers();
        System.out.println(num1+ " " + num2 + " " + num3);
        if(num1 == num2 && num2 == num3) {
            System.out.println("You win!");
            player.setBalance(player.getBalance()+100);

            System.out.println("Your current balance is: " + player.getBalance());
        }
        else {
            player.setBalance(player.getBalance()-1);
            System.out.println("Better luck next time!");
            System.out.println("your current balance is: " + player.getBalance());
        }
    }

    boolean playerHasMoney(Player player) {
        if(player.getBalance() > 0) {
            eligbleToPlay = true;
            return eligbleToPlay;
        }
        else {
            System.out.println("Sorry you do not have enough to play.");
            eligbleToPlay = false;
            return eligbleToPlay;
        }
    }

}
