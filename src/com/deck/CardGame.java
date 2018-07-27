package com.deck;

import java.util.ArrayList;
import java.util.Scanner;
import com.utilities.*;

public class CardGame {
	public static void main(String[] args) throws InterruptedException {
		Deck deck = new Deck();
		deck.shuffle();
		
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String> firstHalf = deck.dealCards(26);
		ArrayList<String> secondHalf = deck.dealCards(26);
		
		System.out.println("Lets play");
		
		System.out.println("Press Y then ENTER if the cards are a Pair");
		System.out.println("Press N then ENTER if the cards are not a Pair");
		
		Thread.sleep(1000);
		
		System.out.println("Ready?");
		
		Thread.sleep(1000);
		
		System.out.println("GO!");
		
		long startTime = System.nanoTime();
		
		boolean result = true;
		
		for(int i = 0; i<26; i++) {
			System.out.println(firstHalf.get(i) + " || " + secondHalf.get(i));
			String input = scanner.nextLine().toLowerCase();
			if ((Deck.isSameValue(firstHalf.get(i), secondHalf.get(i)) && input.equals("n")) 
					|| (!(Deck.isSameValue(firstHalf.get(i), secondHalf.get(i))) && input.equals("y")) || !(input.equals("y") || input.equals("n"))) {
				result = false;
				break;
			}
		}
		
		long endTime = System.nanoTime();
		
		scanner.close();
		
		if(result == false) {
			System.out.println("Sorry, that is incorrect. Better luck next time");
			return;
		}
	
		long duration = (endTime-startTime)/1000000;
		
		double finalTime = duration/1000.0000;
		
		System.out.println("Congratulations! Your time was " + finalTime + " seconds");
		
		System.out.println(Utilities.readFromFile("/Users/jtarsavage/score.txt"));
		
		
	}
}
