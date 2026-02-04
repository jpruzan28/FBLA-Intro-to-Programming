package virtualPet;
import DrawingSurface.*;
import DrawingSurface.Button;
import pets.Pet;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Color;
import java.awt.Container;
import java.util.Scanner;
import javax.swing.*;


public class main extends JFrame{
	
	private static Pet pet;
	private static String petType, petName; 
	
	public main() {
	    Container c = getContentPane();
	    // Creating cardLayout and container panel
	    CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        Button buttons = new Button(cardLayout, cardPanel, pet);
        mainPanel.add(buttons, BorderLayout.CENTER);
        
        
        //Store panel stuff
        StorePanel storePanel = new StorePanel(cardLayout, cardPanel);
        
        // adding both panels to CardLayout 
        cardPanel.add(mainPanel, "Game");
        cardPanel.add(storePanel, "Store");
        
        // add the cardPanel to the frame
        c.add(cardPanel);
        
        // Show main panel first
        cardLayout.show(cardPanel, "Game");
	    
	}
	

	public static void main(String[] args) {
	    //User input
	    String playerName = JOptionPane.showInputDialog("Welcome player! What's your name?");
	    JOptionPane.showMessageDialog(null, "Nice to meet you " + playerName);
	    
	     petType = JOptionPane.showInputDialog("A little birdie told me your looking to take care of a pet, what pet do you want, we have a fish, a dog, and a cat? \n please type in 'dog', 'cat', or 'fish' ");
	    JOptionPane.showMessageDialog(null, "Nice choice, choosing a " + petType);
		
	     petName = JOptionPane.showInputDialog("What would you like to name your " + petType + "?");
	    
	    // Creating the pet
	    pet = new Pet(petName, petType);
	    
	    main w = new main();
	    w.setBounds(300, 300, 400, 400);
	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    w.setVisible(true);
	}
	
}
