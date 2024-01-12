package com.booleanuk;

import java.util.Arrays;

public class Poker {
    // Core
    String cardOrder = "12345678910JQKA";

    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        boolean firstHandIsPair = firstHand[0].equals(firstHand[1]);
        boolean secondHandIsPair = secondHand[0].equals(secondHand[1]);

        if (firstHandIsPair && !secondHandIsPair) {return firstHand;}
        else if (!firstHandIsPair && secondHandIsPair) {return secondHand;}
        else if (!firstHandIsPair && !secondHandIsPair) {return new String[]{};}
        else {
            if (this.cardOrder.indexOf(firstHand[0]) > this.cardOrder.indexOf(secondHand[0])) {return firstHand;}
            else {return secondHand;}
        }
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winningPair = new String[]{"1","1"};
        for (String[] hand : hands) {
            if (hand[0].equals(hand[1]) && this.cardOrder.indexOf(hand[0]) > this.cardOrder.indexOf(winningPair[0])) {
                winningPair = hand;
            }
        }
        if (Arrays.equals(winningPair, new String[]{"1","1"})) {return new String[]{};}
        else {return winningPair;}
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winningPair = new String[]{"1","1"};
        String winningValue = "1";
        boolean threeOfAKind = false;
        for (String[] hand : hands) {
            // If three cards in the current hand
            if (hand.length == 3) {
                // If three of a kind
                if (hand[0].equals(hand[1]) && hand[0].equals(hand[2])) {
                    // If no three of a kind yet
                    if (!threeOfAKind) {
                        winningPair = hand;
                        winningValue = hand[0];
                        threeOfAKind = true;
                    }
                    // Three of a kind already detected, compares values
                    else {
                        // Compare values in the ThreeOfAKind pairs
                        if (this.cardOrder.indexOf(hand[0]) > this.cardOrder.indexOf(winningValue)) {
                            winningPair = hand;
                            winningValue = hand[0];
                        }
                    }
                }
                // Check for pairs in the three cards
                else if ((hand[0].equals(hand[1])  || hand[0].equals(hand[2])) && !threeOfAKind) {
                    if (this.cardOrder.indexOf(hand[0]) > this.cardOrder.indexOf(winningValue)) {
                        winningPair = hand;
                        winningValue = hand[0];
                    }
                }
                else if (hand[1].equals(hand[2]) && !threeOfAKind) {
                    if (this.cardOrder.indexOf(hand[1]) > this.cardOrder.indexOf(winningValue)) {
                        winningPair = hand;
                        winningValue = hand[1];
                    }
                }
            }
            // Two cards in current hand
            else {
                if (hand[0].equals(hand[1]) && !threeOfAKind) {
                    if (this.cardOrder.indexOf(hand[0]) > this.cardOrder.indexOf(winningValue)) {
                        winningPair = hand;
                        winningValue = hand[0];
                    }
                }
            }
        }
        if (Arrays.equals(winningPair, new String[]{"1","1"})) {return new String[]{};}
        else {return winningPair;}
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
