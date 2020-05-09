//class description: The card class is made so that two ints designate the card for example (0,1)= ace of spades
//This will help when we have a bunch of gif files to link to them and allows a for loop to make a deck.


package application;

public class Card {
private int suit;
private int value;
private String suitName;
private String cardName;



/** This constructor will accept two int values that will represent a card
 * @param s the int value that represents the suite
 * @param v the int value that represents the value
 */
public Card(int s, int v) {
	this.suit=s;
	this.value=v;
	this.suitName="";
	this.cardName="";
}



/** This method will basically describe exactly what kind of card there is based on the two int values passed to the method (suite and value)
 * @param s the suit
 * @param v the value
 * @return String result of make name is a string like "Ace of Spades"
 */
public String makeName(int s, int v) {
	int dasuit=s;
	int davalue=v;
	String result="";
	
	switch (dasuit) {
	case 0: suitName="Spades"; //Notice that suits are 0-3 and values are 1-13.  The values start at 1 so I don't have to shift them all when adding a total value for the cards.
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
	

/** this method is used for totaling the cards in blackjack
 * @return the int value
 */
public int getValue() {
	return value;
}


/** this method will never be used but is the setter for value
 * @param value
 */
public void setValue(int value) {
	this.value = value;
}

/** getter for the suit
 * @return suit
 */
public int getSuit() {
	return suit;
}


/**setter for the suite
 * @param suit
 */
public void setSuit(int suit) {
	this.suit = suit;
}


/** getter for the suitName
 * @return String suitName
 */
public String getSuitName() {
	return suitName;
}


/** setter for the suiteName
 * @param suitName
 */
public void setSuitName(String suitName) {
	this.suitName = suitName;
}


/**Getter for the cardName
 * @return String cardName
 */
public String getCardName() {
	return cardName;
}


/** setter for the cardName
 * @param cardName
 */
public void setCardName(String cardName) {
	this.cardName = cardName;
}



/** this method will return the string representation of the suit and value of a card
 *@return String result
 */
public String toString() {
String result="";
result =Integer.toString(suit)+Integer.toString(value);
return result;
}
}
