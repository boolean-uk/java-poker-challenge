package com.booleanuk;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Hand {
    private Card[] cards;
    private HandRanking ranking;
    private int value;

    public Hand(Card[] cards) {
        this.cards = cards;
        scoreHand();
    }

    public void scoreHand(){
        boolean isFlush = isFlush();
        Card highestInStraight = findStraight();
        Map<Integer, Integer> count = countRankOccurences();

        if (isFlush && highestInStraight != null && highestInStraight.getRank() == 14) {
            ranking = HandRanking.ROYALFLUSH;
        }
        else if (isFlush && highestInStraight != null) {
            value = highestInStraight.getRank();
            ranking = HandRanking.STRAIGHTFLUSH;
        }
        else if (findFours(count))
            ranking = HandRanking.FOUROFAKIND;
        else if (findFullHouse(count))
            ranking = HandRanking.FULLHOUSE;
        else if (isFlush){
            value = findHighestRank();
            ranking = HandRanking.FLUSH;
        }
        else if (highestInStraight != null){
            value = highestInStraight.getRank();
            ranking = HandRanking.STRAIGHT;
        }
        else if (findThrees(count))
            ranking = HandRanking.THREEOFAKIND;
        else {
            HandRanking pairRanking = findPairs(count);
            if (pairRanking != null)
                ranking = pairRanking;
            else {
                value = findHighestRank();
                ranking = HandRanking.HIGHCARD;
            }
        }
    }

    private Card findStraight(){
        for (Integer count: countRankOccurences().values()){
            if (count > 1)
                return null;
        }
        Card highestCard = cards[0];
        Card lowestCard = cards[1];
        for (Card card: cards){
            if (card.getRank()>highestCard.getRank())
                highestCard = card;
            if (card.getRank()< lowestCard.getRank())
                lowestCard = card;
        }
        if (highestCard.getRank() - lowestCard.getRank() == 4)
            return highestCard;
        return null;
    }

    private boolean isFlush(){
        Suit firstSuit = cards[0].getSuit();
        for (Card card : cards){
            if (card.getSuit() != firstSuit)
                return false;
        }
        return true;
    }

    private Map<Integer, Integer> countRankOccurences(){
        Map<Integer, Integer> count = new HashMap<>();
        for (Card card: cards){
            if (count.containsKey(card.getRank()))
                count.put(card.getRank(), count.get(card.getRank())+1);
            else
                count.put(card.getRank(),1);
        }
        return count;
    }

    private boolean findFours(Map<Integer, Integer> count){
        for (Map.Entry<Integer, Integer> entry: count.entrySet()){
            if (entry.getValue() == 4){
                value = entry.getKey();
                return true;
            }
        }
        return false;
    }

    private boolean findFullHouse(Map<Integer, Integer> count){
        for (Map.Entry<Integer, Integer> entry: count.entrySet()){
            if (entry.getValue() == 3){
                for (Integer n: count.values()){
                    if (n == 2){
                        value = entry.getKey();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean findThrees(Map<Integer, Integer> count){
        for (Map.Entry<Integer, Integer> entry: count.entrySet()){
            if (entry.getValue() == 3){
                value = entry.getKey();
                return true;
            }
        }
        return false;
    }

    private HandRanking findPairs(Map<Integer, Integer> count){
        for (Map.Entry<Integer, Integer> entry: count.entrySet()){
            if (entry.getValue() == 2){
                for (Map.Entry<Integer, Integer> entry2: count.entrySet()){
                    if (!Objects.equals(entry2.getKey(), entry.getKey()) && entry2.getValue() == 2){
                        value = entry.getKey() > entry2.getKey()? entry.getKey() : entry2.getKey();
                        return HandRanking.TWOPAIR;
                    }
                }
                value = entry.getKey();
                return HandRanking.ONEPAIR;
            }
        }
        return null;
    }

    private int findHighestRank(){
        int highest = cards[0].getRank();
        for (Card card: cards){
            if (card.getRank() > highest)
                highest = card.getRank();
        }
        return highest;
    }

    public int getValue() {
        return value;
    }

    public HandRanking getRanking() {
        return ranking;
    }

    public Card[] getCards() {
        return cards;
    }
}
