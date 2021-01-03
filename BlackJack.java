
/**
 * Class representing a single player blackjack game
 */
public class BlackJack {
	
	private Deck deck;
	private Dealer dealer;
	private Player player;


	/**
	 * Constructs and prepares for a new game of BlackJack.
	 * Creates player, dealer and deck objects then shuffles
	 * the deck and gives both the dealer and player two cards.
	 */
	public BlackJack() {
		
		System.out.println("starting BlackJack");
		
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		deck.shuffle();
		
		player.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
		player.getHand().addCard(deck.draw());
		dealer.getHand().addCard(deck.draw());
	}
	/**
	 * Restarts in a few steps
	 * 1. The Player and dealer return their cards to the deck.
	 * 2. The deck is shuffled.
	 * 3. Both the player and the dealer receive two cards drawn form the top of the deck.
	 */
	public void restart() {
		System.out.println("restart");
		//return player cards to bottom of deck
		Card[] returnCards;
		returnCards = player.getHand().emptyHand();
		System.out.println("need to return this many player cards "+returnCards.length);
		for (int i=0; i<returnCards.length; i++){
			deck.addToBottom(returnCards[i]);
		}
		//return dealer cards to bottom of deck
		returnCards = dealer.getHand().emptyHand();
		for (int i = 0; i < returnCards.length; i++){
			deck.addToBottom(returnCards[i]);
		}	
		deck.shuffle();
		
		Card c = deck.draw();
		player.getHand().addCard(c);
		c = deck.draw();
		player.getHand().addCard(c);
		c = deck.draw();
		dealer.getHand().addCard(c);
		c = deck.draw();
		dealer.getHand().addCard(c);
		
	}
	/**
	 * Returns the value of a card in a standard game of Blackjack based on the type of the card
	 * ex. An Ace would return 1, a 2 would return 2... 
	 * @param c card whose value is extracted
	 * @return value of the card
	 */
	public static int getValueOfCard(Card c) {
		int valueOfCard = -1;
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
		Card[] currentHand = h.getCards();
		int valueOfHand = 0;
		for (int i = 0 ; i < currentHand.length ; i++){
			valueOfHand = valueOfHand + getValueOfCard(currentHand[i]);
		}
		System.out.println("value of hand is "+valueOfHand);
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
