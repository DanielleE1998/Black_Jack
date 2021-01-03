
/**
 * The Dealer in your game of BlackJack. Draws until he/she gets 17 points or has 5 cards.
 *
 */
public class Dealer {
	/**
	 * The dealers hand
	 */
	Hand hand;
	
	/**
	 * Construct a new dealer with an empty hand
	 */
	public Dealer() {
		hand = new Hand();
	}
	
	/**
	 * Dealer draws a card if his hand is worth less than 17 points and has less than 5 cards in in his hand.
	 * Dealer draws a card & adds the card to his hand if his hand is worth less than 17 points and contains less than 5 cards. 
	 * This method should return the card if one was drawn or null otherwise. 
	 * (The card returned here is used in the BlackJackApp.java file to display the correct card graphic in the game). 
	 * HINT: Are there methods that we have previously created in other classes to make this task easier? 
 
	 * @param deck
	 * @return
	 */
	public Card playTurn(Deck deck) {
		Card c=null; //assume we cannot draw
		
		//check if we can draw
		if (!isDone()){
			////draw card and add it to hand
			c = deck.draw();
			hand.addCard(c);
			System.out.println("adding card to dealer hand, new hand size is "+hand.size());
			
		}
		System.out.println("current dealer hand contains");
		Card[] thisC = hand.getCards();
		for (int i=0;i<hand.size();i++){
			System.out.println(thisC[i].toString());
		}
		return c;
	}
	
	/**
	 * A method to check if the dealer has busted
	 * @return boolean true if the dealer has busted
	 */
	public boolean busted() {
		int valueOfHand = BlackJack.getValueOfHand(hand);
		boolean returnValue;
		if (valueOfHand >21){
			returnValue = true;
		}
		else{
			returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * A method to check if the dealer will draw a card.
	 * return@
	 *  Returns true if the dealer will not draw a card next turn.  
	 *  (the dealer draws if his hand is worth less than 17 points and contains less than 5 cards
	 */
	public boolean isDone() {
	    boolean retValue = false; //assume dealer can draw
		if (BlackJack.getValueOfHand(hand) <17 && hand.size() <5){
			System.out.println("dealer can draw");;
			retValue = false;
		}
		return retValue;
	}
	
	/**
	 * Returns the dealers cards to the deck
	 * @param d Deck to return the cards to
	 */
	public void returnCardstoDeck(Deck d) {
		Card[] cardsToReturn = hand.emptyHand();
		System.out.println("nned to return this many cars to deck "+cardsToReturn.length);
		for (int i=0;i<cardsToReturn.length;i++){
			d.addToBottom(cardsToReturn[i]);
		}
	}
	/**
	 * @return Hand the dealer's hand
	 */
	public Hand getHand() {
		return hand;
	}
}
