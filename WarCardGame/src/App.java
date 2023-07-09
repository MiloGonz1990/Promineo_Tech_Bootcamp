public class App {
	
	public static void main(String[] args) {
		
		Deck fullDeck = new Deck();		//instantiates a deck
			
		fullDeck.shuffle();	//calls shuffle method on fullDeck
		
		
		Player player1 = new Player("Tom");	//instantiates players
		Player player2 = new Player("Jerry");
		Player tie = new Player("Tie");
		
		for(int i = 1; i <= 26; i++){ 		//for loop to give each player 26 cards
			player1.hand.add(fullDeck.draw()); 
			player2.hand.add(fullDeck.draw());
		}
		
		player1.describe();
		player2.describe();
		//for loop to increment score and ties 
		for (int i = 1; i <= 26; i++) {
			Card player1Card = player1.flip();
			Card player2Card = player2.flip();
			
			if (player1Card.getcardValue() > player2Card.getcardValue()) {	//compares final score for each player
				player1.incrementScore();
			} else if (player2Card.getcardValue() > player1Card.getcardValue()) {
				player2.incrementScore();
		
			} else {
				tie.incrementScore();
			}
		}  
			//if else statement to print out results
		if (player1.score > player2.score) {
			System.out.println("-_-_-_-_-_-_-_-_-\n");
			System.out.println(player1.name + "'s " + "final score is: " + player1.score + "\n");
			System.out.println(player2.name + "'s " + "final score is: "+ player2.score + "\n");
			System.out.println(player1.name + " and " + player2.name +" ties : " + tie.score + "\n");
			System.out.println(player1.name + " wins this round! \n");
			System.out.println("-_-_-_-_-_-_-_-_-\n");
		} else if(player2.score > player1.score) {
			System.out.println("-_-_-_-_-_-_-_-_-\n");
			System.out.println(player1.name + "'s " + "final score is: " + player1.score + "\n");
			System.out.println(player2.name + "'s " + "final score is: "+ player2.score + "\n");
			System.out.println(player1.name + " and " + player2.name +" ties : " + tie.score + "\n");
			System.out.println(player2.name + " wins this round! \n");
			System.out.println("-_-_-_-_-_-_-_-_-\n");
		} else {
			System.out.println("-_-_-_-_-_-_-_-_-\n");
			System.out.println(player1.name + "'s " + "final score is: " + player1.score + "\n");
			System.out.println(player2.name + "'s " + "final score is: "+ player2.score + "\n");
			System.out.println("Draw! Play Again!\n");
			System.out.println("\n-_-_-_-_-_-_-_-_-\n");
		}
	} 
} 