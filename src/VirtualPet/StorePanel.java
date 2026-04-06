package VirtualPet;


import javax.swing.*;

import properties.*;
import pets.Pet;

import java.awt.*;
import java.awt.event.*;

public class StorePanel extends JPanel implements ActionListener{
	
	JButton usedBall, enchantedChewWand, goldenestBone;
    JButton driftBall, biolumeBubbleMachine, platinumSpeaker;
	JButton plainKittySock, laserPointer, legendaryAirpods;

	Pet p;
	private BackgroundPanel backgroundPanel;
    private JLayeredPane layeredPane;
    private JPanel allToysPanel;
	
    public StorePanel(CardLayout cardLayout, JPanel cardPanel, Pet pet) {
        p = pet;
    	
    	setLayout(new BorderLayout());
        
    	allToysPanel = new JPanel(new BorderLayout());
        
        //A panel where all the toys are on here so they don't get stacked
    	layeredPane = new JLayeredPane();
    	
    	layeredPane.setLayout(null);
    	layeredPane.setPreferredSize(new Dimension(1900, 1060)); // give it an initial size
    	allToysPanel.add(layeredPane, BorderLayout.CENTER);

    	add(allToysPanel, BorderLayout.CENTER);
    	addBackground();

    	
        // Naming buttons
    	usedBall = new JButton("Used Ball: $4.00");  
        enchantedChewWand = new JButton("Enchanted Chew Wand: $25.00"); 
        goldenestBone = new JButton("Goldenest Bone: $90.00"); 
        plainKittySock = new JButton("Plain Kitty Sock: $4.00");
        laserPointer = new JButton("Laser Pointer: $50.00");
        legendaryAirpods = new JButton("Legendary Airpods: $90.00");
        driftBall = new JButton("Drift Ball: $4.00"); 
        biolumeBubbleMachine = new JButton("Biolume Bubble Machine: $25.00"); 
        platinumSpeaker = new JButton("Platinum Speaker: $90.00"); 
        
        //Setting button location
        usedBall.setBounds(90,  460, 120, 40);
        enchantedChewWand.setBounds(90, 100, 120, 40);
        goldenestBone.setBounds(90, 160, 120, 40);
        laserPointer.setBounds(90, 220, 120, 40);
        plainKittySock.setBounds(90, 280, 120, 40);
        legendaryAirpods.setBounds(90,  340, 120, 40);
        driftBall.setBounds(90,  400, 120, 40);
        
        plainKittySock.setName("Plain Kitty Sock");
        laserPointer.setName("Laser Pointer");
        legendaryAirpods.setName("Legendary Airpods");
        driftBall.setName("Drift Ball"); 
        biolumeBubbleMachine.setName("Biolume Bubble Machine"); 
        platinumSpeaker.setName("Platinum Speaker"); 
        usedBall.setName("Used Ball"); 
        enchantedChewWand.setName("Enchanted Chew Wand");  
        goldenestBone.setName("Goldenest Bone");
        
                // Track when buttons are clicked
        usedBall.addActionListener(this);
        enchantedChewWand.addActionListener(this);
        goldenestBone.addActionListener(this); 
        driftBall.addActionListener(this);
        biolumeBubbleMachine.addActionListener(this);
        platinumSpeaker.addActionListener(this);
        plainKittySock.addActionListener(this);
        laserPointer.addActionListener(this);
        legendaryAirpods.addActionListener(this);
        
        
        // Add buttons to screen 
        layeredPane.add(usedBall,  JLayeredPane.PALETTE_LAYER);
        layeredPane.add(enchantedChewWand,  JLayeredPane.PALETTE_LAYER);
        layeredPane.add(goldenestBone,  JLayeredPane.PALETTE_LAYER);
        layeredPane.add(plainKittySock, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(laserPointer, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(legendaryAirpods, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(driftBall, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(biolumeBubbleMachine, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(platinumSpeaker, JLayeredPane.PALETTE_LAYER);
        




        JButton backButton = new JButton("Return to home");
        backButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "Home");
        });
        add(backButton, BorderLayout.SOUTH); 
        
       
        
        
        
    }
    
    public void addBackground() {
        backgroundPanel = new BackgroundPanel("Images/Pet_Sprites/Untitled15.png");
        backgroundPanel.setBounds(0, 0, 1900, 1060);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
        
        // Set layeredPane size immediately so it's not 0,0
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
    
    public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource(); //returns the object that fired the event, but casted as a JButton, and instantiates it
		
		Store store = new Store();
        JButton[] dogToys = new JButton[] {usedBall, enchantedChewWand, goldenestBone};

        // Goes through JButton array
        for(JButton t: dogToys) {
        	// Checks if the button clicked is the same as the JButton
        	if (button.equals(t)) {
        		// Goes through Toys array from Money class
        		for(Toys y: store.getDogToys()) {
        			// Checks if the name of the toy matches the JButton name of the button
        			if(t.getName().equals(y.getName())) {
        				store.buyToys(y, p);
        			}
        		}
        	}
        }
        
        
        JButton[] fishToys = new JButton[] {driftBall, biolumeBubbleMachine, platinumSpeaker};

        // Goes through JButton array
        for(JButton t: fishToys) {
        	// Checks if the button clicked is the same as the JButton
        	if (button.equals(t)) {
        		// Goes through Toys array from Money class
        		for(Toys y: store.getFishToys()) {
        			// Checks if the name of the toy matches the JButton name
        			if(t.getName().equals(y.getName())) {
        				store.buyToys(y, p);
        			}
        		}
        	}
        }
        
        
        JButton[] catToys = new JButton[] {plainKittySock, laserPointer, legendaryAirpods};

        
        // Goes through JButton array
        for(JButton t: catToys) {
        	// Checks if the button clicked is the same as the JButton
        	if (button.equals(t)) {
        		// Goes through Toys array from Money class
        		for(Toys y: store.getCatToys()) {
        			// Checks if the name of the toy matches the JButton name
        			if(t.getName().equals(y.getName())) {
        				store.buyToys(y, p);
        			}
        		}
        	}
        }

    
    }
    
    
}    
