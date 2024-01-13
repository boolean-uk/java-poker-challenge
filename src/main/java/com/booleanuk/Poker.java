package com.booleanuk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Poker {
    // Core

    public static HashMap<String, Integer> initializeCardValues() {
        HashMap<String, Integer> cardValues = new HashMap<>();

        for (int i = 2; i <= 10; i++) {
            cardValues.put(String.valueOf(i), i);
        }
        cardValues.put("J", 11);
        cardValues.put("Q", 12);
        cardValues.put("K", 13);
        cardValues.put("A", 14);

        return cardValues;
    }

    HashMap<String, Integer> cardValues;
    public Poker(){
        this.cardValues = initializeCardValues();
    }
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // init cards
        int hand1_card1 = this.cardValues.getOrDefault(firstHand[0], 0);
        int hand1_card2 = this.cardValues.getOrDefault(firstHand[1], 0);
        int hand2_card1 = this.cardValues.getOrDefault(secondHand[0], 0);
        int hand2_card2 = this.cardValues.getOrDefault(secondHand[1], 0);


        // if p1 has pair and p2 doesnt have pair --> p1 wins
        if((hand1_card1 == hand1_card2) && (hand2_card1 != hand2_card2)){
            return new String[]{firstHand[0], firstHand[1]};
        }

        // if p2 has pair and p1 doesnt have pair --> p2 wins
        if((hand2_card1 == hand2_card2) && (hand1_card1 != hand1_card2)){
            return new String[]{secondHand[0], secondHand[1]};
        }
        if (hand1_card1 == hand1_card2 && hand2_card1 == hand2_card2) {
            // p1 has higher pair
            if(hand1_card1 > hand2_card2){
                return new String[]{firstHand[0], firstHand[1]};
            }
            //p2 has higher pair
            return new String[]{secondHand[0], secondHand[1]};
        }

        //if nothing returns, its a draw
        return new String[]{};
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        if (hands == null || hands.length == 0 || hands[0].length == 0) {
            return new String[]{};
        }

        String[][] handsWithValues = new String[hands.length][hands[0].length];

        for (int i = 0; i < hands.length; i++) {
            for (int j = 0; j < hands[i].length; j++) {
                int card = this.cardValues.getOrDefault(hands[i][j], 0);
                handsWithValues[i][j] = String.valueOf(card);
            }
        }

        String[] currentHighestPair = null;
        int winningHandIndex = -1;
        int pairCount = 0;
        for (int i = 0; i < handsWithValues.length; i++) {
            // hand has pair

            if (Objects.equals(handsWithValues[i][0], handsWithValues[i][1])) {
                System.out.println("HAND " + i + " HAS A PAIR");
                pairCount++;
                if (currentHighestPair == null ||
                        Integer.parseInt(currentHighestPair[0]) < Integer.parseInt(handsWithValues[i][0])) {
                    currentHighestPair = new String[]{handsWithValues[i][0], handsWithValues[i][1]};
                    winningHandIndex = i;
                }
            }
        }
        if(pairCount == 0){
            return new String[]{};
        }
        System.out.println(winningHandIndex);
        return new String[]{hands[winningHandIndex][0], hands[winningHandIndex][1]};
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        if (hands == null || hands.length == 0) {
            return new String[]{};
        }

        String[][] handsWithValues = new String[hands.length][];
        int winningHandIndex = -1;
        String[] currentHighestPair = null;
        String[] currentThreeOfAKind = null;

        for (int i = 0; i < hands.length; i++) {
            handsWithValues[i] = new String[hands[i].length];
            for (int j = 0; j < hands[i].length; j++) {
                int card = this.cardValues.getOrDefault(hands[i][j], 0);
                handsWithValues[i][j] = String.valueOf(card);
            }
            // Check for three of a kind
            if (handsWithValues[i].length == 3 &&
                    Objects.equals(handsWithValues[i][0], handsWithValues[i][1]) &&
                    Objects.equals(handsWithValues[i][1], handsWithValues[i][2])) {
                System.out.println("HAND " + i + " HAS THREE OF A KIND");
                if (currentThreeOfAKind == null ||
                        Integer.parseInt(currentThreeOfAKind[0]) < Integer.parseInt(handsWithValues[i][0])) {
                    currentThreeOfAKind = new String[]{handsWithValues[i][0], handsWithValues[i][1], handsWithValues[i][2]};
                    winningHandIndex = i;
                }
            }
            // Check for pair in hands that have three cards
            else if (handsWithValues[i].length == 3) {
                if(Objects.equals(handsWithValues[i][0], handsWithValues[i][1])){
                    if (currentHighestPair == null ||
                            Integer.parseInt(currentHighestPair[0]) < Integer.parseInt(handsWithValues[i][0])) {
                        currentHighestPair = new String[]{handsWithValues[i][0], handsWithValues[i][1]};
                        winningHandIndex = i;
                    }
                }
                if(Objects.equals(handsWithValues[i][0], handsWithValues[i][2])){
                    if (currentHighestPair == null ||
                            Integer.parseInt(currentHighestPair[0]) < Integer.parseInt(handsWithValues[i][0])) {
                        currentHighestPair = new String[]{handsWithValues[i][0], handsWithValues[i][1]};
                        winningHandIndex = i;
                    }
                }
                if(Objects.equals(handsWithValues[i][1], handsWithValues[i][2])){
                    if (currentHighestPair == null ||
                            Integer.parseInt(currentHighestPair[0]) < Integer.parseInt(handsWithValues[i][1])) {
                        System.out.println("NEW HIGHEST PAIR IN HAND SIZE OF 3");
                        currentHighestPair = new String[]{handsWithValues[i][0], handsWithValues[i][1]};
                        winningHandIndex = i;
                    }
                }
            }
            // Check for pairs
            if (handsWithValues[i].length == 2 && Objects.equals(handsWithValues[i][0], handsWithValues[i][1])) {
                System.out.println("HAND " + i + " HAS A PAIR");
                if (currentHighestPair == null ||
                        Integer.parseInt(currentHighestPair[0]) < Integer.parseInt(handsWithValues[i][0])) {
                    currentHighestPair = new String[]{handsWithValues[i][0], handsWithValues[i][1]};
                    winningHandIndex = i;
                }
            }
        }


        // If no three of a kind or pairs, return empty
        if (winningHandIndex == -1) {
            return new String[]{};

        }

        if(currentHighestPair == null && currentThreeOfAKind == null){
            return new String[]{};
        }

        return winningHandIndex != -1 ? hands[winningHandIndex] : new String[]{};
    }



    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
