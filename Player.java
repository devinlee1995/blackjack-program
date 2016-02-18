
public class Player {
	private Card a[]=new Card[30];
	private int playerHand=0;
	private String LastCard; 

	
	public Player(){
		
	}; 
	
	public void dealCard(Card b){
		if(playerHand<30){
			int x=0;
			while(a[x]!=null){
				if(b.getValue()<a[x].getValue()){
					for(int i=29;i>x;i--){
						a[i]=a[i-1];
					}
					a[x]=b;
				}
				x++;
			}
		playerHand++;
		}
	}
	public Card playCard(int x){
	
		for(int j=0;j<30;j++){
				if(a[j].getValue()==x){
					Card Temp = a[j];
					for(int l=j;l<29;l++){
						a[l]=a[l+1];
					}
					return Temp;
				}
		}
		return a[0];
	}
	
	public void dealTo(Card c) { a[playerHand++] = c;    }    // insert card
	public void reset()        { playerHand = 0;             }    // discard all cards
	
	
	
	 // compute value of blackjack hand
    public int value() {
        int val = 0;
        boolean hasAce = false;
        for (int i = 0; i < playerHand; i++) {
            val = val + a[i].getBJValue(a[i]);
            if (a[i].getBJValue(a[i])==1 ) hasAce = true;
        }
        if (hasAce && (val <= 11)) val = val + 10;          // handle ace = 1 or 11
        return val;
    }
    
    //String of Entire Hand
    public String toString() {
    	String s = "";
        for (int i = 0; i < playerHand; i++)
            s += a[i].getFaceValue(a[i]) + " " + a[i].getBJValue(a[i]) + "\n"; 
        return s;
    }
    
    public String hitCard() { //String of Lastly Added Card to Hand
    	LastCard = a[playerHand-1].getFaceValue(a[playerHand-1]) + a[playerHand-1].getBJValue(a[playerHand-1]) + "\n";
    	return LastCard; 
    }

}

