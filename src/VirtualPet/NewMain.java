package VirtualPet;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pets.Pet;
import DrawingSurface.*;

public class NewMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame(); 
		
		frame.setTitle("Virtual Pet");
		frame.setBounds(0, 0, 1900, 1060);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.green);
		    
		
	 // Creating cardLayout and container panel
	    CardLayout cardLayout = new CardLayout();
	    JPanel cardPanel = new JPanel(cardLayout);
	    
	    frame.add(cardPanel);
	    
	  //User input
	 /*   String playerName = JOptionPane.showInputDialog("Welcome player! What's your name?");
	    JOptionPane.showMessageDialog(null, "Nice to meet you " + playerName);
	    
	    // Ensures the user only enters a valid pet option
	    String petType = "";
	    while(!(petType.equals("cat")) && !(petType.equals("dog")) && !(petType.equals("fish"))) {
		     petType = JOptionPane.showInputDialog("A little birdie told me your looking to take care of a pet, what pet do you want, we have a fish, a dog, and a cat? \n please type in 'dog', 'cat', or 'fish' ");
		
		    if(!(petType.equals("cat")) && !(petType.equals("dog")) && !(petType.equals("fish"))) {
			    JOptionPane.showMessageDialog(null, "Sorry that pet is not an option, please enter an available option");

		    }
	    }
	    
	    JOptionPane.showMessageDialog(null, "Nice choice, choosing a " + petType);

	    String petName = JOptionPane.showInputDialog("What would you like to name your " + petType + "?");
	    //*/
	    
	    // Creating the pet
	    Pet pet = new Pet("Josh", "cat");

	    // Creating cardPanels 
	    DrawingSurface drawingSurface = new DrawingSurface(cardLayout, cardPanel, frame.getWidth(), frame.getHeight(), pet);
		
	    cardLayout.show(cardPanel, "Home");  // ← capital H to match the key above

	    
	    frame.setVisible(true);

	}

}
