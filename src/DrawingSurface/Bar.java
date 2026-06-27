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
	
	public Bar(Pet pet, String name, double x, double y, double maxWidth, double height) {
		this.pet = pet;
		this.name = name; 
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height; 
		this.maxWidth = maxWidth;
		
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
