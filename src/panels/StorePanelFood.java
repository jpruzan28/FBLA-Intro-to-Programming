package panels;

import DrawingSurface.*;
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
	    	  // Dog food buttons
	        kibbleCrunch        = new ItemButton("Kibble Crunch",         "Cost: $10.00", "Level: 1", "Images/Toy_Icons/dog1.png");
	        salmonDelight       = new ItemButton("Salmon Delight",        "Cost: $50.00", "Level: 2", "Images/Toy_Icons/dog2.png");
	        goldenChickenNuggets = new ItemButton("Golden Chicken Nuggets","Cost: $100.00","Level: 3", "Images/Toy_Icons/dog3.png");

	        // Fish food buttons
	        flakes              = new ItemButton("Flakes",                "Cost: $10.00", "Level: 1", "Images/Toy_Icons/fish1.png");
	        algaeCrisps     = new ItemButton("algaeCrisps",      "Cost: $50.00", "Level: 2", "Images/Toy_Icons/fish2.png");
	        deepAbyssInfusion   = new ItemButton("Deep Abyss Infusion",   "Cost: $100.00","Level: 3", "Images/Toy_Icons/fish3.png");

	        // Cat food buttons
	        fiveFishKibble          = new ItemButton("Five Fish Kibble",          "Cost: $10.00", "Level: 1", "Images/Toy_Icons/cat1.png");
	        turkeyAndCranberryTreats = new ItemButton("Turkey And Cranberry Treats","Cost: $50.00","Level: 2", "Images/Toy_Icons/cat2.png");
	        aGoldenRat              = new ItemButton("A Golden Rat",              "Cost: $100.00","Level: 3", "Images/Toy_Icons/cat3.png");


	        // Set positions of each button
	        kibbleCrunch.setBounds(180,  150, 270, 150);
	        salmonDelight.setBounds(180,  385, 270, 150);
	        goldenChickenNuggets.setBounds(65+240,  600, 270, 150);
	        fiveFishKibble.setBounds(600+125,  150, 270, 150);
	        turkeyAndCranberryTreats.setBounds(600+125, 385, 270, 150);
	        aGoldenRat.setBounds(600+125,  600, 270, 150);
	        flakes.setBounds(1270,  150, 270, 150);
	        algaeCrisps.setBounds(1270,  385, 270, 150);
	        deepAbyssInfusion.setBounds(1270,  600, 270, 150);

	        // Add action listeners
	        kibbleCrunch.addActionListener(this);
	        salmonDelight.addActionListener(this);
	        goldenChickenNuggets.addActionListener(this);
	        flakes.addActionListener(this);
	        algaeCrisps.addActionListener(this);
	        deepAbyssInfusion.addActionListener(this);
	        fiveFishKibble.addActionListener(this);
	        turkeyAndCranberryTreats.addActionListener(this);
	        aGoldenRat.addActionListener(this);

	        // Add to layered pane
	        layeredPane.add(kibbleCrunch,             JLayeredPane.PALETTE_LAYER);
	        layeredPane.add(salmonDelight,            JLayeredPane.PALETTE_LAYER);
	        layeredPane.add(goldenChickenNuggets,     JLayeredPane.PALETTE_LAYER);
	        layeredPane.add(flakes,                   JLayeredPane.PALETTE_LAYER);
	        layeredPane.add(algaeCrisps,          JLayeredPane.PALETTE_LAYER);
	        layeredPane.add(deepAbyssInfusion,        JLayeredPane.PALETTE_LAYER);
	        layeredPane.add(fiveFishKibble,           JLayeredPane.PALETTE_LAYER);
	        layeredPane.add(turkeyAndCranberryTreats, JLayeredPane.PALETTE_LAYER);
	        layeredPane.add(aGoldenRat,               JLayeredPane.PALETTE_LAYER);
	     	     
	     JButton bButton = new JButton("Return to home");
	     bButton.addActionListener(e -> {
	        cardLayout.show(cardPanel, "Home");
	     });
	     bButton.setBounds(0, 0, 80, 80);
	     layeredPane.add(bButton, JLayeredPane.PALETTE_LAYER); 
	     
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
