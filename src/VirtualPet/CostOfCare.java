//package VirtualPet;
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//import java.text.DecimalFormat;
//import java.util.Scanner;
//
///*CURRENT ISSUES: 
// * 1. I don't know how to make the JLabel centered in a different place 
// * 2. When I try to make the JLabel go on a new JPanel, is doesn't work and affects the graphics drawing*/
//public class CostOfCare extends JFrame {
//	
//
//		public static void main(String []args)
//	{
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("This is the start of your pet's life! Please Enter a name: ");
//		String inputName = scanner.nextLine();
//		System.out.println("Amazing, Now open up the tab to interact with your pet!");
//		System.out.println("I will help you track your bills down here:");
//		CostOfCare.mainFrame(inputName);
//		
//	}
//		public static void mainFrame(String input) {
//			JFrame frame = new JFrame("Cost Of Care");
//			frame.setSize(1000, 500); 
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//This builds the actual window
//			frame.setBackground(Color.WHITE);
//
//			JLabel petName = new JLabel("Pet Name: " + input);
//			petName.setSize(600, 100);
//			petName.setBackground(Color.CYAN);
//			
//
//		    
//			CostDisplayPanel displayPanel = new CostDisplayPanel();
//			CostControlPanel controls = new CostControlPanel(displayPanel);
//		    frame.add(controls, BorderLayout.WEST); //sets the layout of the panel on the frame
//		    frame.add(displayPanel); //QUESTION: how do you adjust the location of bar?
//		    frame.add(petName, BorderLayout.EAST);
//
//			//panel.add(displayPanel);
//
//		    frame.setVisible(true); //according to google the reason why the buttons don't show up is bc you need to put this at bottom
//		}
//}
