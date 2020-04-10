package mytest;

import java.util.Scanner;

public class Driver {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String PlayAgain="Y";
		
		
		Deck myDeck = new Deck();
		myDeck.DeckMaker();
		//System.out.println(myDeck.getLength());
		//System.out.println(myDeck);
		do {
		myDeck.Shuffle();
		//System.out.println(myDeck);
		Blackjack mygame = new Blackjack();
		mygame.Deal(myDeck);
	//	System.out.println(myDeck.getLength());
		System.out.println(mygame.show());
		
	
		mygame.HitorStay(myDeck);
		System.out.println(mygame.show());
		mygame.HitorStay(myDeck);
		System.out.println(mygame.show());
		System.out.println("Play again? Y/N");
		PlayAgain=in.nextLine();
		
		}
		while(PlayAgain.equals("Y")||PlayAgain.equals("y"));
	}

}
