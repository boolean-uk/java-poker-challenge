package com.booleanuk;

import java.util.*;
import java.util.stream.Collectors;

public class Poker {
    String[] cardValue = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    String[] faces = {"Heart", "Clove", "Spade", "Diamond"};
    ArrayList<String> deck = new ArrayList<>();

    // Core
    public String[] winningPair(String[] firstHand, String[] secondHand) {
        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        int fHandVal = 0;
        int sHandVal = 0;
        if (firstHand[0].equals(firstHand[1])) {
            for (int i = 0; i < cardValue.length; i++) {
                if (firstHand[0].equals(cardValue[i])) {fHandVal = i+2;}
            }
        }
        if (secondHand[0].equals(secondHand[1])) {
            for (int i = 0; i < cardValue.length; i++) {
                if (secondHand[0].equals(cardValue[i])) {sHandVal = i+2;}
            }
        }
        if (sHandVal > fHandVal) {return secondHand;}
        else if (fHandVal > sHandVal) {return firstHand;}
        else {return new String[]{};}
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        int winHandVal = -1;
        int winHandPos = -1;
        for (int i = 0; i < hands.length; i++) {
            if (hands[i][0].equals(hands[i][1])) {
                for (int x = 0; x < cardValue.length; x++) {
                    if (hands[i][0].equals(cardValue[x])) {
                        if (x > winHandVal) {
                            winHandVal = x;
                            winHandPos = i;
                        }
                    }
                }
            }
        }
        if (winHandVal != -1) {return hands[winHandPos];}
        else {return new String[]{};}
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        int winHandVal = -1;
        int winHandLen = -1;
        int winHandPos = -1;
        int handLen = -1;
        String handVal = "";
        for (int i = 0; i < hands.length; i++) {

            if (hands[i].length == 3) {
                if (hands[i][0].equals(hands[i][1]) && hands[i][1].equals(hands[i][2])) {
                    handLen = 3;
                    handVal = hands[i][0];
                } else if (hands[i][0].equals(hands[i][1])) {
                    handLen = 2;
                    handVal = hands[i][0];
                } else if (hands[i][1].equals(hands[i][2])) {
                    handLen = 2;
                    handVal = hands[i][1];
                } else if (hands[i][0].equals(hands[i][2])) {
                    handLen = 2;
                    handVal = hands[i][0];
                } else {
                    continue;
                }
            }
            if (hands[i].length == 2) {
                if (hands[i][0].equals(hands[i][1])) {
                    handLen = 2;
                    handVal = hands[i][0];
                }
                else{
                    continue;
                }
             }


                for (int x = 0; x < cardValue.length; x++) {
                    if (handVal.equals(cardValue[x])) {
                        if ((x > winHandVal && handLen == winHandLen) || handLen > winHandLen) {
                            winHandVal = x;
                            winHandLen = handLen;
                            winHandPos = i;
                        }
                    }
                }

        }
        if (winHandVal != -1) {return hands[winHandPos];}
        else {return new String[]{};}
    }

    // Extension 3
    public String[] extensionThreeMethods(String[][] hands) {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        // Values: 4 of a kind (5)-> Full House (4)-> 3 of a kind (3)-> 2 Pairs (2)-> 1 Pair (1)-> High card (0)
        String[] handWorth = new String[hands.length];
        for (int i = 0; i < hands.length; i++) {
            Map<String,Long> cardMap = Arrays.stream(hands[i]).map(c -> c.split(" ")[0])
                    .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
            // TODO: Add value of card to the handworth array
            if (cardMap.containsValue(4L)) { // 4 of a kind
                handWorth[i] = "5";
            } else if (cardMap.containsValue(3L) && cardMap.containsValue(2L)) { // Full house
                handWorth[i] = "4";
            } else if (cardMap.containsValue(3L)) { // 3 of a kind
                handWorth[i] = "3";
            } else if (cardMap.values().size() == 3) { // 2 pairs
                handWorth[i] = "2";
            } else if (cardMap.containsValue(2L)) { // 1 pair
                handWorth[i] = "1";
            } else { // deck has nothing
                handWorth[i] = "0";
            }

            // TODO: Resolve hands with same worth and value of card (with high card)


        }

        return new String[]{"Replace this method with your own methods and tests"};
    }

    //TODO: Method that calls extensionThreeMethods and checks if there are multiple winners (same hand) and assigns points or stuff

    // player limit 10 cause of deck (ez fix if I want)
    public String[][] dealHands(int players) {
        String[][] hands = new String[players][5];
        for(int i = 0; i < players; i++) {
            for(int x = 0; x < 5; x++) {
                hands[i][x] = this.deck.get(0);
                this.deck.remove(0);
            }
        }
        return hands;
    }

    public void constructDeck() {
        this.deck = new ArrayList<>();
        for(String cardVal: this.cardValue) {
            for(String face: this.faces) {
                this.deck.add(cardVal+" "+face);
            }
        }
        Collections.shuffle(this.deck);
    }

    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.constructDeck();
        // TODO: Might be something useful in here
        //System.out.println(Arrays.toString(poker.dealHands(3)[0]));
        //System.out.println(Arrays.toString(Arrays.stream(new String[]{"Q Diamond", "Q Heart", "4 Heart", "5 Diamond", "7 Heart"}).sorted().toArray()));
        //System.out.println(Arrays.stream(new String[]{"Q Diamond", "Q Heart", "4 Heart", "5 Diamond", "Q Heart"}).map(c -> c.split(" ")[0]).distinct().collect(Collectors.joining()).length());
        Map<String,Long> map = Arrays.stream(new String[]{"2 Diamond", "Q Heart", "4 Heart", "4 Diamond", "4 Heart"}).map(c -> c.split(" ")[0])
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));//.entrySet().stream()
                //.sorted(Map.Entry.comparingByValue())
                //.collect();
        //System.out.println(Math.toIntExact(Collections.max(map.values())));
        System.out.println(map.containsValue(3));
//        Map<String,Long> sortedMap = map.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toMap(String::valueOf, Long::longValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
