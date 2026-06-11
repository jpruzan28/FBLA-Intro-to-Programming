package pets;

import java.util.ArrayList;
import java.util.HashMap;

import DrawingSurface.DrawingSurface;
import properties.*;

/**Creates a pet object that holds the pet's name, type, stats, and user money
 * 
 * @author Jasmine Pruzan, Ishaan Bhalerao, Ellie Lo
 * @version 3/18/26
 */
public class Pet {
	//Fields from UML
	private String name;
	private String type;
	private String owner; 
	
	private int health;
	private int hunger;
	private int emotion;
	private int rest;
	private int hygiene;
	
	private Toy[] toys;
	private double money;
	private double expenses;
	
	private ArrayList<Food> food; 
	private int vetVisits; 
	
	/**Constructor that initializes all of the fields. 
	 * 
	 * @param name name of pet
	 * @param type animal type of pet
	 */
	public Pet(String name, String type, String owner) {
		this.name = name;
		this.type = type;
		this.owner = owner; 
		health = 10;
		hunger = 10;
		emotion = 10;
		rest = 10;
		hygiene = 10;
		
		toys = new Toy[5];
		money = 100.00;
		expenses = 0; 

		food = new ArrayList<Food>(); 
		vetVisits = 0; 
	}
	
	
	//Methods
	
	// Setters
	/**
	 * Renames the pet
	 * @param newName name that will replace the previous name. 
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	
	/**
	 * Updates health
	 * @param newHealth updated health amount
	 * @post health will always be <= 10
	 */
	public void setHealth(int newHealth) {
		// Keeps fields inbounds of 10
		if(newHealth > 10) {
			health = 10;
		}
		else if(newHealth < 0) {
			health = 0;
		}
		else {
			health = newHealth;
		}
	}
	
	/**
	 * Updates hunger
	 * @param newHunger updated hunger amount
	 * @post hunger will always be <= 10
	 */
	public void setHunger(int newHunger) {
		if(newHunger > 10) {
			hunger = 10;
		}
		else {
			hunger = newHunger;
		}
		
	}
	
	/**
	 * Updates emotion
	 * @param newEmotion updated emotion amount
	 * @post emotion will always be <= 10
	 */
	public void setEmotion(int newEmotion) {
		if(newEmotion > 10) {
			emotion = 10;
		}
		else {
			emotion = newEmotion;
		}
	}
	
	/**
	 * Updates rest
	 * @param newRest updated rest amount
	 * @post rest will always be <= 10
	 */
	public void setRest(int newRest) {
		if(newRest > 10) {
			rest = 10;
		}
		else {
			rest = newRest;
		}
		
	}
	
	/**
	 * Updates hygiene
	 * @param newHygiene updated hygiene amount
	 * @post hygiene will always be <= 10
	 */
	public void setHygiene(int newHygiene) {
		if(newHygiene > 10) {
			hygiene = 10;
		}
		else {
			hygiene = newHygiene;
		}
		
	}
	
	/**
	 * Updates money
	 * @param newMoney updated money amount
	 */
	public void setMoney(double newMoney) {
		money = newMoney;
	}
	
	/**
	 * Adds a toy to the toy list
	 * Maximum of 5 toys in the list at once
	 * @param newToy toy being added
	 */
	public void setToys(Toy newToy) {
		int numToys = 0;
		
		// Puts toy into next available spot in toys array
		for(int i = 0; i < toys.length; i++) {
			if(toys[i] == null) {
				toys[i] = newToy;
				i = toys.length;
			}
			else {
				numToys++;
			}
		}
		
		if(numToys == 5) {
			DrawingSurface.errorMessage("Toy overflow");
		}
	}
	
	/**
	 * Increments expenses to keep track of them
	 * @param expense amount added to current expenses
	 */
	public void addExpenses(double expense) {
        expenses += expense;
    }
	
	public void addFood(Food bought) {
		food.add(bought);
	}
	
	public void addVetVisit() {
		vetVisits += 1; 
	}
	
	// Getters
	
	/**
	 * Returns pet name
	 * @return pet name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns pet type
	 * @return pet type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Returns user name
	 * @return user name
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Returns pet health
	 * @return health amount
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Returns pet hunger
	 * @return hunger amount
	 */
	public int getHunger() {
		return hunger;
	}
	
	/**
	 * Returns pet emotion
	 * @return emotion amount
	 */
	public int getEmotion() {
		return emotion;
	}
		
	/**
	 * Returns pet rest
	 * @return rest amount
	 */
	public int getRest() {
		return rest;
	}
	
	/**
	 * Returns pet hygiene
	 * @return hygiene amount
	 */
	public int getHygiene() {
		return hygiene;
	}
		
	/**
	 * Returns amount of money
	 * @return money amount
	 */
	public double getMoney() {
		return money;
	}
		
	/**
	 * Returns pet expenses
	 * @return expenses amount
	 */
	public double getExpenses() {
		return expenses; 
	}
		
	/**
	 * Returns pet toys as a string
	 * @return string of toys bought
	 */
	public String getToysStr() {
			
		String toysStr = "";
		for(int i = 0; i < toys.length; i++) {
			if(toys[i] == null) {
				//skips
			}
			else {
				toysStr += (toys[i].getName() + ", ");
			}
		}
			
		return toysStr;
	}
		
	/**
	 * Returns pet toys as an array
	 * @return array of Toys bought
	 */
	public Toy[] getToysArr() {
		if(toys==null) {
		}
		return toys;
	}
	
	public ArrayList<Food> getFood() {
		return food;
	}
	
	public int getVetVisits() {
		return vetVisits;
	}
	
}
