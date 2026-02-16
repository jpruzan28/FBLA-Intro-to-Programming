package VirtualPet;


import javax.swing.*;

import properties.*;
import pets.Pet;

import java.awt.*;
import java.awt.event.*;

public class StorePanel extends JPanel implements ActionListener{
	
	JButton usedBall, rubberChewBone, enchantedChewWand, guardianPlusBear, dogGodWorshipAltar, goldenestBone;
    JButton driftBall, shellHideout, biolumeBubbleMachine, roboticFriend, ancientCalmingBell, platinumSpeaker;
	JButton plainKittySock, jingleMouse, cornerScratchPost, laserPointer, quarterZip, legendaryAirpods;

	Pet p;
	
    public StorePanel(CardLayout cardLayout, JPanel cardPanel, Pet pet) {
        p = pet;
    	
    	setLayout(new BorderLayout());
        setBackground(Color.gray);
        
        // Add store title
        JLabel titleLabel = new JLabel("Welcome to the Toy Store! Green is dog toys, Blue is cat toys, and Red is fish toys.", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);
        
        //A panel where all the toys are on here so they don't get stacked
        //Kinda like 3 panels inside 1
        JPanel allToysPanel = new JPanel();
        allToysPanel.setLayout(new GridLayout(1, 3, 10, 10));
        
        
        // Create panel
        JPanel dogToysPanel = new JPanel();
        dogToysPanel.setLayout(new GridLayout(3, 2, 8, 8));
        dogToysPanel.setBackground(Color.GREEN);
        
        // Create jbuttons
        usedBall = new JButton("Used Ball: $4.00"); 
        rubberChewBone = new JButton("Rubber Chew Bone: $8.00"); 
        enchantedChewWand = new JButton("Enchanted Chew Wand: $25.00"); 
        guardianPlusBear = new JButton("Guardian Plus Bear: $50.00"); 
        dogGodWorshipAltar = new JButton("Dog God Worship Altar: $70.00"); 
        goldenestBone = new JButton("Goldenest Bone: $90.00"); 
        
        // Names buttons
        usedBall.setName("Used Ball"); 
        rubberChewBone.setName("Rubber Chew Bone"); 
        enchantedChewWand.setName("Enchanted Chew Wand"); 
        guardianPlusBear.setName("Guardian Plus Bear"); 
        dogGodWorshipAltar.setName("Dog God Worship Altar"); 
        goldenestBone.setName("Goldenest Bone"); 
        
        // Adds buttons to screen
        dogToysPanel.add(usedBall);
        dogToysPanel.add(rubberChewBone);
        dogToysPanel.add(enchantedChewWand);
        dogToysPanel.add(guardianPlusBear);
        dogToysPanel.add(dogGodWorshipAltar);
        dogToysPanel.add(goldenestBone);
        
        // Track when buttons are clicked
        usedBall.addActionListener(this);
        rubberChewBone.addActionListener(this);
        enchantedChewWand.addActionListener(this);
        guardianPlusBear.addActionListener(this);
        dogGodWorshipAltar.addActionListener(this);
        goldenestBone.addActionListener(this);

        
        // Creates panel
        JPanel fishToysPanel = new JPanel();
        fishToysPanel.setLayout(new GridLayout(3, 2, 8, 8));
        fishToysPanel.setBackground(Color.RED);
       
        // Create jbuttons
        driftBall = new JButton("Drift Ball: $4.00"); 
        shellHideout = new JButton("Shell Hideout: $8.00"); 
        biolumeBubbleMachine = new JButton("Biolume Bubble Machine: $25.00"); 
        roboticFriend = new JButton("Robotic Friend: $50.00"); 
        ancientCalmingBell = new JButton("Ancient Calming Bell: $70.00"); 
        platinumSpeaker = new JButton("Platinum Speaker: $90.00"); 
        
        // Naming buttons
        driftBall.setName("Drift Ball"); 
        shellHideout.setName("Shell Hideout"); 
        biolumeBubbleMachine.setName("Biolume Bubble Machine"); 
        roboticFriend.setName("Robotic Friend"); 
        ancientCalmingBell.setName("Ancient Calming Bell"); 
        platinumSpeaker.setName("Platinum Speaker"); 

        // Adding buttons to screen
        fishToysPanel.add(driftBall);
        fishToysPanel.add(shellHideout);
        fishToysPanel.add(biolumeBubbleMachine);
        fishToysPanel.add(roboticFriend);
        fishToysPanel.add(ancientCalmingBell);
        fishToysPanel.add(platinumSpeaker);
        
        driftBall.addActionListener(this);
        shellHideout.addActionListener(this);
        biolumeBubbleMachine.addActionListener(this);
        roboticFriend.addActionListener(this);
        ancientCalmingBell.addActionListener(this);
        platinumSpeaker.addActionListener(this);


        // Create jpanel
        JPanel catToysPanel = new JPanel();
        catToysPanel.setLayout(new GridLayout(3, 2, 8, 8));
        catToysPanel.setBackground(Color.BLUE);
       
        // Naming buttons
        plainKittySock = new JButton("Plain Kitty Sock: $4.00");
        jingleMouse = new JButton("Jingle Mouse: $8.00");
        cornerScratchPost = new JButton("Corner Scratch Post: $25.00");
        laserPointer = new JButton("Laser Pointer: $50.00");
        quarterZip = new JButton("Quarter Zip: $70.00");
        legendaryAirpods = new JButton("Legendary Airpods: $90.00");
        
        // Create jbuttons
        plainKittySock.setName("Plain Kitty Sock");
        jingleMouse.setName("Jingle Mouse");
        cornerScratchPost.setName("Corner Scratch Post");
        laserPointer.setName("Laser Pointer");
        quarterZip.setName("Quarter Zip");
        legendaryAirpods.setName("Legendary Airpods");
        
        // Add buttons to screen
        catToysPanel.add(plainKittySock);
        catToysPanel.add(jingleMouse);
        catToysPanel.add(cornerScratchPost);
        catToysPanel.add(laserPointer);
        catToysPanel.add(quarterZip);
        catToysPanel.add(legendaryAirpods);
        
        plainKittySock.addActionListener(this);
        jingleMouse.addActionListener(this);
        cornerScratchPost.addActionListener(this);
        laserPointer.addActionListener(this);
        quarterZip.addActionListener(this);
        legendaryAirpods.addActionListener(this);



        JButton backButton = new JButton("Return to home");
        backButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "Game");
        });
        add(backButton, BorderLayout.SOUTH); 
        
        
        //We add the dog, fish, and cat panels the all toys panel
        //the all toys panel is a panel with 3 different panels
        allToysPanel.add(dogToysPanel);
        allToysPanel.add(fishToysPanel);
        allToysPanel.add(catToysPanel);
        
        add(allToysPanel, BorderLayout.CENTER);
        //Jbutton dog1 =  idk how to finish this gng
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource(); //returns the object that fired the event, but casted as a JButton, and instantiates it
		
		Store store = new Store();
        JButton[] dogToys = new JButton[] {usedBall, rubberChewBone, enchantedChewWand, guardianPlusBear, dogGodWorshipAltar, goldenestBone};

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
        
        
        JButton[] fishToys = new JButton[] {driftBall, shellHideout, biolumeBubbleMachine, roboticFriend, ancientCalmingBell, platinumSpeaker};

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
        
        
        JButton[] catToys = new JButton[] {plainKittySock, jingleMouse, cornerScratchPost, laserPointer, quarterZip, legendaryAirpods};

        
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
