package properties;

import java.util.HashMap;

import pets.Pet;


public class Money {
	
	private String[] availableToysD;  
	private String[] availableToysF;
	private String[] availableToysC;
	
	
	private double[][] toyPrices;   
	private double[] foodPrices; 


	public Money() {
		availableToysD = new String[]{"Used ball", "A Rubber Chew Bone", "Guardian Plus Bear", "Enchanted Chew Wand", "Ecstatic Frizzby", "Golden Bone"};
		availableToysF = new String[]{"Drift Ball", "Shell Hideout", "Bioluminescent Bubble Machine", "Robotic Friend", "Ancient Calming Bell", "Platinum Speaker For Music"};
		availableToysC = new String[]{"Plain Sock", "Jingle Mouse", "Corner Scratch Post", "Laser Pointer", "Quarter Zip", "Legendary Airpods"};
		toyPrices = new double[][] {{3.00, 4.55, 10.00, 18.00, 40.00, 70.00},
				{2.55, 11.00, 15.00, 35.50, 75.00, 100.00}, 
				{3.00, 6.00, 15.00, 30.00, 50.00, 120.00}};
		
		/*HashMap<String, Integer> foods = new Hashmap<>();
		foods.put("Used ball", 3.00);*/
		
		// Find a way to differentiate food for different animals
		// Split up into seperate arrays for animals
		dogFood = new String[] {"Kibble Crunch", "Beef & Veggie Mix", "Chicken Feast", "Salmon Delight", "Lamb & Rice Bowl", "Golden Chicken Nuggets"};
		fishFood = new	String[] {"Flake Feast", "Algae Crisps", "Shrimp Pellets", "Spirulina Flakes", "Caviar Pearls", "Deep Abyss Infusion"};
		catFood = new String [] {"Mixed Kibble Mix", "Veggie Medley", "Turkey & Cranberry Treats", "Expensive Milk","Crunchy Bluefin Tuna Sushi", "One of a kind Lamb Delight" };
		
		// !!!!!!!!!
		foodPrices = new double[] {10.00};
		
		
		//dogFood = new Food[] {new Food("Kibble Crunch", "Dog", 10.00, 1), new Food("Beff...", "Dog", 10, 2), new Food..}
		
		
		
		// Vet visits
	}
	
	// Put in drawing surface/console
	/*public boolean checkIfSelec() {
		
		
		return false;
		
	}*/
	
	public void buyFood(Food f, Pet p, String type) {
		double m = p.getMoney();
				
		p.setMoney(m-f.getCost());
		
		
	}
	
	public void buyToys(Pet p) {
		double m = p.getMoney();
		
		
	}
	
	
	// FAKE GETTERS
	public String getCFood() {
		String food = "";
		for(int i = 0; i < catFood.length; i++) {
			food += catFood[i];
		}
		
		return food;
	}
	
	public String getDFood() {
		String food = "";
		for(int i = 0; i < dogFood.length; i++) {
			food += dogFood[i];
		}
		
		return food;
	}
	
	public String getFFood() {
		String food = "";
		for(int i = 0; i < fishFood.length; i++) {
			food += fishFood[i];
		}
		
		return food;
	}
	
	
	// VET VISIT METHOD
	// $20

}
