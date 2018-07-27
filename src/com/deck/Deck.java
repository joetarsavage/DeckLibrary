package com.deck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private String[] suits = {"H","D","S","C"};
	private String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private ArrayList<String> deck = new ArrayList<String>();
	
	public Deck(){
		for(String suit:suits){
			for(String value: values){
				deck.add(value + " of " + suit); 
			}
		}
	}
	
	public ArrayList<String> getDeck(){
		return deck;
	}
	
	public void shuffle(){
		Collections.shuffle(this.deck);
	}
	
	public ArrayList<String> dealCards(int toBeDealt){
		ArrayList<String> cardsReturned = new ArrayList<String>();
		if((deck.size() - toBeDealt) < 0){
			return cardsReturned;
		}
		for(int i = 0; i < toBeDealt; i++){
			cardsReturned.add(deck.get(i));
		}
		deck.removeAll(cardsReturned);
		return cardsReturned;
	}
	
	public void returnCards(ArrayList<String> hand){
		deck.addAll(hand);
	}
	
	public static void displayCards(ArrayList<String> cards){
		StringBuilder sb = new StringBuilder();
		for(String card : cards){
			sb.append("[" + card + "] ");
		}
		System.out.println(sb.toString());
	}
	
	public int deckCount(){
		return deck.size();
	}
	
	public static boolean isSameValue(String card1,String card2){
		return (card1.split(" ")[0].equals(card2.split(" ")[0]));
	}
	public static boolean isSameSuit(String card1,String card2){
		return (card1.split(" ")[2].equals(card2.split(" ")[2]));
	}
	
	public static String getLongCard(String card){
		String[] cardArr = card.split(" ");
		StringBuilder longCard = new StringBuilder();
		if(cardArr[0].equals("K")){
			longCard.append("King of ");
		}else if(cardArr[0].equals("Q")){
			longCard.append("Queen of ");
		}else if(cardArr[0].equals("J")){
			longCard.append("Jack of ");
		}else if(cardArr[0].equals("10")){
			longCard.append("Ten of ");
		}else if(cardArr[0].equals("9")){
			longCard.append("Nine of ");
		}else if(cardArr[0].equals("8")){
			longCard.append("Eight of ");
		}else if(cardArr[0].equals("7")){
			longCard.append("Seven of ");
		}else if(cardArr[0].equals("6")){
			longCard.append("Six of ");
		}else if(cardArr[0].equals("5")){
			longCard.append("Five of ");
		}else if(cardArr[0].equals("4")){
			longCard.append("Four of ");
		}else if(cardArr[0].equals("3")){
			longCard.append("Three of ");
		}else if(cardArr[0].equals("2")){
			longCard.append("Two of ");
		}else if(cardArr[0].equals("A")){
			longCard.append("Ace of ");
		}
		
		if(cardArr[2].equals("H")){
			longCard.append("Hearts");
		}else if(cardArr[2].equals("D")){
			longCard.append("Diamonds");
		}else if(cardArr[2].equals("S")){
			longCard.append("Spades");
		}else if(cardArr[2].equals("C")){
			longCard.append("Clubs");
		}
		return longCard.toString();
	}
}
