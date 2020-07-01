package com.sg.week2;

import com.sg.week2.Card.Rank;
import com.sg.week2.Card.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public class Deck {
    List<Card> deck = new ArrayList<>();
    
    public Deck() {
        for(Suit s : Suit.values()) {
            for(Rank r : Rank.values()) {
                deck.add(new Card(s, r));
            }
        }
    }

    public List<Card> getDeck() {
        return deck;
    }
    
    
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
}
