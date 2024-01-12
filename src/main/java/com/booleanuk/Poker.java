package com.booleanuk;

import java.util.HashMap;
import java.util.Map;

public class Poker {
    // Core
    private int getPairValue(String[] hand) {
        if (hand.length==3) {
            if (hand[0].equals(hand[1]) & hand[0].equals(hand[2])) {
                switch (hand[1]) {
                    case "2":
                        return 15;
                    case "3":
                        return 16;
                    case "4":
                        return 17;
                    case "5":
                        return 18;
                    case "6":
                        return 19;
                    case "7":
                        return 20;
                    case "8":
                        return 21;
                    case "9":
                        return 22;
                    case "10":
                        return 23;
                    case "J":
                        return 24;
                    case "Q":
                        return 25;
                    case "K":
                        return 26;
                    case "A":
                        return 27;
                    default:
                        return 0;
                }
            }
        }
        if (hand[0].equals(hand[1])){
            switch (hand[1]) {
                case "2":
                    return 2;
                case "3":
                    return 3;
                case "4":
                    return 4;
                case "5":
                    return 5;
                case "6":
                    return 6;
                case "7":
                    return 7;
                case "8":
                    return 8;
                case "9":
                    return 9;
                case "10":
                    return 10;
                case "J":
                    return 11;
                case "Q":
                    return 12;
                case "K":
                    return 13;
                case "A":
                    return 14;
                default:
                    return 0;
            }
        }
            return 0;
        }




        public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
            int firstPairRank = getPairValue(firstHand);
            int secondPairRank = getPairValue(secondHand);

            if (firstPairRank > secondPairRank) {
                return firstHand;
            }
            if (secondPairRank > firstPairRank){
                return secondHand;
            }
            else return new String[]{};

    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        int winner=0;
        String[] winnerhand= new String[]{"",""};
        for (int i = 0; i < hands.length; i++) {
            for (int j = 0; j < hands[i].length; j++) {
                if (winner<getPairValue(hands[i])) {
                    winner=getPairValue(hands[i]);
                    winnerhand=hands[i];
                }
            }
        }
        if (winner != 0) return winnerhand;
        else return new String[]{};
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        int winner=0;
        String[] winnerhand= new String[]{"",""};
        for (int i = 0; i < hands.length; i++) {
            for (int j = 0; j < hands[i].length; j++) {
                if (winner<getPairValue(hands[i])) {
                    winner=getPairValue(hands[i]);
                    winnerhand=hands[i];
                }
            }
        }
        if (winner != 0) return winnerhand;
        else return new String[]{};
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate

    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
