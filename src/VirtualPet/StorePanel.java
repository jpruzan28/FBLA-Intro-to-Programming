package VirtualPet;


import javax.swing.*;

import properties.*;
import pets.Pet;

import java.awt.*;
import java.awt.event.*;

public class StorePanel extends JPanel {
	
	JButton usedBall, rubberChewBone, enchantedChewWand, guardianPlusBear, dogGodWorshipAltar, goldenestBone;
    JButton driftBall, shellHideout, biolumeBubbleMachine, roboticFriend, ancientCalmingBell, platinumSpeaker;
	JButton plainKittySock, jingleMouse, cornerScratchPost, laserPointer, quarterZip, legendaryAirpods;

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

                // Add store title
                
//        // Create jbuttons
        usedBall = new JButton("Used Ball: $4.00");  
        enchantedChewWand = new JButton("Enchanted Chew Wand: $25.00"); 
        goldenestBone = new JButton("Goldenest Bone: $90.00"); 
//        
//        // Names buttons
        usedBall.setName("Used Ball"); 
        enchantedChewWand.setName("Enchanted Chew Wand");  
        goldenestBone.setName("Goldenest Bone"); 
     
        // Track when buttons are clicked
        usedBall.addActionListener(this);
        enchantedChewWand.addActionListener(this);
        goldenestBone.addActionListener(this);  
        
//        // Adds buttons to screen
        layeredPane.add(usedBall,  JLayeredPane.PALETTE_LAYER);
        layeredPane.add(enchantedChewWand,  JLayeredPane.PALETTE_LAYER);
        layeredPane.add(goldenestBone,  JLayeredPane.PALETTE_LAYER);
   

//
//        
//        // Creates panel
//        JPanel fishToysPanel = new JPanel();
//        fishToysPanel.setLayout(new GridLayout(3, 2, 8, 8));
//        fishToysPanel.setBackground(Color.RED);
//       
//        // Create jbuttons
//        driftBall = new JButton("Drift Ball: $4.00"); 
//        shellHideout = new JButton("Shell Hideout: $8.00"); 
//        biolumeBubbleMachine = new JButton("Biolume Bubble Machine: $25.00"); 
//        roboticFriend = new JButton("Robotic Friend: $50.00"); 
//        ancientCalmingBell = new JButton("Ancient Calming Bell: $70.00"); 
//        platinumSpeaker = new JButton("Platinum Speaker: $90.00"); 
//        
//        // Naming buttons
//        driftBall.setName("Drift Ball"); 
//        shellHideout.setName("Shell Hideout"); 
//        biolumeBubbleMachine.setName("Biolume Bubble Machine"); 
//        roboticFriend.setName("Robotic Friend"); 
//        ancientCalmingBell.setName("Ancient Calming Bell"); 
//        platinumSpeaker.setName("Platinum Speaker"); 
//
//        // Adding buttons to screen
//        fishToysPanel.add(driftBall);
//        fishToysPanel.add(shellHideout);
//        fishToysPanel.add(biolumeBubbleMachine);
//        fishToysPanel.add(roboticFriend);
//        fishToysPanel.add(ancientCalmingBell);
//        fishToysPanel.add(platinumSpeaker);
//        
//        driftBall.addActionListener(this);
//        shellHideout.addActionListener(this);
//        biolumeBubbleMachine.addActionListener(this);
//        roboticFriend.addActionListener(this);
//        ancientCalmingBell.addActionListener(this);
//        platinumSpeaker.addActionListener(this);
//
//
//        // Create jpanel
//        JPanel catToysPanel = new JPanel();
//        catToysPanel.setLayout(new GridLayout(3, 2, 8, 8));
//        catToysPanel.setBackground(Color.BLUE);
//       
//        // Naming buttons
//        plainKittySock = new JButton("Plain Kitty Sock: $4.00");
//        jingleMouse = new JButton("Jingle Mouse: $8.00");
//        cornerScratchPost = new JButton("Corner Scratch Post: $25.00");
//        laserPointer = new JButton("Laser Pointer: $50.00");
//        quarterZip = new JButton("Quarter Zip: $70.00");
//        legendaryAirpods = new JButton("Legendary Airpods: $90.00");
//        
//        // Create jbuttons
//        plainKittySock.setName("Plain Kitty Sock");
//        jingleMouse.setName("Jingle Mouse");
//        cornerScratchPost.setName("Corner Scratch Post");
//        laserPointer.setName("Laser Pointer");
//        quarterZip.setName("Quarter Zip");
//        legendaryAirpods.setName("Legendary Airpods");
//        
//        // Add buttons to screen
//        catToysPanel.add(plainKittySock);
//        catToysPanel.add(jingleMouse);
//        catToysPanel.add(cornerScratchPost);
//        catToysPanel.add(laserPointer);
//        catToysPanel.add(quarterZip);
//        catToysPanel.add(legendaryAirpods);
//        
//        plainKittySock.addActionListener(this);
//        jingleMouse.addActionListener(this);
//        cornerScratchPost.addActionListener(this);
//        laserPointer.addActionListener(this);
//        quarterZip.addActionListener(this);
//        legendaryAirpods.addActionListener(this);



        JButton backButton = new JButton("Return to home");
        backButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "Home");
        });
        add(backButton, BorderLayout.SOUTH); 
        
        
        //We add the dog, fish, and cat panels the all toys panel
        //the all toys panel is a panel with 3 different panels
//        allToysPanel.add(dogToysPanel);
//        allToysPanel.add(fishToysPanel);
//        allToysPanel.add(catToysPanel);
        
        
        
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
        
        
//        JButton[] fishToys = new JButton[] {driftBall, shellHideout, biolumeBubbleMachine, roboticFriend, ancientCalmingBell, platinumSpeaker};
//
//        // Goes through JButton array
//        for(JButton t: fishToys) {
//        	// Checks if the button clicked is the same as the JButton
//        	if (button.equals(t)) {
//        		// Goes through Toys array from Money class
//        		for(Toys y: store.getFishToys()) {
//        			// Checks if the name of the toy matches the JButton name
//        			if(t.getName().equals(y.getName())) {
//        				store.buyToys(y, p);
//        			}
//        		}
//        	}
//        }
//        
//        
//        JButton[] catToys = new JButton[] {plainKittySock, jingleMouse, cornerScratchPost, laserPointer, quarterZip, legendaryAirpods};
//
//        
//        // Goes through JButton array
//        for(JButton t: catToys) {
//        	// Checks if the button clicked is the same as the JButton
//        	if (button.equals(t)) {
//        		// Goes through Toys array from Money class
//        		for(Toys y: store.getCatToys()) {
//        			// Checks if the name of the toy matches the JButton name
//        			if(t.getName().equals(y.getName())) {
//        				store.buyToys(y, p);
//        			}
//        		}
//        	}
//        }
//
//    
//    }
//    
//    
}    
