package VirtualPet;


import javax.swing.*;

import properties.*;
import pets.Pet;

import java.awt.*;
import java.awt.event.*;
import DrawingSurface.*;

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
    	usedBall = new ItemButton("Used Ball", "Cost: $4.00", "Level: 1", "Images/Toy_Icons/used_ball.png");
        enchantedChewWand = new ItemButton("Chew Wand", "Cost: $25.00", "Level: 2", "Images/Toy_Icons/enchanted_wand.png"); 
        goldenestBone = new ItemButton("Gold Bone", "Cost: $90.00", "Level: 3", "Images/Toy_Icons/golden_bone.png"); 
        plainKittySock = new ItemButton("Plain Sock", "Cost: $4.00", "Level: 1", "Images/Toy_Icons/plain_sock.png");
        laserPointer = new ItemButton("Laser Pointer", "Cost: $50.00", "Level: 2", "Images/Toy_Icons/laser_pointer.png");
        legendaryAirpods = new ItemButton("Rad Airpods", "Cost: $90.00", "Level: 3", "Images/Toy_Icons/earbud.png");
        driftBall = new ItemButton("Drift Ball", "Cost: $4.00", "Level: 1", "Images/Toy_Icons/drift_ball.png"); 
        biolumeBubbleMachine = new ItemButton("Bubble Maker", "Cost: $25.00", "Level: 2", "Images/Toy_Icons/bubble_machine.png"); 
        platinumSpeaker = new ItemButton("Super Speaker", "Cost: $90.00", "Level: 3", "Images/Toy_Icons/plat_speaker.png"); 
        
        //Setting button location
        usedBall.setBounds(180,  150, 270, 150);
        enchantedChewWand.setBounds(180,  385, 270, 150);
        goldenestBone.setBounds(65+240,  600, 270, 150);
        plainKittySock.setBounds(600+125,  150, 270, 150);
        laserPointer.setBounds(600+125, 385, 270, 150);
        legendaryAirpods.setBounds(600+125,  600, 270, 150);
        driftBall.setBounds(1270,  150, 270, 150);
        biolumeBubbleMachine.setBounds(1270,  385, 270, 150);
        platinumSpeaker.setBounds(1270,  600, 270, 150);
        
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
        		for(Toy y: store.getDogToys()) {
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
        		for(Toy y: store.getFishToys()) {
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
        		for(Toy y: store.getCatToys()) {
        			// Checks if the name of the toy matches the JButton name
        			if(t.getName().equals(y.getName())) {
        				store.buyToys(y, p);
        			}
        		}
        	}
        }

    
    }
    
    
}    
