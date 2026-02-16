package DrawingSurface;

import pets.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;


public class Bar extends JPanel {
	
	Pet p;
	
	public Bar(Pet pet) {
		p = pet;

	}

	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		

		//drawing bar based on pet's stats

		
		double width = getWidth()/16;
		double x = width;
		int y = 50;
		
		double rectWidth = 2*width;
		g.setColor(Color.BLACK);
		
		while (x < getWidth()-width) {
			g.drawRect((int)x, y, (int)rectWidth, 30);

			x += 3*width;

		}
		
		double rectSects = rectWidth/10;
		
		g.setColor(Color.GREEN);
		// Health
		g.fillRect((int)width, y, (int)(p.getHealth()*rectSects), 30);

		// Hunger
		g.fillRect((int)(width + width*3), y, (int)(p.getHunger()*rectSects), 30);

		// Hygiene
		g.fillRect((int)(width*7), y, (int)(p.getHygiene()*rectSects), 30);

		// Rest
		g.fillRect((int)width*10, y, (int)(p.getRest()*rectSects), 30);

		// Emotion
		g.fillRect((int)width*13, y, (int)(p.getEmotion()*rectSects), 30);

		
		// Labeling the bars
		g.setColor(Color.BLACK);
		
		g.drawString("Health", (int)width, y);
		g.drawString("Hunger", (int)(width + width*3), y);
		g.drawString("Hygiene", (int)(width*7), y);
		g.drawString("Rest", (int)(width*10), y);
		g.drawString("Emotion", (int)(width*13), y);



		
	}
}
