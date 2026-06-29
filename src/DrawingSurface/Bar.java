package DrawingSurface;

import pets.*;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;


public class Bar {

	
	Pet pet; 
	String name; 
	
	int amount;
	double x;
	double y; 
	double width;
	double height; 
	double maxWidth;
	
	Color red;
	Color yellow;
	Color green; 
	
	public Bar(Pet pet, String name, double x, double y, double maxWidth, double height) {
		this.pet = pet;
		this.name = name; 
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height; 
		this.maxWidth = maxWidth;
		
		red = new Color(204,  0,  0); // muted red
		yellow = new Color(246, 231,  26); // muted yellow 
		green = new Color(102, 204, 0); // muted green
		
		if (name.equals("Nutrition")) {
			amount = pet.getNutrition();
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
		 if (name.equals("Nutrition")) {
		        return pet.getNutrition();
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
			return red;
		}
		else if (getAmount() >= 8) {
			return green;
		}
		else {
			return yellow;
		}
	}
}
