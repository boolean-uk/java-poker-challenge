package com.booleanuk;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        //Task:
        //Given two pairs of cards, calculate the winning pair. The method
        // winningPair() should accept two arrays with two cards in each, and
        // return the highest pair found as the winning pair. Only pairs can win,
        // so if neither hand contains a pair then an empty array should be returned.
        // Assume that there will be no draws (ie the two pairs will be different to
        // each other).

        //Variables
        String[] output = new String[2];
        String ace = "A";
        boolean firstHandPair = firstHand[0].equals(firstHand[1]);
        boolean secondHandPair = secondHand[0].equals(secondHand[1]);
        boolean firstHandAcePair = firstHand[0].equals(ace) && firstHand[1].equals(ace);
        boolean secondHandAcePair = secondHand[0].equals(ace) && secondHand[1].equals(ace);
        boolean compareValue1 = firstHand[0].compareTo(secondHand[0]) > 0;
        boolean compareValue2 = firstHand[1].compareTo(secondHand[1]) > 0;
        boolean compareValue3 = firstHand[0].compareTo(secondHand[0]) < 0;
        boolean compareValue4 = firstHand[1].compareTo(secondHand[1]) < 0;

        if(compareValue1 && compareValue2){ //Second test case 1 = if second hands' values are greater than second hands' return first hand
            output = firstHand;
        }
        else if(compareValue3 && compareValue4){ //Second test case 2 = if first hands' values are less than second hands' return second hand
            output = firstHand;
        }
        if (!firstHandPair) { //Third test case 1 = if first hand is not a pair, return second hand
            output = secondHand;
        }
        else if (!secondHandPair) { //Third test case 2 = if second hand is not a pair, return first hand
            output = firstHand;
        }
        if (firstHandPair && secondHandPair) {
            if(firstHandAcePair) {
                output = firstHand;
            }
            else if (secondHandAcePair) {
                output = secondHand;
            }
        }
        if (!firstHandPair && !secondHandPair) { //First test = if neither hands are pairs, return empty array
            output = new String[0];
        }
        return output;
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
}
