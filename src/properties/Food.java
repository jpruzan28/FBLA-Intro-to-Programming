package properties;

public class Food {
	
	//fields
	private double cost;
	//rename to eFact for efficiency
	private String enjoymentFactor;
	
	//Food name defers from food type cuz food type is for different animals
	private String foodName;
	private String foodType;
	
	private int health;
	

	//constructor
	public Food() {
		cost = 0;
		enjoymentFactor = "";
		foodName = "";
		foodType = "";
		health = 0;
		
	}
	
	
	
	//Methods below
	public void setHealth(int h) {
		this.health = h;
	}
	public int getHealth() {
		return health;
	}
	
	
	
	
	public void setFoodName(String f) {
		this.foodName = f;
	}
	public String getFoodName() {
		return foodName;
	}
	
	
	
	
	public void setFoodType(String f) {
		this.foodType = f;
	}
	public String getFoodType() {
		return foodType;
	}
	
	
	
	
	public void setCostFood(double c) {
		this.cost = c;
	}
	
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
