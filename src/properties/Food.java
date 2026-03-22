
package properties;

import pets.Pet;

/**
 * Creates a food object with a name, version, price, and type
 * 
 * @author Jasmine Pruzan, Ishaan Bhalerao, Ellie Lo
 * @version 3/20/2026
 */
public class Food {
	// Fields
	// Which version of food was chosen
	private int version;
	private String foodName;
	// Which animal is this food for
	private String foodType;
	private double price;
	
	/**
	 * Constructor that initializes food name, type, price, and version
	 * 
	 * @param name name of the food
	 * @param type type of animal the food is meant for
	 * @param price cost of the food
	 * @param version version determining impact of consumption on the pet
	 */
	public Food(String name, String type, double price, int version) {
		foodName = name;
		foodType = type;
		this.price = price;
		this.version = version;
	}
	
	/**
	 * Checks if the correct food was chosen for the pet 
	 * 
	 * @param p Pet object
	 * @return true if the food type matches the pet type, false otherwise
	 */
	public boolean checkType(Pet p) {
		if(p.getType().equals(foodType)) {
			return true;
		}
		else {
			return false;
		}
		
	}

	/** 
	 * Increases pet hunger field based on which food they chose
	 * @param p Pet object
	 */
	public void feedPet(Pet p) {
		int currentHunger = p.getHunger();
		
		if(checkType(p)) {
			if(version == 4) {
				p.setHunger(currentHunger+8);
			}
			else if(version == 3) {
				p.setHunger(currentHunger+6);
			}
			else if(version == 2){
				p.setHunger(currentHunger+4);
			}
			else {
				p.setHunger(currentHunger+2);
			}
		}
		// Increases half if wrong type
		else if(!checkType(p)) {
			if(version == 4) {
				p.setHunger(currentHunger+4);
				p.setHealth(currentHunger-4);
			}
			else if(version == 3) {
				p.setHunger(currentHunger+3);
				p.setHealth(currentHunger-3);
			}
			else if(version == 2){
				p.setHunger(currentHunger+2);
				p.setHealth(currentHunger-2);
			}
			else {
				p.setHunger(currentHunger+1);
				p.setHealth(currentHunger-1);
			}
		}
	}
	
	
	// Getters
	public String getName() {
		return foodName;
	}
	
	public String getType() {
		return foodType;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getVersion() {
		return version;
	}
}

