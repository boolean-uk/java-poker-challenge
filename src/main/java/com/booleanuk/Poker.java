package com.booleanuk;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        boolean check = false;
        boolean check2 = false;
        int temp = 0;
        int temp2 = 0;
        if (firstHand[0].equals(firstHand[1]) && secondHand[0].equals(secondHand[1])){
            check=true;
            if (firstHand[0].contains("A")){
                return firstHand;
            } else if (secondHand[0].contains("A")) {
                return secondHand;
            }
            firstHand[0].contains("A");
        }else if (firstHand[0].equals(firstHand[1]) && !secondHand[0].equals(secondHand[1])){
            return firstHand;
        } else if ( !firstHand[0].equals(firstHand[1]) && secondHand[0].equals(secondHand[1])) {
            return secondHand;
        }
        if (check==true){
            System.out.println(
                    "firstHand:" + firstHand[0] + firstHand[1] +
                    "\nsecondHand" + secondHand[0] + secondHand[1]
            );
            for (int i =0; i<secondHand.length; i++){
                int list = Integer.parseInt(secondHand[i]);
                int list2 = Integer.parseInt(firstHand[i]);
                if (list>list2){
                    return secondHand;
                }else {
                    return firstHand;
                }
            }
        }else{
            return new String[]{};
        }
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        return new String[]{};
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
