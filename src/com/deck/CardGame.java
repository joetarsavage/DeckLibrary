package com.deck;

import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {
	public static void main(String[] args) throws InterruptedException {
		Deck deck = new Deck();
		deck.shuffle();
		
		Scanner scanner = new Scanner(System.in);
		int players = 2;
		ArrayList<ArrayList<String>> playerHands = new ArrayList<>();
		ArrayList<String> discard;
		
		System.out.println("Lets play");
	
		int numCardsPerHand = (int) Math.floor(52/players);
		
		for (int i = 0; i < players; i++) {
			playerHands.add(deck.dealCards(numCardsPerHand));
		}	
		
		System.out.println(playerHands);
		
		discard = deck.dealCards(52-(numCardsPerHand*players));	
		
		System.out.println("Press space if the NUMBER or LETTER on the cards is the same");
		
		Thread.sleep(1000);
		
		System.out.println("Ready?");
		
		Thread.sleep(1000);
		
		System.out.println("GO!");
		
		scanner.close();
	}
}
