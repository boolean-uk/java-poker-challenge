package com.booleanuk;

import java.util.ArrayList;
import java.util.HashMap;

public class Poker {
    // Core
    HashMap<String, Integer> pointsMap;
    String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Poker(){
        pointsMap = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < 13; i++){
            pointsMap.put(cards[i], i+2);
        }
    }
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        boolean pairOne = firstHand[0].equals(firstHand[1]);
        boolean pairTwo = secondHand[0].equals(secondHand[1]);

        if (pairOne && pairTwo){
            if (pointsMap.get(firstHand[0]) > pointsMap.get(secondHand[0]))
                return firstHand;
            else
                return secondHand;
        }
        else if (pairOne)
            return firstHand;
        else if (pairTwo)
            return secondHand;
        return new String[]{};
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        int handLength = hands.length;
        ArrayList<Integer> indicies = new ArrayList<Integer>();
        int idcsLength;
        int highestPairIdx = 0;
        int highestScore = 0;
        int currScore;
        int currIdx;

        for (int i = 0; i < handLength; i++){
            if (hands[i][0].equals(hands[i][1]))
                indicies.add(i);
        }
        idcsLength = indicies.size();

        if (idcsLength == 0)
            return new String[]{};

        for (int i = 0; i < idcsLength; i++){
            currIdx = indicies.get(i);
            currScore = pointsMap.get(hands[currIdx][0]);
            if (highestScore < currScore){
                highestScore = currScore;
                highestPairIdx = currIdx;
            }
        }
        return hands[highestPairIdx];
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
