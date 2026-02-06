package VirtualPet;
import DrawingSurface.*;
import DrawingSurface.Button;
import pets.Pet;

import java.util.TimerTask;
import java.util.Timer;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Color;
import java.awt.Container;
//import java.util.Scanner;
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
        StorePanelFood storePanelFood = new StorePanelFood(cardLayout, cardPanel);
        
        
        // adding both panels to CardLayout 
        cardPanel.add(mainPanel, "Game");
        cardPanel.add(storePanel, "Store");
        cardPanel.add(storePanelFood, "FStore");
        
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
	    
	    
	    //Reduction Timer
	    //1. instatiate outer class, needed bc the inner classes rely on the pet
	    ReductionTimer reductionTimers = new ReductionTimer(pet);
	    
	    Timer timer = new Timer();
	    
	    timer.schedule(reductionTimers.new reduceHunger(), 0 , 120000); //decreases in milliseconds
	    timer.schedule(reductionTimers.new reduceHealth(), 0 , 120000);
	    timer.schedule(reductionTimers.new reduceHygiene(), 0 , 120000);
	    timer.schedule(reductionTimers.new reduceRest(), 0 , 300000);
	    timer.schedule(reductionTimers.new reduceEmotion(), 0 , 120000);
	    
	    
	    main w = new main();
	    w.setBounds(300, 300, 400, 400);
	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    w.setVisible(true);
	}
	
}
