package DrawingSurface;

import pets.*;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;


public class Bar {
/*	
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



		
	}*/
	
	Pet pet; 
	String name; 
	
	int amount;
	double x;
	double y; 
	double width;
	double height; 
	double maxWidth;
	
	public Bar(Pet pet, String name, double x, double y, double maxWidth, double height) {
		this.pet = pet;
		this.name = name; 
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height; 
		this.maxWidth = maxWidth;
		
		if (name.equals("Hunger")) {
			amount = pet.getHunger();
		}
		else if (name.equals("Health")) {
			amount = pet.getHealth();

		}
		else if (name.equals("Hygiene")) {
			amount = pet.getHygiene();

		}
		else if (name.equals("Rest")) {
			amount = pet.getRest();

		}
		else if (name.equals("Emotion")) {
			amount = pet.getEmotion();

		}
		else {
			amount = -1; 
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getAmount() {
		 if (name.equals("Hunger")) {
		        return pet.getHunger();
		    } else if (name.equals("Health")) {
		        return pet.getHealth();
		    } else if (name.equals("Hygiene")) {
		        return pet.getHygiene();
		    } else if (name.equals("Rest")) {
		        return pet.getRest();
		    } else if (name.equals("Emotion")) {
		        return pet.getEmotion();
		    }
		    return -1;
		
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getWidth() {
	        return (getAmount() / 10.0) * maxWidth;
	    
	}
	
	public double getMaxWidth() {
	    return maxWidth;
	}
	
	public double getHeight() {
		return height;
	}
	
	
	public Color getColor() {
		if (getAmount() <= 3) {
			return Color.RED;
		}
		else if (getAmount() >= 8) {
			return Color.GREEN;
		}
		else {
			return Color.YELLOW;
		}
	}
}
