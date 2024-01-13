package com.booleanuk;

import java.util.ArrayList;
import java.util.HashMap;


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
        return hand[0].equalsIgnoreCase(hand[1]);
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
        int highScore = 0;
        int indexScore = 0;

        for (String[] hand : hands) {
            if (pair(hand)) {
                score.add(pokerValues.get(hand[0]) * 10);
            } else if (!pair(hand)) {
                int score1 = pokerValues.get(hand[0]);
                int score2 = pokerValues.get(hand[1]);
                score.add(Math.max(score1, score2));
            }
        }

        for (int i = 1; i < score.size(); i++) {
            if (score.get(i) > highScore) {
                highScore = score.get(i);
                indexScore = i;
            }
        }
        winningPair = hands[indexScore];
        return winningPair;
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
