package com.booleanuk;

import java.util.ArrayList;
import java.util.HashMap;

public class Poker {
	// Core
	public String[] winningPair(String[] firstHand, String[] secondHand) {
		// Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
		// You can replace the following return value with something appropriate
		int valueFirst = 0;
		int valueSecond = 0;

		char cardFirst = firstHand[0].charAt(0);
		char cardSecond = secondHand[0].charAt(0);

		if (firstHand[0].equals(firstHand[1])) {
			valueFirst = cardValue(cardFirst);
		}
		if (secondHand[0].equals(secondHand[1])) {
			valueSecond = cardValue(cardSecond);
		}

		if (valueFirst > valueSecond) return firstHand;
		if (valueSecond > valueFirst) return secondHand;
		return new String[]{};
	}

	private int cardValue(char card) {
		int value = 0;
		if (Character.isLetter(card)) {
			switch (card) {
				case 'J':
					value = 11;
					break;
				case 'Q':
					value = 12;
					break;
				case 'K':
					value = 13;
					break;
				case 'A':
					value = 14;
					break;
				default:
					value = 0;
			}
		} else {
			value = Character.getNumericValue(card);
		}

		return value;
	}

	// Extension 1
	public String[] winningPairFromArray(String[][] hands) {
		// Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
		// You can replace the following return value with something appropriate
		int highest = 0;
		if (hands[0][0].equals(hands[0][1])) {
			cardValue(hands[0][0].charAt(0));
		}
		int pair = 0;
		for (int i = 1; i < hands.length; i++) {
			int newPair = 0;
			if (hands[i][0].equals(hands[i][1])) {
				newPair = cardValue(hands[i][0].charAt(0));
			}
			if (newPair > pair) {
				highest = i;
				pair = newPair;
			}
		}
		if (pair == 0) {
			return new String[]{};
		}
		return hands[highest];

	}

	// Extension 2
	public String[] winningThreeCardHand(String[][] hands) {
		// Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
		// You can replace the following return value with something appropriate
		HashMap<Integer, String[]> threeHands = new HashMap<>();

		//find all 3 hand
		for (int i = 0; i < hands.length; i++) {
			if (hands[i].length == 3) {
				threeHands.put(i, hands[i]);
			}
		}

		//find all same card
		ArrayList<Integer> removeIndex = new ArrayList<>();
		threeHands.forEach((key, value) -> {
			if (!(value[0].equals(value[1]) && value[0].equals(value[2]))) {
				removeIndex.add(key);
			}
		});
		for (int i : removeIndex) {
			threeHands.remove(i);
		}
		//find the highest
		if (!threeHands.isEmpty()) {
			if (threeHands.size() == 1) {
				return (String[]) threeHands.values().toArray()[0];
			}
		}
		//for all hands check if pair
		int pair = 0;
		int highestIndex = 0;
		pair = findPair(hands[0]);
		for (int i = 1; i < hands.length; i++) {
			int newPair = findPair(hands[0]);
			if (newPair > pair) {
				highestIndex = i;
				pair = newPair;
			}
		}
		if (pair > 0) {
			return hands[highestIndex];
		}
		return new String[]{};
	}

	private int findPair(String[] hand) {
		if (hand.length == 3) {
			if (hand[0].equals(hand[1])) {
				return cardValue(hand[0].charAt(0));
			}
			if (hand[0].equals(hand[2])) {
				return cardValue(hand[0].charAt(0));
			}
			if (hand[1].equals(hand[2])) {
				return cardValue(hand[1].charAt(0));
			}
		}
		if (hand[0].equals(hand[1])) {
			return cardValue(hand[0].charAt(0));
		}
		return 0;
	}

	// Extension 3
	public String extensionThreeMethods() {
		// Completely replace this method with suitable methods to solve Extension 3
		// You will also need to add the relevant tests to Extension3Test.java
		return "Replace this method with your own methods and tests";
	}
}
