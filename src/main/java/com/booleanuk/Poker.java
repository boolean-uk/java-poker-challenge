package com.booleanuk;

import java.util.Arrays;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        int value1 = CardValueConverter.convertToValue(firstHand[0]);
        int value2 = CardValueConverter.convertToValue(secondHand[0]);

        // Check for a pair in each hand
        boolean hasPair1 = firstHand[0].equals(firstHand[1]);
        boolean hasPair2 = secondHand[0].equals(secondHand[1]);

        if (!hasPair1 && !hasPair2) {
            return new String[]{};
        } else if (hasPair1 && !hasPair2) {
            return firstHand;
        } else if (!hasPair1 && hasPair2) {
            return secondHand;
        } else {
            // Both hands have pairs, return the one with the higher value
            return (value1 > value2) ? firstHand : secondHand;
        }
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        String[] winningPair = new String[]{};

        for (String[] hand : hands) {
            if (hand.length == 2) {
                // Check for a pair in each hand
                boolean hasPair = hand[0].equals(hand[1]);

                if (hasPair && (winningPair.length == 0 || CardValueConverter.convertToValue(hand[0]) > CardValueConverter.convertToValue(winningPair[0]))) {
                    winningPair = hand;
                }
            }
        }

        return winningPair;
    }


    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        String[] winningHand = new String[]{};

        for (String[] hand : hands) {
            if (hand.length == 3) {
                // Check for Three of a Kind
                boolean isThreeOfAKind = Arrays.stream(hand).allMatch(card -> card.equals(hand[0]));

                if (isThreeOfAKind && (winningHand.length == 0 || !allMatch(winningHand, winningHand[0]))) {
                    winningHand = hand;
                }
            } else if (hand.length == 2) {
                // Pair in a three-card hand can win
                if (winningHand.length == 0 || hand[0].equals(hand[1]) || !allMatch(winningHand, winningHand[0])) {
                    winningHand = hand;
                }
            }
        }

        return winningHand;
    }

    // Helper method to check if all elements in an array match a given value
    private boolean allMatch(String[] array, String value) {
        for (String element : array) {
            if (!element.equals(value)) {
                return false;
            }
        }
        return true;
    }


    // Extension 3
    public String extensionThreeMethods(String[] hand1, String[] hand2) {
        if (isFourOfAKind(hand1) && isFourOfAKind(hand2)) {
            return compareFourOfAKind(hand1, hand2);
        } else if (isFullHouse(hand1) && isFullHouse(hand2)) {
            return compareFullHouse(hand1, hand2);
        } else if (isThreeOfAKind(hand1) && isThreeOfAKind(hand2)) {
            return compareThreeOfAKind(hand1, hand2);
        } else if (isTwoPairs(hand1) && isTwoPairs(hand2)) {
            return compareTwoPairs(hand1, hand2);
        } else if (isOnePair(hand1) && isOnePair(hand2)) {
            return compareOnePair(hand1, hand2);
        } else {
            return "No winner";
        }
    }

    // Additional methods for Extension 3 can be added here

    private boolean isFourOfAKind(String[] hand) {
        return false;
    }

    private String compareFourOfAKind(String[] hand1, String[] hand2) {
        return "Winner";
    }

    private boolean isFullHouse(String[] hand) {
        return false;
    }

    private String compareFullHouse(String[] hand1, String[] hand2) {
        return "Winner";
    }

    private boolean isThreeOfAKind(String[] hand) {
        return false;
    }

    private String compareThreeOfAKind(String[] hand1, String[] hand2) {
        return "Winner";
    }

    private boolean isTwoPairs(String[] hand) {
        return false;
    }

    private String compareTwoPairs(String[] hand1, String[] hand2) {
        return "Winner";
    }

    private boolean isOnePair(String[] hand) {
        return false;
    }

    private String compareOnePair(String[] hand1, String[] hand2) {
        return "Winner";
    }
}


class CardValueConverter {
    // Convert card values to integers for comparison
    public static int convertToValue(String card) {
        switch (card) {
            case "A":
                return 14;
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            default:
                return Integer.parseInt(card);
        }
    }
}