package virtualPet;

import pets.Pet;
import DrawingSurface.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;



public class DrawingSurface extends JFrame {//JPanel implements ActionListener {
	Pet userPet;
	public JButton feed, rest, clean, vet, play, store;

	
	public DrawingSurface() {
		JFrame frame = new JFrame("Cost Of Care"); //idk what the difference between container and jframe is
		frame.setSize(1000, 500); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		
		Bar bars = new Bar();
		Button buttons = new Button();
		//buttons();
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
