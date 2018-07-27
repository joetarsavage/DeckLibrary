package com.deck;

import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		
		Scanner scanner = new Scanner(System.in);
		int players = 0;
		ArrayList<ArrayList<String>> playerHands = new ArrayList<>();
		ArrayList<String> discard = new ArrayList<>();
		do {
			System.out.println("How many players are there?");
			
			if(scanner.hasNextInt()) {
				players = scanner.nextInt();	
			}else {
				System.out.println("That is not a valid number of players. Try again.");
				players = 0;
				scanner.next();	
			}
		}while(players <= 1);
		
		System.out.println("Lets play");
	
		int numCardsPerHand = (int) Math.floor(52/players);
		
		for (int i = 0; i < players; i++) {
			playerHands.add(deck.dealCards(numCardsPerHand));
		}	
		
		System.out.println(playerHands);
		
		discard = deck.dealCards(52-(numCardsPerHand*players));		
		
		scanner.close();
	}
}
