package com.booleanuk;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        PairAndScore firstHandPairAndScore = new PairAndScore();
        firstHandPairAndScore.calculatePairAndScore(firstHand);

        PairAndScore secondHandPairAndScore = new PairAndScore();
        secondHandPairAndScore.calculatePairAndScore(secondHand);

        boolean firstHandIsWinner = false;

        //firstHand has pair and secondHand does not
        if(firstHandPairAndScore.isPair() && !secondHandPairAndScore.isPair()) {
            firstHandIsWinner = true;
        }

        //Both hands have a pair
        else if(firstHandPairAndScore.isPair() && secondHandPairAndScore.isPair()) {
            if(firstHandPairAndScore.getScore() > secondHandPairAndScore.getScore()) {
                firstHandIsWinner = true;
            }
        }

        //No hands have a pair
        else if(!firstHandPairAndScore.isPair() && !secondHandPairAndScore.isPair()) {
            return new String[0];
        }

        if(firstHandIsWinner) return firstHand;

        return secondHand;
    }


    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        String[] winnerPair = new String[0];
        String[] currentHighestPair;

        //If there are more than two hands
        if(hands.length > 2) {
            for (int i = 0; i < hands.length; i += 2) {
                currentHighestPair = winningPair(hands[i], hands[i + 1]);
                winnerPair = winningPair(winnerPair, currentHighestPair);
            }
        }
        //If there are only two hands
        else {
            winnerPair = winningPair(hands[0], hands[1]);
        }

        return winnerPair;
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
