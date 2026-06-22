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
    
    // Live display labels
    private JLabel moneyLabel;
    private JLabel expensesLabel;
    
	Pet p;
	
	public StorePanelFood(CardLayout cardLayout, JPanel cardPanel, Pet pet) {
		 p = pet;
		
		 setLayout(new BorderLayout());
		 
			allFoodPanel = new JPanel(new BorderLayout());

	    	layeredPane = new JLayeredPane();
	    	layeredPane.setLayout(null);
	    	layeredPane.setPreferredSize(new Dimension(1900, 1060)); 
	    	allFoodPanel.add(layeredPane, BorderLayout.CENTER);

	    	add(allFoodPanel, BorderLayout.CENTER);
	    	addBackground();
	    	
	    	// Top Status Overlay Panel for Financial Stats
	         JPanel statusPanel = new JPanel(new GridLayout(1, 2, 20, 0));
	         statusPanel.setOpaque(false);
	         statusPanel.setBounds(1250, 30, 500, 50); 

	         Font statusFont = new Font("Arial", Font.BOLD, 24);

	         moneyLabel = new JLabel("Balance: $" + String.format("%.2f", p.getMoney()), SwingConstants.RIGHT);
	         moneyLabel.setFont(statusFont);
	         moneyLabel.setForeground(new Color(50, 32, 32));

	         expensesLabel = new JLabel("Spent: $" + String.format("%.2f", p.getExpenses()), SwingConstants.RIGHT);
	         expensesLabel.setFont(statusFont);
	         expensesLabel.setForeground(new Color(140, 60, 60)); 

	         statusPanel.add(moneyLabel);
	         statusPanel.add(expensesLabel);
	         layeredPane.add(statusPanel, JLayeredPane.PALETTE_LAYER);
	    	
	        // Dog food buttons
	        kibbleCrunch         = new ItemButton("Kibble Crunch",         "Cost: $10.00", "Level: 1", "Images/Toy_Icons/dog1.png");
	        salmonDelight        = new ItemButton("Salmon Delight",        "Cost: $50.00", "Level: 2", "Images/Toy_Icons/dog2.png");
	        goldenChickenNuggets = new ItemButton("Gold Nuggets","Cost: $100.00","Level: 3", "Images/Toy_Icons/dog3.png");

	        // Fish food buttons
	        flakes            = new ItemButton("Flakes",                "Cost: $10.00", "Level: 1", "Images/Toy_Icons/fish1.png");
	        algaeCrisps       = new ItemButton("Algae Crisps",          "Cost: $50.00", "Level: 2", "Images/Toy_Icons/fish2.png");
	        deepAbyssInfusion = new ItemButton("Abyss Infusion",        "Cost: $100.00","Level: 3", "Images/Toy_Icons/fish3.png");

	        // Cat food buttons
	        fiveFishKibble           = new ItemButton("Fish Kibble",          "Cost: $10.00", "Level: 1", "Images/Toy_Icons/cat1.png");
	        turkeyAndCranberryTreats = new ItemButton("Turkey Treats","Cost: $50.00","Level: 2", "Images/Toy_Icons/cat2.png");
	        aGoldenRat               = new ItemButton("A Golden Rat",          "Cost: $100.00","Level: 3", "Images/Toy_Icons/cat3.png");

	        // FIX STEP 1: Explicitly map the internal text criteria mapping name field
	        kibbleCrunch.setName("Kibble Crunch");
	        salmonDelight.setName("Salmon Delight");
	        goldenChickenNuggets.setName("Gold Nuggets");
	        flakes.setName("Flakes");
	        algaeCrisps.setName("Algae Crisps");
	        deepAbyssInfusion.setName("Abyss Infusion");
	        fiveFishKibble.setName("Fish Kibble");
	        turkeyAndCranberryTreats.setName("Turkey Treats");
	        aGoldenRat.setName("A Golden Rat");

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
	        layeredPane.add(algaeCrisps,              JLayeredPane.PALETTE_LAYER);
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
	     
	        // Initialize display values right at startup
	        updateBalanceDisplay();
	}    
	
	public void addBackground() {
		backgroundPanel = new BackgroundPanel("Images/Pet_Sprites/Untitled16.png");
		backgroundPanel.setBounds(0, 0, 1900, 1060);
		layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

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

	private void updateBalanceDisplay() {
        moneyLabel.setText("Balance: $" + String.format("%.2f", p.getMoney()));
        expensesLabel.setText("Spent: $" + String.format("%.2f", p.getExpenses()));
    }
	
	public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource(); 
			
			Store store = new Store();
	        JButton[] dogFood = new JButton[] {kibbleCrunch, salmonDelight, goldenChickenNuggets};

	        for(JButton f: dogFood) {
	        	if (button.equals(f)) {
	        		for(Food y: store.getDogFood()) {
	        			if(f.getName() != null && f.getName().equals(y.getName())) {
	        				store.buyFood(y, p);
	        			}
	        		}
	        	}
	        }
	        
	        JButton[] fishFood = new JButton[] {flakes, algaeCrisps, deepAbyssInfusion};

	        for(JButton f: fishFood) {
	        	if (button.equals(f)) {
	        		for(Food y: store.getFishFood()) {
	        			if(f.getName() != null && f.getName().equals(y.getName())) {
	        				store.buyFood(y, p);
	        			}
	        		}
	        	}
	        }
	        
	        JButton[] catFood = new JButton[] {fiveFishKibble, turkeyAndCranberryTreats, aGoldenRat};

	        for(JButton f: catFood) {
	        	if (button.equals(f)) {
	        		for(Food y: store.getCatFood()) {
	        			if(f.getName() != null && f.getName().equals(y.getName())) {
	        				store.buyFood(y, p);
	        			}
	        		}
	        	}
	        }
	        
	        updateBalanceDisplay();
	    }
}