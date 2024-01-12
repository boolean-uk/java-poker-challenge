package com.booleanuk;
import java.util.Arrays;
public class Poker {
    // Core
    String[] list = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        String[] winner = {};
        if (!firstHand[0].equals(firstHand[1]) && !secondHand[0].equals(secondHand[1])) {
            winner = new String[]{};

        } else if (!firstHand[0].equals(firstHand[1])) {
            if (secondHand[0].equals(secondHand[1])){
                winner = new String[]{secondHand[0], secondHand[1]};

            }
        } else if (firstHand[0].equals(firstHand[1])) {
            if (!secondHand[0].equals(secondHand[1])) {
                winner = new String[]{firstHand[0], firstHand[1]};

            } else {
                int position1 = -1;
                for (int i = 0; i < list.length; i++) {
                    if (list[i].equals(firstHand[0])) {
                        position1 = i;
                        break;
                    }
                }
                int position2 = -1;
                for (int i = 0; i < list.length; i++) {
                    if (list[i].equals(secondHand[0])) {
                        position2 = i;
                        break;
                    }
                }
                if(position1 < position2){
                    winner = new String[]{secondHand[0], secondHand[1]};

                } else {
                    winner = new String[]{firstHand[0], firstHand[1]};

                }
            }
        }
        return winner;
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        return new String[]{"Replace me", "with something else"};
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
