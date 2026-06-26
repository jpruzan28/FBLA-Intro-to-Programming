package panels;

import javax.swing.*;
import properties.*;
import pets.Pet;
import java.awt.*;
import java.awt.event.*;
import DrawingSurface.*;

public class StorePanel extends JPanel implements ActionListener {
	
	JButton usedBall, enchantedChewWand, goldenestBone;
	JButton driftBall, biolumeBubbleMachine, platinumSpeaker;
	JButton plainKittySock, laserPointer, legendaryAirpods;
	
	private JLabel moneyLabel;
	private JLabel expensesLabel;

	Pet p;
	private BackgroundPanel backgroundPanel;
	private JLayeredPane layeredPane;
	private JPanel allToysPanel;
	
	public StorePanel(CardLayout cardLayout, JPanel cardPanel, Pet pet) {
		p = pet;
		
		setLayout(new BorderLayout());
		allToysPanel = new JPanel(new BorderLayout());
		layeredPane = new JLayeredPane();
		
		layeredPane.setLayout(null);
		layeredPane.setPreferredSize(new Dimension(1900, 1060)); 
		allToysPanel.add(layeredPane, BorderLayout.CENTER);
		add(allToysPanel, BorderLayout.CENTER);
		
		addBackground();
		
		// FINANCIAL STATUS MONITOR (Centered at the Bottom)
		JPanel statusPanel = new JPanel(new GridLayout(1, 2, 20, 0));
		statusPanel.setOpaque(false);
		statusPanel.setBounds(700, 950, 500, 50); 

		Font statusFont = new Font("Arial", Font.BOLD, 24);

		moneyLabel = new JLabel("Balance: $" + String.format("%.2f", p.getMoney()), SwingConstants.CENTER);
		moneyLabel.setFont(statusFont);
		moneyLabel.setForeground(new Color(50, 32, 32));

		/*expensesLabel = new JLabel("Spent: $" + String.format("%.2f", p.getExpenses()), SwingConstants.CENTER);
		expensesLabel.setFont(statusFont);
		expensesLabel.setForeground(new Color(140, 60, 60)); */

		statusPanel.add(moneyLabel);
		//statusPanel.add(expensesLabel);
		layeredPane.add(statusPanel, JLayeredPane.PALETTE_LAYER);

		// ITEM BUTTONS
		usedBall = new ItemButton("Used Ball", "Cost: $4.00", "Level: 1", "Images/Toy_Icons/used_ball.png");
		enchantedChewWand = new ItemButton("Chew Wand", "Cost: $25.00", "Level: 2", "Images/Toy_Icons/enchanted_wand.png"); 
		goldenestBone = new ItemButton("Gold Bone", "Cost: $90.00", "Level: 3", "Images/Toy_Icons/golden_bone.png"); 
		plainKittySock = new ItemButton("Plain Sock", "Cost: $4.00", "Level: 1", "Images/Toy_Icons/plain_sock.png");
		laserPointer = new ItemButton("Laser Pointer", "Cost: $50.00", "Level: 2", "Images/Toy_Icons/laser_pointer.png");
		legendaryAirpods = new ItemButton("Rad Airpods", "Cost: $90.00", "Level: 3", "Images/Toy_Icons/earbud.png");
		driftBall = new ItemButton("Drift Ball", "Cost: $4.00", "Level: 1", "Images/Toy_Icons/drift_ball.png"); 
		biolumeBubbleMachine = new ItemButton("Bubble Maker", "Cost: $25.00", "Level: 2", "Images/Toy_Icons/bubble_machine.png"); 
		platinumSpeaker = new ItemButton("Super Speaker", "Cost: $90.00", "Level: 3", "Images/Toy_Icons/plat_speaker.png"); 
		
		usedBall.setName("Used Ball");
		enchantedChewWand.setName("Chew Wand");
		goldenestBone.setName("Gold Bone");
		plainKittySock.setName("Plain Sock");
		laserPointer.setName("Laser Pointer");
		legendaryAirpods.setName("Rad Airpods");
		driftBall.setName("Drift Ball");
		biolumeBubbleMachine.setName("Bubble Maker");
		platinumSpeaker.setName("Super Speaker");

		// PLACEMENT GRID
		usedBall.setBounds(180,  150, 270, 150);
		enchantedChewWand.setBounds(180,  385, 270, 150);
		goldenestBone.setBounds(65+240,  600, 270, 150);
		plainKittySock.setBounds(600+125,  150, 270, 150);
		laserPointer.setBounds(600+125, 385, 270, 150);
		legendaryAirpods.setBounds(600+125,  600, 270, 150);
		driftBall.setBounds(1270,  150, 270, 150);
		biolumeBubbleMachine.setBounds(1270,  385, 270, 150);
		platinumSpeaker.setBounds(1270,  600, 270, 150);
		
		usedBall.addActionListener(this);
		enchantedChewWand.addActionListener(this);
		goldenestBone.addActionListener(this); 
		driftBall.addActionListener(this);
		biolumeBubbleMachine.addActionListener(this);
		platinumSpeaker.addActionListener(this);
		plainKittySock.addActionListener(this);
		laserPointer.addActionListener(this);
		legendaryAirpods.addActionListener(this);
		
		layeredPane.add(usedBall,  JLayeredPane.PALETTE_LAYER);
		layeredPane.add(enchantedChewWand,  JLayeredPane.PALETTE_LAYER);
		layeredPane.add(goldenestBone,  JLayeredPane.PALETTE_LAYER);
		layeredPane.add(plainKittySock, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(laserPointer, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(legendaryAirpods, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(driftBall, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(biolumeBubbleMachine, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(platinumSpeaker, JLayeredPane.PALETTE_LAYER);

		// EXIT BUTTON (Top-Left Placement)
		JButton backButton = new JButton("Return to home");
		backButton.addActionListener(e -> {
			cardLayout.show(cardPanel, "Home");
		});
		backButton.setBounds(0, 0, 80, 80);
		layeredPane.add(backButton, JLayeredPane.PALETTE_LAYER); 
		
		updateBalanceDisplay();
	}
	
	public void addBackground() {
		backgroundPanel = new BackgroundPanel("Images/Pet_Sprites/Untitled15.png");
		backgroundPanel.setBounds(0, 0, 1900, 1060);
		layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
		layeredPane.setSize(1900, 1060);

		allToysPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
			@Override
			public void componentResized(java.awt.event.ComponentEvent e) {
				layeredPane.setSize(allToysPanel.getSize());
				backgroundPanel.setBounds(0, 0, allToysPanel.getWidth(), allToysPanel.getHeight());
				layeredPane.revalidate();
			}
		});
	}
	
	private void updateBalanceDisplay() {
		moneyLabel.setText("Balance: $" + String.format("%.2f", p.getMoney()));
		//expensesLabel.setText("Spent: $" + String.format("%.2f", p.getExpenses()));
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource(); 
		Store store = new Store();
		
		JButton[] dogToys = new JButton[] {usedBall, enchantedChewWand, goldenestBone};
		for(JButton t: dogToys) {
			if (button.equals(t)) {
				for(Toy y: store.getDogToys()) {
					if(t.getName() != null && t.getName().equals(y.getName())) {
						store.buyToys(y, p);
					}
				}
			}
		}
		
		JButton[] fishToys = new JButton[] {driftBall, biolumeBubbleMachine, platinumSpeaker};
		for(JButton t: fishToys) {
			if (button.equals(t)) {
				for(Toy y: store.getFishToys()) {
					if(t.getName() != null && t.getName().equals(y.getName())) {
						store.buyToys(y, p);
					}
				}
			}
		}
		
		JButton[] catToys = new JButton[] {plainKittySock, laserPointer, legendaryAirpods};
		for(JButton t: catToys) {
			if (button.equals(t)) {
				for(Toy y: store.getCatToys()) {
					if(t.getName() != null && t.getName().equals(y.getName())) {
						store.buyToys(y, p);
					}
				}
			}
		}
		
		updateBalanceDisplay();
	}
}