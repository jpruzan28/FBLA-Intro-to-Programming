package VirtualPet;
import DrawingSurface.*;
import DrawingSurface.Button;
import pets.Pet;

import java.util.TimerTask;
import java.util.Timer;
import java.awt.*;

//import java.util.Scanner;
import javax.swing.*;
import DrawingSurface.Bar;


public class main extends JFrame{
	private static Pet pet;
	private static String petType, petName; 
	
	private JLabel moneyLabel;
	
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
	
	
	public main(Pet pet) {
	    Container c = getContentPane();
	    
	    // Creating cardLayout and container panel
	    cardLayout = new CardLayout();
	    cardPanel = new JPanel(cardLayout);
	    GameOverPanel gameOver = new GameOverPanel(cardLayout, cardPanel);

	    JPanel mainPanel = new JPanel(new BorderLayout());
	    mainPanel.setBackground(Color.WHITE);

	    // Buttons on the left
	    Button buttons = new Button(cardLayout, cardPanel, pet);
	    mainPanel.add(buttons, BorderLayout.WEST);
	    

	    // Creates a left panel with the GridBagLayout for positioning
	    JPanel rightPanel = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridx = 1;
	    gbc.weightx = 1.0;
	    gbc.fill = GridBagConstraints.BOTH;
	    
	    // Below contains the layout for where components on GUI is going to be
	    
	    // Row 1: // Row 0: bar at the top 
	    Bar bars = new Bar(pet);
	    bars.setBackground(Color.GRAY);
	    bars.setPreferredSize(new Dimension(200, 200));
	    gbc.gridy = 0;
	    gbc.weighty = 0.3;
	    rightPanel.add(bars, gbc);
	    
	    // Row 2: money label below bars 
	    moneyLabel = new JLabel("Total Currency: $" + pet.getMoney(), SwingConstants.CENTER);
	    moneyLabel.setFont(new Font("Inconsolata", Font.BOLD, 24));
	    gbc.gridy = 1;
	    gbc.weighty = 0.1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.anchor = GridBagConstraints.CENTER;
	    rightPanel.add(moneyLabel, gbc);
	    
	    //For the timer to work
	    javax.swing.Timer displayTimer = new javax.swing.Timer(1000, e -> {
	        moneyLabel.setText("Total Currency: $" + String.format("%.2f", pet.getMoney()));
	    });
	    displayTimer.start();

	    
	    
	    // Row 3: SPRITE takes the remaining space 
	    Sprite sprites = new Sprite(pet);
	    
	    gbc.gridy = 3;
	    gbc.weighty = 3;
	    gbc.fill = GridBagConstraints.BOTH;
	    rightPanel.add(sprites, gbc);
	    
	    mainPanel.add(rightPanel, BorderLayout.CENTER);
	    

	    // Store panel stuff
	    StorePanel storePanel = new StorePanel(cardLayout, cardPanel, pet);
	    StorePanelFood storePanelFood = new StorePanelFood(cardLayout, cardPanel, pet);

	    // Adding all panels to CardLayout
	    cardPanel.add(mainPanel, "Game");
	    cardPanel.add(storePanel, "Store");
	    cardPanel.add(storePanelFood, "FStore");
	    cardPanel.add(gameOver, "GameOver");	    

	    // Add the cardPanel to the frame
	    c.add(cardPanel);

	    // Show main panel first
	    cardLayout.show(cardPanel, "Game");
	}
	
	
	public void gameOver() {
		cardLayout.show(cardPanel, "GameOver");
	}
	
	
	//Gets money and updates is by using the format method to update the number
	public void updateMoneyDisplay() {
        moneyLabel.setText("Total Currency: $" + String.format("%.2f", pet.getMoney()));
    }
	
	public static void errorMessage(String problem) {
		if(problem.equals("Too expensive")) {
		    JOptionPane.showMessageDialog(null, "Sorry, this item is too expensive.");
		}
		else if(problem.equals("Toy overflow")) {
		    JOptionPane.showMessageDialog(null, "Sorry, you have reached the maximum number of toys. You cannot buy anymore.");
		}
	}

	public static void main(String[] args) {
	    //User input
	    String playerName = JOptionPane.showInputDialog("Welcome player! What's your name?");
	    JOptionPane.showMessageDialog(null, "Nice to meet you " + playerName);
	    
	     petType = JOptionPane.showInputDialog("A little birdie told me your looking to take care of a pet, what pet do you want, we have a fish, a dog, and a cat? \n please type in 'dog', 'cat', or 'fish' ");
	    JOptionPane.showMessageDialog(null, "Nice choice, choosing a " + petType);
		
	     petName = JOptionPane.showInputDialog("What would you like to name your " + petType + "?");
	    
	    // Creating the pet
	     pet = new Pet(petName, petType);

	     // CREATE THE WINDOW FIRST
	     main w = new main(pet);
	     w.setBounds(100, 100, 900, 900);
	     w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     w.setVisible(true);

	     // THEN create ReductionTimer with reference to w
	     ReductionTimer reductionTimers = new ReductionTimer(pet, w);
	     
	     Timer timer = new Timer();
	     // Reduce fields overtime
	     timer.schedule(reductionTimers.new reduceHunger(), 0, 30000);
//	     timer.schedule(reductionTimers.new reduceHealth(), 0, 20000);
	     timer.schedule(reductionTimers.new reduceHygiene(), 0, 30000);
	     timer.schedule(reductionTimers.new reduceRest(), 0, 30000);
	     timer.schedule(reductionTimers.new reduceEmotion(), 0, 30000);
	     
	     // Giving the user money
	     timer.schedule(reductionTimers.new salary(), 0, 35000);
	     timer.schedule(reductionTimers.new bonus(), 0, 35000);
	     
	     // Updating pet health
	     // Was originally 120000 I'm pretty sure
	     timer.schedule(reductionTimers.new updateHealth(), 0, 35000);
	     
	    // sprites.paintComponent(w);

	     while(true) {
	    	 w.repaint();
	     }
	}
	
}
