//package VirtualPet;
//import java.awt.Color;
//import java.awt.Graphics;
//
//import javax.swing.JButton;
//import javax.swing.JPanel;

/*CURRENT ISSUES: :c
 * 1. When I press more than the maximum of one bar there is an error
 * 2. After I do that and then press the other bar, an extra chunk appears on the other bar*/
//public class CostDisplayPanel extends JPanel {
//	private int happyCount, hungerCount, healthCount;
//	public JButton buttonA, buttonB, buttonC;
//	
//	  public CostDisplayPanel()
//	  {
//	    setBackground(Color.WHITE);
//	    happyCount = 0;
//	    hungerCount = 0;
//	    healthCount = 0;
//		CostControlPanel costControlPanel = new CostControlPanel(null); //calls from other class
//		costControlPanel.setSharedButton(buttonA, buttonB, buttonC);
//	  }
//	  
//	public void happyCare() {
//		happyCount++;
//		CostControlPanel costControlPanel = new CostControlPanel(null); //calls from other class
//		costControlPanel.setSharedButton(buttonA, buttonB, buttonC);
//		if (happyCount>5) {
//			System.out.println("Happiness max reached!"); 
//			buttonB.setEnabled(false);//makes the button not work
//			buttonC.setEnabled(false);
//		}
//
//	}
//	public void hungerCare() {
//		hungerCount++;
//		if (hungerCount>10) {
//			System.out.println("Pet is full!");
//			buttonA.setEnabled(false);
//		}
//	} 
////	public void healthCare() {  UNDONE COMPONENT
////		
////	}
//
//	
//	public void paintComponent(Graphics g) { //QUESTION: It worked when I named the method paintComponent, why?
//	    super.paintComponent(g); //added this and there weren't weird looking things
//		int xLength1 = happyCount*100;
//		int xLength2 = hungerCount*50;
//		if (happyCount<=2) {
//			g.setColor(Color.RED); //makes the bar red if your happiness is too low
//		} else {
//		g.setColor(Color.GREEN);
//		}
//		g.fillRect(0, 300, xLength1, 50);
//		g.drawRect(0, 300, 500, 50);
//		
//		if (hungerCount<=4) {
//			g.setColor(Color.RED); //makes the bar red if your happiness is too low
//		} else {
//		g.setColor(Color.GREEN);
//		}
//		g.fillRect(0, 400, xLength2, 50);
//		g.drawRect(0, 400, 500, 50);
//		
//		g.setColor(Color.BLACK);
//		g.drawString("Happiness Bar", 200, 290);
//		g.drawString("Hunger Bar", 200, 390);
//	}
//}
