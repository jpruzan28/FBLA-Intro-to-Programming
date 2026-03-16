package DrawingSurface;

import java.awt.CardLayout;

import javax.swing.*;
import java.awt.event.*;
import pets.Pet;

public class DrawingSurface extends JFrame implements ActionListener {
	private JButton food, rest, clean, vet, play, store;
	private Pet pet;
	
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
	public DrawingSurface(CardLayout cardLayout, JPanel cardPanel, Pet pet) {
		
		this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        
        this.pet = pet;
        if (this.pet == null) {
        	System.out.println("Pet is null");
        }
		
        setLayout(null);
		
		addButtons();
	}
	
	public void addButtons() {

		food = new JButton("Food");
		rest = new JButton("Rest");
		clean = new JButton("Clean");
		vet = new JButton("Vet");
		play = new JButton("Play");
		store = new JButton("Store");
		
		food.setBounds(50,  100, 120, 40);
		rest.setBounds(50,  160, 120, 40);
		clean.setBounds(50,  220, 120, 40);
		vet.setBounds(50,  280, 120, 40);
		play.setBounds(50,  340, 120, 40);
		store.setBounds(50,  400, 120, 40);
		
		food.addActionListener(this);
		rest.addActionListener(this);
		clean.addActionListener(this);
		vet.addActionListener(this);
		play.addActionListener(this);
		store.addActionListener(this);
	  
	  
		add(food);
		add(rest);
		add(clean);
		add(vet);
		add(play);
		add(store);
		
		
		
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
	

}
