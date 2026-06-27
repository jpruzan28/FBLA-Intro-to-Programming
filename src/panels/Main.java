package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pets.Pet;
import DrawingSurface.*;

public class Main {

	public static void main(String[] args) {
		// Sets fonts for popups and makes them bigger
		UIManager.put("OptionPane.messageFont", new Font("SansSerif", Font.BOLD, 25));
		UIManager.put("OptionPane.buttonFont", new Font("SansSerif", Font.PLAIN, 20));
		UIManager.put("TextField.font", new Font("SansSerif", Font.PLAIN, 23));
		
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
	   String playerName = JOptionPane.showInputDialog("Welcome player! What's your name?");
	    JOptionPane.showMessageDialog(null, "Nice to meet you " + playerName);
	    
	    // Ensures the user only enters a valid pet option
	    String petType = "";
	    while(!(petType.equalsIgnoreCase("Dog")) && !(petType.equalsIgnoreCase("Cat")) && !(petType.equalsIgnoreCase("Fish"))) {
		     petType = JOptionPane.showInputDialog("A little birdie told me your looking to take care of a pet, what pet do you want, we have a fish, a dog, and a cat? \n please type in 'Dog', 'Cat', or 'Fish' ");
		
	    	
	    	// MAKES THE PET CHOICES BUTTONS 
	    	/*String[] options = {"Dog", "Cat", "Fish"};

	    	int choice = JOptionPane.showOptionDialog(
	    	    null,                            // parent (null = center on screen)
	    	    "Which pet would you like?",     // the message
	    	    "Choose Your Pet",               // the title bar text
	    	    JOptionPane.DEFAULT_OPTION,      // option type
	    	    JOptionPane.QUESTION_MESSAGE,    // icon shown (the little ?)
	    	    null,                            // custom icon (null = use default)
	    	    options,                         // your button labels
	    	    null                             // no button highlighted by default
	    	);

	    	if (choice == JOptionPane.CLOSED_OPTION) {
	    	    petType = null;                   // user closed with the X
	    	} else {
	    	    petType = options[choice];        // "Dog", "Cat", or "Fish"
	    	}*/
	    	
	    	
		    if(!(petType.equalsIgnoreCase("Dog")) && !(petType.equalsIgnoreCase("Cat")) && !(petType.equalsIgnoreCase("Fish"))) {
			    JOptionPane.showMessageDialog(null, "Sorry that is not an option, please click an available option");

		    }
	    }
	    
	    JOptionPane.showMessageDialog(null, "Nice choice, choosing a " + petType);

	    String petName = JOptionPane.showInputDialog("What would you like to name your " + petType + "?");
	    
	    String howToPlayMessage = "<html><center>"
	    		+ "<font color='#FF6B8B'>To make sure your new pet, " + petName + ", lives a happy and healthy life,<br>"
	            + "you need to make sure their needs are met.</font><br><br>"
	            + "Take care of your pet by navigating through the buttons around the screen,<br>"
	            + "and make sure to keep your pet at an overall good health level by playing,<br>"
	            + "feeding, cleaning, taking them to the vet, and putting them to bed!<br><br>"
	            + "<b>Don't forget to keep track of your currency and don't work spend!</b>"
	            + "</center></html>";
	    
	    JOptionPane.showMessageDialog(
	            null, 
	            howToPlayMessage, 
	            "How to Play", 
	            JOptionPane.INFORMATION_MESSAGE
	    );
	    
	    
	    // Creating the pet
	   Pet pet = new Pet(petName, petType, playerName);


	    
	    	    // Creating cardPanels 
	    DrawingSurface drawingSurface = new DrawingSurface(cardLayout, cardPanel, 1700, 1060, pet);
	    cardLayout.show(cardPanel, "Home");  // ← capital H to match the key above
	    
	    frame.setVisible(true);
	    
	    ReductionTimer reductionTimers = new ReductionTimer(pet, drawingSurface);
		Timer timer = new Timer();
		timer.schedule(reductionTimers.new reduceNutrition(),  25000, 25000);
		timer.schedule(reductionTimers.new reduceHygiene(), 25000, 25000);
		timer.schedule(reductionTimers.new reduceRest(),    25000, 25000);
		timer.schedule(reductionTimers.new reduceEmotion(), 25000, 25000);
		timer.schedule(reductionTimers.new updateHealth(),  25000, 10000);
		
		 javax.swing.Timer gameOverChecker = new javax.swing.Timer(1000, null);

	        // Create a regular ActionListener
	        ActionListener checkGameOver = new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (pet.getHealth() <= 0 ||
	                    pet.getHygiene() <= 0 ||
	                    pet.getEmotion() <= 0 ||
	                    pet.getRest()    <= 0 ||
	                    pet.getNutrition()  <= 0) {
	                        drawingSurface.gameOver();
	                        gameOverChecker.stop();
	                }
	            }
	        };

	        // Add the listener to the timer
	        gameOverChecker.addActionListener(checkGameOver);

	        // Start the timer
	        gameOverChecker.start();

		// Repaint loop
		while (true) {
			frame.repaint();
		}

	}

}
