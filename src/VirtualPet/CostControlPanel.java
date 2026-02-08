//package VirtualPet;
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//public class CostControlPanel extends JPanel implements ActionListener
//{
//	public int total; //total needs to be declared as field
//	public JButton button1, button2, button3, button4;
//	CostDisplayPanel chartPanel;
//	
//	
//	public CostControlPanel(CostDisplayPanel chart) {
//	chartPanel = chart;
//	
//    JPanel panel = new JPanel(); //This is the Panel that sections off things. 
//    panel.setLayout(new GridLayout(3, 1, 10, 10)); //This affects how things look INSIDE the panel; buttons, etc.
//    panel.setPreferredSize(new Dimension(200, 455)); //when set length to 500, it doesn't fit in frame for some reason :c
//    panel.setBackground(Color.BLUE);
//    
////    JPanel panel2 = new JPanel(); 
////    panel2.setPreferredSize(new Dimension(600, 100));
////    panel2.setBackground(Color.GREEN);
////    panel2.add(chart);
////    
//
////    add(panel2, BorderLayout.EAST);
//    add(panel);
//        
//    button1= new JButton("Feed"); //adds buttons to the panel
//    button1.addActionListener(this);
//    panel.add(button1); //add panel later(?) panel.add(button1);
//    
//    
//    button2 = new JButton("Play");
//
//    button2.addActionListener(this);
//    panel.add(button2);
//    
//    button3 = new JButton("Clean");
//    button3.addActionListener(this);
//    panel.add(button3);
//    
////    button4 = new JButton("GO TO THE VET"); UNDONE COMPONENT
//    
//    
//	}
//
//	public void setSharedButton(JButton buttonA, JButton buttonB, JButton buttonC) {
//        this.button1 = buttonA; //makes the button sharable to other class
//        this.button2 = buttonB;
//        this.button3 = buttonC;
//        
//	}
//	
//	public void actionPerformed(ActionEvent e) {
//		//(JButton)e.getSource() returns the object that fired the event, but casted as a JButton, and instantiates it
//	    JButton button = (JButton)e.getSource(); 
//		if (button == button1) {
//		total+=2;
//		  System.out.println("+$2.00 to bill");
//		  System.out.println("CURRENT TOTAL: " +total);
//		  chartPanel.hungerCare(); //calls the method to add to the happiness factor
//		  
//		} else if (button == button2) {
//				total+=1;
//		  System.out.println("+$1.00 to bill");
//		  System.out.println("CURRENT TOTAL: " +total);
//		  chartPanel.happyCare();
//		} else if (button == button3) {
//			total+=5;
//			  System.out.println("+$5.00 to bill");
//			  System.out.println("CURRENT TOTAL: " +total);
//			  chartPanel.happyCare();
//		}     chartPanel.repaint(); //adding this is what made the increasing bars work!
//		
//
//
//}
//}
