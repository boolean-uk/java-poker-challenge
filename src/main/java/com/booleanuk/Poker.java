package com.booleanuk;

import java.sql.Array;
import java.util.HashMap;

public class Poker {
    // Core
    HashMap<String,Integer> cards;

    public Poker(){
        this.cards = new HashMap<>();
        this.cards.put("A", 14);
        this.cards.put("K", 13);
        this.cards.put("Q", 12);
        this.cards.put("J", 11);
        this.cards.put("10", 10);
        this.cards.put("9", 9);
        this.cards.put("8", 8);
        this.cards.put("7", 7);
        this.cards.put("6", 6);
        this.cards.put("5", 5);
        this.cards.put("4", 4);
        this.cards.put("3", 3);
        this.cards.put("2", 2);

    }
    public String[] winningPair(String[] firstHand, String[] secondHand) {

        String[] winner = new String[2];
        //Check if the arrays has values and apply value to card
        boolean firstIsPair = false;
        boolean secondIsPair = false;
        int firstMaxValue = 0;
        int secondMaxValue = 0;

        //Firsthand
        int firFirstCard = cards.get(firstHand[0]);
        int firSecondCard = cards.get(firstHand[1]);
        if (firFirstCard == firSecondCard) {
            firstIsPair = true;
        }
        firstMaxValue = firFirstCard + firSecondCard;

        //Secondhand
        int secFirstCard = cards.get(secondHand[0]);
        int secSecondCard = cards.get(secondHand[1]);
        if (secFirstCard == secSecondCard) {
            secondIsPair = true;
        }
        secondMaxValue = secFirstCard + secSecondCard;


        if (firstIsPair == true & firstMaxValue > secondMaxValue) {
            winner = firstHand;
        } else if (secondIsPair == true & firstMaxValue < secondMaxValue) {
            winner = secondHand;
        } else if (firstIsPair == false & secondIsPair == false) {
            return new String[]{};
        }

        return winner;
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
