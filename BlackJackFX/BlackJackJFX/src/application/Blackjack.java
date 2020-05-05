package application;

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

public int getDvalue() {
	return Dvalue;
}



public int getPvalue() {
	return Pvalue;
}




public Blackjack() {
	this.Dvalue=0;
	this.Pvalue=0;
	Dhand= new ArrayList<Card>();
	Phand= new ArrayList<Card>();
}


public Deck Deal(Deck a) {
Dhand.add(a.DealCard());
Phand.add(a.DealCard());
Dhand.add(a.DealCard());
Phand.add(a.DealCard());
return a;
}




public boolean Stay(Deck b) {
	boolean stay = true;
	DealerTurn(b);
	return stay;
}




public String showD() {
	String result="";
	for(Card c : Dhand) {
		result+=c.getSuit();
		result+=c.getValue();
		result+=",";
	}
return result;
}

public String showP() {
	String result="";
	for(Card c : Phand) {
		result+=c.getSuit();
		result+=c.getValue();
		result+=",";
	}
return result;
}

public void tally() {
	showP();
	showD();
	boolean DAce=false;
	boolean PAce=false;
	Dvalue=0;
	Pvalue=0;
	for(Card C : Dhand) {
		if(C.getValue()>=10) {Dvalue+=10;}
		else if(C.getValue()==1) {DAce=true; Dvalue+=11;}
		else {Dvalue+=C.getValue();}
		if(DAce==true&&Dvalue>21) {Dvalue-=10;}
	}
	
	for(Card C : Phand) {
		if(C.getValue()>=10) {Pvalue+=10;}
		else if(C.getValue()==1) {PAce=true; Pvalue+=11;}
		else {Pvalue+=C.getValue();}
		if(PAce==true&&Pvalue>21) {Pvalue-=10;}
	}
	

}

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




