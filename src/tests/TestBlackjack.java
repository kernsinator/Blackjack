package tests;

import deck.Card;
import game.Game;
import players.Player;

public class TestBlackjack {


    public static void main(String[] args) {

        //Deck d = new Deck();
        //d.printDeck();
        Player player = new Player();
        Player dealer = new Player(true);

        Card c1, c2;

        Game game = new Game(player, dealer);

        //for(int i = 0; i < 500; i++){
        game.run();
        //}
        System.out.println("Number of hands you won: " + game.getPlayerWins());
        System.out.println("Number of hands dealer won: " + game.getDealerWins());



        /*
        d.shuffleDeck();
        System.out.println();
        d.printDeck();
        for (int i = 0; i <= 10; i++ ){
            ArrayList<Card> hand = new ArrayList<>();
            hand.add(d.dealCard());
            hand.add(d.dealCard());
            System.out.println(hand);
            */

    }
}
