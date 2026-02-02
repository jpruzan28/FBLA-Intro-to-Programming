package VirtualPet;
import DrawingSurface.*;
import DrawingSurface.Button;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Color;
import java.awt.Container;
import java.util.Scanner;
import javax.swing.*;


public class main extends JFrame{
	
	public main() {
	    Container c = getContentPane();
	    // Creating cardLayout and container panel
	    CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        Button buttons = new Button(cardLayout, cardPanel);
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
	    main w = new main();
	    w.setBounds(300, 300, 400, 400);
	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    w.setVisible(true);
	    
	    
	    //User input
	    String name = JOptionPane.showInputDialog("Welcome player! What's your name?");
	    JOptionPane.showMessageDialog(null, "Nice to meet you " + name);
	    
	    String pet = JOptionPane.showInputDialog("A little birdie told me your looking to take care of a pet, what pet do you want, we have a fish, a dog, and a cat? \n please type in 'dog', 'cat', or 'fish' ");
	    JOptionPane.showMessageDialog(null, "Nice choice, choosing a " + pet);
		
	}
	
}
