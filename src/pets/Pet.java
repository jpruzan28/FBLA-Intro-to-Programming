package pets;

import properties.Toys;
import virtualPet.main;

public class Pet {
	//Fields from UML
	private String name;
	private int age;
	private String type;
	
	private int health;
	private int hunger;
	private int emotion;
	private int rest;
	private int hygiene;
	
	private Toys[] toys;
	private double money;
	
	
	//Constructor maybe???
	public Pet(String name, String type) {
		this.name = name;
		this.type = type;
		age = 0;
		health = 10;
		hunger = 10;
		emotion = 10;
		rest = 10; 
		hygiene = 10;
		
		toys = new Toys[5];
		money = 100.00;
	}
	
	
	//Methods
	
	// Setters
	public void setName(String newName) {
		name = newName;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}
	
	// Keeps fields inbounds of 10
	public void setHealth(int newHealth) {
		if(newHealth > 10) {
			health = 10;
			System.out.println("Health is at maximum");
		}
		else {
			health = newHealth;
			System.out.println("Adding " + newHealth + " to health");
		}
//		Health.addHungerToHealth(health);
	}
	
	public void setHunger(int newHunger) {
		if(newHunger > 10) {
			hunger = 10;
		}
		else {
			hunger = newHunger;
		}
	}
	
	public void setEmotion(int newEmotion) {
		if(newEmotion > 10) {
			emotion = 10;
		}
		else {
			emotion = newEmotion;
		}
	}
	
	public void setRest(int newRest) {
		if(newRest > 10) {
			rest = 10;
		}
		else {
			rest = newRest;
		}
	}
	
	public void setMoney(double newMoney) {
		money = newMoney;
	}
	
	public void setHygiene(int newHygeine) {
		hygiene = newHygeine;
	}
	
	// Puts toy into next available spot in toys array
	public void setToys(Toys newToy) {
		System.out.println("Added to toys");
		int numToys = 0;
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
			main.errorMessage("Toy overflow");
		}
	}
	
	// Getters
		public String getName() {
			return name;
		}
		
		public String getType() {
			return type;
		}
		
		public int getAge() {
			return age;
		}
		
		public int getHealth() {
			return health;
		}
		
		public int getHunger() {
			return hunger;
		}
		
		public int getEmotion() {
			return emotion;
		}
		
		public int getRest() {
			return rest;
		}
		
		public double getMoney() {
			return money;
		}
		
		public int getHygiene() {
			return hygiene;
		}
		
		// Returns the toys array in a string
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
		
		public Toys[] getToysArr() {
			return toys;
		}
		
	
	
}
