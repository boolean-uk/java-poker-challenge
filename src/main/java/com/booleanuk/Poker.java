package com.booleanuk;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        if(firstHand[0].equals(firstHand[1])) {
            if(secondHand[0].equals(secondHand[1])) {
                int firstHandValue = getCardValue(firstHand[0]);
                int secondHandValue = getCardValue(secondHand[0]);

                if(firstHandValue > secondHandValue) {
                    return firstHand;
                } else if(firstHandValue < secondHandValue) {
                    return secondHand;
                } else {
                    return new String[]{};
                }
            } else {
                return firstHand;
            }
        } else if(secondHand[0].equals(secondHand[1])) {
            return secondHand;
        } else {
            return new String[]{};
        }
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

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
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
        int currentValue;
        String[] highestPairHand = new String[]{};
        String[] highestThreeOfPairHand = new String[]{};

        for(String[] hand: hands) {
            if(hand.length == 2 && highestThreeOfKindValue == 0) {
                if (hand[0].equals(hand[1])) {
                    currentValue = getCardValue(hand[0]);
                    if (currentValue > highestPairValue) {
                        highestPairValue = currentValue;
                        highestPairHand = hand;
                    }
                }
            } else if(hand.length == 3){
                if(hand[0].equals(hand[1]) && hand[0].equals(hand[2])) {
                    currentValue = getCardValue(hand[0]);
                    if (currentValue > highestThreeOfKindValue) {
                        highestThreeOfKindValue = currentValue;
                        highestThreeOfPairHand = hand;
                    }
                } else if(hand[0].equals(hand[1]) || hand[0].equals(hand[2])) {
                    currentValue = getCardValue(hand[0]);
                    if (currentValue > highestPairValue) {
                        highestPairValue = currentValue;
                        highestPairHand = hand;
                    }
                } else if(hand[1].equals(hand[2])) {
                    currentValue = getCardValue(hand[1]);
                    if (currentValue > highestPairValue) {
                        highestPairValue = currentValue;
                        highestPairHand = hand;
                    }
                }
            }
        }

        return highestThreeOfKindValue == 0? highestPairHand : highestThreeOfPairHand;
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
