package DrawingSurface;

import VirtualPet.*; 

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import pets.Pet;

public class DrawingSurface extends JPanel implements ActionListener {
	private JButton work, food, sleep, clean, vet, play, store;
	private Bar health, hunger, hygiene, rest, emotion;
	private Pet pet;
	
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
	// Creates layers so the background can be on the bottom with button on top
	private JLayeredPane layeredPane;
	private BackgroundPanel backgroundPanel;
	
	public DrawingSurface(CardLayout cardLayout, JPanel cardPanel, Pet pet) {
		
		this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        
        this.pet = pet;
        if (this.pet == null) {
        	System.out.println("Pet is null");
        }
		
        setLayout(null);
        
        
        // JLayeredPane replaces the default content pane
        setLayout(new BorderLayout());
        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        add(layeredPane, BorderLayout.CENTER);

		
		addButtons();
	}
	
	public void createCardLayout() {
		// Organize all of the different panels
	}
	
	public void addTimer() {
		// Put the timer on screen
	}
	
	// Adds a background to the bottom layer
	public void addBackground() {
		backgroundPanel = new BackgroundPanel("Image Address");
		backgroundPanel.setBounds(0,0,getWidth(),getHeight());
	    layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

	}
	
	public void createBars() {
		// Calculating spacing of the bars
		double windWidth = getWidth();
		double piece = windWidth/16;
		double x = piece;
		int y = getHeight() / 20;
				
		double rectWidth = 2*piece;
				
		health = new Bar(pet, "Health", x, y, rectWidth, 30);
		hunger = new Bar(pet, "Hunger", (x + 3*piece), y, rectWidth, 30);
		hygiene = new Bar(pet, "Hygiene", (x + 6*piece), y, rectWidth, 30);
		rest = new Bar(pet, "Rest", (x + 9*piece), y, rectWidth, 30);
		emotion = new Bar(pet, "Emotion", (x + 12*piece), y, rectWidth, 30);
		
	}
	
	public void drawSprite() {
		// Draw the pet
	}
	
	public void addButtons() {
		work = new JButton("Work");
		// Add other button stuff for work


		food = new JButton("Food");
		sleep = new JButton("Sleep");
		clean = new JButton("Clean");
		vet = new JButton("Vet");
		play = new JButton("Play");
		store = new JButton("Store");
		
		food.setBounds(50,  100, 120, 40);
		sleep.setBounds(50,  160, 120, 40);
		clean.setBounds(50,  220, 120, 40);
		vet.setBounds(50,  280, 120, 40);
		play.setBounds(50,  340, 120, 40);
		store.setBounds(50,  400, 120, 40);
		
		food.addActionListener(this);
		sleep.addActionListener(this);
		clean.addActionListener(this);
		vet.addActionListener(this);
		play.addActionListener(this);
		store.addActionListener(this);
	  
		
        // Add all buttons on layer 1 (above the background)
		layeredPane.add(food, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(sleep, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(clean, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(vet, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(play, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(store, JLayeredPane.PALETTE_LAYER);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String bPressed = button.getText();
		
		if(bPressed.equals("Food")) {

			cardLayout.show(cardPanel, "FStore");

		}
		
		else if(bPressed.equals("Store")) {
			
			cardLayout.show(cardPanel, "Store");


		}	else {
			Button newButton = new Button(pet, bPressed);
			newButton.actionPerformed();
			
		}
		
		
	}
	
	public void paintComponent(Graphics g) {
		createBars();
		
		// Writing stats on top of bars
		int fontSize = 24;
		g.setColor(Color.BLACK); 
		g.setFont(new Font("SansSerif", Font.BOLD, fontSize)); 

		g.drawString("Health", (int)health.getX(), (int)health.getY() - fontSize);
		g.drawString("Hunger", (int)hunger.getX(), (int)hunger.getY() - fontSize);
		g.drawString("Hygiene", (int)hygiene.getX(), (int)hygiene.getY() - fontSize);
		g.drawString("Rest", (int)rest.getX(), (int)rest.getY() - fontSize);
		g.drawString("Emotion", (int)emotion.getX(), (int)emotion.getY() - fontSize);
		
		// Drawing outlines of bars 
		g.drawRect((int)health.getX(), (int)health.getY(), (int)health.getWidth(), (int)health.getHeight());
		g.drawRect((int)hunger.getX(), (int)hunger.getY(), (int)hunger.getWidth(), (int)hunger.getHeight());
		g.drawRect((int)hygiene.getX(), (int)hygiene.getY(), (int)hygiene.getWidth(), (int)hygiene.getHeight());
		g.drawRect((int)rest.getX(), (int)rest.getY(), (int)rest.getWidth(), (int)rest.getHeight());
		g.drawRect((int)emotion.getX(), (int)emotion.getY(), (int)emotion.getWidth(), (int)emotion.getHeight());

		// Filling in bars with the correct colors
		g.setColor(health.getColor());
		g.drawRect((int)health.getX(), (int)health.getY(), (int)health.getWidth(), (int)health.getHeight());
		
		g.setColor(hunger.getColor());
		g.drawRect((int)hunger.getX(), (int)hunger.getY(), (int)hunger.getWidth(), (int)hunger.getHeight());

		g.setColor(hygiene.getColor());
		g.drawRect((int)hygiene.getX(), (int)hygiene.getY(), (int)hygiene.getWidth(), (int)hygiene.getHeight());

		g.setColor(rest.getColor());
		g.drawRect((int)rest.getX(), (int)rest.getY(), (int)rest.getWidth(), (int)rest.getHeight());

		g.setColor(emotion.getColor());
		g.drawRect((int)emotion.getX(), (int)emotion.getY(), (int)emotion.getWidth(), (int)emotion.getHeight());

	}
	

}
