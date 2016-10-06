import java.util.ArrayList;
import java.util.List;

public class BlackJack {

    BlackJackDisplay blackJackDisplay = new BlackJackDisplay();
    UserInput userInput = new UserInput();

    private boolean power = true;
    private boolean eligbleToPlay = false;
    boolean playerBust;
    boolean playerStand;
    boolean dealerBust;
    boolean dealerStand;
    private int pot = 0;
    int dealerHandValue = 0;
    int playerHandValue = 0;
    Player player = new Player();
    Hand dealer = new Hand();

    List<Card> dealerHand = new ArrayList<Card>();
    List<Card> playerHand = new ArrayList<Card>();

    Deck deck;

    void run(Player player) {
        blackJackDisplay.welcomeScreen();
        power = true;
        while(power) {
            if(!playerHasMoney(player)){
                power = false;
                return;
            }
            blackJackDisplay.menuScreen();
            int response = userInput.promptInt();
            switch (response) {
                case 1: playBlackJack(player);
                    break;
                case 2: showCurrentBalance(player);
                    break;
                case 3: power = false;
                    break;
                default:
                    System.out.println("Please select one of the options.");
            }
        }
    }

    void playBlackJack(Player player) {
        initializeRound();
        makeBet(player);
        dealInitialHand();
        showHandStatus();
        while (!playerStand && !playerBust) {
            hitOrStand();
            checkBustPlayer(playerHand);
            showHandStatus();
        }
        dealerLogic();
        playerWin(player);
        showResult();
        showCurrentBalance(player);
    }

    void initializeRound() {
        deck = new Deck();
        dealerHand = new ArrayList<Card>();
        playerHand = new ArrayList<Card>();
        playerBust = false;
        playerStand = false;
        dealerBust = false;
        dealerStand = false;
        player = new Player();
        dealer = new Hand();
    }

    void dealerLogic() {
        while(!dealerStand && !dealerBust) {
            if(getHandValue(dealerHand) < 17) {
                Card card = deck.dealOneCard();
                dealerHand.add(card);
                System.out.println("Dealer was dealt: " + card.getCardName() + "\nTotal: " + getHandValue(dealerHand) + "\n");
            }
            else if(getHandValue(dealerHand) < 22) {
                dealerStand = true;
            }
            else {
                dealerBust = true;
            }
        }
    }

    void showResult() {
//        String message =
        System.out.println("Dealer has: " + getHandValue(dealerHand));
        System.out.println("Player has: " + getHandValue(playerHand));
    }

    boolean playerWin(Player player) {
        dealerHandValue = getHandValue(dealerHand);
        playerHandValue = getHandValue(playerHand);
        if(playerBust == true) {
            System.out.println("You busted!");
            return false;
        }
        else if(dealerBust == true && playerBust == false) {
            player.setBalance(player.getBalance()+pot);
            System.out.println("Dealer busted you win!");
            return true;

        }
//        DEALER WINS ON TIE
//        else if(dealerHandValue == playerHandValue) {
//            player.setBalance(player.getBalance()+pot/2);
//            System.out.println("It was a push.");
//            return false;
//        }
        else if(dealerHandValue < playerHandValue) {
            player.setBalance(player.getBalance()+pot);
            System.out.println("Congrats you won!");
            return true;
        }
        else {
            System.out.println("Better luck next time!");
            return false;
        }
    }

    void makeBet(Player player) {
        System.out.println("How much would you like to bet?");
        System.out.println("Your current balance is: " + player.getBalance());
        int bet = userInput.promptInt();
        if(bet <= player.getBalance() && bet > 0) {
            player.setBalance(player.getBalance()-bet);
            pot = bet * 2;
        }
        else {
            System.out.println("Please enter a number between 0 - " + player.getBalance());
            makeBet(player);
        }
    }

    void dealInitialHand() {
        dealerHand.add(deck.dealOneCard());
        playerHand.add(deck.dealOneCard());
        playerHand.add(deck.dealOneCard());
    }

    void checkBustPlayer(List<Card> hand) { //switch this later to make player hold hand / value to pass player in as para
        if(getHandValue(hand) > 21) { // hand should have its own values : bust / value
            playerBust = true;
        }
    }

    void checkBustDealer(List<Card> hand) {
        if(getHandValue(hand) > 21) {
            dealerBust = true;
        }
    }

    void checkBust(Hand hand) {
        if(hand.getValue() > 21) {
            hand.setBust(true);
        }
    }

    int getHandValue(List<Card> hand) { // if card = 2-10 value = value if JQK = 10 if A = 11
        int handValue = 0;
        for(Card x : hand) {
            handValue += x.getBlackJackValue();
        }
        if(handValue > 21) {
            for(Card x : hand) {
                if(x.getValueAsString().equalsIgnoreCase("ace")){
                    handValue-= 10;
                }
            }
        }
        return handValue;
    }

    void showHandStatus() {
        System.out.println("Dealer has: " + getHandValue(dealerHand));
        for(Card x : dealerHand) {
            System.out.println(x.getCardName());
        }
        System.out.println("\nYou have: " + getHandValue(playerHand));
        for(Card x : playerHand) {
            System.out.println(x.getCardName());
        }
        System.out.println("\n");
    }

    void hitOrStand() {
            blackJackDisplay.gameChoice();
            int choice = userInput.promptInt();
            switch (choice) {
                case 1: playerHand.add(deck.dealOneCard());
                    break;
                case 2: playerStand = true;
                    break;
                default:
                    System.out.println("Please select an option");
            }
    }

    void showCurrentBalance(Player player) {
        System.out.println("Your current balance is: " + player.getBalance() + "\n");
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


