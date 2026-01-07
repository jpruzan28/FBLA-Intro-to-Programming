package pets;

public class Pet {
	//Fields from UML
	private String name;
	private int age;
	
	private int health;
	private int hunger;
	private int emotion;
	private int rest;
	
	private String[] toys;
	private double money;
	
	
	//Constructor maybe???
	public Pet() {
		name = "";
		age = 0;
		health = 10;
		hunger = 10;
		emotion = 10;
		rest = 10; 
		
		toys = new String[5];
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
	
	public void setHealth(int newHealth) {
		health = newHealth;
	}
	
	public void setHunger(int newHunger) {
		hunger = newHunger;
	}
	
	public void setEmotion(int newEmotion) {
		emotion = newEmotion;
	}
	
	public void setRest(int newRest) {
		rest = newRest;
	}
	
	public void setMoney(double newMoney) {
		money = newMoney;
	}
	
	// Puts toy into next available spot in toys array
	public void setToys(String newToy) {
		for(int i = 0; i < toys.length; i++) {
			if(toys[i].equals("")) {
				toys[i] = newToy;
			}
		}
	}
	
	// Getters
		public String getName() {
			return name;
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
		
		public int setEmotion() {
			return emotion;
		}
		
		public int getRest() {
			return rest;
		}
		
		public double getMoney() {
			return money;
		}
		
		// Returns the toys array in a string
		public String getToys(String newToy) {
			
			String toysStr = "";
			for(int i = 0; i < toys.length; i++) {
				if(toys[i].equals("")) {
					//skips
				}
				else {
					toysStr += (toys[i] + " ");
				}
			}
			
			return toysStr;
		}
	
	
}
