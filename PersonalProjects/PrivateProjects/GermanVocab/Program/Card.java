package Program;

public class Card {
	private String gerWord;
	private String engWord;
	private int chapter;
	private String type;
	
	public Card(int i, String t, String g, String e){
		gerWord = g;
		engWord = e;
		chapter = i;
		type = t;
	}
	
	public String getGer(){
		return gerWord;
	}
	
	public String getEng(){
		return engWord;
	}
	
	public int getChapter(){
		return chapter;
	}
	
	public String getType(){
		return type;
	}
}
