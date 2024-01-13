package com.booleanuk;

import java.util.ArrayList;
import java.util.Arrays;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        int change = 0;
        int change2 = 0;
        ArrayList<Integer> intFirstHand = new ArrayList<>();
        ArrayList<Integer> intSecondHand = new ArrayList<>();
        for (int i = 0; i<secondHand.length; i++){

            if (secondHand[i].equals("A")) {
                change2= 14;
            }else if (secondHand[i].equals("K")) {
                change2= 13;
            }else if (secondHand[i].equals("Q")) {
                change2= 12;
            }else if (secondHand[i].equals("J")) {
                change2= 11;
            }else{
                change2 = Integer.parseInt(secondHand[i]);
            }
            intSecondHand.add(change2);
        }
        for (int i = 0; i<firstHand.length; i++){
            //String AGE_AS_STRING = Integer.toString(age);

            if (firstHand[i].equals("A")){
                change= 14;
            } else if (firstHand[i].equals("K")) {
                change= 13;
            }else if (firstHand[i].equals("Q")) {
                change= 12;
            }else if (firstHand[i].equals("J")) {
                change= 11;
            }else {
                change = Integer.parseInt(firstHand[i]);

            }
            intFirstHand.add(change);

        }
        System.out.println(Arrays.asList(firstHand));
        System.out.println(Arrays.asList(intFirstHand));
        System.out.println();
        System.out.println();
        System.out.println(Arrays.asList(secondHand));
        System.out.println(Arrays.asList(intSecondHand));

        if (intFirstHand.get(0).equals(intFirstHand.get(1)) && intSecondHand.get(0).equals(intSecondHand.get(1))){
                if (intFirstHand.get(0)>intSecondHand.get(0)){
                    return firstHand;
                }else{
                    return secondHand;
                }
        }else if (intFirstHand.get(0).equals(intFirstHand.get(1)) && !intSecondHand.get(0).equals(intSecondHand.get(1))){
            return firstHand;
        }else if (!intFirstHand.get(0).equals(intFirstHand.get(1)) && intSecondHand.get(0).equals(intSecondHand.get(1))){
            return secondHand;
        }


        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        return new String[]{};
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        String[] winningPair = new String[]{};
        int highestPairValue = 0;

        for (String[] hand : hands) {
            ArrayList<Integer> intHand = new ArrayList<>();

            // Convert card values to integers
            for (String card : hand) {
                int cardValue = getCardValue(card);
                intHand.add(cardValue);
            }

            // Check if the hand is a pair and if it's the highest pair so far
            if (intHand.get(0).equals(intHand.get(1))) {
                int pairValue = intHand.get(0);
                if (pairValue > highestPairValue) {
                    highestPairValue = pairValue;
                    winningPair = hand;
                }
            }
        }

        return winningPair;
    }

    private int getCardValue(String card) {
        switch (card) {
            case "A": return 14;
            case "K": return 13;
            case "Q": return 12;
            case "J": return 11;
            default:  return Integer.parseInt(card);
        }
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
