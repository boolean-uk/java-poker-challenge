package com.booleanuk;

import java.util.ArrayList;
import java.util.HashMap;

public class Poker {
    // Core

    HashMap<String, Integer> cardValues = new HashMap<String, Integer>();
    public  Poker() {
        cardValues.put("2", 2);
        cardValues.put("3", 3);
        cardValues.put("4", 4);
        cardValues.put("5", 5);
        cardValues.put("6", 6);
        cardValues.put("7", 7);
        cardValues.put("8", 8);
        cardValues.put("9", 9);
        cardValues.put("10", 10);
        cardValues.put("J", 11);
        cardValues.put("Q", 12);
        cardValues.put("K", 13);
        cardValues.put("A", 14);

    }



    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        boolean firsthandMatches = false;
        boolean secondhandMatches = false;
        if(firstHand[0] == firstHand[1]) {
            firsthandMatches = true;
        }
        if (secondHand[0] == secondHand[1]) {
            secondhandMatches = true;
        }
        if (firsthandMatches && secondhandMatches) {
            if (cardValues.get(firstHand[0]) > cardValues.get(secondHand[0])) {
                return firstHand;
            } else {
                return secondHand;
            }
        } else if (firsthandMatches) {
            return firstHand;
        } else if (secondhandMatches) {
            return secondHand;
        } else {
            return new String[0];
        }

    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[][] matchingHands = new String[2][2];
        for(int i = 0; i < hands.length; i++) {
            if(hands[i][0] == hands[i][1]) {
                matchingHands[i] = hands[i];
            }
        }
        String[] winningHand = {};
        for(int i = 0; i < matchingHands.length; i++) {
            for(int j = 0; j < matchingHands.length; j++) {
                if(cardValues.get(matchingHands[i][0]) < cardValues.get(matchingHands[j][0])) {
                    winningHand = matchingHands[j];
                }

            }
        }

        //return winningHand;
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
