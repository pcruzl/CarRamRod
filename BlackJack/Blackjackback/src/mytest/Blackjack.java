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

public void HitorStay(Deck b) {
	System.out.println("Hit=H Stay=S");
	String a = in.nextLine();
	if(a.equals("H")||a.equals("h")) {PlayerHit(b);}
	else if(a.equals("S")||a.equals("s")) {DealerTurn(b);}
	else {System.out.println("Please input H or S");}
}

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

public Deck PlayerHit(Deck a) {
	Phand.add(a.DealCard());
	HitorStay(a);
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




