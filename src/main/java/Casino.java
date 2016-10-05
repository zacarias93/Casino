/**
 * Created by zaclee on 10/1/16.
 */
public class Casino { // user interacts here and all calls go to engine
    //engine can launch games
    private boolean power = true;
    Display display = new Display();
    UserInput userInput = new UserInput();
    Player player = new Player();
    SlotMachine slotMachine = new SlotMachine();
    BlackJack blackJack = new BlackJack();

    void run() {

        display.homeScreen();
        while(power) {
            display.menuOptions();
            int mainMenuResponse = userInput.promptInt();

            switch(mainMenuResponse) {
                case 1:
                    display.depositMoneyMessage();
                    int amount = userInput.promptInt();
                    try { player.addToBalance(amount); }
                    catch (Exception e) { System.out.println(e); }
                    break;
                case 2:
                    display.displayBalance(player.getBalance());
                    break;
                case 3: // SLOT MACHINE
                    slotMachine.run(player);
                    break;
                case 4: //BLACK JACK
                     blackJack.run(player);
                    break;
                case 9:
                    power = false;
                    break;

            }
        }
    }
}
