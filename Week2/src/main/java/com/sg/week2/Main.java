package com.sg.week2;

/**
 *
 * @author Kyle David Rudy
 */
public class Main {
    public static void main(String[] args) {
        Deck d = new Deck();
        d.shuffle();
        for(Card c : d.getDeck()) {
            System.out.println(c.getCardString());
        }
    }
}
