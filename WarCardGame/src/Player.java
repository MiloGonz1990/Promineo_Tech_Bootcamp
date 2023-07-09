import java.util.ArrayList;
import java.util.List;

public class Player {
	
	//fields hand, score, and name
	// 
	List<Card> hand = new ArrayList<Card>(); 
	int score;
	String name;
	
	
	//constructor that gets the score and name 
	public Player(String name) { 
		this.score = 0; 
		this.name = name;
	}
	//methods
	//prints out info about player and score
	public void describe() {
		System.out.println(name + " " + "has:\n" );
			for(Card card : hand) {
				card.describe();
			}
		System.out.println("-_-_-_-_-_-_-_-_-\n");
	}
	//removes and returns the top card of the Hand
	public Card flip() {
		Card drawCard = hand.get(0);
		hand.remove(0);
		return drawCard;
	}
	//takes a Deck as an argument and calls the draw method on the deck, adding the returned Card to the hand field
	public void draw(Deck deck) {
		Card card = deck.draw();
		hand.add(card);
	}
	
	public void incrementScore() {
		this.score++; //increments by 1 
	}
} 