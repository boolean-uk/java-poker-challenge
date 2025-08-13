package com.booleanuk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Poker {

    private int getValueOfCard(String card){
        switch (card){
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 14;
            default: return Integer.valueOf(card);
        }
    }

    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        int firstHandValue = firstHand[0].equals(firstHand[1])? getValueOfCard(firstHand[0]) : 0;
        int secondHandValue = secondHand[0].equals(secondHand[1])? getValueOfCard(secondHand[0]) : 0;
        if(firstHandValue > secondHandValue)
            return firstHand;
        else if (secondHandValue > firstHandValue)
            return secondHand;
        else
            return new String[]{};
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winningHand = {};
        for (int i = 0; i < hands.length-1; i++) {
            winningHand = winningPair(hands[i], hands[i+1]);
        }
        return winningHand;
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        int[] scores = new int[hands.length];
        for (int i = 0; i < hands.length; i++) {
            Map<String, Integer> count = new HashMap<>();
            for (String card: hands[i]){
                if (count.containsKey(card))
                    count.put(card, count.get(card)+1);
                else
                    count.put(card,1);
            }
            for (Map.Entry<String, Integer> entry: count.entrySet()){
                switch (entry.getValue()){
                    case 3: scores[i] = 1000 + getValueOfCard(entry.getKey()); break;
                    case 2: scores[i] = getValueOfCard(entry.getKey()); break;
                }
            }
        }
        int winningInd = -1;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] > 0 && winningInd == -1){
                winningInd = i;
            } else if (scores[i] > 0 && scores[i] > scores[winningInd]) {
                winningInd = i;
            }
        }
        return winningInd == -1? new String[]{} : hands[winningInd];
    }

    // Extension 3
    public Hand getWinningHand(Hand[] hands){
        Hand winningHand = hands[0];
        for (int i = 1; i < hands.length; i++) {
            if(hands[i].getRanking().ordinal() > winningHand.getRanking().ordinal()){
                winningHand = hands[i];
            } else if (hands[i].getRanking().ordinal() == winningHand.getRanking().ordinal()){
                if(hands[i].getValue() > winningHand.getValue())
                    winningHand = hands[i];
            }
        }
        return winningHand;
    }
}
