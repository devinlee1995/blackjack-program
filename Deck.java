import java.util.Random;

/**
 * 
 *
 * 
 * Deck stores each Card object in a Card array and has a shuffle and deal method. 
 * Shuffle randomizes the cards. 
 * Deal hands out the cards depending on how many players the user chooses. 
 *
 */
public class Deck {
	public static Card c [] = new Card[52];   
	private int placeHolder = 1; 
	
	public Deck() { //constructor makes new Card objects per Suite 
		int position = 0; 
		for (int i = 2; i <= 14; i++) {
			c[position++] = new Card (i, "spade"); 
			c[position++] = new Card (i, "heart"); 
			c[position++] = new Card (i, "diamond"); 
			c[position++] = new Card (i, "club"); 
			
		}
		
	}; 
	/**
	 * Method that shuffles cards by swapping with randomly generated indexes
	 */
	public static void shuffle(){
	    Random randomIndex = new Random();
		Card temp; 
		
		for(int b=0;b<52;b++){
			//picks a random index from 0 and 52)  
			int index = randomIndex.nextInt(52);
			
			//swaps original card array and newly shuffled one 
			temp = c[b]; 
			c[b] = c[index]; 
			c[index] = temp; 
			 
			
		}
		
		//for (int i = 0; i < 52; i++) {
			//System.out.println(c[i].getFaceValue(c[i]) + c[i].getBJValue(c[i]));
		//}
		
	}; 
	
	public Card deal() {
		placeHolder++; 
		return c[placeHolder-1]; 
	}
	
	
			

}; 

