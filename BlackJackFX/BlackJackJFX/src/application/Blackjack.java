//Class Description: The BlackJack Class will be responsible for setting up the main structure of the game. 1. Setting up the dealer and player card array lists. 2. Creating the values and also using methods to fill the appropriate values depending on the specific game action.  


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

/**
 * @return The Dealers card value
 */
public int getDvalue() {
	return Dvalue;
}



/**
 * @return The Players card value
 */
public int getPvalue() {
	return Pvalue;
}




/**Constructor will create the 2 array lists of cars for both the dealer and player
 * 
 */
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




/**This method will check the current deck being used and use a boolean check to let the player stay playing if they wish.
 * @param b The DeckObject passed in as a parameter in order to Stay in the Game.
 * @return the boolean variable Stay which will activate the Stay game action.
 */
public boolean Stay(Deck b) {
	boolean stay = true;
	DealerTurn(b);
	return stay;
}




/** This method will Show the dealers card values
 * @return A string result
 */
public String showD() {
	String result="";
	for(Card c : Dhand) { //Advance for loop to iterate through the Arraylist and get the Dealers values.
		result+=c.getSuit();
		result+=c.getValue();
		result+=",";
	}
return result;
}

/**This method will show the Players card values
 * @return A string result
 */
public String showP() {
	String result="";
	for(Card c : Phand) {//same process as before with the dealer
		result+=c.getSuit();
		result+=c.getValue();
		result+=",";
	}
return result;
}

/**this void method will be responsible for displaying the correct card information for both the player and dealer
 * 
 */
public void tally() {
	showP();
	showD();
	boolean DAce=false;
	boolean PAce=false;
	Dvalue=0;
	Pvalue=0;
	for(Card C : Dhand) { //this advance for loop must compare the values of the card and tally the card values based on the values in the card list
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

/** This Method is responsible for representing the hit game game action of BlackJack and will add return value of the dealCard method to the Card arrayList
 * @param a The Deck Object
 * @return the Deck Object
 */
public Deck PlayerHit(Deck a) {
	Phand.add(a.DealCard());
	return a;

}



/**This method will be responsible for allowing the player to stay in the game if they so chose.
 * @param a The Deck object
 */
public void PlayerStay(Deck a) {
	DealerTurn(a);//add the DeckObject to the Dealerturn method
}

/**This method will check if the Dealers value is less than 16 and if it is it will add the return value of the DealCard method through the Deck Obect to the DHand arrayList.
 * @param a The Deck object
 * @return a The Deck Object
 */
public Deck DealerTurn(Deck a) {	
	if(Dvalue<16) {//if dvalue is less than 16
		Dhand.add(a.DealCard());		
	}
	return a;
}

/** this method returns and empty string
 *@return String result
 */
public String toString() {
String result="";
return result;
}
}




