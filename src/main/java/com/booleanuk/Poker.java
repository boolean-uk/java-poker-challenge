package com.booleanuk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class Poker {
    HashMap<String, Integer> bindings;
    public Poker(){
        bindings = populateMap();
    }

    public HashMap<String, Integer> populateMap() {
        HashMap<String, Integer> retMap = new HashMap<>();
        retMap.put("0", 0);
        retMap.put("2", 2);
        retMap.put("3", 3);
        retMap.put("4", 4);
        retMap.put("5", 5);
        retMap.put("6", 6);
        retMap.put("7", 7);
        retMap.put("8", 8);
        retMap.put("9", 9);
        retMap.put("10", 10);
        retMap.put("J", 11);
        retMap.put("Q", 12);
        retMap.put("K", 13);
        retMap.put("A", 14);
        return retMap;
    }

    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        boolean firstHandPair = false;
        boolean secondHandPair = false;

        // Check if no cards provided in either hand
        if (firstHand.length == 0 && secondHand.length == 0) {
            return new String[]{};
        }

        // Check to see if either player has a pair
        if (firstHand[0] == firstHand[1]) {
            firstHandPair = true;
        }

        if (secondHand[0] == secondHand[1]) {
            secondHandPair = true;
        }

        // Set winner if only one hand has pair
        if ((firstHandPair && secondHandPair) && (this.bindings.get(firstHand[0]) == this.bindings.get(secondHand[0]))) {
            return new String[]{};
        // Compare from bindings if both hands has pair
        } else if (firstHandPair && secondHandPair) {
            return bindings.get(firstHand[0]) > bindings.get(secondHand[0]) ? new String[]{firstHand[0], firstHand[0]} : new String[]{secondHand[0], secondHand[0]};
        // Return firsthand if only pair
        } else if (firstHandPair) {
            return new String[]{firstHand[0], firstHand[1]};
        // Return secondhand if only pair
        } else if (secondHandPair) {
            return new String[]{secondHand[0], secondHand[1]};
        }
        // Return empty if none of above
        return new String[]{};
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] currentWinningHand = new String[]{};
        for (int i = 0; i < hands.length-1; i++) {
            currentWinningHand = winningPair(hands[i], hands[i+1]);
        }

        return currentWinningHand;
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        Stack<String[]> noOfKind = new Stack<>();
        Stack<String[]> twoOfKind = new Stack<>();
        Stack<String[]> threeOfKind = new Stack<>();

        // Check to see how many of each cardinality, thus able to ignore some hands
        for(String[] hand : hands) {
            if (typeOfHand(hand) == "noOfKind") {
                noOfKind.push(hand);
            } else if (typeOfHand(hand) == "twoOfKind") {
                twoOfKind.push(hand);
            } else if (typeOfHand(hand) == "threeOfKind") {
                threeOfKind.push(hand);
            } else {
                System.exit(0);
            }
        }

        if (!threeOfKind.isEmpty()) {
            return bestHand(threeOfKind);
        } else if (!twoOfKind.isEmpty()) {
            return bestHand(twoOfKind);
        } else return new String[]{};

    }

    // Helper method for Extension 2 to return what type of hand
    public String typeOfHand(String[] hand) {
        if (hand.length == 2) {
            if (hand[0] == hand[1]) {
                return "twoOfKind";
            }
        } else if (hand.length == 3) {
            if (hand[0] == hand[1] && hand[1] == hand[2]) {
                return "threeOfKind";
            } else if ((hand[0] == hand[1]) || (hand[0] == hand[2]) || (hand[1] == hand[2])) {
                return "twoOfKind";
            } else {
                return "noOfKind";
            }
        }
        return "noOfKind";
    }

    // Helper method to find bestHand when removed redundant hands
    public String[] bestHand(Stack<String[]> relevantHands) {
        String[] currentWinningHand = new String[]{"0", "0", "0"};
        if (relevantHands.peek().length == 3 || relevantHands.peek().length == 2) {
            int size = relevantHands.size();
            for (int i = 0; i < size; i++) {
                String[] tmp = relevantHands.pop();
                int a = bindings.get(tmp[0]);
                int b = bindings.get(currentWinningHand[0]);
                if (a > b) {
                    currentWinningHand = tmp;
                }
            }
        }
        return currentWinningHand;
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
