package com.booleanuk.extension;
import com.booleanuk.Poker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Extension3Test {
    @Test
    public void moreHandsOfThree() {
        Poker poker = new Poker();
        String[][] hands = {new String[]{"7", "2", "8"}, new String[]{"A", "J", "Q"}, new String[]{"2", "5", "3"}};
        String[] result = poker.extensionThreeMethods(hands);
        Assertions.assertArrayEquals(new String[]{}, result);
    }
}
