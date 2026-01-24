package properties;
import pets.Pet;


public class Money {
	
	private String[] availableToysD;  
	private String[] availableToysF;
	private String[] availableToysC;
	
	
	private double[] toyPrices;   
	private double[] foodPrices; 

	private String[] dFood;
	private String[] fFood; 
	private String[] cFood;        
	
	
	// Temp fields
	private String[] catFood;
	private String[] dogFood;
	private String[] fishFood;
	
	
	public Money() {
		availableToysD = new String[]{"Used ball", "A Rubber Chew Bone", "Guardian Plus Bear", "Enchanted Chew Wand", "Ecstatic Frizzby", "Golden Bone"};
		availableToysF = new String[]{"Drift Ball", "Shell Hideout", "Bioluminescent Bubble Machine", "Robotic Friend", "Ancient Calming Bell", "Platinum Speaker For Music"};
		availableToysC = new String[]{"Plain Sock", "Jingle Mouse", "Corner Scratch Post", "Laser Pointer", "Quarter Zip", "Legendary Airpods"};
		toyPrices = new double[] {3.00, 4.55, 10.00, 18.00, 40.00, 70.00,
				2.55, 11.00, 15.00, 35.50, 75.00, 100.00, 
				3.00, 6.00, 15.00, 30.00, 50.00, 120.00};
		
		// Find a way to differentiate food for different animals
		// Split up into seperate arrays for animals
		dFood = new String[] {"Kibble Crunch", "Beef & Veggie Mix", "Chicken Feast", "Salmon Delight", "Lamb & Rice Bowl", "Golden Chicken Nuggets"};
		fishFood = new	String[] {"Flake Feast", "Algae Crisps", "Shrimp Pellets", "Spirulina Flakes", "Caviar Pearls", "Deep Abyss Infusion"};
		 catFood = new String [] {"Mixed Kibble Mix", "Veggie Medley", "Turkey & Cranberry Treats", "Expensive Milk","Crunchy Bluefin Tuna Sushi", "One of a kind Lamb Delight" };
		
		foodPrices = new double[] {10.00};
		
		
		
		//Temp fields
		catFood = new String[]{"cFood1", "cFood2", "cFood3"};
		dogFood = new String[]{"dFood1", "dFood2", "dFood3"};
		fishFood = new String[]{"fFood1", "fFood2", "fFood3"};

		
		
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
	
	
	

}
