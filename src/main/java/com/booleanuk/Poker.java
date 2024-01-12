package com.booleanuk;

import java.util.Objects;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        boolean isPair1 = firstHand[0].equals(firstHand[1]);
        boolean isPair2 = secondHand[0].equals(secondHand[1]);

        if (!isPair1 && !isPair2) {
            return new String[]{};
        }

        if (isPair1 && !isPair2) {
            return firstHand;
        } else if (!isPair1) {
            return secondHand;
        }

        int value1 = getLetterValue(firstHand[0]);
        int value2 = getLetterValue(secondHand[0]);

        return (value1 > value2) ? firstHand : secondHand;
    }

    private int getLetterValue(String card) {
        return switch (card) {
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10" -> 10;
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            case "A" -> 14;
            default -> 0;
        };
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        String[] winningPair = null;

        for (String[] hand : hands) {
            if (hand.length == 2 && hand[0].equals(hand[1])) {
                if (winningPair == null || getLetterValue(hand[0]) > getLetterValue(winningPair[0])) {
                    winningPair = hand.clone();
                }
            }
        }

        return Objects.requireNonNullElseGet(winningPair, () -> new String[0]);
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winningHand = null;

        for (String[] hand : hands) {
            if (hand.length == 1 || hand.length == 2 || hand.length == 3) {
                if (isPair(hand) || isThreeOfAKind(hand) || pairWithSingle(hand)) {
                    if (winningHand == null || compareHands(hand, winningHand) > 0) {
                        winningHand = hand.clone();
                    }
                }
            }
        }

        return Objects.requireNonNullElseGet(winningHand, () -> new String[0]);
    }

    private boolean isPair(String[] hand) {
        return hand.length == 2 && hand[0].equals(hand[1]);
    }

    private boolean isThreeOfAKind(String[] hand) {
        return hand.length == 3 && hand[0].equals(hand[1]) && hand[1].equals(hand[2]);
    }

    private boolean pairWithSingle(String[] hand) {
        return hand.length == 3 && hand[0].equals(hand[1]) && !hand[1].equals(hand[2]);
    }

    private int compareHands(String[] hand1, String[] hand2) {
        int value1 = getLetterValue(hand1[0]);
        int value2 = getLetterValue(hand2[0]);

        if (isThreeOfAKind(hand1) && isPair(hand2)) {
            return 1;
        } else if (isPair(hand1) && isThreeOfAKind(hand2)) {
            return -1;
        } else if (isPair(hand1) && isPair(hand2)) {
            return Integer.compare(value1, value2);
        } else if (pairWithSingle(hand1) && pairWithSingle(hand2)) {
            return Integer.compare(value1, value2);
        } else {
            return Integer.compare(value1, value2);
        }
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java

        /*
        If I were to implement a game where all hands have 5 cards I would create more booleans to check for
        the hands, then I would change the for loop to iterate through the hands. Would also need to add more
        statements for comparing the hands.
         */

        return "Replace this method with your own methods and tests";
    }
}
