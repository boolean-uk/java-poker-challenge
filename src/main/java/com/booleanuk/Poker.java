package com.booleanuk;

import java.util.Arrays;
import java.util.HashMap;

public class Poker {
    // Core
    HashMap<String, Integer> values;

    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        //Create a list of best card to the weakest

        this.values = new HashMap<>();
        this.values.put("A", 14);
        this.values.put("K", 13);
        this.values.put("Q", 12);
        this.values.put("J", 11);
        this.values.put("10", 10);
        this.values.put("9", 9);
        this.values.put("8", 8);
        this.values.put("7", 7);
        this.values.put("6", 6);
        this.values.put("5", 5);
        this.values.put("4", 4);
        this.values.put("3", 3);
        this.values.put("2", 2);

        //Find a way to check each hand is a pair
        //Will have 0 in value if no pair (lowest score in poker)
        int firstHandValue = 0;
        int secondHandValue = 0;

        if (firstHand[0].equals(firstHand[1])){
            firstHandValue = values.get(firstHand[0]);
        }
        if (secondHand[0].equals(secondHand[1])){
            secondHandValue = values.get(secondHand[0]);
        }

        //compare the pair to see which hand won
        if (firstHandValue > secondHandValue){
            System.out.println(Arrays.toString(firstHand));
            return firstHand;
        }else if (secondHandValue > firstHandValue) {
            System.out.println(Arrays.toString(secondHand));
            return secondHand;
        }else return new String[]{};


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

    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.winningPair(new String[]{"Q","Q"}, new String[]{"K","J"});
        poker.winningPair(new String[]{"Q","Q"}, new String[]{"K","K"});

    }
}
