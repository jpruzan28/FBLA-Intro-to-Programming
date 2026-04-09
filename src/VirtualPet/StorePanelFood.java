package VirtualPet;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import properties.*;
import pets.Pet;

public class StorePanelFood extends JPanel implements ActionListener {
	
	JButton kibbleCrunch, salmonDelight, goldenChickenNuggets;
	JButton flakes, algaeCrisps, deepAbyssInfusion;
	JButton fiveFishKibble, turkeyAndCranberryTreats, aGoldenRat;
	
	private BackgroundPanel backgroundPanel;
    private JLayeredPane layeredPane;
    JPanel allFoodPanel; 
    
	Pet p;
	
	public StorePanelFood(CardLayout cardLayout, JPanel cardPanel, Pet pet) {
		 p = pet;
		
		 setLayout(new BorderLayout());
		 
			allFoodPanel = new JPanel(new BorderLayout());

	        //A panel where all the toys are on here so they don't get stacked
	    	layeredPane = new JLayeredPane();
	    	
	    	layeredPane.setLayout(null);
	    	layeredPane.setPreferredSize(new Dimension(1900, 1060)); // give it an initial size
	    	allFoodPanel.add(layeredPane, BorderLayout.CENTER);

	    	add(allFoodPanel, BorderLayout.CENTER);
	    	addBackground();
	     
//	     // Create buttons
//	     kibbleCrunch = new JButton("Kibble Crunch: $10.00");
//	     salmonDelight = new JButton("Salmon Delight: $50.00");
//	     goldenChickenNuggets = new JButton("Golden Chicken Nuggets: $100.00");
	     fiveFishKibble = new JButton("Five Fish Kibble: $10.00");
	     turkeyAndCranberryTreats = new JButton("Turkey And Cranberry Treats: $50.00");
	     aGoldenRat = new JButton("A Golden Rat: $100.00");
	     flakes = new JButton("Flakes: $10.00"); 
	     algaeCrisps = new JButton("Algae Crisps: $20.00"); 
	     deepAbyssInfusion = new JButton("Deep Abyss Infusion: $100.00"); 
//	     
//	     
//	     // Setting the names of the buttons
//	     kibbleCrunch.setName("Kibble Crunch");
//	     salmonDelight.setName("Salmon Delight");
//	     goldenChickenNuggets.setName("Golden Chicken Nuggets");
	     flakes.setName("Flakes"); 
	     algaeCrisps.setName("Algae Crisps"); 
	     deepAbyssInfusion.setName("Deep Abyss Infusion"); 
//	     fiveFishKibble.setName("Five Fish Kibble");
//	     turkeyAndCranberryTreats.setName("Turkey And Cranberry Treats");
//	     aGoldenRat.setName("A Golden Rat");
//	     
//	     // Add buttons to screen
//	     allFoodPanel.add(kibbleCrunch);
//	     allFoodPanel.add(salmonDelight);
//	     allFoodPanel.add(goldenChickenNuggets);
//	     
//	     
//	     // Track when the buttons are clicked
//	     kibbleCrunch.addActionListener(this);
//	     salmonDelight.addActionListener(this);
//	     goldenChickenNuggets.addActionListener(this);
//	     
//	     // CAT
//	     // Creating new panel
//	     JPanel catFoodPanel = new JPanel();
//	     catFoodPanel.setLayout(new GridLayout(3, 2, 8, 8));
//	    
//	     
//
//	     
//	     fiveFishKibble.addActionListener(this);
//	     turkeyAndCranberryTreats.addActionListener(this);
//	     aGoldenRat.addActionListener(this);
//	     
//	     // FISH
//	     // Creates new panel
	     JPanel fishFoodPanel = new JPanel();
	     fishFoodPanel.setLayout(new GridLayout(3, 2, 8, 8));
	     fishFoodPanel.setBackground(Color.RED);
//	       
//
//	     
//
//	     // Adds buttons to window
	     fishFoodPanel.add(flakes);
	     fishFoodPanel.add(algaeCrisps);
	     fishFoodPanel.add(deepAbyssInfusion);
	     
	     flakes.addActionListener(this); 
	     algaeCrisps.addActionListener(this); 
	     deepAbyssInfusion.addActionListener(this); 
//
//	     
	     allFoodPanel.add(fishFoodPanel);
	     JButton bButton = new JButton("Return to home");
	     bButton.addActionListener(e -> {
	        cardLayout.show(cardPanel, "Home");
	     });
	     add(bButton, BorderLayout.SOUTH); 

	     

	     
	     
	     
	     
	     
	     
	}    
	
	
	public void addBackground() {
		backgroundPanel = new BackgroundPanel("Images/Pet_Sprites/Untitled16.png");
		backgroundPanel.setBounds(0, 0, 1900, 1060);
		layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

		// Set layeredPane size immediately so it's not 0,0
		layeredPane.setSize(1900, 1060);

		allFoodPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
			@Override
			public void componentResized(java.awt.event.ComponentEvent e) {
				layeredPane.setSize(allFoodPanel.getSize());
				backgroundPanel.setBounds(0, 0, allFoodPanel.getWidth(), allFoodPanel.getHeight());
				layeredPane.revalidate();
			}
		});
	}

	 public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource(); //returns the object that fired the event, but casted as a JButton, and instantiates it
			
			Store store = new Store();
	        JButton[] dogFood = new JButton[] {kibbleCrunch, salmonDelight, goldenChickenNuggets};

	        // Goes through JButton array
	        for(JButton f: dogFood) {
	        	// Checks if the button clicked is the same as the JButton
	        	if (button.equals(f)) {
	        		// Goes through Toys array from Money class
	        		for(Food y: store.getDogFood()) {
	        			// Checks if the name of the toy matches the JButton name
	        			if(f.getName().equals(y.getName())) {
	        				store.buyFood(y, p);
	        			}
	        		}
	        	}
	        }
	        
	        
	        JButton[] fishFood = new JButton[] {flakes, algaeCrisps, deepAbyssInfusion};

	        // Goes through JButton array
	        for(JButton f: fishFood) {
	        	// Checks if the button clicked is the same as the JButton
	        	if (button.equals(f)) {
	        		// Goes through Toys array from Money class
	        		for(Food y: store.getFishFood()) {
	        			// Checks if the name of the toy matches the JButton name
	        			if(f.getName().equals(y.getName())) {
	        				store.buyFood(y, p);
	        			}
	        		}
	        	}
	        }
	        
	        
	        JButton[] catFood = new JButton[] {fiveFishKibble, turkeyAndCranberryTreats, aGoldenRat};

	        
	        // Goes through JButton array
	        for(JButton f: catFood) {
	        	// Checks if the button clicked is the same as the JButton
	        	if (button.equals(f)) {
	        		// Goes through Toys array from Money class
	        		for(Food y: store.getCatFood()) {
	        			// Checks if the name of the toy matches the JButton name 
	        			if(f.getName().equals(y.getName())) {
	        				store.buyFood(y, p);
	        			}
	        		}
	        	}
	        }

	    
	    }

}
