//create classic card game WAR
public class Card {
	
	
	//gave an integer to each suit to build card deck with an array
	public static final int CLUBS = 0;
	public static final int DIAMONDS = 1;
	public static final int HEARTS = 2;
	public static final int SPADES = 3;
	
	//gave integer value to face cards to use for ranking 
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int ACE = 14;
	
	//create fields for value and name of cards
	private int cardName;		
	private int cardValue;
	
	//constructor for card class with two integers cardName and cardValue as parameters
	public Card(int cardName, int cardValue) {
		this.setCardName(cardName);
		this.setCardValue(cardValue);	
    //using "this" keyword to refer to the current object being created in the constructor
	}
    //getters and setters to get name and value 
    //This ensures the name of CardName does not allow input outside cardName parameters
	private void setCardName(int newCardName) {
		if (newCardName >= 0 && newCardName <= 3) {
			this.cardName = newCardName;
		} else {
			throw new IllegalArgumentException("ERROR!! Bad Suit!");
		}
	}
	
    //This ensures the value of CardValue does not allow input values that are not within our cardValue parameters
	private void setCardValue(int newCardValue) {	
		if (newCardValue < 2 || newCardValue > 14) {
			throw new IllegalArgumentException("ERROR!! Bad Rank!");
		}
		this.cardValue = newCardValue;
	}
	
	public int getcardName() {
		return cardName;
	}
	
	public int getcardValue() {
		return cardValue;
	}
	

	//methods to describe info about card using if else statements
	public String toString() {			
		String s = "";
			if (cardValue == JACK) {
				s += "Jack";
			} else if (cardValue == QUEEN) {
				s += "Queen";
			} else if (cardValue == KING) {
				s += "King";
			} else if (cardValue == ACE) {
				s += "Ace";
			} else if (cardValue == 2) {
				s += "Two";
			} else if (cardValue == 3) {
				s += "Three";
			} else if (cardValue == 4) {
				s += "Four";
			} else if (cardValue == 5) {
				s += "Five";
			} else if (cardValue == 6) {
				s += "Six";
			} else if (cardValue == 7) {
				s += "Seven";
			} else if (cardValue == 8) {
				s += "Eight";
			} else if (cardValue == 9) {
				s += "Nine";
			} else if (cardValue == 10) {
				s += "Ten";
			} else {
				s += cardValue;
			}
			
			s += " of ";
			
			if (cardName == CLUBS) {
				s += "Clubs";
			} else if (cardName == DIAMONDS) {
				s += "Diamonds";
			} else if (cardName == HEARTS) {
				s += "Hearts";
			} else if (cardName == SPADES) {
				s += "Spades";
			}
		return s; 
	}

	public void describe() {
		System.out.println(this.toString() + "\n"); //prints out card
		
	}
 	
} 