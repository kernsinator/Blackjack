package tests;

import game.Game;
import players.Player;

public class TestBlackjack {


    public static void main(String[] args) {


        Player player = new Player();
        Player dealer = new Player(true);

        Game game = new Game(player, dealer);


        game.run();

        System.out.println("Number of hands you won: " + game.getPlayerWins());
        System.out.println("Number of hands dealer won: " + game.getDealerWins());

    }
}
