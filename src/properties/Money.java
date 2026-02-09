package properties;

import java.util.HashMap;

import pets.Pet;
import VirtualPet.main;


// Health Gain Factor is 1-4
// 1 --> 0 - 10 dollars
// 2 --> 11 - 35 dollars
// 3 --> 36 - 70 dollars
// 4 --> 70 plus dollars

//Enjoyment Factor is 1-4
//1 --> 0 - 8 dollars
//2 --> 9 - 8 dollars
//3 --> 9 - 70 dollars
//4 --> 70 plus dollars




// I understand you can get the same health benefit/enjoyment with a low price for some foods and toys, but I think it teaches financial responsibility to the user,
// Can be fixed later tho

public class Money {

	private Food[] dogFood;  
	private Food[] fishFood;
	private Food[] catFood;
	
	
	private Toys[] dogToys;
	private Toys[] fishToys;
	private Toys[] catToys;
	
	

	public Money() {
		
		dogFood = new Food[] {new Food("Kibble Crunch", "Dog", 10.00, 1), new Food("Beef and Veggie Mix", "Dog", 20.00, 2), new Food("Chicken Feast", "Dog", 30.00, 2), 
				new Food("Salmon Delight", "Dog", 50.00, 3), new Food("Lamb and Rice Bowl", "Dog", 70.00, 3), new Food("Golden Chicken Nuggets", "Dog", 100.00, 4)};
		
		fishFood = new Food[] {new Food("Flakes", "Fish", 10.00, 1), new Food("Algae Crisps", "Fish", 20.00, 2), new Food("Shrimp Pellets", "Fish", 30.00, 2), 
				new Food("Spirulina Flakes", "Fish", 50.00, 3), new Food("Caviar Pearls", "Fish", 70.00, 3), new Food("Deep Abyss Infusion", "Fish", 100.00, 4)};
		
		catFood = new Food[] {new Food("Five Fish Kibble", "Cat", 10.00, 1), new Food("Veggie Medley", "Cat", 20.00, 2), new Food("Expensive Melk", "Cat", 30.00, 2), 
				new Food("Turkey and Cranberry Treats", "Cat", 50.00, 3), new Food("Bluefin Tuna Steak", "Cat", 70.00, 3), new Food("A Golden Rat", "Cat", 100.00, 4)};
		
		
		
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
			p.setToys(t);
		}
	}

	public void vetVisit(Pet p) {
		double m = p.getMoney();
		
		if(m < 20) {
			main.errorMessage("Too expensive");
		}
		
		else {
			p.setHealth(10);
			p.setMoney(m -= 20);
		}
		

		System.out.println("Went to the vet");
		System.out.println("The health is " + p.getHealth());
	}
	
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
