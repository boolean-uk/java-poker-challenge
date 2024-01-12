package com.booleanuk;

import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;
import static java.util.Collections.max;

public class Poker {

    HashMap<String, Integer> cards = new HashMap<String, Integer>() {{
        put("1", 1);
        put("2", 2);
        put("3", 3);
        put("4", 4);
        put("5", 5);
        put("6", 6);
        put("7", 7);
        put("8", 8);
        put("9", 9);
        put("10", 10);
        put("J", 11);
        put("Q", 12);
        put("K", 13);
        put("A", 14);
    }};
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        int highestPairFirstHand = getHighestPairFromHand(firstHand);
        int highestPairSecondHand = getHighestPairFromHand(secondHand);

        if(highestPairFirstHand > highestPairSecondHand) {
            return firstHand;
        } else if(highestPairFirstHand < highestPairSecondHand) {
            return secondHand;
        } else {
            return new String[] {};
        }
    }

    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.winningPair(new String[] {"3", "6", "5", "7", "9", "7"}, new String[] {"2", "5"} );
    }

    public int getHighestPairFromHand(String[] hand) {
        HashMap<String, Integer> cardCountMap = new HashMap<>();
        for(String card : hand) {
            cardCountMap.put(card, cardCountMap.getOrDefault(card, 0) + 1);
        }
        int highestPair = -1;
        for(Map.Entry<String, Integer> entry : cardCountMap.entrySet()) {
            String card = entry.getKey();
            int value = entry.getValue();

            if(value == 2) {
                int cardValue = cards.get(card);

                if (cardValue > highestPair) {
                    highestPair = cardValue;
                }
            }
        }
        return highestPair;
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        int[] handArray = new int[hands.length];
        for(int i = 0; i < hands.length; i++) {
            handArray[i] = getHighestPairFromHand(hands[i]);
        }
        int maxAt = 0;
        for (int i = 0; i < handArray.length; i++) {
            if(handArray[maxAt] < handArray[i]) {
                maxAt = i;
            }
        }
        if(maxAt != 0) {
            return hands[maxAt];
        } else {
            return new String[]{};
        }
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        int[] handArray = new int[hands.length];
        for(int i = 0; i < hands.length; i++) {
            handArray[i] = getHighestThreeFromHand(hands[i]);
        }
        int maxAt = 0;
        for (int i = 0; i < handArray.length; i++) {
            if(handArray[maxAt] < handArray[i]) {
                maxAt = i;
            }
        }
        if(maxAt != 0) {
            return hands[maxAt];
        } else {
            String[] highestPair = new String[] {"0","0"};
            for(String[] hand : hands) {
                if(getHighestPairThreeFromHand(hand) > parseInt((highestPair[0]))) {
                    highestPair = hand;
                }
            }
            if(highestPair[0].equals("0")) {
                return new String[]{};
            } else {
                return highestPair;
            }

        }
    }

    public int getHighestThreeFromHand(String[] hand) {
        HashMap<String, Integer> cardCountMap = new HashMap<>();
        for(String card : hand) {
            cardCountMap.put(card, cardCountMap.getOrDefault(card, 0) + 1);
        }
        int highestPair = -1;
        for(Map.Entry<String, Integer> entry : cardCountMap.entrySet()) {
            String card = entry.getKey();
            int value = entry.getValue();

            if(value == 3) {
                int cardValue = cards.get(card);

                if (cardValue > highestPair) {
                    highestPair = cardValue;
                }
            }
        }
        return highestPair;
    }

    public int getHighestPairThreeFromHand(String[] hand) {
        HashMap<String, Integer> cardCountMap = new HashMap<>();
        for(String card : hand) {
            cardCountMap.put(card, cardCountMap.getOrDefault(card, 0) + 1);
        }
        int highestPair = -1;
        for(Map.Entry<String, Integer> entry : cardCountMap.entrySet()) {
            String card = entry.getKey();
            int value = entry.getValue();

            if(value == 2) {
                int cardValue = cards.get(card);

                if (cardValue > highestPair) {
                    highestPair = cardValue;
                }
            }
        }
        return highestPair;
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
