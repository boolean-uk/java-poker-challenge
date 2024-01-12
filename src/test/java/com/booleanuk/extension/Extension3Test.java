package com.booleanuk.extension;
import com.booleanuk.Poker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Extension3Test {
    @Test
    public void shouldPass() {
    Poker poker = new Poker();

    String[] hand1 = {"A", "A", "A", "A", "2"};  // Replace with actual hands
    String[] hand2 = {"K", "K", "K", "K", "3"};  // Replace with actual hands

    // Call the method with the actual hands
    String result = poker.extensionThreeMethods(hand1, hand2);

    // Update the expected result based on your implementation
        Assertions.assertEquals("Hand 1 wins", result);
}
}
