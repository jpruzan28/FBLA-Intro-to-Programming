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
		


	}	
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
