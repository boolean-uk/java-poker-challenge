package com.booleanuk.extension;
import com.booleanuk.Poker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Extension3Test {


    @Test
    public void royalFlush() {
        Poker poker = new Poker();
        String[][] hands = {new String[]{"A", "K", "Q", "J", "10"}, new String[]{"9", "9","9", "9", "2"}, new String[]{"6", "6", "4"}};
        String[] result = poker.extensionThreeMethods(hands);
        Assertions.assertArrayEquals(new String[]{"A", "K", "Q", "J", "10"}, result);
    }

    @Test
    public void testSorting() {
        Poker poker = new Poker();
        String[] hand = new String[]{"A", "K", "Q", "J", "10","3","2","5"};
        String[] result = poker.sortStringArrayOfCards(hand);
        Assertions.assertArrayEquals(new String[]{"2", "3", "5", "10", "J", "Q", "K", "A"}, result);
    }


    @Test
    public void testTwoThreeFourOfAKind() {
        Poker poker = new Poker();
        String[] hand = new String[] {"A","A","A","K","K"};
        int[] result = poker.howManyTwoThreeFourOfAKind(hand);
        Assertions.assertArrayEquals(new int[]{1,1,0}, result);
    }

    @Test
    public void testIsItFlush() {
        Poker poker = new Poker();
        String[] hand = new String[] {"3","2","5","6","4"};
        boolean result= poker.isItStraight(hand);
        Assertions.assertTrue(result);
    }

}
