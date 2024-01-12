package com.booleanuk;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        return winningPairFromArray(new String[][]{firstHand, secondHand});
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        int highestValue = 0, currentValue;
        String[] highestHand = new String[]{};

        for(String[] hand: hands) {
            if(hand[0].equals(hand[1])) {
                currentValue = getCardValue(hand[0]);
                if(currentValue > highestValue) {
                    highestValue = currentValue;
                    highestHand = hand;
                }
            }
        }

        return highestHand;
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        int highestPairValue = 0, highestThreeOfKindValue = 0;
        int currentValue = -1;
        String currentKind;
        String[] highestPairHand = new String[]{};
        String[] highestThreeOfKindHand = new String[]{};

        for(String[] hand: hands) {
            currentKind = "";
            if(hand.length == 2 && highestThreeOfKindValue == 0 && hand[0].equals(hand[1])) {
                currentValue = getCardValue(hand[0]);
                currentKind = "pair";
            } else if(hand.length == 3){
                if(hand[0].equals(hand[1]) && hand[0].equals(hand[2])) {
                    currentValue = getCardValue(hand[0]);
                    currentKind = "three of kind";
                } else if(hand[0].equals(hand[1]) || hand[0].equals(hand[2])) {
                    currentValue = getCardValue(hand[0]);
                    currentKind = "pair";
                } else if(hand[1].equals(hand[2])) {
                    currentValue = getCardValue(hand[1]);
                    currentKind = "pair";
                }
            }

            if(currentKind.equals("pair")) {
                if (currentValue > highestPairValue) {
                    highestPairValue = currentValue;
                    highestPairHand = hand;
                }
            } else if(currentKind.equals("three of kind")) {
                if (currentValue > highestThreeOfKindValue) {
                    highestThreeOfKindValue = currentValue;
                    highestThreeOfKindHand = hand;
                }
            }
        }

        return highestThreeOfKindValue == 0? highestPairHand : highestThreeOfKindHand;
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }

    private int getCardValue(String card) {
        int value;
        switch(card.toLowerCase()) {
            case "j" -> value = 11;
            case "q" -> value = 12;
            case "k" -> value = 13;
            case "a" -> value = 14;
            default -> value = Integer.parseInt(card);
        }
        return value;
    }
}
