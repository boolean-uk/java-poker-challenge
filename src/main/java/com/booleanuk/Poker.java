package com.booleanuk;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;


import static java.util.Map.entry;

public class Poker {


    //Map of cards and their values;
    private final Map<String, Integer> cardsAndTheirValues = Map.ofEntries(
            entry("1", 1),
            entry("2", 2),
            entry("3", 3),
            entry("4", 4),
            entry("5", 5),
            entry("6", 6),
            entry("7", 7),
            entry("8", 8),
            entry("9", 9),
            entry("10", 10),
            entry("J", 11),
            entry("Q", 12),
            entry("K", 13),
            entry("A", 14)

    );
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        System.out.println(firstHand[0]);
        System.out.println(secondHand[0]);

        if(firstHand[0].equals(firstHand[1]) && secondHand[0].equals(secondHand[1])) {

            // First hand wins in draws aswell
            if(cardsAndTheirValues.get(firstHand[0]) >= cardsAndTheirValues.get(secondHand[0])) {
                return firstHand;
            }

            if(cardsAndTheirValues.get(secondHand[0]) > cardsAndTheirValues.get(firstHand[0])) {
                return secondHand;
            }

        } else if(firstHand[0].equals((firstHand[1]))) {
            return firstHand;
        } else if(secondHand[0].equals((secondHand[1]))) {
            return secondHand;
        }

        return new String[0];

    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {

        int winningHandIndex = 0;
        int winningHandScore = 0;

        for(int i = 0; i < hands.length; i++) {
            int currentCardScore = 0;
            for(int j = 0; j < hands[i].length - 1; j++) {
                if(hands[i][j].equals(hands[i][j+1])) {
                    currentCardScore += cardsAndTheirValues.get(hands[i][j]);
                }
            }
            if(currentCardScore > winningHandScore) {
                winningHandScore = currentCardScore;
                winningHandIndex = i;
            }


        }

        if(winningHandScore != 0) {
            return hands[winningHandIndex];
        }

        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        return new String[0];
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate

        int winningHandIndex = 0;
        int winningHandScore = 0;

        for(int i = 0; i < hands.length; i++) {
            int currentCardScore = 0;
            for(int j = 0; j < hands[i].length - 1; j++) {
                if(hands[i][j].equals(hands[i][j+1])) {
                    currentCardScore += cardsAndTheirValues.get(hands[i][j]);
                }

                //Difference between winningThreeCardHand and winningPairFromArray.
                if(j+2 < hands[i].length) {
                    if(hands[i][j].equals(hands[i][j+2])) {
                        currentCardScore += cardsAndTheirValues.get(hands[i][2]);
                    }
                }
            }
            if(currentCardScore > winningHandScore) {
                winningHandScore = currentCardScore;
                winningHandIndex = i;
            }


        }

        if(winningHandScore != 0) {
            return hands[winningHandIndex];
        }

        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        return new String[0];
    }

    // Extension 3
    public String[] extensionThreeMethods(String[][] hands) {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java

        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate

        int winningHandIndex = 0;
        int winningHandScore = 0;



        for(int i = 0; i < hands.length; i++) {

            int currentCardScore = this.CheckValueOfHand(hands[i]);

            if(currentCardScore > winningHandScore) {
                winningHandScore = currentCardScore;
                winningHandIndex = i;
            }


            }
        if(winningHandScore != 0) {
            return hands[winningHandIndex];
        }

        /*
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        */

        return new String[0];


    }

    public String[] sortStringArrayOfCards(String[] hand) {

        Arrays.sort(hand, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return cardsAndTheirValues.get(o1) - cardsAndTheirValues.get(o2);
            }
        });
        System.out.println(Arrays.toString(hand));
        return hand;
    }

    public int CheckValueOfHand(String[] hand) {


        int[] ofKinds = howManyTwoThreeFourOfAKind(hand);

        if(ofKinds[2] == 1) {
            return 8;
        } else if(ofKinds[0] == 1 && ofKinds[1] == 1) {
            return 7;
        } else if(isItStraight(hand)) {
            return 5;
        } else if(ofKinds[1] == 1) {
            return 4;
        } else if(ofKinds[0] == 2) {
            return 3;
        } else if(ofKinds[0] == 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public int[] howManyTwoThreeFourOfAKind(String[] hand) {
        int currentEqualCards = 1;
        int twoOfAKind = 0;
        int threeOfAKind = 0;
        int fourOfAKind = 0;

        this.sortStringArrayOfCards(hand);

        for(int i = 0; i < hand.length; i++) {

            if(i+1 < hand.length) {
                if(hand[i].equals(hand[i+1])) {
                    currentEqualCards++;

                    if(currentEqualCards == 2) {
                        System.out.println(Arrays.toString(hand));
                        System.out.println("TwoOfAKind");
                        twoOfAKind++;
                    }
                    if(currentEqualCards == 3) {
                        System.out.println("ThreeOfAKind");
                        twoOfAKind--;
                        threeOfAKind++;
                    }
                    if(currentEqualCards == 4) {
                        System.out.println("TwoOfAKind");
                        threeOfAKind--;
                        fourOfAKind++;
                    }
                }



                if(!hand[i].equals(hand[i+1])) {
                    System.out.println(hand[i] + "    " + hand[i+1]);
                    currentEqualCards = 1;
                }

            }

        }


        System.out.println(twoOfAKind + " : " + threeOfAKind + " : " + fourOfAKind);
        return new int[] {twoOfAKind, threeOfAKind, fourOfAKind};
    }

    public boolean isItStraight(String[] hand) {
        this.sortStringArrayOfCards(hand);

        for(int i = hand.length-1; i >= 0; i--) {
            if(i-4 >= 0) {
                if (cardsAndTheirValues.get(hand[i]) == cardsAndTheirValues.get(hand[i - 1]) + 1
                        && cardsAndTheirValues.get(hand[i]) == cardsAndTheirValues.get(hand[i - 2]) + 2
                        && cardsAndTheirValues.get(hand[i]) == cardsAndTheirValues.get(hand[i - 3]) + 3
                        && cardsAndTheirValues.get(hand[i]) == cardsAndTheirValues.get(hand[i - 4]) + 4) {
                    return true;

                }
            }

        }




        return false;
    }
}

