/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardsjava;

import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kylerudy
 */
public class MainTest {
    
    static HashSet<Card> hand1 = new HashSet<>();
    static HashSet<Card> hand2 = new HashSet<>();
    static HashSet<Card> hand3 = new HashSet<>();
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        hand1.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        hand1.add(new Card(Card.Suit.CLUBS, Card.Rank.TWO));
        hand1.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE));
        hand1.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR));

        hand2.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        hand2.add(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        hand2.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand2.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));

        hand3.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR));
        hand3.add(new Card(Card.Suit.SPADES, Card.Rank.KING));
        hand3.add(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT));
        hand3.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
    }
    
    @Test
    public void isTwoPair() throws Exception {
        assertFalse(Main.isTwoPair(hand1));
        assertTrue(Main.isTwoPair(hand2));
        assertFalse(Main.isTwoPair(hand3));
    }

    @Test
    public void isThreeOfAKind() throws Exception {
        assertFalse(Main.isThreeOfAKind(hand1));
        assertTrue(Main.isThreeOfAKind(hand2));
        assertFalse(Main.isThreeOfAKind(hand3));
    }

    @Test
    public void isStraightFlush() throws Exception {
        assertTrue(Main.isStraightFlush(hand1));
        assertFalse(Main.isStraightFlush(hand2));
        assertFalse(Main.isStraightFlush(hand3));
    }

    @Test
    public void isFlush() throws Exception {
        assertTrue(Main.isFlush(hand1));
        assertFalse(Main.isFlush(hand2));
        assertFalse(Main.isFlush(hand3));
    }

    @Test
    public void isStraight() throws Exception {
        assertTrue(Main.isStraight(hand1));
        assertFalse(Main.isStraight(hand2));
        assertFalse(Main.isStraight(hand3));
    }

    @Test
    public void isFourOfAKind() throws Exception {
        assertFalse(Main.isFourOfAKind(hand1));
        assertTrue(Main.isFourOfAKind(hand2));
        assertFalse(Main.isFourOfAKind(hand3));
    }
    
}
