package com.sg.cardsjava;

import com.sg.cardsjava.Card.Rank;
import com.sg.cardsjava.Card.Suit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kdrudy on 9/12/16.
 */
public class Main {

    private static HashSet<Card> createDeck() {
        HashSet<Card> deck = new HashSet<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card c = new Card(suit, rank);
                deck.add(c);
            }
        }
        return deck;
    }

    private static HashSet<HashSet<Card>> createHands(HashSet<Card> deck) {
        HashSet<HashSet<Card>> hands = new HashSet<>();
        deck.forEach((c1) -> {
            HashSet<Card> deck2 = (HashSet<Card>) deck.clone();
            deck2.remove(c1);
            deck2.forEach((c2) -> {
                HashSet<Card> deck3 = (HashSet<Card>) deck2.clone();
                deck3.remove(c2);
                deck3.forEach((c3) -> {
                    HashSet<Card> deck4 = (HashSet<Card>) deck3.clone();
                    deck4.remove(c3);
                    deck4.stream().map((c4) -> {
                        HashSet<Card> hand = new HashSet();
                        hand.add(c1);
                        hand.add(c2);
                        hand.add(c3);
                        hand.add(c4);
                        return hand;
                    }).forEachOrdered((hand) -> {
                        hands.add(hand);
                    });
                });
            });
        });
        return hands;
    }

    public static boolean isFlush(HashSet<Card> hand) {
        return false;
    }

    public static boolean isStraight(HashSet<Card> hand) {
        return false;
    }

    public static boolean isStraightFlush(HashSet<Card> hand) {
        return false;
    }

    public static boolean isFourOfAKind(HashSet<Card> hand) {
        return false;
    }

    public static boolean isThreeOfAKind(HashSet<Card> hand) {
        return false;
    }

    public static boolean isTwoPair(HashSet<Card> hand) {
        return false;
    }

    public static void main(String args[]) {
        HashSet<Card> deck = createDeck();
        HashSet<HashSet<Card>> allCards = createHands(deck);
        System.out.println("Total Hands: " + allCards.size());

        //Count straights
        HashSet<HashSet<Card>> straightHands = allCards;
        straightHands = straightHands.stream()
                .filter(Main::isStraight)
                .filter((h) -> !isStraightFlush(h))
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Straights (2520)" + straightHands.size());

        //Count flushes
        HashSet<HashSet<Card>> flushHands = allCards;
        flushHands = flushHands.stream()
                .filter(Main::isFlush)
                .filter((h) -> !isStraightFlush(h))
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Flushes (2820)" + flushHands.size());

        //Count straight flushes
        HashSet<HashSet<Card>> straightFlushHands = allCards;
        straightFlushHands = straightFlushHands.stream()
                .filter(Main::isStraightFlush)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Straight Flushes (40)" + straightFlushHands.size());

        //Count four of a kinds
        HashSet<HashSet<Card>> fourKindHands = allCards;
        fourKindHands = fourKindHands.stream()
                .filter(Main::isFourOfAKind)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Four of a kinds (13)" + fourKindHands.size());

        //Count three of a kinds
        HashSet<HashSet<Card>> threeKindHands = allCards;
        threeKindHands = threeKindHands.stream()
                .filter(Main::isThreeOfAKind)
                .filter((h) -> !isFourOfAKind(h))
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Three of a kinds (2496)" + threeKindHands.size());

        //Count two pairs
        HashSet<HashSet<Card>> twoPairHands = allCards;
        twoPairHands = twoPairHands.stream()
                .filter(Main::isTwoPair)
                .filter((h) -> !isFourOfAKind(h))
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Two pairs (2808)" + twoPairHands.size());
    }
}
