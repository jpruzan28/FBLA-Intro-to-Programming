

package properties;

import pets.Pet;

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
	
	
	
	
	public void setEnjFact(String ef) {
		this.enjoymentFactor = ef;
	}
	
	public String getEnjFact() {
		return enjoymentFactor;
	}
	
	
	
	
	
}
