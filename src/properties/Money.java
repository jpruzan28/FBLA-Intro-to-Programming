package properties;
import pets.Pet;


public class Money {
	
	private String[] availableToys;     
	private double[] toyPrices;         

	private String[] availableFoods;     
	private double[] foodPrices;         
	
	public Money() {
		availableToys = new String[]{"Used ball", "A Rubber Chew Bone", "Guardian Plus Bear", "Enchanted Chew Wand", "Ecstatic Frizzby", "Golden Bone", 
				"Drift Ball", "Shell Hideout", "Bioluminescent Bubble Machine", "Robotic Friend", "Ancient Calming Bell", "Platinum Speaker For Music",
				"Plain Sock", "Jingle Mouse", "Corner Scratch Post", "Laser Pointer", "Quarter Zip", "Legendary Airpods"};
		toyPrices = new double[] {3.00, 4.55, 10.00, 18.00, 40.00, 70.00,
				2.55, 11.00, 15.00, 35.50, 75.00, 100.00, 
				3.00, 6.00, 15.00, 30.00, 50.00, 120.00};
		
		// Find a way to differentiate food for different animals
		// Split up into seperate arrays for animals
		availableFoods = new String[] {"Kibble Crunch", "Beef & Veggie Mix", "Chicken Feast", "Salmon Delight", "Lamb & Rice Bowl", "Golden Chicken Nuggets",
				"Flake Feast", "Algae Crisps", "Shrimp Pellets", "Spirulina Flakes", "Caviar Pearls", "Deep Abyss Infusion",
				"Mixed Kibble Mix", "Veggie Medley", "Turkey & Cranberry Treats", "Expensive Milk","Crunchy Bluefin Tuna Sushi", "One of a kind Lamb Delight" };
		foodPrices = new double[] {10.00};
		
		
		// Vet visits
	}
	
	// Put in drawing surface
	public boolean checkIfSelec() {
		return false;
		
	}
	
	public void buyFood(Food f, Pet p) {
		double m = p.getMoney();
		
		
		
		
	}
	
	public void buyToys(Pet p) {
		double m = p.getMoney();
		
		
	}
	
	
	

}
