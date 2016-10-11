import java.util.List;

public class BlackJack {

    BlackJackDisplay blackJackDisplay = new BlackJackDisplay();
    UserInput userInput = new UserInput();

    private boolean power = true;
    private boolean eligbleToPlay = false;
    private boolean dealerStand;
    private int pot = 0;
    Hand dealerHand;
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
        initializeRound(player);
        makeBet(player);
        dealInitialHand(player);
        showHandStatus(player);
        while (player.stand == false && player.hand.bust == false) {
            hitOrStand(player);
            checkBust(player.hand);
            showHandStatus(player);
        }
        dealerLogic();
        playerWin(player);
        showResult(player);
        showCurrentBalance(player);
        resetHand(player);
    }

    void initializeRound(Player player) {
        deck = new Deck();
        dealerStand = false;
        dealerHand = new Hand();
        player.setStand(false);
        player.hand.setBust(false);
    }

    void dealerLogic() {
        while(!dealerStand && !dealerHand.bust) {
            if(dealerHand.calcHandValue()< 17) {
                Card card = deck.dealOneCard();
                dealerHand.cards.add(card);
                System.out.println("Dealer was dealt: " + card.getCardName() + "\nTotal: " + dealerHand.calcHandValue() + "\n");
            }
            else if(dealerHand.calcHandValue() < 22) {
                dealerStand = true;
            }
            else {
                dealerHand.bust = true;
            }
        }
    }

    void showResult(Player player) {
//        String message =
        System.out.println("Dealer has: " + dealerHand.calcHandValue());
        System.out.println("Player has: " + player.hand.calcHandValue());
    }

    boolean playerWin(Player player) {
        if(player.hand.bust) {
            System.out.println("You busted!");
            return false;
        }
        else if(dealerHand.bust) {
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
        else if(dealerHand.calcHandValue() < player.hand.getValue()) {
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

    void dealInitialHand(Player player) {
        dealerHand.cards.add(deck.dealOneCard());
        player.hand.cards.add(deck.dealOneCard());
        player.hand.cards.add(deck.dealOneCard());
    }

//    void checkBustPlayer(List<Card> hand) { //switch this later to make player hold hand / value to pass player in as para
//        if(getHandValue(hand) > 21) { // hand should have its own values : bust / value
//            playerBust = true;
//        }
//    }
//
//    void checkBustDealer(List<Card> hand) {
//        if(getHandValue(hand) > 21) {
//            dealerBust = true;
//        }
//    }

    void checkBust(Hand hand) {
        if(hand.calcHandValue() > 21) {
            hand.setBust(true);
        }
    }

    void showHandStatus(Player player) {
        System.out.println("Dealer has: " + dealerHand.calcHandValue());
        for(Card x : dealerHand.cards) {
            System.out.println(x.getCardName());
        }
        System.out.println("\nYou have: " + player.hand.calcHandValue());
        for(Card x : player.hand.cards) {
            System.out.println(x.getCardName());
        }
        System.out.println("\n");
    }

    void hitOrStand(Player player) {
            blackJackDisplay.gameChoice();
            int choice = userInput.promptInt();
            switch (choice) {
                case 1: player.hand.cards.add(deck.dealOneCard());
                    break;
                case 2: player.setStand(true);
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

    void resetHand(Player player) {
        for(int i=0; i<player.hand.cards.size(); i++) {
            player.hand.cards.remove(0);
            if(player.hand.cards.size() != 0) {
                resetHand(player);
            }
        }
    }
}


