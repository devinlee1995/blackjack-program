import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class BJGUI extends JFrame implements ActionListener{
	
	Deck deck; 
	Panel buttons = new Panel(); 
	
	
	
	private Player player =new Player();
	private Player dealer = new Player(); 
	
	Button start = new Button("Start");
	Button exit = new Button("Exit");
	Button hit = new Button("Hit");
	Button stay = new Button("Stay");
	Button restart = new Button("Play Again"); 
	
	private TextArea User = new TextArea(); //Player's Text Area
	private TextArea Computer = new TextArea(); //Dealer's Text Area
	
	 public BJGUI(){
	      setTitle("BJ Game");
		  setSize(500,500);
		  setLayout(new GridLayout(1,3));	
		  setVisible(true);
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
		  setLocation(500,500);
		  
		  //hit, stay, play again, exit buttons 
		  buttons.add(start); 
		  buttons.add(hit);
	      buttons.add(stay);
	      buttons.add(restart); 
	      buttons.add(exit);
	    
		  
		  Container myContentPane = getContentPane();
		  
		  
		  myContentPane.add(User); 
		  myContentPane.add(buttons);
		  myContentPane.add(Computer); 
		
		  
		  start.addActionListener(this);
		  start.setEnabled(true);
		  exit.addActionListener(this);
		  exit.setEnabled(true);
		  hit.addActionListener(this);
		  hit.setEnabled(false);
		  stay.addActionListener(this);
		  stay.setEnabled(false);
		  restart.addActionListener(this);
		  restart.setEnabled(false); 
		  
		
		  
		  pack(); 

	 }
	 
	 private void first_deal(Player player) { //dealing a card in beginning
	        player.dealTo(deck.deal());
	    }
	 
	 private void hit_user(Player player) { //card gained for user from hit 
		 player.dealTo(deck.deal()); 
		 User.append(player.hitCard());
	 }
	 
	 private void hit_dealer(Player player) { //card gained for dealer
		 player.dealTo(deck.deal()); 
		 Computer.append(player.hitCard()); 
	 }
	 
		
	// deal out two cards each and adds text to TextArea
	 private void deal() {
		 player.reset(); 
		 dealer.reset(); 
		 deck = new Deck();
		 deck.shuffle();
		 first_deal(player);
	     first_deal(dealer);
	     first_deal(player);
	     first_deal(dealer);
	     User.append(player.toString()); 
	     Computer.append(dealer.toString());
	  
	     
	     
	 }
	 
	 public void clearboard() { //clears board for new game
		 User.setText("");
		 Computer.setText(""); 
	 }
		 
	 
	 private void checkWinner() { //says who wins and loses
	        if      (player.value() >  21)              {JOptionPane.showMessageDialog(null,"You bust");}
	        else if (dealer.value()  >  21)             {JOptionPane.showMessageDialog(null,"Dealer busts");}
	        else if (player.value() == dealer.value())  {JOptionPane.showMessageDialog(null,"Push");}
	        else if (player.value() >  dealer.value())  {JOptionPane.showMessageDialog(null,"You win");}
	        else JOptionPane.showMessageDialog(null,"Dealer wins");
	        
	    }

	 
	// processes a button push
	    public void actionPerformed(ActionEvent e) {
	    	if (e.getSource() == start) {
	    		deal(); 
	    		hit.setEnabled(true); 
	    		stay.setEnabled(true); 
	    	}
	        if (e.getSource() == hit) {
	            hit_user(player);
	            if(player.value() > 21) {
	                checkWinner();
	                hit.setEnabled(false);
	                stay.setEnabled(false);
	                start.setEnabled(false); 
	                restart.setEnabled(true); 

           }
	        }

	        if (e.getSource() == stay) {
	            while(dealer.value() < 17)
	                hit_dealer(dealer);
	            checkWinner();
	            hit.setEnabled(false);
	            stay.setEnabled(false);
	            start.setEnabled(true);
	            restart.setEnabled(true); 
	        }

	        if (e.getSource() == restart) {
	        	clearboard(); 
	        	deal(); 
	            hit.setEnabled(true);
	            stay.setEnabled(true);
	            start.setEnabled(false);
	        }
	        
	        if (e.getSource() == exit) {
	            System.exit(0);
	        }
	    }
	 
}
	 

