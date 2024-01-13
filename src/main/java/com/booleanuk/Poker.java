package com.booleanuk;

import java.util.ArrayList;
import java.util.Arrays;

public class Poker {
    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        int change = 0;
        int change2 = 0;
        ArrayList<Integer> intFirstHand = new ArrayList<>();
        ArrayList<Integer> intSecondHand = new ArrayList<>();
        for (int i = 0; i<secondHand.length; i++){

            if (secondHand[i].equals("A")) {
                change2= 14;
            }else if (secondHand[i].equals("K")) {
                change2= 13;
            }else if (secondHand[i].equals("Q")) {
                change2= 12;
            }else if (secondHand[i].equals("J")) {
                change2= 11;
            }else{
                change2 = Integer.parseInt(secondHand[i]);
            }
            intSecondHand.add(change2);
        }
        for (int i = 0; i<firstHand.length; i++){
            //String AGE_AS_STRING = Integer.toString(age);

            if (firstHand[i].equals("A")){
                change= 14;
            } else if (firstHand[i].equals("K")) {
                change= 13;
            }else if (firstHand[i].equals("Q")) {
                change= 12;
            }else if (firstHand[i].equals("J")) {
                change= 11;
            }else {
                change = Integer.parseInt(firstHand[i]);

            }
            intFirstHand.add(change);

        }
        System.out.println(Arrays.asList(firstHand));
        System.out.println(Arrays.asList(intFirstHand));
        System.out.println();
        System.out.println();
        System.out.println(Arrays.asList(secondHand));
        System.out.println(Arrays.asList(intSecondHand));

        if (intFirstHand.get(0).equals(intFirstHand.get(1)) && intSecondHand.get(0).equals(intSecondHand.get(1))){
                if (intFirstHand.get(0)>intSecondHand.get(0)){
                    return firstHand;
                }else{
                    return secondHand;
                }
        }else if (intFirstHand.get(0).equals(intFirstHand.get(1)) && !intSecondHand.get(0).equals(intSecondHand.get(1))){
            return firstHand;
        }else if (!intFirstHand.get(0).equals(intFirstHand.get(1)) && intSecondHand.get(0).equals(intSecondHand.get(1))){
            return secondHand;
        }


        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        return new String[]{};
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        int numb = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i< hands.length; i++){
            if (hands[i][0].equals(hands[i][1])){
                if (hands[i][0].equals("A")){
                    numb = 14;
                } else if (hands[i][0].equals("K")) {
                    numb = 13;

                }else if (hands[i][0].equals("Q")) {
                    numb = 12;

                }else if (hands[i][0].equals("J")) {
                    numb = 11;

                }else {
                    numb = Integer.parseInt(hands[i][0]);
                }
                numbers.add(numb);
            }
        }
        int temp = 0;
        for (int i = 0; i<numbers.size(); i++){
            if (temp<numbers.get(i)){
                temp=numbers.get(i);
            }
        }
        String temp2="";
        if (temp==14){
            temp2="A";
        } else if (temp==13) {
            temp2="K";
        }else if (temp==12) {
            temp2="Q";
        }else if (temp==11) {
            temp2="J";
        }else {
            temp2 = Integer.toString(temp);
        }

        String[] winner = new String[]{};

        for(int i = 0; i< hands.length; i++){
            for (int j = 0; j< hands[i].length; j++){
                if (hands[i][j].equals(temp2)){
                    winner = hands[i];
                }
            }
        }
        System.out.println(Arrays.asList(winner));
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        return winner;
    }


    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        int numb = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] winner = new String[]{};
        for(int i = 0; i< hands.length; i++){
            if (hands[i].length==3 && hands[i][0].equals(hands[i][1]) && hands[i][0].equals(hands[i][2]) ){
                    return winner = hands[i];
            }else if (hands[i][0].equals(hands[i][1])){
                if (hands[i][0].equals("A")){
                    numb = 14;
                } else if (hands[i][0].equals("K")) {
                    numb = 13;

                }else if (hands[i][0].equals("Q")) {
                    numb = 12;

                }else if (hands[i][0].equals("J")) {
                    numb = 11;

                }else {
                    numb = Integer.parseInt(hands[i][0]);
                }
                numbers.add(numb);
            }
        }

        int temp = 0;
        for (int i = 0; i<numbers.size(); i++){
            if (temp<numbers.get(i)){
                temp=numbers.get(i);
            }
        }
        String temp2="";
        if (temp==14){
            temp2="A";
        } else if (temp==13) {
            temp2="K";
        }else if (temp==12) {
            temp2="Q";
        }else if (temp==11) {
            temp2="J";
        }else {
            temp2 = Integer.toString(temp);
        }



        for(int i = 0; i< hands.length; i++){
            for (int j = 0; j< hands[i].length; j++){
                if (hands[i][j].equals(temp2)){
                    winner = hands[i];
                }
            }
        }
        System.out.println(Arrays.asList(winner));

        return winner;

    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
