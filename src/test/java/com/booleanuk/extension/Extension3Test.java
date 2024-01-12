package com.booleanuk.extension;
import com.booleanuk.Poker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Extension3Test {

    @Test
    public void compareThreeHands() {
        Poker poker = new Poker();
        String[][] hands = {new String[]{"2 Heart", "2 Clove", "2 Diamond", "9 Diamond", "3 Diamond"},
                new String[]{"Q Clove", "9 Heart", "3 Heart", "6 Diamond", "2 Heart"},
                new String[]{"Q Diamond", "Q Heart", "4 Heart", "5 Diamond", "7 Heart"}};
        String[] result = poker.extensionThreeMethods(hands);
        Assertions.assertArrayEquals(new String[]{"2 Heart", "2 Clove", "2 Diamond", "9 Diamond", "3 Diamond"}, result);
    }
}
