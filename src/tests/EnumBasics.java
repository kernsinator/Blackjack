package tests;

import deck.Deck;
import deck.Card;
import deck.Rank;
import game.*;
import players.Player;

import java.util.ArrayList;

public class EnumBasics {
    enum Status {
        START, PAUSE, STOP;
    }

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
        System.out.println(game.getPlayerWins());
        System.out.println(game.getDealerWins());



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


        //System.out.println("c1: " + c1 + " - value: " + c1.getRankValue());
        //System.out.println("c2: " + c2 + " - value: " + c2.getRankValue());

        //if(c1.getRank().getValue() == c2.getRank().getValue()) {
        //    System.out.println("Equal value");
        //}

        //int total = c1.getRank().getValue() + c2.getRank().getValue();
        //System.out.println(total);
    }


/*
Status gameStatus;

        gameStatus= Status.START;

        deck.Rank r = deck.Rank.ACE;

        if(r == deck.Rank.ACE) {
            System.out.println("Ace");
        }

        int handVal = r.getValue();
        r=deck.Rank.KING;
        handVal+=r.getValue();
        System.out.println(handVal);
 */

/*
ArrayList<Rank> rankList = new ArrayList<>();

        Rank[] values = Rank.values();

        for(Rank r : values) {
            rankList.add(r);
        }

        for(Rank r : rankList) {
            System.out.print(r.getName() + ", ");
        }
        System.out.println();
        for(Rank r : rankList) {
            System.out.print(r.getValue() + ", ");
        }
 */

/*
Deck d = new Deck();
        d.printDeck();

        Card c1, c2;

        c1 = d.dealCard();
        c2 = d.getDeck().remove(12);

        System.out.println("c1: " + c1 + " - value: " + c1.getRankValue());
        System.out.println("c2: " + c2 + " - value: " + c2.getRankValue());

        if(c1.getRank().getValue() == c2.getRank().getValue()) {
            System.out.println("Equal value");
        }

        int total = c1.getRank().getValue() + c2.getRank().getValue();
        System.out.println(total);
 */