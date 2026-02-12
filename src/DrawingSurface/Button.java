package DrawingSurface;
import properties.*;
import pets.Pet;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.CardLayout;


public class Button extends JPanel implements ActionListener {
	private JButton food, rest, clean, vet, play, store;
	
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
	private Activities activity;
	private Pet pet;
	
	public Button(CardLayout cardLayout, JPanel cardPanel, Pet pet) {
		this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        
        this.pet = pet;
        if (this.pet == null) {
        	System.out.println("Pet is null");
        }
        
        this.activity = new Activities(pet);
        
		// Creates the buttons
		
	    JPanel panel = new JPanel(); //This is the Panel that sections off things. 
	    panel.setLayout(new GridLayout(6, 1)); //This affects how things look INSIDE the panel; buttons, etc.
	    panel.setPreferredSize(new Dimension(600, 600)); //when set length to 500, it doesn't fit in frame for some reason :c
	    panel.setBackground(Color.BLUE);
	    
		food = new JButton("Food"); 
		rest = new JButton("Rest");
		clean = new JButton("Clean");
		vet = new JButton("Vet");
		play = new JButton("Play");
		store = new JButton("Store");
		
		
		food.addActionListener(this);
		rest.addActionListener(this);
		clean.addActionListener(this);
		vet.addActionListener(this);
		play.addActionListener(this);
		store.addActionListener(this);
	  
	  
		panel.add(food);
		panel.add(rest);
		panel.add(clean);
		panel.add(vet);
		panel.add(play);
		panel.add(store);
		
		add(panel, BorderLayout.WEST);

		

	}
		
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource(); //returns the object that fired the event, but casted as a JButton, and instantiates it
    
		Money stores = new Money();
		if(button == food) {
			//pet.setMoney(pet.getMoney()+10);

			cardLayout.show(cardPanel, "FStore");
		}
		else if(button == rest) {
		    String sleepAmount = JOptionPane.showInputDialog("How many hours would you like your pet to sleep? 1, 2, or 5? ");

		    activity.sleep(sleepAmount);
			pet.setMoney(pet.getMoney()+10);
		    JOptionPane.showMessageDialog(null, pet.getName() + " is sleeping deeply. ZZZ");


		}
		else if(button == clean) {
			activity.clean();
			pet.setMoney(pet.getMoney()+10);
		    JOptionPane.showMessageDialog(null, pet.getName() + " is squeaky clean!");

		}
		else if(button == vet) {
			System.out.println("Veting");
			
			stores.vetVisit(pet);
			pet.setMoney(pet.getMoney()+10);

		    JOptionPane.showMessageDialog(null, pet.getName() + " feels much healthier!");

		}
		else if(button == play) {
			String ownedToys = pet.getToysStr();
			Toys chosenToy = null;
			
			if(ownedToys.equals("")) {
				JOptionPane.showMessageDialog(null, "Sorry, you don't own any toys. Go to the store to buy some!");
			}
			else {
				String chosenToyName = JOptionPane.showInputDialog("Which toy would you like to play with: " + ownedToys + "?");
				for(int i = 0; i < pet.getToysArr().length; i++) {
					if(pet.getToysArr()[i] == null) {
						System.out.println("The toy is null");
					}
					else if (chosenToyName.equals((pet.getToysArr()[i]).getName())) {
						chosenToy = pet.getToysArr()[i];
					}
				}
				
				activity.play(chosenToy);
				
				JOptionPane.showMessageDialog(null, pet.getName() + " is happy playing with " + chosenToy.getName() + "!");

			}
			

			
			System.out.println("Playing");
			pet.setMoney(pet.getMoney()+10);
			
		}
		else if(button == store) {
			System.out.println("Buying");
			
			cardLayout.show(cardPanel, "Store");

		}
	}
}
