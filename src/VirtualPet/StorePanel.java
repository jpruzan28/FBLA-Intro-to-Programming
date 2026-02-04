package VirtualPet;


import javax.swing.*;

import properties.Toys;

import java.awt.*;
import java.awt.event.*;

public class StorePanel extends JPanel {
	
	JButton usedBall, rubberChewBone, enchantedChewWand, guardianPlusBear, dogGodWorshipAltar, goldenestBone;
    JButton driftBall, shellHideout, biolumeBubbleMachine, roboticFriend, ancientCalmingBell, platinumSpeaker;
	JButton plainKittySock, jingleMouse, cornerScratchPost, laserPointer, quarterZip, legendaryAirpods;

	
	
    public StorePanel(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(new BorderLayout());
        setBackground(Color.gray);
        
        // Add store title
        JLabel titleLabel = new JLabel("Welcome to the Pet Store!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);
        
        
        toyStore(cardLayout, cardPanel);
        
        // Add store items panel
        JPanel dogToysPanel = new JPanel();
        dogToysPanel.setLayout(new GridLayout(3, 2, 10, 10));
        dogToysPanel.setBackground(Color.GREEN);
//        dogToysPanel.setBounds(30, 30, 50, 100);
	//    dogToysPanel.setPreferredSize(new Dimension(200, 455)); 
        add(dogToysPanel, BorderLayout.WEST);
        
        usedBall = new JButton("Used Ball"); 
        rubberChewBone = new JButton("Rubber Chew Bone"); 
        enchantedChewWand = new JButton("Enchanted Chew Wand"); 
        guardianPlusBear = new JButton("Guardian Plus Bear"); 
        dogGodWorshipAltar = new JButton("Dog God Worship Altar"); 
        goldenestBone = new JButton("Goldenest Bone"); 
        
        dogToysPanel.add(usedBall);
        dogToysPanel.add(rubberChewBone);
        dogToysPanel.add(enchantedChewWand);
        dogToysPanel.add(guardianPlusBear);
        dogToysPanel.add(dogGodWorshipAltar);
        dogToysPanel.add(goldenestBone);


        
        JPanel fishToysPanel = new JPanel();
        fishToysPanel.setLayout(new GridLayout(3, 2, 10, 10));
        fishToysPanel.setBackground(Color.RED);
        add(fishToysPanel, BorderLayout.CENTER);
        
        driftBall = new JButton("Drift Ball"); 
        shellHideout = new JButton("Shell Hideout"); 
        biolumeBubbleMachine = new JButton("Biolume Bubble Machine"); 
        roboticFriend = new JButton("Robotic Friend"); 
        ancientCalmingBell = new JButton("Ancient Calming Bell"); 
        platinumSpeaker = new JButton("Platinum Speaker"); 

        fishToysPanel.add(driftBall);
        fishToysPanel.add(shellHideout);
        fishToysPanel.add(biolumeBubbleMachine);
        fishToysPanel.add(roboticFriend);
        fishToysPanel.add(ancientCalmingBell);
        fishToysPanel.add(platinumSpeaker);


        //	JButton plainKittySock, jingleMouse, cornerScratchPost, laserPointer, quarterZip, legendaryAirpods;

        
        JPanel catToysPanel = new JPanel();
        catToysPanel.setLayout(new GridLayout(3, 2, 10, 10));
        catToysPanel.setBackground(Color.BLUE);
        add(catToysPanel, BorderLayout.EAST);
        
        plainKittySock = new JButton("Plain Kitty Sock");
        jingleMouse = new JButton("Jingle Mouse");
        cornerScratchPost = new JButton("Corner Scratch Post");
        laserPointer = new JButton("Laser Pointer");
        quarterZip = new JButton("Quarter Zip");
        legendaryAirpods = new JButton("Legendary Airpods");
        
        catToysPanel.add(plainKittySock);
        catToysPanel.add(jingleMouse);
        catToysPanel.add(cornerScratchPost);
        catToysPanel.add(laserPointer);
        catToysPanel.add(quarterZip);
        catToysPanel.add(legendaryAirpods);


        
        
        //Jbutton dog1 =  idk how to finish this gng
        
        
    }
    
    public void toyStore(CardLayout cardLayout, JPanel cardPanel) {
	    JPanel itemsPanel = new JPanel();
	    itemsPanel.setLayout(new GridLayout(3, 2, 10, 10));
	    itemsPanel.setBackground(Color.WHITE);
    }
    
}    
