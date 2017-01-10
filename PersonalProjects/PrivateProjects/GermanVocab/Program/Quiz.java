package Program;
import java.io.*;
import java.net.URL;

import javax.swing.*;


public class Quiz {
	private static Deck deck;
	private static String typeQuiz;
	private static int whichChapter;
	final private static String[] choice = {"Nouns","Verbs","Phrases","Adjectives","All","Exit"};
	private static URL fileName;
	private static BufferedReader inputFile;
	
	public Quiz(int[] chapters, String[] types){
		deck = new Deck();
		if(getFile(getClass().getResource("/words.txt"))){
			populateDeck(chapters,types);
		}
		deck.shuffle();
	}
	
	/*
	 * check if string is a valid input integer
	 * 
	 */
	private static boolean isValidInt(String s){
		if(s.length()==0)
			return false;
		
		else{
			//char c = s.charAt(0);
			int i = Integer.parseInt(s);
			//if(c=='-')
			//	return false;
			/*******WILL NEED TO CHANGE AS WE DO MORE CHAPTERS*******/
			if(i<0 || i>12)
				return false;
			/********************************************************/
			else
				return true;
		}
	}
	
	/*
	 * Set chapter for flashcards
	 * 0 to test all chapters
	 */
	private static void pickChapter(){
		
	}
	
	/*
	 * pick to test nouns or verbs
	 * sets up file as well through deck class
	 */
	private static void pickType(){		
		
	}
	
	/*
	 * populate deck with cards of desired chapter
	 */
	private static void populateDeck(int[] chapters, String[] types){
		try{
			String type = "";
			for(int i = 0; i < 4; i++){
				if(Character.toString(types[i].charAt(0)).equals(" ")){}
				else
					type = type+Character.toString(types[i].charAt(0));
			}
			String s = inputFile.readLine();
			while(s!=null){
				if(s.charAt(0)!='#'){
					String[] card = s.split("\t");
					if(chapters[Integer.parseInt(card[0])-1]==1 && type.contains(card[1].toUpperCase())){
						deck.add(new Card(Integer.parseInt(card[0]), card[1], card[2], card[card.length-1]));
					}
				}
				s = inputFile.readLine();
			}
		}
		catch (IOException e){
			System.out.println(e);
		}
	}

	/*
	 * 
	 */
	public boolean getFile(URL url){
		try{
			//get file and set up buffered reader and return true
			fileName = url;
			inputFile = new BufferedReader(new InputStreamReader(url.openStream()));
			return true;
		}
		
		catch (IOException e){
			//catch ioexception and return false
			System.out.println("Unable to open "+fileName);
			return false;
		}
	}
	
	/*
	 * 
	 */
	public Deck getDeck(){
		return deck;
	}
	
	/*
	 * 
	 */
	public void close(){
		try {
			inputFile.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"File closed successfully");
		}
	}
}

