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
        JLabel titleLabel = new JLabel("Welcome to the Toy Store! Green is dog toys, Blue is cat toys, and Red is fish", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);
        
        //A panel where all the toys are on here so they don't get stacked
        //Kinda like 3 panels inside 1
        JPanel allToysPanel = new JPanel();
        allToysPanel.setLayout(new GridLayout(1, 3, 10, 10));
        
        
        // Add store items panel
        JPanel dogToysPanel = new JPanel();
        dogToysPanel.setLayout(new GridLayout(3, 2, 8, 8));
        dogToysPanel.setBackground(Color.GREEN);
        
        
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
        fishToysPanel.setLayout(new GridLayout(3, 2, 8, 8));
        fishToysPanel.setBackground(Color.RED);
       
        
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
        catToysPanel.setLayout(new GridLayout(3, 2, 8, 8));
        catToysPanel.setBackground(Color.BLUE);
       
        
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
    
    
}    
