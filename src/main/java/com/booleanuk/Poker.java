package com.booleanuk;

import java.util.Arrays;
import java.util.HashMap;

public class Poker {
    private static final int firstCard = 0;
    private static final int secondCard = 1;
    private static final int thirdCard = 2;

    HashMap<String, Integer> valuesOfCards = new HashMap<>();

    public Poker() {
        setValuesOfCards();
    }

    public static void main(String[] args) {
        Poker poker = new Poker();
        String[][] hands = {new String[]{"K", "5"}, new String[]{"3", "7"}};

        System.out.println(Arrays.toString(poker.winningPairFromArray(hands)));
    }

    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] bestHand = new String[]{};

        if (containsAPair(firstHand) && containsAPair(secondHand)) {
             if (getValueOfBestCard(firstHand) > getValueOfBestCard(secondHand)) {
                 bestHand = firstHand;
             } else {
                 bestHand = secondHand;
             }
        } else if (containsAPair(firstHand)) {
            bestHand = firstHand;
        } else if (containsAPair(secondHand)) {
            bestHand = secondHand;
        }
        return bestHand;
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] bestHand = hands[0];
        String[] empty = new String[]{};

        for (int i = 1; i < hands.length; i++) {
            bestHand = winningPair(bestHand, hands[i]);
        }
        if (containsAPair(bestHand)) {
            return bestHand;
        }
        return empty;
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] bestCards = new String[]{};

        for (int i = 1; i < hands.length; i++) {
            if (i == 1) {
                bestCards = bestHand(hands[i-1], hands[i]);
            } else {
                bestCards = bestHand(bestCards, hands[i]);
            }
        }
        return bestCards;
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }

    private boolean containsAPair(String[] hand) {
        if (hand.length == 0) {
            return false;
        }
        if (hand.length == 2) {
            return hand[firstCard].equals(hand[secondCard]);
        }
        if (hand[firstCard].equals(hand[secondCard])) {
            return true;
        } else if (hand[firstCard].equals(hand[thirdCard])) {
            return true;
        } else if (hand[thirdCard].equals(hand[secondCard])) {
            return true;
        }
        return false;
    }

    private boolean isThreeOfAKind(String[] hand) {
        if (hand.length > 1) {
            if (hand[firstCard].equals(hand[secondCard])) {
                if (hand.length == 3) {
                    return hand[thirdCard].equals(hand[secondCard]);
                }
            }
        }
        return false;
    }

    private int getValue(String card) {
        return this.valuesOfCards.get(card);
    }

    private int getValueOfBestCard(String[] hand) {
        int tempValue;
        int cardValue = 0;
        for (String card : hand) {
            tempValue = getValue(card);
            if (tempValue > cardValue) {
                cardValue = tempValue;
            }
        }
        return cardValue;
    }

    private String[] bestHand(String[] firstHand, String[] secondHand) {

        if (isThreeOfAKind(firstHand) && isThreeOfAKind(secondHand)) {
            return bestHighestCard(firstHand, secondHand);
        } else if (isThreeOfAKind(firstHand) && !isThreeOfAKind(secondHand)) {
            return firstHand;
        } else if (!isThreeOfAKind(firstHand) && isThreeOfAKind(secondHand)) {
            return secondHand;
        }

        if (containsAPair(firstHand) && containsAPair(secondHand)) {
            return bestPair(firstHand, secondHand);
        } else if (containsAPair(firstHand) && !containsAPair(secondHand)) {
            return firstHand;
        } else if (!containsAPair(firstHand) && containsAPair(secondHand)) {
            return secondHand;
        }
        return new String[]{};
    }

    private String[] bestHighestCard(String[] firstHand, String[] secondHand) {
        int first = getValueOfBestCard(firstHand);
        int second = getValueOfBestCard(secondHand);

        if (first > second) {
            return firstHand;
        }
        return secondHand;
    }

    private String[] bestPair(String[] firstHand, String[] secondHand) {
        int first = pairValue(firstHand);
        int second = pairValue(secondHand);

        if (first > second) {
            return firstHand;
        }
        return secondHand;
    }

    private int pairValue(String[] hand) {
        if (hand.length == 2) {
            return this.valuesOfCards.get(hand[firstCard]);
        }
        if (hand[firstCard].equals(hand[secondCard])) {
            return this.valuesOfCards.get(hand[firstCard]);
        }
        else if (hand[firstCard].equals(hand[thirdCard])) {
            return this.valuesOfCards.get(hand[firstCard]);
        }
        else if (hand[thirdCard].equals(hand[secondCard])) {
            return this.valuesOfCards.get(hand[thirdCard]);
        }
        return -1;
    }

    private void setValuesOfCards() {
        this.valuesOfCards.put("2", 2);
        this.valuesOfCards.put("3", 3);
        this.valuesOfCards.put("4", 4);
        this.valuesOfCards.put("5", 5);
        this.valuesOfCards.put("6", 6);
        this.valuesOfCards.put("7", 7);
        this.valuesOfCards.put("8", 8);
        this.valuesOfCards.put("9", 9);
        this.valuesOfCards.put("10", 10);
        this.valuesOfCards.put("J", 11);
        this.valuesOfCards.put("Q", 12);
        this.valuesOfCards.put("K", 13);
        this.valuesOfCards.put("A", 14);
    }
}
