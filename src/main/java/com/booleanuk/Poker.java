package com.booleanuk;

import java.util.Arrays;
import java.util.HashMap;

public class Poker {
    HashMap<String, Integer> deck;
    String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public Poker(){
        deck = new HashMap<>();
        for (int i = 0; i < 13; ++i) {
            deck.put(cards[i], + i);
        }
    }
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        boolean handOne = firstHand[0].equals(firstHand[1]);
        boolean handTwo = secondHand[0].equals(secondHand[1]);

        if (handOne && handTwo) {
            if (deck.get(firstHand[0]) < deck.get(secondHand[0])) {
                System.out.println(deck.get(secondHand[0]));
                return secondHand;
            } else {
                return firstHand;
            }
        } else if (handOne) {
            return firstHand;
        } else if (handTwo) {
            return secondHand;
        } else {
            return new String[]{};
        }
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        String[] topPair = new String[2];
        int maxPairValue = 0;
        for (String[] hand : hands) {
            boolean handCards = hand[0].equals(hand[1]);
            if (handCards) {
                int score = deck.get(hand[0]);
                if (score > maxPairValue) {
                    maxPairValue = score;
                    topPair[0] = hand[0];
                    topPair[1] = hand[1];
                }
            }
        }
        return maxPairValue > 0 ? topPair : new String[]{};
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] topPairThree = new String[3];
        String[] topPairTwo = new String[2];
        int maxPairValueThree = 0;
        int maxPairValueTwo = 0;
        for (String[] hand : hands)
            for (int i = 0; i < hand.length; ++i){
                boolean handCardsThree = hand[0].equals(hand[i]);
                boolean handCardsTwo = hand[0].equals(hand[i]);
                if (handCardsThree){
                    int score = deck.get(hand[0]);
                    if (score > maxPairValueThree) {
                        maxPairValueThree = score;
                        topPairThree[0] = hand[0];
                        topPairThree[1] = hand[1];
                        topPairThree[2] = hand[2];
                    }
                }
                else if (handCardsTwo){
                    int score = deck.get(hand[0]);
                    if (score > maxPairValueTwo) {
                        maxPairValueTwo = score;
                        topPairTwo[0] = hand[0];
                        topPairTwo[1] = hand[1];
                    }
                }
            }
        if (maxPairValueThree > 0){
            return topPairThree;
        } else if (maxPairValueTwo > 0) {
            return topPairTwo;
        } else {
            return new String[]{};
        }
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
