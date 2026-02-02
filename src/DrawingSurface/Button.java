package DrawingSurface;
import properties.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.CardLayout;


public class Button extends JPanel implements ActionListener {
	public JButton feed, rest, clean, vet, play, store;
	
	 private CardLayout cardLayout;
	 private JPanel cardPanel;
	
	public Button(CardLayout cardLayout, JPanel cardPanel) {
		this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        
		// Creates the buttons
		
	    JPanel panel = new JPanel(); //This is the Panel that sections off things. 
	    panel.setLayout(new GridLayout(6, 1, 10, 10)); //This affects how things look INSIDE the panel; buttons, etc.
	    panel.setPreferredSize(new Dimension(200, 455)); //when set length to 500, it doesn't fit in frame for some reason :c
	    panel.setBackground(Color.BLUE);
		
		feed = new JButton("Feed"); 
		rest = new JButton("Rest");
		clean = new JButton("Clean");
		vet = new JButton("Vet");
		play = new JButton("Play");
		store = new JButton("Store");
		
//		feed.setPreferredSize(new Dimension(100,50));
//		rest.setPreferredSize(new Dimension(100,50));
//		clean.setPreferredSize(new Dimension(100,50));
//		vet.setPreferredSize(new Dimension(100,50));
//		play.setPreferredSize(new Dimension(100,50));
//		store.setPreferredSize(new Dimension(100,50));
		
		feed.addActionListener(this);
		rest.addActionListener(this);
		clean.addActionListener(this);
		vet.addActionListener(this);
		play.addActionListener(this);
		store.addActionListener(this);

	  //panel.add(feed); add panel later(?) panel.add(feed);
	  
	  
		add(feed);
		add(rest);
		add(clean);
		add(vet);
		add(play);
		add(store);

	//  button2.addActionListener(this);
	  
	//button2.addActionListener(this);
	  
	//button2.addActionListener(this);
	  
	//button2.addActionListener(this);
	  
	//button2.addActionListener(this);
	  

	}
		
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource(); //returns the object that fired the event, but casted as a JButton, and instantiates it
    
		if(button == feed) {
			System.out.println("Feeding");
		}
		else if(button == rest) {
			System.out.println("Resting");

		}
		else if(button == clean) {
			System.out.println("Cleaning");
	
		}
		else if(button == vet) {
			System.out.println("Veting");

		}
		else if(button == play) {
			System.out.println("Playing");

		}
		else if(button == store) {
			System.out.println("Buying");
			
			cardLayout.show(cardPanel, "Store");

		}
	}
}
