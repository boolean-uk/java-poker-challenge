package com.booleanuk;

import java.util.Arrays;

public class Hand {
    private int[] cards = new int[5];
    private int rank; // ascending from nothing=1 to fourOfAKind=6


    public Hand(String[] cards) {
        createHand(cards);
        sortHand();
        rank = findHighestRank();
    }

    private void sortHand() {
        Arrays.sort(cards);
    }

    private void createHand(String[] cards) {
        for(int i = 0; i < 5; i++) {
            this.cards[i] = getCardValue(cards[i]);
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

    public int getRank() {
        return rank;
    }

    public int[] getCards() {
        return cards;
    }

    private int findHighestRank() {
        if(checkFourOfAKind()) {
            return 6;
        }
        if(checkFullHouse()) {
            return 5;
        }
        if(checkThreeOfAKind()) {
            return 4;
        }
        if(checkTwoPairs()) {
            return 3;
        }
        if(checkPair()) {
            return 2;
        }
        return 1;
    }

    private boolean checkFourOfAKind() {
        if(cards[0] == cards[1]) {
            for(int i = 2; i < 4; i++) {
                if(cards[i] != cards[0]) {
                    return false;
                }
            }
            return true;
        }
        for(int i = 1; i < 5; i++) {
            if(cards[i] != cards[1]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkFullHouse() {
        if(cards[0]==cards[1] && cards[1]==cards[2] && cards[3]==cards[4]) {
            return true;
        } else if(cards[2]==cards[3] && cards[3]==cards[4] && cards[0]==cards[1]) {
            cards = new int[] {cards[2],cards[2],cards[2],cards[0],cards[0]}; //flip so three of a kind is first
            return true;
        } else {
            return false;
        }
    }

    private boolean checkThreeOfAKind() {
        int val = cards[2]; //since sorted, middle card will always be a part if three of kind exists
        if(cards[1]==val) {
            if(cards[0]==val) {
                return true;
            } else if(cards[3]==val) {
                cards = new int[]{val,val,val,cards[0],cards[4]};
                return true;
            } else {
                return false;
            }
        } else if(cards[3]==val && cards[4]==val) {
            cards = new int[]{val,val,val,cards[0],cards[1]};
            return true;
        } else {
            return false;
        }
    }

    private boolean checkTwoPairs() {
        if(cards[0]==cards[1]) {
            if(cards[2]==cards[3]) {
                cards = new int[]{cards[2],cards[2],cards[0],cards[0],cards[4]};
                return true;
            } else if(cards[3]==cards[4]) {
                cards = new int[]{cards[3],cards[3],cards[0],cards[0],cards[2]};
            }
            return true;

        } else if(cards[1]==cards[2] && cards[3]==cards[4]) {
            cards = new int[]{cards[3],cards[3],cards[1],cards[1],cards[0]};
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPair() {
        if(cards[0]==cards[1]) {
            return true;
        }
        if(cards[1]==cards[2]) {
            cards = new int[]{cards[1],cards[1],cards[0],cards[3],cards[4]};
            return true;
        }
        if(cards[2]==cards[3]) {
            cards = new int[]{cards[2],cards[2],cards[0],cards[1],cards[4]};
            return true;
        }
        if(cards[3]==cards[4]) {
            cards = new int[]{cards[3],cards[3],cards[0],cards[1],cards[2]};
            return true;
        }
        return false;
    }

    public int getHighestKicker() {
        return cards[4];
    }


    @Override
    public String toString() {
        String output = "";
        for(int card: cards) {
            output += card + " ";
        }
        return output + "   " + rank;
    }
}
