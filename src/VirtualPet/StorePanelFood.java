package virtualPet;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import properties.*;
import pets.Pet;

public class StorePanelFood extends JPanel implements ActionListener {
	
	JButton kibbleCrunch, beefAndVeggieMix, chickenFeast, salmonDelight, lambAndRiceBowl, goldenChickenNuggets;
	JButton flakes, algaeCrisps, shrimpPellets, spirulinaFlakes, caviarPearls, deepAbyssInfusion;
	JButton fiveFishKibble, veggieMedley, expensiveMelk, turkeyAndCranberryTreats, bluefinTunaSteak, aGoldenRat;
	
	Pet p;
	
	public StorePanelFood(CardLayout cardLayout, JPanel cardPanel, Pet pet) {
		 p = pet;
		
		 setLayout(new BorderLayout());
	     setBackground(Color.magenta);
	     
	     //Add title
	     JLabel titleLabel = new JLabel("Welcome to the Food Store! Green is dog food, Blue is cat food, and Red is fish food.", SwingConstants.CENTER);
	     titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
	     add(titleLabel, BorderLayout.NORTH);
	     
	     JPanel allFPanel = new JPanel();
	     allFPanel.setLayout(new GridLayout(1, 3, 10, 10));
	     
	     
	     // Create panel
	     JPanel dogFoodPanel = new JPanel();
	     dogFoodPanel.setLayout(new GridLayout(3, 2, 8, 8));
	     dogFoodPanel.setBackground(Color.GREEN);
	     
	     // Create buttons
	     kibbleCrunch = new JButton("Kibble Crunch: $10.00");
	     beefAndVeggieMix = new JButton("Beef & Veggie Mix: $20.00");
	     chickenFeast = new JButton("Chicken Feast: $30.00");
	     salmonDelight = new JButton("Salmon Delight: $50.00");
	     lambAndRiceBowl = new JButton("Lamb and Rice Bowl: $70.00");
	     goldenChickenNuggets = new JButton("Golden Chicken Nuggets: $100.00");
	     
	     // Setting the names of the buttons
	     kibbleCrunch.setName("Kibble Crunch");
	     beefAndVeggieMix.setName("Beef and Veggie Mix");
	     chickenFeast.setName("Chicken Feast");
	     salmonDelight.setName("Salmon Delight");
	     lambAndRiceBowl.setName("Lamb and Rice Bowl");
	     goldenChickenNuggets.setName("Golden Chicken Nuggets");
	     
	     // Add buttons to screen
	     dogFoodPanel.add(kibbleCrunch);
	     dogFoodPanel.add(beefAndVeggieMix);
	     dogFoodPanel.add(chickenFeast);
	     dogFoodPanel.add(salmonDelight);
	     dogFoodPanel.add(lambAndRiceBowl);
	     dogFoodPanel.add(goldenChickenNuggets);
	     
	     // Track when the buttons are clicked
	     kibbleCrunch.addActionListener(this);
	     beefAndVeggieMix.addActionListener(this);
	     chickenFeast.addActionListener(this);
	     salmonDelight.addActionListener(this);
	     lambAndRiceBowl.addActionListener(this);
	     goldenChickenNuggets.addActionListener(this);
	     
	     // Creating new panel
	     JPanel catFoodPanel = new JPanel();
	     catFoodPanel.setLayout(new GridLayout(3, 2, 8, 8));
	     catFoodPanel.setBackground(Color.BLUE);
	     
	     // Creating buttons
	     fiveFishKibble = new JButton("Five Fish Kibble: $10.00");
	     veggieMedley = new JButton("Veggie Medley: $20.00");
	     expensiveMelk = new JButton("Expensive Melk: $30.00");
	     turkeyAndCranberryTreats = new JButton("Turkey And Cranberry Treats: $50.00");
	     bluefinTunaSteak = new JButton("Bluefin Tuna Steak: $70.00");
	     aGoldenRat = new JButton("A Golden Rat: $100.00");
	     
	     // Naming buttons
	     fiveFishKibble.setName("Five Fish Kibble");
	     veggieMedley.setName("Veggie Medley");
	     expensiveMelk.setName("Expensive Melk");
	     turkeyAndCranberryTreats.setName("Turkey And Cranberry Treats");
	     bluefinTunaSteak.setName("Bluefin Tuna Steak");
	     aGoldenRat.setName("A Golden Rat");
	     
	     // Adding buttons to window
	     catFoodPanel.add(fiveFishKibble);
	     catFoodPanel.add(veggieMedley);
	     catFoodPanel.add(expensiveMelk);
	     catFoodPanel.add(turkeyAndCranberryTreats);
	     catFoodPanel.add(bluefinTunaSteak);
	     catFoodPanel.add(aGoldenRat);
	     
	     fiveFishKibble.addActionListener(this);
	     veggieMedley.addActionListener(this);
	     expensiveMelk.addActionListener(this);
	     turkeyAndCranberryTreats.addActionListener(this);
	     bluefinTunaSteak.addActionListener(this);
	     aGoldenRat.addActionListener(this);
	     
	     
	     // Creates new panel
	     JPanel fishFoodPanel = new JPanel();
	     fishFoodPanel.setLayout(new GridLayout(3, 2, 8, 8));
	     fishFoodPanel.setBackground(Color.RED);
	       
	     // Creates Jbuttons
	     flakes = new JButton("Flakes: $10.00"); 
	     algaeCrisps = new JButton("Algae Crisps: $20.00"); 
	     shrimpPellets = new JButton("Shrimp Pellets: $30.00"); 
	     spirulinaFlakes = new JButton("Spirulina Flakes: $50.00"); 
	     caviarPearls = new JButton("Caviar Pearls: $70.00"); 
	     deepAbyssInfusion = new JButton("Deep Abyss Infusion: $100.00"); 
	     
	     // Names Jbuttons
	     flakes.setName("Flakes"); 
	     algaeCrisps.setName("Algae Crisps"); 
	     shrimpPellets.setName("Shrimp Pellets"); 
	     spirulinaFlakes.setName("Spirulina Flakes"); 
	     caviarPearls.setName("Caviar Pearls"); 
	     deepAbyssInfusion.setName("Deep Abyss Infusion"); 

	     // Adds buttons to window
	     fishFoodPanel.add(flakes);
	     fishFoodPanel.add(algaeCrisps);
	     fishFoodPanel.add(shrimpPellets);
	     fishFoodPanel.add(spirulinaFlakes);
	     fishFoodPanel.add(caviarPearls);
	     fishFoodPanel.add(deepAbyssInfusion);
	     
	     JButton bButton = new JButton("Return to home");
	     bButton.addActionListener(e -> {
	        cardLayout.show(cardPanel, "Game");
	     });
	     add(bButton, BorderLayout.SOUTH); 

	     
	     allFPanel.add(dogFoodPanel);
	     allFPanel.add(fishFoodPanel);
	     allFPanel.add(catFoodPanel);
	        
	     add(allFPanel, BorderLayout.CENTER);
	     
	     
	     
	     
	     
	     
	}    
	
	
	 public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource(); //returns the object that fired the event, but casted as a JButton, and instantiates it
			
			Money store = new Money();
	        JButton[] dogFood = new JButton[] {kibbleCrunch, beefAndVeggieMix, chickenFeast, salmonDelight, lambAndRiceBowl, goldenChickenNuggets};

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
	        
	        
	        JButton[] fishFood = new JButton[] {flakes, algaeCrisps, shrimpPellets, spirulinaFlakes, caviarPearls, deepAbyssInfusion};

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
	        
	        
	        JButton[] catFood = new JButton[] {fiveFishKibble, veggieMedley, expensiveMelk, turkeyAndCranberryTreats, bluefinTunaSteak, aGoldenRat};

	        
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
