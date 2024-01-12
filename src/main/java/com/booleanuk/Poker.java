package com.booleanuk;

import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

public class Poker {
    HashMap<String, Integer> letterValues;
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] emptyArray = new String[0];
        initializeValues();
        if(firstHand.length == 0 || secondHand.length==0) return emptyArray;

        if(firstHand[0].equals(firstHand[1]) && !secondHand[0].equals(secondHand[1]))
            return firstHand;
        else if(!firstHand[0].equals(firstHand[1]) && secondHand[0].equals(secondHand[1]))
            return secondHand;
        else if (firstHand[0].equals(firstHand[1]))
        {
            if(letterValues.get(firstHand[0]) > letterValues.get(secondHand[0])) return firstHand;
            else return secondHand;
        }

            return emptyArray;
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] emptyArray = new String[0];
        String[] prevWinner;
        String[] newWinner;

        prevWinner = winningPair(hands[0], hands[1]);

        for(int i = 1; i < hands.length-2; i++)
        {
            newWinner = winningPair(hands[i], hands[i+1]);
            prevWinner = winningPair(prevWinner, newWinner);
        }

        return (prevWinner.length != 0) ? prevWinner : emptyArray;


    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate

        // Initialize the values of the Strings in a HashMap
        this.initializeValues();

        // Initialize the winner as an empty List
        List<String> winner = Arrays.asList(hands[0]);
        String duplicate = "";
        int iterations = 1;

        // Create a List for temporary storage
        List<String> compare;
        String dupCompare = "";
        int iterCompare = 1;

        // Set the first to be winner for comparisons
        for(int i = 0; i < winner.size(); i++)
        {
            if(i == 0) duplicate = winner.get(0);   // Set first card to duplicate
            else if(winner.get(i).equals(duplicate))    // If next card is same as the duplicate value
                iterations += 1;    // Increase amount of times it is found
            // If card is equal to not duplicate, but the previous card...
            else if(winner.get(i).equals(winner.get(i-1)) && winner.get(i).equals(duplicate)) {
                duplicate = winner.get(i);  // Current (and previous) is now duplicate
                iterations = 2;
            }
        }

        // Set hand in values for comparison
        for(int j = 1; j < hands.length; j++) {
            compare = Arrays.asList(hands[j]);  // Make the current Array as a List
            for (int i = 0; i < hands[j].length; i++) {
                if (i == 0) dupCompare = hands[j][i];   // Set first card as the duplicate
                else if (hands[j][i].equals(dupCompare))
                    iterCompare += 1;   // Increase iterations of duplicate
                else if (hands[j][i].equals(hands[j][i-1]) && hands[j][i].equals(dupCompare)) {
                    dupCompare = hands[j][i];   // Set new duplicate
                    iterCompare = 2;    // Iterations is two
                }
            }
            if(iterCompare > iterations)    // If previous hand is greater
            {
                // Set winner to be current hand
                winner = compare;
                duplicate = dupCompare;
                iterations = iterCompare;
                // Otherwise if the iterations are more than 1 and value exists in HashMap
            }   else if(iterCompare > 1 && letterValues.get(dupCompare) != null)
            {
                // If value of current pair is greater, set it as winner
                if(letterValues.get(dupCompare) > letterValues.get(duplicate)) {
                    winner = compare;
                    duplicate = dupCompare;
                    iterations = iterCompare;
                }
            }
            iterCompare = 1;
        }

        String[] returnWinner= winner.toArray(new String[winner.size()]);

        // If neither hand has a pair, return an empty array
        return (iterations < 2) ? new String[0] : returnWinner;
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }

    public void initializeValues()
    {
        this.letterValues = new HashMap<>();

        this.letterValues.put("2", 2);
        this.letterValues.put("3", 3);
        this.letterValues.put("4", 4);
        this.letterValues.put("5", 5);
        this.letterValues.put("6", 6);
        this.letterValues.put("7", 7);
        this.letterValues.put("8", 8);
        this.letterValues.put("9", 9);
        this.letterValues.put("10", 10);
        this.letterValues.put("J", 11);
        this.letterValues.put("Q", 12);
        this.letterValues.put("K", 13);
        this.letterValues.put("A", 14);
    }
}
