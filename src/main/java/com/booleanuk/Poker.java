package com.booleanuk;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.*;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);

        int[] firstPair = {map.get(firstHand[0]), map.get(firstHand[1])};
        int[] secondPair = {map.get(secondHand[0]), map.get(secondHand[1])};

        Arrays.sort(firstPair);
        Arrays.sort(secondPair);

        if (firstPair[0] == firstPair[1] && secondPair[0] == secondPair[1]) { //are both pairs???
            return (firstPair[1] > secondPair[1]) ? firstHand : secondHand; //ternary statement, that checks what is greater between the two values and returns it
        } else if (firstPair[0] == firstPair[1]) { //does firsthand have pairs?
            return firstHand;
        } else if (secondPair[0] == secondPair[1]) {//does secondhand have pairs?
            return secondHand;
        }

        return new String[0];
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);


            String[] winner = new String[0];
            int highestPairValue = 0;

            for (String[] hand : hands) {
                int[] pair = {map.get(hand[0]), map.get(hand[1])};
                Arrays.sort(pair);

                if (pair[0] == pair[1] && pair[1] > highestPairValue) {
                    highestPairValue = pair[1];
                    winner = hand;
                }
            }

            return winner;

    }




    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {

            HashMap<String, Integer> map = new HashMap<>();
            map.put("2", 2);
            map.put("3", 3);
            map.put("4", 4);
            map.put("5", 5);
            map.put("6", 6);
            map.put("7", 7);
            map.put("8", 8);
            map.put("9", 9);
            map.put("10", 10);
            map.put("J", 11);
            map.put("Q", 12);
            map.put("K", 13);
            map.put("A", 14);

            String[] winner = new String[0];
            int highestPairValue = 0;
            int highestThreeOfAKindValue = 0;

            for (String[] hand : hands) {
                int[] cardValues = new int[hand.length];
                for (int i = 0; i < hand.length; i++) {
                    cardValues[i] = map.get(hand[i]);
                }

                Arrays.sort(cardValues);

                if (hand.length == 2) {
                    if (cardValues[0] == cardValues[1] && cardValues[1] > highestPairValue) {
                        highestPairValue = cardValues[1];
                        winner = hand;
                    }
                } else if (hand.length == 3) {
                    if (cardValues[0] == cardValues[1] && cardValues[1] == cardValues[2] && cardValues[2] > highestThreeOfAKindValue) {
                        highestThreeOfAKindValue = cardValues[2];
                        winner = hand;
                    }
                    else if (cardValues[0] == cardValues[1] && cardValues[1] > highestPairValue) {
                        highestPairValue = cardValues[1];
                        winner = hand;
                    } else if (cardValues[1] == cardValues[2] && cardValues[2] > highestPairValue) {
                        highestPairValue = cardValues[2];
                        winner = hand;
                    }
                }
            }

            return winner;

    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}

