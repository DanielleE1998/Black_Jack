import javafx.scene.image.Image;

public class Card {
	
	/**
	 * Suits of a card deck
	 */
	public static enum Suit{
		CLUB, DIAMOND, HEART, SPADE
	}
	
	/**
	 * Types of cards
	 */
	public static enum Type {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	private Suit suit;
	private Type type;
	
	/**
	 * Create a card with Type type and Suit suit
	 * @param type type of the card
	 * @param suit suit of the card
	 */
	public Card(Type type, Suit suit) {
		
		System.out.println("building card " +suit+" "+type);
		this.suit = suit;
		this.type = type;
	}
	
	/**
	 * Checks if this card equals card c
	 * @param c Card to compare
	 * @return boolean true if the suit and type of the cards match
	 */
	public boolean equals(Card c) {
		boolean returnValue = false; //assume no match
		if (c != null){
				if (c.suit .equals(suit)  && c.type.equals(type)){
					System.out.println("yes cards match");
					returnValue = true;
				}
		}
		return returnValue; //replace this line with your own code
	}
	
	/**
	 * Returns a String representation of the Card (ex. ACE OF SPADES)
	 */
	@Override
	public String toString() {
		 
		return (""+ type + " of "+suit + "s");
	}
	
	/**
	 * @return the suit of the card
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * @return the type of the card
	 */
	public Type getType() {
		return type;
	}
	/**
	 * Don't worry about this method. This is for the Graphical User Interface
	 * @return the image of the card
	 */
	public Image getImage() {
		return new Image("file:classic-cards/" + this.getType() + "" + this.getSuit() + ".png");
	}
}
