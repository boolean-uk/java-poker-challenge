package com.booleanuk;

public class Game {

    Hand[] hands;

    public Game(Hand[] hands) {
        this.hands = hands;
    }

    public Hand getWinningHand() {
        int bestHandRank = 0;
        Hand bestHand = null;

        for(Hand hand: hands) {
            if(hand.getRank() > bestHandRank) {
                bestHandRank = hand.getRank();
                bestHand = hand;
            } else if(hand.getRank() == bestHandRank) {
                bestHand = getWinnerOfDraw(hand, bestHand);
            }
        }
        return bestHand;
    }

    private Hand getWinnerOfDraw(Hand h1, Hand h2) {

        if(h1.getRank() == 6) {
            return (h1.getHighestKicker() > h2.getHighestKicker()? h1 : h2);
        }else if(h1.getRank() == 5) {
            return (h1.getCards()[0] > h2.getCards()[0]? h1 : h2);
        }else if(h1.getRank() == 4) {
            return (h1.getCards()[0] > h2.getCards()[0]? h1 : h2);
        }else if(h1.getRank() == 3) {
            if(h1.getCards()[0] == h2.getCards()[0]) {
                if(h1.getCards()[2] == h2.getCards()[2]) {
                    return (h1.getHighestKicker() > h2.getHighestKicker()? h1 : h2);
                } else {
                    return (h1.getCards()[2] > h2.getCards()[2]? h1 : h2);
                }
            }
            return (h1.getCards()[0] > h2.getCards()[0]? h1 : h2);
        }else if(h1.getRank() == 2) {
            if(h1.getCards()[0] == h2.getCards()[0]) { //same pair
                for(int i = 4; i > 1; i--) { //go through highest cards
                    if(h1.getCards()[i] != h2.getCards()[i]) {
                        return (h1.getCards()[i] > h2.getCards()[i]? h1 : h2);
                    }
                }
                return h1; //same hands, h1=h2
            } else {
                return (h1.getCards()[0] > h2.getCards()[0] ? h1 : h2);
            }
        } else { //if both hands have nothing
            for(int i = 4; i >= 0; i--) { //go through highest cards
                if(h1.getCards()[i] != h2.getCards()[i]) {
                    return (h1.getCards()[i] > h2.getCards()[i]? h1 : h2);
                }
            }
            return h1; //same hands, h1=h2
        }
    }
}
