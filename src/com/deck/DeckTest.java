package com.deck;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	public void testNewDeck(){
		Deck deck = new Deck();
		assertEquals(52,deck.deckCount());
	}
	
	@Test
	public void testIsShuffled(){
		Deck deck = new Deck();
		Deck unshuffled = new Deck();
		deck.shuffle();
		assertNotEquals(deck.getDeck(),unshuffled.getDeck());
	}
	
	@Test
	public void testCardsReturnedLength(){
		Deck deck = new Deck();
		ArrayList<String> hand = deck.dealCards(5);
		assertEquals(hand.size(),5);
	}
	
	@Test
	public void testCardsReturnedLeaveDeck(){
		Deck deck = new Deck();
		ArrayList<String> hand = deck.dealCards(5);
		boolean inDeck = false;
		for(String card : hand){
			if(deck.getDeck().contains(card)){
				inDeck = true;
			}
		}
		assertFalse(inDeck);
	}
	
	@Test
	public void testCardsReturnedToDeck(){
		Deck deck = new Deck();
		ArrayList<String> hand = deck.dealCards(5);
		deck.returnCards(hand);
		boolean inDeck = true;
		for(String card : hand){
			if(!(deck.getDeck().contains(card))){
				inDeck = false;
			}
		}
		assertTrue(inDeck);
	}
	
	@Test
	public void testIsSameValue_WithSameValue(){
		Deck deck = new Deck();
		String card1 = deck.getDeck().get(0);
		String card2 = deck.getDeck().get(13);
		assertTrue(Deck.isSameValue(card1,card2));
		
	}
	@Test
	public void testIsSameValue_WithDifferentValue(){
		Deck deck = new Deck();
		String card1 = deck.getDeck().get(0);
		String card2 = deck.getDeck().get(1);
		assertFalse(Deck.isSameValue(card1,card2));
	}
	
	@Test
	public void testIsSameSuit_WithSameSuit(){
		Deck deck = new Deck();
		String card1 = deck.getDeck().get(0);
		String card2 = deck.getDeck().get(1);
		assertTrue(Deck.isSameSuit(card1,card2));
	}
	@Test
	public void testIsSameSuit_WithDifferentSuit(){
		Deck deck = new Deck();
		String card1 = deck.getDeck().get(0);
		String card2 = deck.getDeck().get(13);
		assertFalse(Deck.isSameSuit(card1,card2));
	}
	
	@Test
	public void testCardAsString(){
		
		assertEquals("King of Hearts",Deck.getLongCard("K of H"));
		assertEquals("King of Diamonds",Deck.getLongCard("K of D"));
		assertEquals("Nine of Clubs",Deck.getLongCard("9 of C"));
		assertEquals("Ace of Spades",Deck.getLongCard("A of S"));
	}
}
