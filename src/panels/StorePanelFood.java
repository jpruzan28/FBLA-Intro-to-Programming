package panels;

import javax.swing.*;
import properties.*;
import pets.Pet;
import java.awt.*;
import java.awt.event.*;
import DrawingSurface.*;

public class StorePanelFood extends JPanel implements ActionListener {
	
	JButton kibbleCrunch, salmonDelight, goldNuggets;
	JButton flakes, algaeCrisps, abyssInfusion;
	JButton fishKibble, turkeyTreats, goldenRat;
	
	private JLabel moneyLabel;
	private JLabel expensesLabel;

	Pet p;
	private BackgroundPanel backgroundPanel;
	private JLayeredPane layeredPane;
	private JPanel allFoodPanel;
	
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
		
		// FINANCIAL STATUS MONITOR (Centered at the Bottom)
		JPanel statusPanel = new JPanel(new GridLayout(1, 2, 20, 0));
		statusPanel.setOpaque(false);
		statusPanel.setBounds(630, 2, 500, 50); 

		Font statusFont = new Font("Arial", Font.BOLD, 24);

		moneyLabel = new JLabel("Balance: $" + String.format("%.2f", p.getMoney()), SwingConstants.CENTER);
		moneyLabel.setFont(statusFont);
		moneyLabel.setForeground(new Color(50, 32, 32));
		expensesLabel = new JLabel("Spent: $" + String.format("%.2f", p.getExpenses()), SwingConstants.CENTER);
		expensesLabel.setFont(statusFont);
		expensesLabel.setForeground(new Color(140, 60, 60)); 

		statusPanel.add(moneyLabel);
		statusPanel.add(expensesLabel);
		layeredPane.add(statusPanel, JLayeredPane.PALETTE_LAYER);

		// ITEM BUTTONS
		kibbleCrunch = new ItemButton("Kibble Crunch", "Cost: $10.00", "Level: 1", "Images/Food_Icons/kibble.png");
		salmonDelight = new ItemButton("Salmon Delight", "Cost: $50.00", "Level: 2", "Images/Food_Icons/salmon.png");
		goldNuggets = new ItemButton("Gold Nuggets", "Cost: $100.00", "Level: 3", "Images/Food_Icons/nuggets.png");
		fishKibble = new ItemButton("Fish Kibble", "Cost: $10.00", "Level: 1", "Images/Food_Icons/cat_kibble.png");
		turkeyTreats = new ItemButton("Turkey Treats", "Cost: $50.00", "Level: 2", "Images/Food_Icons/turkey.png");
		goldenRat = new ItemButton("A Golden Rat", "Cost: $100.00", "Level: 3", "Images/Food_Icons/golden_rat.png");
		flakes = new ItemButton("Flakes", "Cost: $10.00", "Level: 1", "Images/Food_Icons/flakes.png");
		algaeCrisps = new ItemButton("Algae Crisps", "Cost: $50.00", "Level: 2", "Images/Food_Icons/algae.png");
		abyssInfusion = new ItemButton("Abyss Infusion", "Cost: $100.00", "Level: 3", "Images/Food_Icons/abyss.png");
		
		kibbleCrunch.setName("Kibble Crunch");
		salmonDelight.setName("Salmon Delight");
		goldNuggets.setName("Gold Nuggets");
		fishKibble.setName("Fish Kibble");
		turkeyTreats.setName("Turkey Treats");
		goldenRat.setName("A Golden Rat");
		flakes.setName("Flakes");
		algaeCrisps.setName("Algae Crisps");
		abyssInfusion.setName("Abyss Infusion");

		// PLACEMENT GRID
		kibbleCrunch.setBounds(180, 150+20, 270, 150);
		salmonDelight.setBounds(180, 385+20, 270, 150);
		goldNuggets.setBounds(180, 600+20, 270, 150);
		fishKibble.setBounds(600+125, 150+20, 270, 150);
		turkeyTreats.setBounds(600+125, 385+20, 270, 150);
		goldenRat.setBounds(600+125, 600+20, 270, 150);
		flakes.setBounds(1270, 150, 150+20, 150);
		algaeCrisps.setBounds(1270, 385+20, 270, 150);
		abyssInfusion.setBounds(1270, 600+20, 270, 150);
		
		kibbleCrunch.addActionListener(this);
		salmonDelight.addActionListener(this);
		goldNuggets.addActionListener(this);
		flakes.addActionListener(this);
		algaeCrisps.addActionListener(this);
		abyssInfusion.addActionListener(this);
		fishKibble.addActionListener(this);
		turkeyTreats.addActionListener(this);
		goldenRat.addActionListener(this);
		
		layeredPane.add(kibbleCrunch, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(salmonDelight, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(goldNuggets, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(fishKibble, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(turkeyTreats, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(goldenRat, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(flakes, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(algaeCrisps, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(abyssInfusion, JLayeredPane.PALETTE_LAYER);

		// Exit Button
		ImageIcon returnIcon = DrawingSurface.createScaledIcon("Images/Homescreen_Buttons/ReturnButton.png", 160);
		ImageIcon returnGlow = DrawingSurface.createScaledIcon("Images/Homescreen_Buttons/ReturnGlow.png", 160);

		JButton backButton = new JButton(returnIcon);
		backButton.addActionListener(e -> {
			cardLayout.show(cardPanel, "Home");
		});

		backButton.setBounds(1500, 835, returnIcon.getIconWidth(), 160);
		DrawingSurface.clearBackground(backButton);
		backButton.setRolloverIcon(returnGlow);
		
		layeredPane.add(backButton, JLayeredPane.PALETTE_LAYER);

		updateBalanceDisplay();
	}
	
	public void addBackground() {
		backgroundPanel = new BackgroundPanel("Images/Food_Icons/FoodStore.png"); 
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
		
		JButton[] dogFood = new JButton[] {kibbleCrunch, salmonDelight, goldNuggets};
		for(JButton f: dogFood) {
			if (button.equals(f)) {
				for(Food foo: store.getDogFood()) {
					if(f.getName() != null && f.getName().equals(foo.getName())) {
						store.buyFood(foo, p);
					}
				}
			}
		}
		
		JButton[] fishFood = new JButton[] {flakes, algaeCrisps, abyssInfusion};
		for(JButton f: fishFood) {
			if (button.equals(f)) {
				for(Food foo: store.getFishFood()) {
					if(f.getName() != null && f.getName().equals(foo.getName())) {
						store.buyFood(foo, p);
					}
				}
			}
		}
		
		JButton[] catFood = new JButton[] {fishKibble, turkeyTreats, goldenRat};
		for(JButton f: catFood) {
			if (button.equals(f)) {
				for(Food foo: store.getCatFood()) {
					if(f.getName() != null && f.getName().equals(foo.getName())) {
						store.buyFood(foo, p);
					}
				}
			}
		}
		
		updateBalanceDisplay();
	}
}