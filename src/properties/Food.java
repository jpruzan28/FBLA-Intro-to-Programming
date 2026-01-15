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
	//private String foodName;
	// Which animal is this food for
	private String foodType;
	
	
	public Food(int version, String type) {
		this.version = version;
		foodType = type;
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
			if(version == 1) {
				p.setHunger(currentHunger+8);
			}
			else if(version == 2) {
				p.setHunger(currentHunger+6);
			}
			else {
				p.setHunger(currentHunger+4);
			}
		}
		// Increases half if wrong type
		else if(!checkType(p)) {
			if(version == 1) {
				p.setHunger(currentHunger+4);
			}
			else if(version == 2) {
				p.setHunger(currentHunger+3);
			}
			else {
				p.setHunger(currentHunger+2);
			}
		}
	}
	
	// Add method to decrease health if wrong food type
}

/*
public class Food {
	
	//fields
//	private double cost;

	private String enjoymentFactor;
	private int clickOnFood;
	

	private String[][] foodName;
	//private String[] foodType;
	
	private int defHealth;
	

	//constructor
	public Food() {
//		cost = 0;
		enjoymentFactor = "";
		foodName = new String[3][3];
		//foodType = new String[3];
		defHealth = 10;
		
	}
	
	
	
	//Methods below
	public int getHealth() {
		return defHealth;
	}
	
	public void setFoodName(String f) {
		for(int i = 0; i < foodName.length; i++) {
			for(int j = 0; j < foodName[0].length; j++) {
				f = this.foodName[j][i];
			}
		}
	}
	
	public void checkFoodName(String pType) {
		int fType;
		int petsType;
		
		if(pType.equals("dog")) {
			petsType = 0;
			
		}
		
		else if(pType.equals("cat")) {
			petsType = 1;
		} 
		
		else {
			petsType = 2;
		}
		
		
		if(clickOnFood >= 1 && clickOnFood <=3) {
			fType = 0;
			
		}
		else if(clickOnFood >= 4 && clickOnFood <= 6) {
			fType = 1;
		}
		else {
			fType = 2;
		}
		
		if(fType == petsType) {
			//good tings
			
		}
		else {
			//bad stuff
		}
	}
	
	
	public void setFoodType() {
		
		
	}
	
//	public String[] getFoodType() {
//		return foodType;
//	}
	
	
	/**
	 * Uncomment out if I'm wrong about commenting out this method
	 * 
	 */
//	public void setCostFood(double c) {
//		this.cost = c;
//	}
	
	
//	public double getCostFood() {
//		return cost;	
//	}
	
	/*
	
	
	public void setEnjFact(String ef) {
		this.enjoymentFactor = ef;
	}
	
	public String getEnjFact() {
		return enjoymentFactor;
	}
	
	
	
	
	
}*/
