package mytest;

public class Card {
private int suit;
private int value;
private String suitName;
private String cardName;


//The card class is made so that two ints designate the card for example (0,1)= ace of spades
//This will help when we have a bunch of gif files to link to them and allows a for loop to make a deck.
public Card(int s, int v) {
	this.suit=s;
	this.value=v;
	this.suitName="";
	this.cardName="";
}


//Notice that suits are 0-3 and values are 1-13.  The values start at 1 so I don't have to shift them all when adding
//A total value for the cards.  
//The result of make name is a string like "Ace of Spades"
public String makeName(int s, int v) {
	int dasuit=s;
	int davalue=v;
	String result="";
	
	switch (dasuit) {
	case 0: suitName="Spades";
	break;
	case 1: suitName="Clubs";
	break;
	case 2: suitName="Hearts";
	break;
	case 3: suitName="Diamonds";
	break;
	default: suitName="Error";
	}
	switch(davalue) {
	case 1: cardName="Ace";
	break;
	case 2: cardName="Duece";
	break;
	case 3: cardName="Three";
	break;
	case 4: cardName="Four";
	break;
	case 5: cardName="Five";
	break;
	case 6: cardName="Six";
	break;
	case 7: cardName="Seven";
	break;
	case 8: cardName="Eight";
	break;
	case 9: cardName="Nine";
	break;
	case 10: cardName="Ten";
	break;
	case 11: cardName="Jack";
	break;
	case 12: cardName="Queen";
	break;
	case 13: cardName="King";
	break;
	default: cardName="Error";
	}
	result=cardName + " of " + suitName+"\n";
	
	return result;
}
	
//for totaling the cards in blackjack
public int getValue() {
	return value;
}

//setValue will never be used.
public void setValue(int value) {
	this.value = value;
}

//ToString just calls makeName() method.
public String toString() {
String result="";
result = makeName(suit,value);
return result;
}
}
