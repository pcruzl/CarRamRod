package mytest;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	//I chose an ArrayList because the shuffle method.  ArrayList behaves most like a deck of cards.
private ArrayList<Card>  DaDeck;
	
	public Deck() {
		DaDeck= new ArrayList<Card>();
	}
	
	//This method creates a standard deck of cards.  Multiple decks can be created and added together.
	//Most methods of the blackjack object will pass the deck to each other so that it works like an actual game
	//of Blackjack.
	public ArrayList<Card> DeckMaker() {
		for (int i=0;i<=3;i++) {
			for (int j=1;j<=13;j++) {
				Card myCard= new Card(i,j);
				DaDeck.add(myCard);	
			}
		}
	return DaDeck;
	}
	
	//Shuffles the deck
	public ArrayList<Card> Shuffle(){
		Collections.shuffle(DaDeck);
		return DaDeck;
		
	}
	
	//Deals one card off the top of the deck.
	public Card DealCard() {
		Card a = DaDeck.remove(0);
		return a;
	}
	
	//Returns an int for how many cards are left int the deck.  I will use this number for knowing when to shuffle again.
	public int getLength() {
		return DaDeck.size();
	}
	
	//Basically just uses the tostring from card over and over.
	public String toString() {
		String result="";
		for(Card C : DaDeck) {result+=C+"\n";}
		return result;
	}
	
}
