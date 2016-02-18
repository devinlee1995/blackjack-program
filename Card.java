/**
 * 
 * 
 * 
 * This is a class that represents the value of a single playing card. 
 * 
 * Type = (Clubs, Diamond, Heart, Spade)
 * Face Value = 2-14 where (2-10, Jack, Queen, King, Ace) 
 * BJ Value = numerical value of the card itself 
 */

public class Card {
	
	private int Value; 
	private String Type;

	
	public Card (int x, String y) {
		Value = x; 
		Type = y;
		
		
	}; 
	
	private void setValue (int x) {
		Value = x; 
	}
	
	public int getValue () {
		return Value; 
	};
	
	public int getBJValue (Card c) {
		int BJValue = 0; 
		if (c.Value== 11 || c.Value == 12 || c.Value == 13) {BJValue=10;}
		else if (c.Value == 14)  {BJValue = 1;}
		else BJValue = c.Value; 
		return BJValue; 
	}
	
	
	public String getType () {
		return Type; 
	}; 
	
	public static String getFaceValue (Card c) {
		String FaceValue = "";  
		if (c.Value == 11) {FaceValue = "Jack of " + c.Type ;} 
		else if (c.Value == 12) {FaceValue = "Queen of" + c.Type;}
		else if (c.Value == 13) {FaceValue = "King of " + c.Type;} 
		else if (c.Value == 14) {FaceValue = "Ace of " + c.Type;}
		if (c.Value < 11) FaceValue = String.valueOf(c.Value) + " of " + c.Type;
		return FaceValue; 
	}
	
	public void printCard(Card c){
		if(c.Value==14) System.out.println("Ace of "+c.Type);
		else if(c.Value==11) System.out.println("Jack of "+c.Type);
		else if(c.Value==12) System.out.println("Queen of "+c.Type);
		else if(c.Value==13) System.out.println("King of "+c.Type);
		else System.out.print(c.Value+" of "+c.Type);
		
	}; 
	
	
}
	
	

