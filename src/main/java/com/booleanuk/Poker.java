package com.booleanuk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;



public class Poker {

    public HashMap<String, Integer> pokerValues;
    String[] strings = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    Integer[] values = {14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    public Poker() {
        pokerValues = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            pokerValues.put(strings[i], values[i]);
        }
    }

    public boolean pair(String[] hand) {
        if (hand.length == 2 || hand.length == 3) {
            return hand[0].equalsIgnoreCase(hand[1]);
        } else if (hand.length == 3){
            return (hand[1].equalsIgnoreCase(hand[2]) ||  hand[1].equalsIgnoreCase(hand[3]));
        }
        return false;
    }

    public String[] winningPair(String[] firstHand, String[] secondHand) {

        String[] winningPair = new String[]{};

        if (pair(firstHand) && !pair(secondHand)) {
            return firstHand;
        } else if (!pair(firstHand) && pair(secondHand)) {
            return secondHand;
        } else if (pair(firstHand) && pair(secondHand)) {
            if (pokerValues.get(firstHand[0]) > pokerValues.get(secondHand[0])) {
                return firstHand;
            } else
                return secondHand;
        } else if (!pair(firstHand) && !pair(secondHand)) {
            return new String[0];
        }
        return winningPair;
    }
    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winningPair = new String[]{};
        ArrayList<Integer> score = new ArrayList<>();

        for (String[] hand : hands) {
            if (pair(hand)) {
                score.add(pokerValues.get(hand[0]));
            } else if (!pair(hand)) {
                score.add(0);
            }
        }

        int highScore = score.get(0);
        int index = 0;

        for (int i = 0; i < score.size(); i++) {
            if (highScore < score.get(i)) {
                highScore = score.get(i);
                winningPair = hands[i];
            }
        }
        return winningPair;
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winningHand = new String[]{};
        int highScore = 0;

        for (String[] hand : hands) {
            if (pair(hand)) {
                int currentScore = pokerValues.get(hand[0]);
                if (hand.length == 3) {
                    currentScore += pokerValues.get(hand[2])*3;
                }
                if (currentScore > highScore) {
                    highScore = currentScore;
                    winningHand = hand;
                }
            }
        }
        return winningHand;
    }
        // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }

}
