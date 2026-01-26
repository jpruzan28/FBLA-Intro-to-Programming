/*
 * Change hunger field
 * 	- Increase when correct food choice
 *  - Decrease when incorrect food choice
 *  
 *  Lower health when wrong food choice
 */

package properties;

import pets.Pet;

public class Food {
	// Fields
	// Which version of food was chosen
	private int version;
	private String foodName;
	// Which animal is this food for
	private String foodType;
	private double price;
	
	
	public Food(String name, String type, double price, int version) {// change order
		foodName = name;
		foodType = type;
		this.price = price;
		this.version = version;
	}
	
	// Checks if the correct food was chosen for the pet 
	public boolean checkType(Pet p) {
		if(p.getType().equals(foodType)) {
			return true;
		}
		else {
			return false;
		}
		
	}

	// Increases pet hunger field based on which food they chose
	// Affect emotion
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
			}
			else if(version == 3) {
				p.setHunger(currentHunger+3);
			}
			else if(version == 2){
				p.setHunger(currentHunger+2);
			}
			else {
				p.setHunger(currentHunger+1);
			}
		}
	}
	
	
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
	// Add method to decrease health if wrong food type
}

