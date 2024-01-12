package com.booleanuk;

import java.util.ArrayList;
import java.util.Arrays;

public class Poker {
    private final String[] cardPriorityOrder = {
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "J",
            "Q",
            "K",
            "A"
    };

    private String[] findPair(String[] hand) {
        for (int i = 0; i < hand.length; i++) {
            for (int j = 0; j < hand.length; j++) {
                if (i == j) continue;
                if (hand[i].equals(hand[j])) {
                    return hand;
                }
            }
        }
        return new String[0];
    }

    private String[] highestPair(String[][] hands) {
        ArrayList<String[]> _potentialHands = new ArrayList<>();

        for (String[] hand : hands) {
            String[] _pair = findPair(hand);
            if (_pair.length > 0)
                _potentialHands.add(hand);
        }

        ArrayList<String[]> _threeOfAKind = new ArrayList<>();
        ArrayList<String[]> _pairs = new ArrayList<>();

        for (String[] handPairs : _potentialHands) {
            String _cardToCompare = handPairs[0];
            boolean _isTOAK = handPairs.length > 2;

            for (String card : handPairs) {
                if (!_cardToCompare.equals(card)) {
                    _isTOAK = false;
                    break;
                }
            }

            if (_isTOAK) {
                System.out.println(Arrays.toString(handPairs));
                _threeOfAKind.add(handPairs);
            }
            else
                _pairs.add(handPairs);
        }

        return getWinningHandOnPairs(_threeOfAKind.isEmpty() ? _pairs : _threeOfAKind);
    }

    private String[] getWinningHandOnPairs(ArrayList<String[]> pairs) {
        int _highestScore = 0;
        String[] _winningHand = new String[0];

        for (String[] hand : pairs) {
            int _score = getHandScore(hand);
            if (_score > _highestScore) {
                _highestScore = _score;
                _winningHand = hand;
            }
        }

        return _winningHand;
    }

    private int getHandScore(String[] hand) {
        int _outScore = 0;
        for (String card : hand) {
            for (int i = 0; i < cardPriorityOrder.length; i++)
                if (cardPriorityOrder[i].equals(card))
                    _outScore += i;
        }
        return _outScore;
    }

    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        return highestPair(new String[][]{ firstHand, secondHand });
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        return highestPair(hands);
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        return highestPair(hands);
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
