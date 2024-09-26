package com.booleanuk.extension;
import com.booleanuk.Hand;
import com.booleanuk.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Extension3Test {

    private final Hand nothing = new Hand(new String[]{"K", "5", "3", "2", "9"});
    private final Hand fourOfAKind = new Hand(new String[]{"K", "K", "K", "2", "K"});
    private final Hand betterFourOfAKind = new Hand(new String[]{"A", "A", "A", "2", "A"});
    private final Hand fullHouse = new Hand(new String[]{"K", "3", "3", "K", "3"});
    private final Hand betterFullHouse = new Hand(new String[]{"7", "2", "7", "2", "7"});
    private final Hand threeOfAKind = new Hand(new String[]{"K", "7", "7", "2", "7"});
    private final Hand betterThreeOfAKind = new Hand(new String[]{"K", "J", "10", "J", "J"});
    private final Hand twoPairs = new Hand(new String[]{"2", "9", "K", "K", "9"});
    private final Hand betterTwoPairs = new Hand(new String[]{"9", "10", "K", "K", "9"});
    private final Hand onePair = new Hand(new String[]{"Q", "2", "K", "K", "9"});
    private final Hand betterOnePair = new Hand(new String[]{"9", "3", "K", "Q", "K"});

    @Test
    public void shouldCreateSortedHand() {
        Assertions.assertArrayEquals(new int[]{2,3,5,9,13}, nothing.getCards());
    }

    @Test
    public void shouldFindNothing() {
        Assertions.assertEquals(1, nothing.getRank());
    }

    @Test
    public void shouldFindFourOfAKind() {
        int result = fourOfAKind.getRank();
        Assertions.assertEquals(6, result);
    }

    @Test
    public void shouldFindFullHouse() {
        int result = fullHouse.getRank();
        Assertions.assertEquals(5, result);
    }

    @Test
    public void shouldFindThreeOfAKind() {
        int result = threeOfAKind.getRank();
        Assertions.assertEquals(4, result);
    }

    @Test
    public void shouldFindTwoPairs() {
        int result = twoPairs.getRank();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void shouldFindOnePair() {
        int result = onePair.getRank();
        Assertions.assertEquals(2, result);
    }

    //FOR GAME CLASS

    @Test
    public void fullHouseWins() {
        Game game = new Game(new Hand[]{nothing, fullHouse, onePair, twoPairs});
        Hand result = game.getWinningHand();
        Assertions.assertEquals(fullHouse, result);
    }

    @Test
    public void fourOfAKindWins() {
        Game game = new Game(new Hand[]{nothing, fullHouse, onePair, fourOfAKind, threeOfAKind, twoPairs});
        Hand result = game.getWinningHand();
        Assertions.assertEquals(fourOfAKind, result);
    }

    @Test
    public void betterFourOfAKindWins() {
        Game game = new Game(new Hand[]{nothing, fullHouse, betterOnePair,betterFourOfAKind, onePair, fourOfAKind, threeOfAKind, twoPairs});
        Hand result = game.getWinningHand();
        Assertions.assertEquals(betterFourOfAKind, result);
    }

    @Test
    public void betterFullHouseWins() {
        Game game = new Game(new Hand[]{nothing, fullHouse, betterFullHouse, betterOnePair, onePair, threeOfAKind, twoPairs});
        Hand result = game.getWinningHand();
        Assertions.assertEquals(betterFullHouse, result);
    }

    @Test
    public void betterThreeOfAKindWins() {
        Game game = new Game(new Hand[]{nothing, onePair, threeOfAKind, betterOnePair, twoPairs, betterThreeOfAKind});
        Hand result = game.getWinningHand();
        Assertions.assertEquals(betterThreeOfAKind, result);
    }

    @Test
    public void betterTwoPairsWins() {
        Game game = new Game(new Hand[]{nothing, onePair, betterOnePair, betterTwoPairs, twoPairs});
        Hand result = game.getWinningHand();
        Assertions.assertEquals(betterTwoPairs, result);
    }

    @Test
    public void betterOnePairWins() {
        Game game = new Game(new Hand[]{nothing, onePair, betterOnePair});
        Hand result = game.getWinningHand();
        Assertions.assertEquals(betterOnePair, result);
    }

    @Test
    public void betterNothingHandWins() {
        Hand h1 = new Hand(new String[]{"K", "5", "3", "2", "9"});
        Hand h2 = new Hand(new String[]{"K", "5", "4", "2", "9"});
        Hand h3 = new Hand(new String[]{"K", "5", "5", "2", "9"});

        Game game = new Game(new Hand[]{h1, h2, h3});
        Hand result = game.getWinningHand();
        Assertions.assertEquals(h3, result);
    }
}
