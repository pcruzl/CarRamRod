package mytest;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
private int Dvalue;
private int Pvalue;
private ArrayList<Card> Dhand;
private ArrayList<Card> Phand;
final int bust=22;
final int Dstay=16;
int Dvalue2;
int Pvalue2;
Scanner in = new Scanner(System.in);

//The black jack object has 2 hands of cards as ArrayLists and their associated value.
public Blackjack() {
	this.Dvalue=0;
	this.Pvalue=0;
	Dhand= new ArrayList<Card>();
	Phand= new ArrayList<Card>();
}

//Deals the deck correctly alternating player and dealer.
public Deck Deal(Deck a) {
Dhand.add(a.DealCard());
Phand.add(a.DealCard());
Dhand.add(a.DealCard());
Phand.add(a.DealCard());
return a;
}

//HitorStay method takes keyboard input and decides which method to move forward with.  
//Eventually this will be JavaFx buttons
public boolean HitorStay(Deck b) {
	boolean stay = false;
	System.out.println("Hit=H Stay=S");
	String a = in.nextLine();
	if(a.equals("H")||a.equals("h")) {
		
		PlayerHit(b);
		return stay;}
	else if(a.equals("S")||a.equals("s")) {
		stay=true;
		DealerTurn(b);
		return stay;}
	else {
		System.out.println("Please input H or S");
		return stay;}
}

//This is one of the main methods of the game.  Aces are worth 1 or 11 so we have a boolean representing if an ace showed up.
//the method takes face cards and makes them worth 10.  It counts the totals and displays the result.
//It shows if the player busts.  Eventually most of the business of the blackjack game will be in this method.
//As of now it's still a work in progress.
public String show() {
	String result ="";
	boolean DAce=false;
	boolean PAce=false;
	Dvalue=0;
	Pvalue=0;
	for(Card C : Dhand) {
		if(C.getValue()>=10) {Dvalue+=10;}
		else if(C.getValue()==1) {DAce=true; Dvalue+=1;}
		else {Dvalue+=C.getValue();}
	System.out.println(C.toString());
	}
	for(Card C : Phand) {
		if(C.getValue()>=10) {Pvalue+=10;}
		else if(C.getValue()==1) {PAce=true; Pvalue+=1;}
		else {Pvalue+=C.getValue();}
		System.out.println(C.toString());
	}
	
	result += "Dealer has " + Dvalue;
	if(DAce==true&&Dvalue+11<=21) {
		result+=" or "+ (Dvalue+11);
		}
	else if(Dvalue+11>=22) {DAce=false;
	}
	
	if(Pvalue>21) {result+="\nPlayer bust with "+ Pvalue+" \nDealer wins.";}
	else {
	result+="\nPlayer has " + Pvalue;
	if(PAce==true) {
		result+=" or "+ (Pvalue+11);
		if(Dvalue+11>=22) {
			PAce=false;
			
		}
		}
	}	
return result;
}

//When the player chooses to hit it deals a card and goes to hit or stay. .
public Deck PlayerHit(Deck a) {
	Phand.add(a.DealCard());
	return a;

}

public void PlayerStay(Deck a) {
	DealerTurn(a);
}

public Deck DealerTurn(Deck a) {	
	if(Dvalue<16) {
		Dhand.add(a.DealCard());		
	}
	return a;
}

public String toString() {
String result="";
return result;
}
}




