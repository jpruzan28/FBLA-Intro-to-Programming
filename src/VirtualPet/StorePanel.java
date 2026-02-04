package virtualPet;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StorePanel extends JPanel {
	
	JButton usedBall, rubberChewBone, enchantedChewWand, guardianPlusBear, dogGodWorshipAltar, goldenestBone;
    
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
        dogToysPanel.setBackground(Color.WHITE);
        dogToysPanel.setBounds(30, 30, 50, 100);
	//    dogToysPanel.setPreferredSize(new Dimension(200, 455)); 
        
        usedBall = new JButton("Used Ball"); 
        rubberChewBone = new JButton("Rubber Chew Bone"); 
        enchantedChewWand = new JButton("Enchanted Chew Wand"); 
        guardianPlusBear = new JButton("Guardian Plus Bear"); 
        dogGodWorshipAltar = new JButton("Dog God Worship Altar"); 
        goldenestBone = new JButton("Goldenest Bone"); 
        
        add(usedBall);
        add(rubberChewBone);
        add(enchantedChewWand);
        add(guardianPlusBear);
        add(dogGodWorshipAltar);
        add(goldenestBone);


        
        JPanel fishToysPanel = new JPanel();
        fishToysPanel.setLayout(new GridLayout(3, 2, 10, 10));
        fishToysPanel.setBackground(Color.WHITE);
        
        JPanel catToysPanel = new JPanel();
        catToysPanel.setLayout(new GridLayout(3, 2, 10, 10));
        catToysPanel.setBackground(Color.WHITE);
        
        
        
        //Jbutton dog1 =  idk how to finish this gng
        
        
    }
    
    public void toyStore(CardLayout cardLayout, JPanel cardPanel) {
	    JPanel itemsPanel = new JPanel();
	    itemsPanel.setLayout(new GridLayout(3, 2, 10, 10));
	    itemsPanel.setBackground(Color.WHITE);
    }
    
}    
