package com.booleanuk;

public enum Card {
    // Hearts
    H1(Suit.HEARTS, 1),
    H2(Suit.HEARTS, 2),
    H3(Suit.HEARTS, 3),
    H4(Suit.HEARTS, 4),
    H5(Suit.HEARTS, 5),
    H6(Suit.HEARTS, 6),
    H7(Suit.HEARTS, 7),
    H8(Suit.HEARTS, 8),
    H9(Suit.HEARTS, 9),
    H10(Suit.HEARTS, 10),
    HJ(Suit.HEARTS, 11),
    HQ(Suit.HEARTS, 12),
    HK(Suit.HEARTS, 13),
    HA(Suit.HEARTS, 14),

    // Diamonds
    D1(Suit.DIAMONDS, 1),
    D2(Suit.DIAMONDS, 2),
    D3(Suit.DIAMONDS, 3),
    D4(Suit.DIAMONDS, 4),
    D5(Suit.DIAMONDS, 5),
    D6(Suit.DIAMONDS, 6),
    D7(Suit.DIAMONDS, 7),
    D8(Suit.DIAMONDS, 8),
    D9(Suit.DIAMONDS, 9),
    D10(Suit.DIAMONDS, 10),
    DJ(Suit.DIAMONDS, 11),
    DQ(Suit.DIAMONDS, 12),
    DK(Suit.DIAMONDS, 13),
    DA(Suit.DIAMONDS, 14),

    // Spades
    S1(Suit.SPADES, 1),
    S2(Suit.SPADES, 2),
    S3(Suit.SPADES, 3),
    S4(Suit.SPADES, 4),
    S5(Suit.SPADES, 5),
    S6(Suit.SPADES, 6),
    S7(Suit.SPADES, 7),
    S8(Suit.SPADES, 8),
    S9(Suit.SPADES, 9),
    S10(Suit.SPADES, 10),
    SJ(Suit.SPADES, 11),
    SQ(Suit.SPADES, 12),
    SK(Suit.SPADES, 13),
    SA(Suit.SPADES, 14),

    // Clubs
    C1(Suit.CLUBS, 1),
    C2(Suit.CLUBS, 2),
    C3(Suit.CLUBS, 3),
    C4(Suit.CLUBS, 4),
    C5(Suit.CLUBS, 5),
    C6(Suit.CLUBS, 6),
    C7(Suit.CLUBS, 7),
    C8(Suit.CLUBS, 8),
    C9(Suit.CLUBS, 9),
    C10(Suit.CLUBS, 10),
    CJ(Suit.CLUBS, 11),
    CQ(Suit.CLUBS, 12),
    CK(Suit.CLUBS, 13),
    CA(Suit.CLUBS, 14);

    private Suit suit;
    private int value;

    Card(Suit suit, int value){
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getRank() {
        return value;
    }
}

