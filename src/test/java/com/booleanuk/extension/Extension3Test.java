package com.booleanuk.extension;
import com.booleanuk.Card;
import com.booleanuk.Hand;
import com.booleanuk.HandRanking;
import com.booleanuk.Poker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Extension3Test {
    @Test
    public void TestRoyalFlushScoring() {
        Hand hand = new Hand(new Card[]{Card.HA, Card.HJ, Card.HK, Card.HQ, Card.H10});
        Assertions.assertEquals(HandRanking.ROYALFLUSH, hand.getRanking());
        Assertions.assertEquals(0, hand.getValue());
    }

    @Test
    public void TestWinning() {
        Poker poker = new Poker();
        Hand hand2 = new Hand(new Card[]{Card.CA, Card.CJ, Card.CK, Card.CQ, Card.C10});
        Hand hand1 = new Hand(new Card[]{Card.H9, Card.HJ, Card.HK, Card.HQ, Card.H10});
        Assertions.assertEquals(hand2, poker.getWinningHand(new Hand[]{hand1, hand2}));
    }

    @Test
    public void TestWinning2() {
        Poker poker = new Poker();
        Hand hand1 = new Hand(new Card[]{Card.H9, Card.D9, Card.S9, Card.C9, Card.H10});
        Hand hand2 = new Hand(new Card[]{Card.H4, Card.CJ, Card.D7, Card.H3, Card.C6});
        Assertions.assertEquals(hand1, poker.getWinningHand(new Hand[]{hand1, hand2}));
    }

    @Test
    public void TestStraightFlushScoring() {
        Hand hand = new Hand(new Card[]{Card.H9, Card.HJ, Card.HK, Card.HQ, Card.H10});
        Assertions.assertEquals(HandRanking.STRAIGHTFLUSH, hand.getRanking());
        Assertions.assertEquals(13, hand.getValue());
    }

    @Test
    public void TestFourScoring() {
        Hand hand = new Hand(new Card[]{Card.H9, Card.D9, Card.S9, Card.C9, Card.H10});
        Assertions.assertEquals(HandRanking.FOUROFAKIND, hand.getRanking());
        Assertions.assertEquals(9, hand.getValue());
    }

    @Test
    public void TestFullScoring() {
        Hand hand = new Hand(new Card[]{Card.H9, Card.D9, Card.S9, Card.C10, Card.H10});
        Assertions.assertEquals(HandRanking.FULLHOUSE, hand.getRanking());
        Assertions.assertEquals(9, hand.getValue());
    }

    @Test
    public void TestFlushScoring() {
        Hand hand = new Hand(new Card[]{Card.H9, Card.H5, Card.H2, Card.H3, Card.H10});
        Assertions.assertEquals(HandRanking.FLUSH, hand.getRanking());
        Assertions.assertEquals(10, hand.getValue());
    }

    @Test
    public void TestStraightScoring() {
        Hand hand = new Hand(new Card[]{Card.H4, Card.H5, Card.H2, Card.H3, Card.C6});
        Assertions.assertEquals(HandRanking.STRAIGHT, hand.getRanking());
        Assertions.assertEquals(6, hand.getValue());
    }

    @Test
    public void TestThreeScoring() {
        Hand hand = new Hand(new Card[]{Card.H4, Card.C4, Card.D4, Card.H3, Card.C6});
        Assertions.assertEquals(HandRanking.THREEOFAKIND, hand.getRanking());
        Assertions.assertEquals(4, hand.getValue());
    }

    @Test
    public void TestTwoPairScoring() {
        Hand hand = new Hand(new Card[]{Card.H4, Card.C4, Card.D3, Card.H3, Card.C6});
        Assertions.assertEquals(HandRanking.TWOPAIR, hand.getRanking());
        Assertions.assertEquals(4, hand.getValue());
    }

    @Test
    public void TestPairScoring() {
        Hand hand = new Hand(new Card[]{Card.H4, Card.C4, Card.D7, Card.H3, Card.C6});
        Assertions.assertEquals(HandRanking.ONEPAIR, hand.getRanking());
        Assertions.assertEquals(4, hand.getValue());
    }

    @Test
    public void TestHighestScoring() {
        Hand hand = new Hand(new Card[]{Card.H4, Card.CJ, Card.D7, Card.H3, Card.C6});
        Assertions.assertEquals(HandRanking.HIGHCARD, hand.getRanking());
        Assertions.assertEquals(11, hand.getValue());
    }
}
