package properties;


import DrawingSurface.DrawingSurface;
import pets.Pet;

public class Store {

	private Food[] dogFood;  
	private Food[] fishFood;
	private Food[] catFood;
	
	
	private Toys[] dogToys;
	private Toys[] fishToys;
	private Toys[] catToys;
	
	

	public Store() {
		
		// Food Arrays
		dogFood = new Food[] {new Food("Kibble Crunch", "Dog", 10.00, 1), new Food("Salmon Delight", "Dog", 50.00, 2),
				new Food("Golden Chicken Nuggets", "Dog", 100.00, 3)};
		
		fishFood = new Food[] {new Food("Flakes", "Fish", 10.00, 1), new Food("Algae Crisps", "Fish", 20.00, 2),
				 new Food("Deep Abyss Infusion", "Fish", 100.00, 3)};
		
		catFood = new Food[] {new Food("Five Fish Kibble", "Cat", 10.00, 1),
				new Food("Turkey and Cranberry Treats", "Cat", 50.00, 2), new Food("A Golden Rat", "Cat", 100.00, 3)};
		
		
		// Toy Arrays
		dogToys = new Toys[] {new Toys("Used Ball", "Dog", 4.00, 1), new Toys("Enchanted Chew Wand", "Dog", 25.00, 2),
				new Toys("Goldenest Bone", "Dog", 90.00, 3)};
		
		fishToys = new Toys[] {new Toys("Drift Ball", "Fish", 4.00, 1), new Toys("Biolume Bubble Machine", "Fish", 25.00, 2),
				new Toys("Platinum Speaker", "Fish", 90.00, 3)};
		
		catToys = new Toys[] {new Toys("Plain Kitty Sock", "Cat", 4.00, 1), new Toys("Laser Pointer", "Cat", 50.00, 2), 
				new Toys("Legendary Airpods", "Cat", 90.00, 3)};

	}
	
	
	public void buyFood(Food f, Pet p) {
		double m = p.getMoney();
		
		if(m < f.getPrice()) {
			DrawingSurface.errorMessage("Too expensive");
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
			DrawingSurface.errorMessage("Too expensive");
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
			DrawingSurface.errorMessage("Too expensive");
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
