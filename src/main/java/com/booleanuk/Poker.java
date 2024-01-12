package com.booleanuk;

public class Poker {
    String[] ranks;
    int[] values;

    public Poker() {
        this.ranks = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        this.values = new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14};
    }

    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        if (!hasPair(firstHand) && !hasPair(secondHand)) {
            return new String[]{};
        } else if (!hasPair(firstHand)) {
            return secondHand;
        } else if (!hasPair(secondHand)) {
            return firstHand;
        }

        int score1 = calculateScore(firstHand);
        int score2 = calculateScore(secondHand);

        if (score1 == score2) {
            return new String[]{};
        }
        return (score1 > score2 ? firstHand : secondHand);
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

    private int calculateScore(String[] hand) {
        int index = -1;
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i].equals(hand[0])) {
                // Should always be a pair
                index = i;
            }
        }
        return values[index];
    }

    private boolean hasPair(String[] hand) {
        int len = hand.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (hand[i].equals(hand[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
