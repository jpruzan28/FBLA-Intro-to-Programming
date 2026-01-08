package properties;

public class Food {
	
	//fields
	private double cost;
	//rename to eFact for efficiency
	private String enjoymentFactor;
	
	//Food name defers from food type cuz food type is for different animals
	private String foodName;
	private String[] foodType;
	
	private int defHealth;
	

	//constructor
	public Food() {
		cost = 0;
		enjoymentFactor = "";
		foodName = "";
		foodType = new String[3];
		defHealth = 10;
		
	}
	
	
	
	//Methods below
	public int getHealth() {
		return defHealth;
	}
	
	
	
	
	public void setFoodName(String f) {
		this.foodName = f;
	}
	public String getFoodName() {
		return foodName;
	}
	
	
	
	
	public String[] getFoodType() {
		return foodType;
	}
	
	
	/**
	 * Uncomment out if I'm wrong about commenting out this method
	 * 
	 */
//	public void setCostFood(double c) {
//		this.cost = c;
//	}
	
	
	public double getCostFood() {
		return cost;	
	}
	
	
	
	
	public void setEnjFact(String ef) {
		this.enjoymentFactor = ef;
	}
	
	public String getEnjFact() {
		return enjoymentFactor;
	}
	
	
	
	
	
}
