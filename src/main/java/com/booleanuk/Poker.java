package com.booleanuk;

import java.util.HashMap;
import java.util.Map;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        //Task:
        //Given two pairs of cards, calculate the winning pair. The method
        // winningPair() should accept two arrays with two cards in each, and
        // return the highest pair found as the winning pair. Only pairs can win,
        // so if neither hand contains a pair then an empty array should be returned.
        // Assume that there will be no draws (ie the two pairs will be different to
        // each other).

        //Variables
        String[] output = new String[2];
        String ace = "A";
        boolean firstHandPair = firstHand[0].equals(firstHand[1]);
        boolean secondHandPair = secondHand[0].equals(secondHand[1]);
        boolean firstHandAcePair = firstHand[0].equals(ace) && firstHand[1].equals(ace);
        boolean secondHandAcePair = secondHand[0].equals(ace) && secondHand[1].equals(ace);
        boolean compareValue1 = firstHand[0].compareTo(secondHand[0]) > 0;
        boolean compareValue2 = firstHand[1].compareTo(secondHand[1]) > 0;
        boolean compareValue3 = firstHand[0].compareTo(secondHand[0]) < 0;
        boolean compareValue4 = firstHand[1].compareTo(secondHand[1]) < 0;

        if(compareValue1 && compareValue2){ //Second test case 1 = if second hands' values are greater than second hands' return first hand
            output = firstHand;
        }
        else if(compareValue3 && compareValue4){ //Second test case 2 = if first hands' values are less than second hands' return second hand
            output = firstHand;
        }
        if (!firstHandPair) { //Third test case 1 = if first hand is not a pair, return second hand
            output = secondHand;
        }
        else if (!secondHandPair) { //Third test case 2 = if second hand is not a pair, return first hand
            output = firstHand;
        }
        if (firstHandPair && secondHandPair) {
            if(firstHandAcePair) {
                output = firstHand;
            }
            else if (secondHandAcePair) {
                output = secondHand;
            }
        }
        if (!firstHandPair && !secondHandPair) { //First test = if neither hands are pairs, return empty array
            output = new String[0];
        }
        return output;
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winningPair = new String[0]; // Initially no winning pair
        int highestValue = -1;

        for (String[] hand : hands) {
            int handValue = getHandValue(hand);
            if (hand[0].equals(hand[1]) && handValue > highestValue) {
                highestValue = handValue;
                winningPair = hand;
            }
        }

        return winningPair;
    }

    private int getHandValue(String[] hand) {
        String card = hand[0]; // Assuming both cards are the same, we can just check one
        if (card.equals("A")) return 14;
        if (card.equals("K")) return 13;
        if (card.equals("Q")) return 12;
        if (card.equals("J")) return 11;
        return Integer.parseInt(card);
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winningHand = new String[0];
        int highestRank = 0; // 0: no hand, 1: pair, 2: three of a kind
        int highestValue = -1;

        for (String[] hand : hands) {
            int[] rankAndValue = getHandRankAndValue(hand);
            if (rankAndValue[0] > highestRank || (rankAndValue[0] == highestRank && rankAndValue[1] > highestValue)) {
                highestRank = rankAndValue[0];
                highestValue = rankAndValue[1];
                winningHand = hand;
            }
        }

        return winningHand;
    }

    private int[] getHandRankAndValue(String[] hand) {
        // Simplified logic; you may need a more complex method for full poker rules
        HashMap<String, Integer> cardCounts = new HashMap<>();
        for (String card : hand) {
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }

        int rank = 0;
        int value = -1;
        for (Map.Entry<String, Integer> entry : cardCounts.entrySet()) {
            int cardValue = getHandValue(new String[]{entry.getKey()});
            if (entry.getValue() == 3) return new int[]{2, cardValue}; // Three of a kind
            if (entry.getValue() == 2 && rank < 1) {
                rank = 1;
                value = cardValue;
            }
        }

        return new int[]{rank, value};

    }
    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }

}
