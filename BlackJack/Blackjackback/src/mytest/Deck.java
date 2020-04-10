package mytest;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

private ArrayList<Card>  DaDeck;
	
	public Deck() {
		DaDeck= new ArrayList<Card>();
	}
	
	public ArrayList<Card> DeckMaker() {
		for (int i=0;i<=3;i++) {
			for (int j=1;j<=13;j++) {
				Card myCard= new Card(i,j);
				DaDeck.add(myCard);	
			}
		}
	return DaDeck;
	}
	
	public ArrayList<Card> Shuffle(){
		Collections.shuffle(DaDeck);
		return DaDeck;
		
	}
	
	public Card DealCard() {
		Card a = DaDeck.remove(0);
		return a;
	}
	
	public int getLength() {
		return DaDeck.size();
	}
	public String toString() {
		String result="";
		for(Card C : DaDeck) {result+=C+"\n";}
		return result;
	}
	
}
