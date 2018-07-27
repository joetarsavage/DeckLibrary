package com.deck;

import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {
	public static void main(String[] args) throws InterruptedException {
		Deck deck = new Deck();
		deck.shuffle();
		
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String> firstHalf = deck.dealCards(26);
		ArrayList<String> secondHalf = deck.dealCards(26);
		
		System.out.println("Lets play");
		
		System.out.println("Press P then ENTER if the cards are a Pair");
		
		Thread.sleep(1000);
		
		System.out.println("Ready?");
		
		Thread.sleep(1000);
		
		System.out.println("GO!");
		
		
	
		
		scanner.close();
	}
}
