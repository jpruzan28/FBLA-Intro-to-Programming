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
import properties.Toys;
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
	     JLabel titleLabel = new JLabel("Welcome to the Food Store! Green is dog toys, Blue is cat toys, and Red is fish", SwingConstants.CENTER);
	     titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
	     add(titleLabel, BorderLayout.NORTH);
	     
	     JPanel allFPanel = new JPanel();
	     allFPanel.setLayout(new GridLayout(1, 3, 10, 10));
	     
	     
	     // Add store items panel
	     JPanel dogFoodPanel = new JPanel();
	     dogFoodPanel.setLayout(new GridLayout(3, 2, 8, 8));
	     dogFoodPanel.setBackground(Color.GREEN);
	     
	     kibbleCrunch = new JButton("Kibble Crunch");
	     beefAndVeggieMix = new JButton("Beef and Veggie Mix");
	     chickenFeast = new JButton("Chicken Feast");
	     salmonDelight = new JButton("Salmon Delight");
	     lambAndRiceBowl = new JButton("Lamb and Rice Bowl");
	     goldenChickenNuggets = new JButton("Golden Chicken Nuggets");
	     
	     dogFoodPanel.add(kibbleCrunch);
	     dogFoodPanel.add(beefAndVeggieMix);
	     dogFoodPanel.add(chickenFeast);
	     dogFoodPanel.add(salmonDelight);
	     dogFoodPanel.add(lambAndRiceBowl);
	     dogFoodPanel.add(goldenChickenNuggets);
	     
	     kibbleCrunch.addActionListener(this);
	     beefAndVeggieMix.addActionListener(this);
	     chickenFeast.addActionListener(this);
	     salmonDelight.addActionListener(this);
	     lambAndRiceBowl.addActionListener(this);
	     goldenChickenNuggets.addActionListener(this);
	     
	     
	     JPanel catFoodPanel = new JPanel();
	     catFoodPanel.setLayout(new GridLayout(3, 2, 8, 8));
	     catFoodPanel.setBackground(Color.BLUE);
	     
	     fiveFishKibble = new JButton("Five Fish Kibble");
	     veggieMedley = new JButton("Veggie Medley");
	     expensiveMelk = new JButton("Expensive Melk");
	     turkeyAndCranberryTreats = new JButton("Turkey And Cranberry Treays");
	     bluefinTunaSteak = new JButton("Bluefin Tuna Steak");
	     aGoldenRat = new JButton("A Golden Rat");
	     
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
	     
	     
	     JPanel fishFoodPanel = new JPanel();
	     fishFoodPanel.setLayout(new GridLayout(3, 2, 8, 8));
	     fishFoodPanel.setBackground(Color.RED);
	       
	        
	     flakes = new JButton("Flakes"); 
	     algaeCrisps = new JButton("Algae Crisps"); 
	     shrimpPellets = new JButton("Shrimp Pellets"); 
	     spirulinaFlakes = new JButton("Spirulina Flakes"); 
	     caviarPearls = new JButton("Caviar Pearls"); 
	     deepAbyssInfusion = new JButton("Deep Abyss Infusion"); 

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
