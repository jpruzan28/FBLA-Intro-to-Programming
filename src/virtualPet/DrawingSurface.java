package VirtualPet;

import pets.Pet;
import DrawingSurface.*;
import java.awt.Color;
import javax.swing.*;


public class DrawingSurface extends JFrame{
	Pet userPet;
	
	public DrawingSurface() {
		JFrame frame = new JFrame("Cost Of Care"); //idk what the difference between container and jframe is
		frame.setSize(1000, 500); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		
		Bar bars = new Bar();
		Button buttons = new Button();
	}
	
	
	public static void main(String[] args) {
	    DrawingSurface w = new DrawingSurface();
	    w.setBounds(300, 300, 400, 400);
	    w.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    w.setVisible(true);
		
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
