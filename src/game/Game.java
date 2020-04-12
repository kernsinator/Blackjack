/*
This class represents the blackjack game. This includes game rules, win conditions, the game loop, hand comparisons,
instantiation of necessary components, and aggregation of player and dealer.
 */

package game;

import deck.*;
import players.*;

import java.util.Scanner;

public class Game {
    enum Status {
        START, STOP
    }

    Scanner scanner = new Scanner(System.in);
    private Status gameStatus; // used to start and stop game
    private Deck deck = new Deck();
    private Player player;
    private Player dealer;
    private int playerWins; // used to keep track of total wins (will likely be removed in future version)
    private int dealerWins;

    public Game(Player player, Player dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    // run method starts game loop
    public void run() {
        setupGame();
        while (gameStatus == Status.START) {
            if (endGameStatus()) { // check for criteria to end game
                break;
            }

            // access hands of both player and dealer
            Hand playerHand = getHand(player);
            Hand dealerHand = getHand(dealer);

            gameTurn(playerHand, dealerHand); //
        }
    }

    private void setupGame() { // set status to START, load and shuffle deck, then print start message for game
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

    private void gameTurn(Hand playerHand, Hand dealerHand) { // carries out one hand of blackjack
        System.out.println("\nDealing cards...");
        System.out.println();
        waitOneSecond();

        dealHand(playerHand, dealerHand); // deal two cards each to player and dealer

        showPlayerHand(); // display player's hand
        waitOneSecond();

        showDealerHand(); // display dealer's hand
        waitOneSecond();

        hit(playerHand); // offer player chance to "hit", then display their hand
        showDealerHand();
        compareHand(playerHand, dealerHand); // compares player and dealer hands, prints message to player
    }

    private void showPlayerHand() {
        System.out.println("Your hand: ");
        player.printHand();
        System.out.println();
    }

    private void showDealerHand() {
        System.out.println("Dealer's hand: ");
        dealer.printHand();
        System.out.println();
    }

    private void waitThreeSeconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waitOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dealHand(Hand playerHand, Hand dealerHand) { // clear player and dealer hands, deal 2 cards each
        playerHand.clearHand();
        dealerHand.clearHand();
        playerHand.addToHand(deck.dealCard());
        playerHand.addToHand(deck.dealCard());
        dealerHand.addToHand(deck.dealCard());
        dealerHand.addToHand(deck.dealCard());
    }

    public void compareHand(Hand playerHand, Hand dealerHand) {

        // get values of hands
        int playerHandVal = playerHand.getHandVal();
        int dealerHandVal = dealerHand.getHandVal();

        // lines below print hand values for debugging purposes
        //System.out.println(playerHandVal);
        //System.out.println(dealerHandVal);

        if (playerHand.isBust(playerHandVal)) { // check if player busts
            System.out.println("Bust!");
            dealerWins++;
            waitThreeSeconds();
        } else if (playerHand.isBlackjack() && !dealerHand.isBlackjack()) { // check if player wins with blackjack
            System.out.println("Blackjack!");
            playerWins++;
            waitThreeSeconds();
        } else if (dealerHand.isBlackjack()) { // check for dealer blackjack
            System.out.println("Dealer gets blackjack");
            dealerWins++;
            waitThreeSeconds();
        } else if (dealerHand.isBust(dealerHandVal)) { // check if dealer bust
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

    public void hit(Hand playerHand) {
        if (playerHits()) { // if player chooses to "hit"
            playerHand.addToHand(deck.dealCard()); // deal one additional card to hand
            System.out.println("Dealing card...");
        }

        waitOneSecond();
        showPlayerHand();
    }

    public boolean playerHits() { // if player types 'h' for "hit", returns true. if 's' for "stand", returns false
        String input = "";
        while (!input.equals("h") && !input.equals("s")) {
            System.out.println("Hit ('h') or stand ('s')?");
            input = scanner.nextLine();
            if (input.equals("h")) {
                return true;
            }
            if (input.equals("s")) {
                return false;
            }
        }
        return false;
    }

    public Hand getHand(Player p) { // return hand belonging to player object
        return p.getHand();
    }

    public boolean endGameStatus() { // set game status to stop if criteria are met
        if (gameOver(player, dealer, deck)) {
            gameStatus = Status.STOP;
            return true;
        }
        return false;
    }

    //if player is out of money, dealer is out of money, or are not enough cards for one hand, game should end
    private boolean gameOver(Player p, Player d, Deck deck) {
        if (p.getMoney() <= 0 || d.getMoney() <= 0 || deck.remainingCards() < 4) {
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
