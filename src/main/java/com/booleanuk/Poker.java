package com.booleanuk;

import java.util.Arrays;
import java.util.HashMap;

public class Poker {

    public HashMap<String, Integer> map = new HashMap<>();

    public Poker(){
        this.map = makeMap();
    }

    public HashMap<String, Integer> makeMap() {
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10",10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);

        return map;
    }



    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        String[] wp = new String[]{};

        if (truePair(firstHand) && truePair(secondHand)){
            if ((this.map.get(firstHand[0])) > (this.map.get(secondHand[0]))){
                wp = firstHand;
            }else{
                wp = secondHand;
            }
        } else if (truePair(firstHand) && !truePair(secondHand)) {
            wp = firstHand;
        } else if (!truePair(firstHand) && truePair(secondHand)) {
            wp = secondHand;
        }

        return wp;
    }

    private boolean truePair(String[] firstHand) {
        return firstHand[0].equalsIgnoreCase(firstHand[1]);
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

    public static void main(String[] args){
        Poker poker = new Poker();

        System.out.println(poker.map);
    }


}
