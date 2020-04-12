/*
This is the test class to test the blackjack game. This class creates a player and dealer.
It then instantiates and runs the blackjack game.
Created by Tyler Kerns for CSCI 2001-51
 */

package tests;

import game.Game;
import players.Player;

public class TestBlackjack {

    public static void main(String[] args) {

        Player player = new Player();
        Player dealer = new Player(true);

        Game game = new Game(player, dealer);

        game.run();

        // lines below allow to see how many hands play wins vs hands dealer wins
        //System.out.println("Number of hands you won: " + game.getPlayerWins());
        //System.out.println("Number of hands dealer won: " + game.getDealerWins());

    }
}
