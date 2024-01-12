package com.booleanuk;

public class PairAndScore {
    private int score = 0;
    private boolean pair = false;

    public int getScore() {
        return this.score;
    }

    public boolean isPair() {
        return this.pair;
    }

    public void calculatePairAndScore(String[] hand) {
        int[] pairs = new int[52];
        int score = 0;

        for(String value : hand) {
            int number = 0;

            switch (value) {
                case "J":
                    number = 11;
                    break;
                case "Q":
                    number = 12;
                    break;
                case "K":
                    number = 13;
                    break;
                case "A":
                    number = 14;
                    break;
                default:
                    number = Integer.parseInt(value);
                    break;
            }

            score += number;
            pairs[number]++;
            if(pairs[number] == 2) {
                this.pair = true;
            }
        }

        this.score = score;
    }
}
