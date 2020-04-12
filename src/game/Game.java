package game;

import deck.*;
import players.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    enum Status {
        START, STOP;
    }

    Scanner scanner = new Scanner(System.in);
    private Status gameStatus;
    private Deck deck = new Deck();
    private Player player;
    private Player dealer;
    private int playerWins;
    private int dealerWins;
    private int pot;


    public Game(Player player, Player dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    //handle all rules for the game
    //game loop
    //handle all hand comparisons and win conditions

    //should consist of a player, dealer
    //aggregation of player and dealer
    //should have a deck
    //table, pot, etc (optional)

    public void run() {
        setupGame();
        while (gameStatus == Status.START) {
            if (endGameStatus()) {
                break;
            }

            Hand playerHand = getHand(player);
            Hand dealerHand = getHand(dealer);

            gameTurn(playerHand, dealerHand);


            //dealHand();

            //gameStatus = Status.STOP;
        }

    }

    public void setupGame() {
        gameStatus = Status.START;
        deck.loadDeck();
        deck.shuffleDeck();
        printStartMessage();
        waitThreeSeconds();

    }

    private void printStartMessage() {
        System.out.print("\n***This game plays several hands of blackjack, until the single deck is out" +
                " of cards. After each hand is dealt, you will " +
                "have the choice to either hit or stand.***\n");
    }

    public void gameTurn(Hand playerHand, Hand  dealerHand) {
        System.out.println("\nDealing cards...");
        System.out.println();

        waitOneSecond();

        dealHand(playerHand, dealerHand);

        System.out.println("Your hand: ");
        player.printHand();
        System.out.println();

        waitOneSecond();

        System.out.println("Dealer's hand: ");
        dealer.printHand();
        System.out.printf("");
        System.out.println();

        waitOneSecond();
        hit(playerHand);
        compareHand(playerHand, dealerHand);
    }

    public void waitThreeSeconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dealHand(Hand playerHand, Hand dealerHand) {
        playerHand.clearHand();
        dealerHand.clearHand();
        playerHand.addToHand(deck.dealCard());
        playerHand.addToHand(deck.dealCard());
        dealerHand.addToHand(deck.dealCard());
        dealerHand.addToHand(deck.dealCard());
    }

    public void dealCard(Hand playerHand, Hand dealerHand) {

        playerHand.addToHand(deck.dealCard());
        dealerHand.addToHand(deck.dealCard());
    }

    public Hand getHand(Player p) {
        return p.getHand();
    }

    public void compareHand(Hand playerHand, Hand dealerHand) {

        int playerHandVal = playerHand.getHandVal();
        int dealerHandVal = dealerHand.getHandVal();

        System.out.println(playerHandVal);
        System.out.println(dealerHandVal);

        if (playerHand.isBust(playerHandVal)) {
            System.out.println("Bust!");
            dealerWins++;
            waitThreeSeconds();
        } else if (playerHand.isBlackjack() && !dealerHand.isBlackjack()) {
            System.out.println("Blackjack!");
            playerWins++;
            waitThreeSeconds();
        } else if (dealerHand.isBlackjack()) {
            System.out.println("Dealer gets blackjack");
            dealerWins++;
            waitThreeSeconds();
        } else if (dealerHand.isBust(dealerHandVal)) {
            System.out.println("Dealer bust!");
            playerWins++;
            waitThreeSeconds();
        } else if (playerHandVal > dealerHandVal) {
            System.out.println("You win!");
            playerWins++;
            waitThreeSeconds();
        } else if (dealerHandVal > playerHandVal) {
            System.out.println("Dealer wins");
            dealerWins++;
            waitThreeSeconds();
        } else if (playerHandVal == dealerHandVal) {
            System.out.println("Tie, Dealer still wins");
            dealerWins++;
            waitThreeSeconds();
        }
    }

    public void playerWin() {
        //player
    }

    public void hit(Hand playerHand) {
        if (playerHits()) {
            playerHand.addToHand(deck.dealCard());
            System.out.println("Dealing card...");
        }

        waitOneSecond();
        System.out.println("Your hand: ");
        playerHand.printHand();
        System.out.println();
    }

    public boolean playerHits() {
        String input = "";
        while (!input.equals("h") || !input.equals("s")) {
            System.out.println("Hit ('h') or stand ('s')?");
            input = scanner.nextLine();
            if (input.equals("h")) {
                return true;
            }
            if (input.equals("s")) {
                return  false;
            }

        }
        return false;
    }

    public boolean endGameStatus() {
        if (GameRules.gameOver(player, dealer, deck)) {
            gameStatus = Status.STOP;
            return true;
        }
        return false;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getDealerWins() {
        return dealerWins;
    }
}
