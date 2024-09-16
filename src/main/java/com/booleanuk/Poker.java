package com.booleanuk;

import static java.lang.Integer.parseInt;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.

        String[] firstHandOriginal = new String[2];
        firstHandOriginal[0] = firstHand[0];
        firstHandOriginal[1] = firstHand[1];

        String[] secondHandOriginal = new String[2];
        secondHandOriginal[0] = secondHand[0];
        secondHandOriginal[1] = secondHand[1];

        int firstPairValue;
        boolean firstHasPair;
        int secondPairValue;
        boolean secondHasPair;

        // Check if hands have face cards and give it number value
        for(int i = 0; i < 2; i++){
            switch (firstHand[i]){
                case "J":
                    firstHand[i] = "11";
                    break;
                case "Q":
                    firstHand[i] = "12";
                    break;
                case "K":
                    firstHand[i] = "13";
                    break;
                case "A":
                    firstHand[i] = "14";
                    break;
            }
            switch (secondHand[i]){
                case "J":
                    secondHand[i] = "11";
                    break;
                case "Q":
                    secondHand[i] = "12";
                    break;
                case "K":
                    secondHand[i] = "13";
                    break;
                case "A":
                    secondHand[i] = "14";
                    break;
            }
        }
        // Find if first hand has pair and what number
        firstHasPair = firstHand[0].equals(firstHand[1]);
        secondHasPair = secondHand[0].equals(secondHand[1]);

        firstPairValue = parseInt(firstHand[0]);
        secondPairValue = parseInt(secondHand[0]);

        int firstHandMax = Math.max(parseInt(firstHand[0]), parseInt(firstHand[1]));
        int secondHandMax = Math.max(parseInt(secondHand[0]), parseInt(secondHand[1]));
        int firstHandMin = Math.min(parseInt(firstHand[0]), parseInt(firstHand[1]));
        int secondHandMin = Math.min(parseInt(secondHand[0]), parseInt(secondHand[1]));

        if (firstHasPair && secondHasPair){
            if(firstPairValue >= secondPairValue){
                return firstHandOriginal;
            } else {
                return secondHandOriginal;
            }
        } else if(firstHasPair){
            return firstHandOriginal;
        } else if(secondHasPair){
            return secondHandOriginal;
        }  else {

            return new String[0];
        }
        /*
            if(firstHandMax == secondHandMax){
                if(firstHandMin >= secondHandMin){
                    return firstHandOriginal;
                } else{
                    return secondHandOriginal;
                }
            } else if(firstHandMax > secondHandMax){
                return firstHandOriginal;
            } else return secondHandOriginal;
        }
*/


        // You can replace the following return value with something appropriate
        //  return new String[]{"Replace me", "with something else"};
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.

        // Started, did not finish
        for(int row = 0; row < hands.length; row++){
            for(int col = 0; col < hands[row].length; col++) {
                hands[row][col] = "";

            }
        }

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
