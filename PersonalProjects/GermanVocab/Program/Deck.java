package Program;

import java.util.*;

public class Deck {
	private Stack<Card> deck;
	private int chapter = 0;
//	private static String fileName;
//	private static BufferedReader inputFile;

	public Deck(){
		deck = new Stack<Card>();
	}
	
	/*
	 * Shuffle cards in the deck
	 */
	public void shuffle(){
		Collections.shuffle(deck);
	}
	
	/*
	 * Add a card to the deck
	 */
	public void add(Card c){
		deck.push(c);
	}
	
	/*
	 * Remove a card from the deck
	 */
	public Card remove(){
		return deck.pop();
	}
	
	/*
	 * Get the deck chapter
	 * If chapter = 0, it is all chapters
	 */
	public int getChapter(){
		return chapter;
	}
	
	/*
	 * 
	 */
	public Stack<Card> getStack(){
		return deck;
	}
}
