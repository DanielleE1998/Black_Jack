/**
 * A player in a blackJack game
 *
 */
public class Player {
	/**
	 * The players hand
	 */
	private Hand hand;
	
	/**
	 * Instantiates the hand instance variable.
	 */
	public Player() {
		hand = new Hand();
		
	}
	
	/**
	 * @return true if the player has busted
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
	 * empty the player hand into the cards
	 * @param d deck that receives the cards
	 */
	public void returnCardstoDeck(Deck d) {
		Card[] cardsToReturn = hand.emptyHand();
		for (int i=0;i<cardsToReturn.length;i++){
			d.addToBottom(cardsToReturn[i]);
		}
	}
	/**
	 * @return the player's hand
	 */
	public Hand getHand() {
		return hand;
	}
}
