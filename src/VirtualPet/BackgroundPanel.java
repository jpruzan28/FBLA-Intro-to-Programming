package VirtualPet;

import DrawingSurface.Bar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	private BufferedImage image;
	
	private Bar[] bars; 
	
	public BackgroundPanel(String imagePath, Bar[] bars) {
		setLayout(null);
		setOpaque(false);
		
		this.bars = bars; 
		
		try {
			image = ImageIO.read(new File(imagePath));
		}
		catch (IOException e) {
			System.out.println("Background image not found");
		}
	}
	
	public BackgroundPanel(String imagePath) {
		setLayout(null);
		setOpaque(false);
		
		this.bars = null; 
		
		try {
			image = ImageIO.read(new File(imagePath));
		}
		catch (IOException e) {
			System.out.println("Background image not found");
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
		  if (bars == null) return;
		
		Bar health = bars[0];
		Bar hunger = bars[1];
		Bar hygiene = bars[2];
		Bar rest = bars[3];
		Bar emotion = bars[4];

		
		// Writing stats on top of bars
		int fontSize = 24;
		g.setColor(Color.BLACK); 
		g.setFont(new Font("SansSerif", Font.BOLD, fontSize)); 

		g.drawString("Health", (int)health.getX(), (int)health.getY() - fontSize);
		g.drawString("Hunger", (int)hunger.getX(), (int)hunger.getY() - fontSize);
		g.drawString("Hygiene", (int)hygiene.getX(), (int)hygiene.getY() - fontSize);
		g.drawString("Rest", (int)rest.getX(), (int)rest.getY() - fontSize);
		g.drawString("Emotion", (int)emotion.getX(), (int)emotion.getY() - fontSize);
		
		double outlineWidth = health.getMaxWidth();	
		// Drawing outlines of bars 
		g.drawRect((int)health.getX(), (int)health.getY(), (int)outlineWidth, (int)health.getHeight());
		g.drawRect((int)hunger.getX(), (int)hunger.getY(), (int)outlineWidth, (int)hunger.getHeight());
		g.drawRect((int)hygiene.getX(), (int)hygiene.getY(), (int)outlineWidth, (int)hygiene.getHeight());
		g.drawRect((int)rest.getX(), (int)rest.getY(), (int)outlineWidth, (int)rest.getHeight());
		g.drawRect((int)emotion.getX(), (int)emotion.getY(), (int)outlineWidth, (int)emotion.getHeight());

		// Filling in bars with the correct colors
		g.setColor(health.getColor());
		g.fillRect((int)health.getX(), (int)health.getY(), (int)health.getWidth(), (int)health.getHeight());
		
		g.setColor(hunger.getColor());
		g.fillRect((int)hunger.getX(), (int)hunger.getY(), (int)hunger.getWidth(), (int)hunger.getHeight());

		g.setColor(hygiene.getColor());
		g.fillRect((int)hygiene.getX(), (int)hygiene.getY(), (int)hygiene.getWidth(), (int)hygiene.getHeight());

		g.setColor(rest.getColor());
		g.fillRect((int)rest.getX(), (int)rest.getY(), (int)rest.getWidth(), (int)rest.getHeight());

		g.setColor(emotion.getColor());
		g.fillRect((int)emotion.getX(), (int)emotion.getY(), (int)emotion.getWidth(), (int)emotion.getHeight());


	}
	

}
