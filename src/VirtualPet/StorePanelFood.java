package VirtualPet;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class StorePanelFood extends JPanel{
	
	JButton kibbleCrunch, beefAndVeggieMix, chickenFeast, salmonDelight, lambAndRiceBowl, goldenChickenNuggets;
	JButton flakes, algaeCrisps, shrimpPellets, spirulinaFlakes, caviarPearls, deepAbyssInfusion;
	JButton fiveFishKibble, veggieMedley, expensiveMelk, turkeyAndCranberryTreats, bluefinTunaSteak, aGoldenRat;
	
	public StorePanelFood(CardLayout cardLayout, JPanel cardPanel) {
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
	     
		
		
	
	

	

}
