import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	//fields
	//used arraylist for list of cards (52)
	List<Card> cards = new ArrayList<Card>(); 
	
	//constructor for Deck class
	//for loop to go through suits 's' and values 'v' to create new cards
	public Deck () {
		for (int s = 0; s < 4; s++) {
			for (int v = 2; v <= 14; v++) {
				cards.add(new Card (s, v)); 
			}
		}	
	}
	//getters and setters 
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
		
    //method to check if deck is empty if not draw top card from top of deck
	public Card draw() {
		if (cards.isEmpty()){
			return null; 
		} else {
			Card drawCard = cards.get(0);
			cards.remove(0);
			return drawCard;
		}
	}
	
    //shuffle method 
	public void shuffle() {
		Collections.shuffle(cards);
		
	} 
} 