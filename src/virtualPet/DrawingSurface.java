package VirtualPet;

import pets.Pet;
import DrawingSurface.*;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Graphics;
import java.awt.Insets;



public class DrawingSurface extends JFrame {//JPanel implements ActionListener {
	Pet userPet;
	public JButton[] buttons;//feed, rest, clean, vet, play, store;

	
	public DrawingSurface() {
//		JFrame frame = new JFrame("Cost Of Care"); //idk what the difference between container and jframe is
//		frame.setSize(2000, 2000); 
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setBackground(Color.WHITE);
//		frame.setLayout(new FlowLayout());
		
		Bar bars = new Bar();
		
//		Button buttons = new Button();
//		buttons = createButtons();
		
//		for(int i = 0; i < buttons.length; i++) {
//			buttons[i].setMargin(new Insets(10,10,10,10));
//			
//			add(buttons[i]);			
		
//		}
		
		
		
	}
	
	
	public void createButtons() {
		JButton feed = new JButton("Feed");
		JButton rest = new JButton("Rest");
		JButton clean = new JButton("Clean");
		JButton vet = new JButton("Vet");
		JButton play = new JButton("Play");
		JButton store = new JButton("Store");
		
		
		feed.setPreferredSize(new Dimension(10,50));
		rest.setPreferredSize(new Dimension(10,50));
		clean.setPreferredSize(new Dimension(10,50));
		vet.setPreferredSize(new Dimension(10,50));
		play.setPreferredSize(new Dimension(10,50));
		store.setPreferredSize(new Dimension(10,50));

//		add(feed);
//		add(rest);
//		add(clean);
//		add(vet);
//		add(play);
//		add(store);
	}
	
	/*
	public void buttons() {

		feed = new JButton("Feed"); 
		rest = new JButton("Rest");
		clean = new JButton("Clean");
		vet = new JButton("Vet");
		play = new JButton("Play");
		store = new JButton("Store");

		
		feed.addActionListener(this);
		rest.addActionListener(this);
		clean.addActionListener(this);
		vet.addActionListener(this);
		play.addActionListener(this);
		store.addActionListener(this);

	  //panel.add(feed); add panel later(?) panel.add(feed);
	  
	  
		add(feed);
		add(rest);
		add(clean);
		add(vet);
		add(play);
		add(store);

		
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource(); //returns the object that fired the event, but casted as a JButton, and instantiates it
    
		if(button == feed) {
			System.out.println("Feeding");
		}
		else if(button == rest) {
			System.out.println("Resting");

		}
		else if(button == clean) {
			System.out.println("Cleaning");
	
		}
		else if(button == vet) {
			System.out.println("Veting");

		}
		else if(button == play) {
			System.out.println("Playing");

		}
		else if(button == store) {
			System.out.println("Buying");

		}
	}*/

	
}
// 2 Drawing Surfaces, 1 with user interaction(buttons/ store), 1 without user interaction(bars, pet)

/*
 * FBLA requirements now
 * Pet type and name: DONE
 * Actions
 * - Feed (Hunger/Money):
 * - Play (Activities/Money):
 * - Rest (Activities):
 * - Clean (Activities):
 * - Health Check (Health/Money) - Vet visits:
 * Ellie: we should print the reminder to go the the vet in the console/main class probably
 * Reactions - Based on emotion and health level:
 * Total expenses (Money) - vet visits, food cost, toy cost:
 * Making money - tasks, bonus after x amount of time:
 * Implement time - which will affect (age, money, health, cleanliness, rest):
 * 
 * Future endeavors
 * Toys able to be discarded
 * Pet having requests
 */
