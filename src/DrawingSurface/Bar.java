package DrawingSurface;

import pets.*;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;


public class Bar extends JPanel {
	
	Pet p;
	
	public Bar(Pet pet) {
		p = pet;

	}

	public void paintComponent(Graphics g) { 
		//drawing bar based on pet's stats
		
		double width = getWidth()/16;
		double x = width;
		
		double rectWidth = 2*width;
		g.setColor(Color.BLACK);
		
		while (x < getWidth()-width) {
			g.drawRect((int)x, 50, (int)rectWidth, 30);

			x += 3*width;

		}
		
		double rectSects = rectWidth/10;
		
		g.setColor(Color.GREEN);
		// Health
		g.fillRect((int)width, 50, (int)(p.getHealth()*rectSects), 30);
		//Hunger
		g.fillRect((int)(width + width*3), 50, (int)(p.getHunger()*rectSects), 30);
		// Hygiene
		g.fillRect((int)(width*7), 50, (int)(p.getHygiene()*rectSects), 30);
		// Rest
		g.fillRect((int)width*10, 50, (int)(p.getRest()*rectSects), 30);
		// Emotion
		g.fillRect((int)width*13, 50, (int)(p.getEmotion()*rectSects), 30);

		
		
	}
}
