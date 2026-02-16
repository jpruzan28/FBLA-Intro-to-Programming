package properties;


import pets.Pet;
import VirtualPet.main;


public class Store {

	private Food[] dogFood;  
	private Food[] fishFood;
	private Food[] catFood;
	
	
	private Toys[] dogToys;
	private Toys[] fishToys;
	private Toys[] catToys;
	
	

	public Store() {
		
		// Food Arrays
		dogFood = new Food[] {new Food("Kibble Crunch", "Dog", 10.00, 1), new Food("Beef and Veggie Mix", "Dog", 20.00, 2), new Food("Chicken Feast", "Dog", 30.00, 2), 
				new Food("Salmon Delight", "Dog", 50.00, 3), new Food("Lamb and Rice Bowl", "Dog", 70.00, 3), new Food("Golden Chicken Nuggets", "Dog", 100.00, 4)};
		
		fishFood = new Food[] {new Food("Flakes", "Fish", 10.00, 1), new Food("Algae Crisps", "Fish", 20.00, 2), new Food("Shrimp Pellets", "Fish", 30.00, 2), 
				new Food("Spirulina Flakes", "Fish", 50.00, 3), new Food("Caviar Pearls", "Fish", 70.00, 3), new Food("Deep Abyss Infusion", "Fish", 100.00, 4)};
		
		catFood = new Food[] {new Food("Five Fish Kibble", "Cat", 10.00, 1), new Food("Veggie Medley", "Cat", 20.00, 2), new Food("Expensive Melk", "Cat", 30.00, 2), 
				new Food("Turkey and Cranberry Treats", "Cat", 50.00, 3), new Food("Bluefin Tuna Steak", "Cat", 70.00, 3), new Food("A Golden Rat", "Cat", 100.00, 4)};
		
		
		// Toy Arrays
		dogToys = new Toys[] {new Toys("Used Ball", "Dog", 4.00, 1), new Toys("Rubber Chew Bone", "Dog", 8.00, 1), new Toys("Enchanted Chew Wand", "Dog", 25.00, 2), new Toys("Guardian Plus bear", "Dog", 50.00, 2), 
				new Toys("Dog God Worship Altar", "Dog", 70.00, 3), new Toys("Goldenest Bone", "Dog", 90.00, 4)};
		
		fishToys = new Toys[] {new Toys("Drift Ball", "Fish", 4.00, 1), new Toys("Shell Hideout", "Fish", 8.00, 1), new Toys("Biolume Bubble Machine", "Fish", 25.00, 2), new Toys("Robotic Friend", "Fish", 50.00, 2), 
				new Toys("Ancient Calming Bell", "Fish", 70.00, 3), new Toys("Platinum Speaker", "Fish", 90.00, 4)};
		
		catToys = new Toys[] {new Toys("Plain Kitty Sock", "Cat", 4.00, 1), new Toys("Jingle Mouse", "Cat", 8.00, 1), new Toys("Corner Scratch Post", "Cat", 25.00, 2), new Toys("Laser Pointer", "Cat", 50.00, 2), 
				new Toys("Quarter Zip", "Cat", 70.00, 3), new Toys("Legendary Airpods", "Cat", 90.00, 4)};

	}
	
	
	public void buyFood(Food f, Pet p) {
		double m = p.getMoney();
		
		if(m < f.getPrice()) {
			main.errorMessage("Too expensive");
		}
		
		else {
			p.setMoney(m - f.getPrice());
			p.addExpenses(f.getPrice());
			f.feedPet(p);
		}
	}
	
	public void buyToys(Toys t, Pet p) {
		double m = p.getMoney();
		
		if(m < t.getPrice()) {
			main.errorMessage("Too expensive");
		}
		
		else {
			p.setMoney(m - t.getPrice());	
			p.addExpenses(t.getPrice()); 
			p.setToys(t);
		}
	}

	public boolean vetVisit(Pet p) {
		double m = p.getMoney();
		
		if(m < 20) {
			main.errorMessage("Too expensive");
			return false;
		}
		
		else {
			p.setHealth(10);
			p.setMoney(m -= 20);
			p.addExpenses(20);

			return true;
		}
	}
	
	
	// Getters
	public Toys[] getDogToys() {
		return dogToys;
	}
	
	public Toys[] getFishToys() {
		return fishToys; 
	}
	
	public Toys[] getCatToys() {
		return catToys;
	}
	
	public Food[] getDogFood() {
		return dogFood;
	}
	
	public Food[] getCatFood() {
		return catFood;
	}
	
	public Food[] getFishFood() {
		return fishFood;
	}
}
