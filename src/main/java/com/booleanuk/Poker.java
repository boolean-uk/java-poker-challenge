package com.booleanuk;

import java.util.ArrayList;
import java.util.HashMap;

public class Poker {
    HashMap<String, Integer> cardScores;

    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        setScoring();
        int firstHandScore = 0;
        int secondHandScore = 0;

        if(firstHand[0].equals(firstHand[1])){
            firstHandScore += cardScores.get(firstHand[0]) + cardScores.get(firstHand[1]);
        }
        if(secondHand[0].equals(secondHand[1])){
            secondHandScore += cardScores.get(secondHand[0]) + cardScores.get(secondHand[1]);
        }

        if(firstHandScore > secondHandScore){
            return firstHand;
        }
        else if(firstHandScore < secondHandScore){
            return secondHand;
        }
        else{
            return new String[] {};
        }

    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        setScoring();
        ArrayList<String[]> correctPairs = new ArrayList<>();
        String[] winningHand = new String[1];
        boolean hasThreeOfAKind = false;

        for(int i = 0; i < hands.length; i++){
            if(hands[i].length > 2){
                hasThreeOfAKind = true;
                if(hands[i][0].equals(hands[i][1]) && hands[i][0].equals(hands[i][2])){
                    correctPairs.add(hands[i]);
                }
            }
            else if(hands[i].length < 3 && !hasThreeOfAKind){
                if(hands[i][0].equals(hands[i][1])){
                    correctPairs.add(hands[i]);
                }
            }

        }
        if(!correctPairs.isEmpty()){
            int highestScore = 0;
            for (String[] hand : correctPairs){
                if(hand.length > 2){
                    int tempScore = (cardScores.get(hand[0]) + cardScores.get(hand[1]) + cardScores.get(hand[2]));
                    if(tempScore > highestScore){
                        highestScore = tempScore;
                        winningHand = hand;
                    }
                }
                else {
                    int tempScore = (cardScores.get(hand[0]) + cardScores.get(hand[1]));
                    if(tempScore > highestScore){
                        highestScore = tempScore;
                        winningHand = hand;
                    }
                }
            }
        }
        if(correctPairs.isEmpty()){
            return new String[] {};
        }
        else{
            return winningHand;
        }
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate

        setScoring();
        ArrayList<String[]> correctPairs = new ArrayList<>();
        String[] winningHand = new String[1];
        for(int i = 0; i < hands.length; i++){
            if(hands[i].length > 2){
                if(hands[i][0].equals(hands[i][1]) && hands[i][0].equals(hands[i][2])){
                    correctPairs.add(hands[i]);

                }
                else if(hands[i][0].equals(hands[i][1]) || hands[i][0].equals(hands[i][2])){
                    correctPairs.add(hands[i]);
                }
            }
            else if(hands[i].length < 3){
                if(hands[i][0].equals(hands[i][1])){
                    correctPairs.add(hands[i]);
                }
            }
        }
        if(!correctPairs.isEmpty()){
            int highestScore = 0;
            for (String[] hand : correctPairs){
                    if(hand.length > 2){
                        if(hand[0].equals(hand[1]) && hand[0].equals(hand[2])){
                            winningHand = hand;
                            break;
                        }
                        int tempScore = (cardScores.get(hand[0]) + cardScores.get(hand[1]) + cardScores.get(hand[2]));
                        if(tempScore > highestScore){

                            highestScore = tempScore;
                            winningHand = hand;
                        }
                    }
                    else {
                        int tempScore = (cardScores.get(hand[0]) + cardScores.get(hand[1]));
                        if(tempScore > highestScore){
                            highestScore = tempScore;
                            winningHand = hand;
                        }
                    }
                }
            }
        if(correctPairs.isEmpty()){
            return new String[] {};
        }
        else{

            return winningHand;
        }

    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java




        return "Replace this method with your own methods and tests";
    }

    public void setScoring(){
        cardScores = new HashMap<>();

        for (int i = 2; i <= 10; i++) {
            cardScores.put(Integer.toString(i), i);
        }
        cardScores.put("J", 11);
        cardScores.put("Q", 12);
        cardScores.put("K", 13);
        cardScores.put("A", 14);
    }
}
