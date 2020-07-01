package com.sg.week2;

/**
 * Created by kdrudy on 9/12/16.
 */
public class Card {

    enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    enum Rank {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);
        private final int val;
        private Rank(int v) { this.val = v; }
        public int getVal() { return val; }
    }

    public Suit suit;
    public Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        return rank == card.rank;

    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
    
    public String getSuitString() {
        switch(suit) {
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case SPADES:
                return "Spades";
            case CLUBS:
                return "Clubs";
            default:
                return "Unknown";
        }
    }
    
    public String getRankString() {
        switch(rank) {
            case TWO:
            case THREE:
            case FOUR:
            case FIVE:
            case SIX:
            case SEVEN:
            case EIGHT:
            case NINE:
            case TEN:
                return Integer.toString(rank.getVal());
            case ACE:
                return "Ace";
            case JACK:
                return "Jack";
            case QUEEN:
                return "Queen";
            case KING:
                return "King";
            default:
                return "Unknown";
        }
    }
    
    public String getCardString() {
        return getRankString() + " of " + getSuitString();
    }
}
