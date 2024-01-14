package com.booleanuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Poker {
    // Core
    HashMap<String,Integer> cardValue = new HashMap<>();
    boolean pair;
    boolean threeOfAKind;
    boolean fourOfAKind;
    boolean fullHouse;


    public Poker(){
        cardValue.put("2",2);
        cardValue.put("3",3);
        cardValue.put("4",4);
        cardValue.put("5",5);
        cardValue.put("6",6);
        cardValue.put("7",7);
        cardValue.put("8",8);
        cardValue.put("9",9);
        cardValue.put("10",10);
        cardValue.put("J",11);
        cardValue.put("Q",12);
        cardValue.put("K",13);
        cardValue.put("A",14);

        pair = false;
        threeOfAKind = false;
        fourOfAKind = false;
        fullHouse = false;
    }

    public boolean isPair(String[] hand){
        int i = 0;
        return hand[i].equals(hand[i + 1]);
    }

    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        int totalvalue1 = 0;
        int totalvalue2 = 0;
        int index = 0;
        String[] noPair = new String[0];

        if (firstHand == null && secondHand == null){
            return noPair;
        }else if (firstHand == null && secondHand != null){
            return secondHand;
        }else if (firstHand != null && secondHand == null){
            return firstHand;
        }

        if (isPair(firstHand) && isPair(secondHand)) {
            for (String string : firstHand) {
                totalvalue1 += cardValue.get(string);
            }
            for (String string : secondHand) {
                totalvalue2 += cardValue.get(string);
            }
            if (totalvalue1 > totalvalue2){
                return firstHand;
            }
            else{
                return secondHand;
            }
        }

        else if (isPair(firstHand) && !isPair(secondHand)) {
            return firstHand;
        }

        else if (isPair(secondHand) && !isPair(firstHand)) {
            return secondHand;
        }

        return noPair;

        /*
        else if (!isPair(firstHand) && !isPair(secondHand)){
            for (String string : firstHand) {
                totalvalue1 += cardValue.get(string);
            }
            for (String string : secondHand) {
                totalvalue2 += cardValue.get(string);
            }
        }
        if (totalvalue1 > totalvalue2){
            return firstHand;
        }
        else{
            return secondHand;
        }

         */
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String [] winningHand = hands[1];
        String [] currentHand;

        for (String[] hand : hands) {
            if (isPair(hand)) {
                currentHand = hand;
                winningHand = winningPair(winningHand, currentHand);
            }
        }
        if (isPair(winningHand)){
            return winningHand;
        }
        return new String[]{};
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
