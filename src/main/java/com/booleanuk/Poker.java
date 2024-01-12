package com.booleanuk;

import java.util.HashMap;
import java.util.Map;

public class Poker {
    Map<String, Integer> valueMap = Map.ofEntries(
            Map.entry("A", 100),
            Map.entry("2", 2),
            Map.entry("3", 3),
            Map.entry("4", 4),
            Map.entry("5", 5),
            Map.entry("6", 6),
            Map.entry("7", 7),
            Map.entry("8", 8),
            Map.entry("9", 9),
            Map.entry("10", 10),
            Map.entry("J", 11),
            Map.entry("Q", 12),
            Map.entry("K", 15)
    );
    public Poker(){

    }
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        String[] winningPair;
        boolean pairFirst = false, pairSecond = false;
        if (firstHand[0].equals(firstHand[1])) pairFirst = true;
        if (secondHand[0].equals(secondHand[1])) pairSecond = true;

        if (pairFirst && pairSecond){
            if (valueMap.get(firstHand[0]) < valueMap.get(secondHand[0])){
                winningPair = secondHand;
            } else {
                winningPair = firstHand;
            }
        } else if (pairFirst) {
            winningPair = firstHand;
        } else if (pairSecond){
            winningPair = secondHand;
        }

        return new String[0];
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        return new String[]{"Replace me", "with something else"};
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        return new String[]{"Replace me", "with something else"};
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
