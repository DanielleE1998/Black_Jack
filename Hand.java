
/**
 * 
 * @author ghyzel
 *
 */
public class Hand {
	
	/**
	 * The cards in the hand
	 */
	private Card [] cards;
	
	/**
	 * Creates an empty hand
	 */
	public Hand() {
		//Initializing an empty array. 
		//Calling cards.length on this array would return 0
		cards = new Card[0];		
	}

	/**
	 * Adds Card c to the hand
	 * 
	 * @param c card to be added
	 */
	public void addCard(Card c) {
		Card[] oldCards = new Card[cards.length];
		//copy existing hand
		for (int i=0;i<cards.length;i++){
			oldCards[i]=cards[i];
		}
		cards = new Card[cards.length+1];
		//copy previous cards
		for (int i=0;i<oldCards.length;i++){
			cards[i]=oldCards[i];
		}
		//add new card to hand
		System.out.println("about to set index "+ (cards.length-1)+ "to "+c.toString());
		cards[cards.length-1]=c;
	}
	
	/**
	 * @return number of cards in the hand
	 */
	public int size() {
		return cards.length;
	}
	
	/**
	 * Returns an array of all the cards in the hand
	 * 
	 * @return the cards in the hand
	 */
	public Card[] getCards() {
		// Ensure you return reference to the copy of the cards array
		// and not a reference actual cards array!
		Card[] hand = new Card[cards.length];
		for (int i=0;i<cards.length;i++){
			hand[i]=cards[i];
		}
		return hand;
	}
	
	/**
	 * Empties the hand, and returns an array containing the discarded cards.
	 * 
	 * @return the discarded cards
	 */
	public Card[] emptyHand() {
		Card[] hand = getCards();
		cards = new Card[0];
		return hand;
	}
	
	/**
	 * Returns a String representation of the hand
	 * 
	 * E.g.
	 * 
	 * "Empty Hand"
	 * "1. ACE OF SPADES\n2. QUEEN OF HEARTS"
	 * 
	 * @return a String representing the hand
	 */
	@Override
	public String toString() {
		// HINT: Use the toString() method of the card class
		String result ="";
		if (cards.length ==0){
			result = result +"Empty Hand";
		}
		else{
			for (int i=0;i<cards.length;i++){
				result = result +i+". "+cards[i].toString()+"\n";
			}
		}
		return result;
	}
}
