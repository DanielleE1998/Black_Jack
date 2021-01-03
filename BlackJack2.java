
/**
 * Class representing a single player blackjack game
 */


public class BlackJack2 {
	
	private Deck deck;
	private Dealer dealer;
	private Player player;


	/**
	 * Constructs and prepares for a new game of BlackJack.
	 * Creates player, dealer and deck objects then shuffles
	 * the deck and gives both the dealer and player two cards.
	 */
	public BlackJack2() {
		Card c;
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		deck.shuffle(); //shuffle cards 100 times
		
		//1) Draw 2 cards from the deck, put them in the players hand 
		c = deck.draw(); // get one card
		player.getHand().addCard(c);
		c = deck.draw(); // get one card
		player.getHand().addCard(c);
		
		//2) Draw 2 cards from the deck, put them in the dealer’s hand. 
		
		c = deck.draw(); // get one card
		dealer.getHand().addCard(c);
		c = deck.draw(); // get one card
		dealer.getHand().addCard(c);
	}
	
	/**
	 * Restarts in a few steps
	 * 1. The Player and dealer return their cards to the deck.
	 * 2. The deck is shuffled.
	 * 3. Both the player and the dealer receive two cards drawn form the top of the deck.
	 */
	public void restart() {
		//return player cards to bottom of deck
		Card[] cardsToReturn;
		cardsToReturn = player.getHand().emptyHand();
		for (int i=0;i<cardsToReturn.length;i++){
			deck.addToBottom(cardsToReturn[i]);
		}
		//return dealer cards to bottom of deck
		cardsToReturn = dealer.getHand().emptyHand();
		for (int i=0;i<cardsToReturn.length;i++){
			deck.addToBottom(cardsToReturn[i]);
		} 
		
		deck.shuffle();
		
		//1) Draw 2 cards from the deck, put them in the players hand 
		Card c;
		c = deck.draw(); // get one card
		player.getHand().addCard(c);
		c = deck.draw(); // get one card
		player.getHand().addCard(c);
				
		//2) Draw 2 cards from the deck, put them in the dealer’s hand. 
				
		c = deck.draw(); // get one card
		dealer.getHand().addCard(c);
		c = deck.draw(); // get one card
		dealer.getHand().addCard(c);
	}
	
	/**
	 * Returns the value of a card in a standard game of Blackjack based on the type of the card
	 * ex. An Ace would return 1, a 2 would return 2... 
	 * @param c card whose value is extracted
	 * @return value of the card
	 */
	public static int getValueOfCard(Card c) {
		int valueOfCard=-1;
		Card.Type type = c.getType();
		switch(type) {
		case ACE:
			valueOfCard = 1;
			break;
		case TWO:
			valueOfCard = 2;
			break;
		case THREE:
			valueOfCard = 3;
			break;
		case FOUR:
			valueOfCard = 4;
			break;
		case FIVE:
			valueOfCard = 5;
			break;	
		case SIX:
			valueOfCard = 6;
			break;
		case SEVEN:
			valueOfCard = 7;
			break;	
		case EIGHT:
			valueOfCard = 8;
			break;
		case NINE:
			valueOfCard = 9;
			break;		
		case TEN:
		case JACK:	
		case QUEEN:
		case KING:	
			valueOfCard = 10;
		}
		
		return valueOfCard; 
	}
	/**
	 * Returns the maximum value of the hand that does not result in a bust
	 * @param h Hand whose value is returned
	 * @return value of h
	 */
	public static int getValueOfHand(Hand h) {
		Card[] thisHand = h.getCards();
		int valueOfHand=0;
		for (int i=0;i<thisHand.length;i++){
			valueOfHand = valueOfHand+getValueOfCard(thisHand[i]);
		}
		return valueOfHand;
	}

	/**
	 * @return Deck used to play
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * @return Dealer of the game
	 */
	public Dealer getDealer() {
		return dealer;
	}
	
	/**
	 * @return Player playing the blackjack game
	 */
	public Player getPlayer() {
		return player;
	}

}
*/