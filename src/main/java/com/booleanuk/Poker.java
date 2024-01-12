package com.booleanuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Poker {

    public HashMap<String, Integer> cardValueMap;
    public Poker(){
        this.cardValueMap = createCardValueMap();
    }

    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winningPair = new String[]{};

        if(isPair(firstHand) && isPair(secondHand)) {

            if ((this.cardValueMap.get(firstHand[0])) > (this.cardValueMap.get(secondHand[0]))){
                winningPair = firstHand;
            } else {
                winningPair = secondHand;
            }

        } else if (isPair(firstHand) && !isPair(secondHand)) {
            winningPair = firstHand;
        }
        else if (!isPair(firstHand) && isPair(secondHand)) {
            winningPair = secondHand;
        }

        return winningPair;
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate

        String[] winningPair = new String[]{};
        ArrayList<String> listOfPairValues = new ArrayList<>();
        String higestCard;

        for (String[] hand : hands){
            if(isPair(hand)){
                listOfPairValues.add(hand[0]);
            }
        }

        higestCard = getHigestCard(listOfPairValues);

        if (!listOfPairValues.isEmpty()){
            winningPair = new String[]{higestCard, higestCard};
        }

        return winningPair;
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate

        String[] winningHand = new String[]{};
        ArrayList<String> listOfTripleValues = new ArrayList<>();
        HashMap<String, String[]> mapOfPairs = new HashMap<>();


        for (String[] hand : hands){

            if(amountOfIdenticalCards(hand) == 3){
                listOfTripleValues.add(hand[0]);
            }
            else if(amountOfIdenticalCards(hand) == 2){
                mapOfPairs.put(getCardOfPair(hand), hand);
            }

        }

        if (!listOfTripleValues.isEmpty()){
            winningHand = new String[3];
            Arrays.fill(winningHand, getHigestCard(listOfTripleValues));
        } else if (!mapOfPairs.isEmpty()){
            ArrayList<String> listOfPairValues2 = new ArrayList<>(mapOfPairs.keySet());
            String high = getHigestCard(listOfPairValues2);
            winningHand = mapOfPairs.get(high);
        }

        return winningHand;
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }

    public String getCardOfPair(String[] hand){
        String resCard = "";
        String firstCard = hand[0];
        String previousCard = "";
        for (String card: hand){
            if(isPair(new String[]{previousCard, card}) || isPair(new String[]{firstCard, card})){
                resCard = card;
            }
            previousCard = card;
        }
        return resCard;
    }

    public int amountOfIdenticalCards(String[] hand){
        int amount = 0;
        String firstCard = hand[0];
        String previousCard = "";
        for (String card: hand){
            if(isPair(new String[]{previousCard, card}) || isPair(new String[]{firstCard, card})){
                amount +=1;
            }
            previousCard = card;
        }
        return amount;
    }

    public boolean isPair(String[] hand){
        return hand[0].equalsIgnoreCase(hand[1]);
    }

    public String getHigestCard(ArrayList<String> listOfCards){

        int maxValue = 0;
        String highestCard = "";

        for (String card : listOfCards){
            int currentValue = this.cardValueMap.get(card);
            if(currentValue > maxValue){
                maxValue = currentValue;
                highestCard = card;
            }
        }
        return highestCard;
    }

    public HashMap<String, Integer> createCardValueMap(){

        HashMap<String, Integer> cardValueMap = new HashMap<>();

        cardValueMap.put("2", 2);
        cardValueMap.put("3", 3);
        cardValueMap.put("4", 4);
        cardValueMap.put("5", 5);
        cardValueMap.put("6", 6);
        cardValueMap.put("7", 7);
        cardValueMap.put("8", 8);
        cardValueMap.put("9", 9);
        cardValueMap.put("10", 10);
        cardValueMap.put("J", 11);
        cardValueMap.put("Q", 12);
        cardValueMap.put("K", 13);
        cardValueMap.put("A", 14);

        return cardValueMap;
    }
}
