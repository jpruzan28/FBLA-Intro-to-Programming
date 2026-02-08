package VirtualPet;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameOverPanel extends JPanel{
	
	public GameOverPanel(CardLayout cardLayout, JPanel cardPanel) {
		
		 setLayout(new BorderLayout());
	     setBackground(Color.cyan);
	     
	     
	     
	     JLabel titleLabel = new JLabel("GAME OVER! :<", SwingConstants.CENTER);
	     titleLabel.setFont(new Font("Rubik Mono One", Font.BOLD, 50));
	     add(titleLabel, BorderLayout.CENTER);
		
		
	}
	
	
}
