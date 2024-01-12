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

        int[] firstPair = {map.get(hands[0][0]), map.get(hands[0][1])};
        int[] secondPair = {map.get(hands[1][0]), map.get(hands[1][1])};

        Arrays.sort(firstPair);
        Arrays.sort(secondPair);

        String[] pair1 = {hands[0][0], hands[0][1]};
        String[] pair2 = {hands[1][0], hands[1][1]};

        if (firstPair[0] == firstPair[1] && secondPair[0] == secondPair[1]) { //are both pairs???
            return (map.get(pair1[0]) > map.get(pair2[0])) ? pair1 : pair2; //ternary statement, that checks what is greater between the two values and returns it
        } else if (firstPair[0] == firstPair[1]) { //does firsthand have pairs?
            return pair1;
        } else if (secondPair[0] == secondPair[1]) {//does secondhand have pairs?
            return pair2;
        }

        return new String[0];

        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

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

