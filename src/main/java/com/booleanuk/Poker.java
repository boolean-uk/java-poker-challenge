package com.booleanuk;

import java.util.ArrayList;
import java.util.Arrays;
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
            Map.entry("K", 13),
            Map.entry("0", 0)
    );
    public Poker(){

    }
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        String[] winningPair = new String[2];
        boolean pairFirst = false, pairSecond = false;

        if (firstHand[0].equals(firstHand[1])){
            pairFirst = true;
        }
        if (secondHand[0].equals(secondHand[1])){
            pairSecond = true;
        }

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

        return Arrays.equals(winningPair, new String[2])  ? new String[0] : winningPair;
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        String[] winningPair = {"0", "0"};
        ArrayList<Integer> pairIndices = new ArrayList<>();

        int i = 0;
        for (String[] hand : hands){
            if (Arrays.stream(hand).distinct().count() == 1) {
                pairIndices.add(i++);
            }
        }

        for (int pair : pairIndices){
            if (valueMap.get(hands[pair][0]) > valueMap.get(winningPair[0])){
                winningPair = hands[pair];
            }
        }

        return Arrays.equals(winningPair, new String[]{"0", "0"}) ? new String[0] : winningPair;
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate

        String[] winningHand = {"0", "0", "0"};
        ArrayList<Integer> pairs = new ArrayList<>();
        ArrayList<Integer> threeOfAKinds = new ArrayList<>();

        int i = 0;
        for (String[] hand : hands){
            long distinctCount = Arrays.stream(hand).distinct().count();

            if (hand.length == 3 && distinctCount == 1) {
                threeOfAKinds.add(i);
            } else if (hand.length == 3 && distinctCount == 2) {
                pairs.add(i);
            } else if (hand.length == 2 && distinctCount == 1) {
                pairs.add(i);
            }
            i++;
        }
        for (int threeOfAKind : threeOfAKinds) {
            if (valueMap.get(hands[threeOfAKind][0]) > valueMap.get(winningHand[0])) {
                winningHand = hands[threeOfAKind].clone();
            }
        }

        if (Arrays.equals(winningHand, new String[]{"0", "0", "0"})) {
            for (int pair : pairs) {
                if (valueMap.get(hands[pair][0]) > valueMap.get(winningHand[0])) {
                    winningHand = hands[pair].clone();
                }
            }
        }
        return Arrays.equals(winningHand, new String[]{"0", "0", "0"}) ? new String[0] : winningHand;
    }


    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
