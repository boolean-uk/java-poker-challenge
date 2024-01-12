package com.booleanuk;

import java.util.HashMap;

public class Poker {
    HashMap<String, Integer> theCard;
    public Poker(){
       this.theCard  = createCard();
    }
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winPair = new String[2];

        int firstHandCard1 = theCard.get(firstHand[0]);
        int firstHandCard2 = theCard.get(firstHand[1]);
        int corePair1 = firstHandCard1 + firstHandCard2;
        int secondHandCard1 = theCard.get(secondHand[0]);
        int secondHandCard2 = theCard.get(secondHand[1]);
        int corePair2 = secondHandCard1 + secondHandCard2;
        if(firstHandCard1 != firstHandCard2 && secondHandCard1 != secondHandCard2){
            return  winPair = new String[]{};
        }
        else if(corePair1 > corePair2){
            winPair = firstHand;
        }else if (corePair1 < corePair2) {
            winPair =secondHand;
        }
        return winPair;

    }
    public HashMap<String, Integer> createCard (){
        HashMap<String, Integer> cardMap = new HashMap<>();
        cardMap.put("2", 2);
        cardMap.put("3", 3);
        cardMap.put("4", 4);
        cardMap.put("5", 5);
        cardMap.put("6", 6);
        cardMap.put("7", 7);
        cardMap.put("8", 8);
        cardMap.put("9", 9);
        cardMap.put("10", 10);
        cardMap.put("J", 11);
        cardMap.put("Q", 12);
        cardMap.put("K", 13);
        cardMap.put("A", 14);

        return cardMap;
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winPair = new String[2];
        int maxValue = 0;
        for(int i = 0; i<hands.length; i++){
            if(hands[i][0].equals(hands[i][1])){
                int currentValue = theCard.get(hands[i][0]);
                if(currentValue > maxValue){
                    maxValue = currentValue;
                    winPair = hands[i];
                }
            }
        }
        if(maxValue == 0){
            return new String[]{};
        }
        return winPair;
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
