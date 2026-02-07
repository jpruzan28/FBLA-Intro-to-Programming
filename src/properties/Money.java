package properties;

import java.util.HashMap;

import pets.Pet;


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
	
	private String[] availableToysD;  
	private String[] availableToysF;
	private String[] availableToysC;
	
	private Food[] d;  
	private Food[] fi;
	private Food[] ca;
	
	
	private Toys[] dog;
	private Toys[] fish;
	private Toys[] cat;
	
	
	
	private double[][] toyPrices;   
	private double[] foodPrices; 


	public Money() {
		
		d = new Food[] {new Food("Kibble Crunch", "Dog", 10.00, 1), new Food("Beef & Veggie Mix", "Dog", 20.00, 2), new Food("Chicken Feast", "Dog", 30.00, 2), 
				new Food("Salmon Delight", "Dog", 50.00, 3), new Food("Lamb and Rice Bowl", "Dog", 70.00, 3), new Food("Golden Chicken Nuggets", "Dog", 100.00, 4)};
		
		fi = new Food[] {new Food("Flakes", "Fish", 10.00, 1), new Food("Algae Crisps", "Fish", 20.00, 2), new Food("Shrimp Pellets", "Fish", 30.00, 2), 
				new Food("Spirulina Flakes", "Fish", 50.00, 3), new Food("Caviar Pearls", "Fish", 70.00, 3), new Food("Deep Abyss Infusion", "Fish", 100.00, 4)};
		
		ca = new Food[] {new Food("5 Fish Kibble", "Cat", 10.00, 1), new Food("Veggie Medley", "Cat", 20.00, 2), new Food("Expensive Melk", "Cat", 30.00, 2), 
				new Food("Turkey & Crannberry Treats", "Cat", 50.00, 3), new Food("Bluefin Tuna Steak", "Cat", 70.00, 3), new Food("A Golden Rat", "Cat", 100.00, 4)};
		
		
		
		dog = new Toys[] {new Toys("Used Ball", "Dog", 4.00, 1), new Toys("A Rubber Chew Bone", "Dog", 8.00, 1), new Toys("Enchanted Chew Wand", "Dog", 25.00, 2), new Toys("Guardian Plus bear", "Dog", 50.00, 2), 
				new Toys("Dog God Worship Altar", "Dog", 70.00, 3), new Toys("The Goldenest Bone", "Dog", 90.00, 4)};
		
		fish = new Toys[] {new Toys("Drift Ball", "Fish", 4.00, 1), new Toys("Shell Hideout", "Fish", 8.00, 1), new Toys("Biolume Bubble Machine", "Fish", 25.00, 2), new Toys("Robotic Friend", "Fish", 50.00, 2), 
				new Toys("Ancient Calming Bell", "Fish", 70.00, 3), new Toys("Platinum Speaker For Music", "Fish", 90.00, 4)};
		
		cat = new Toys[] {new Toys("Plain Kitty Sock", "Cat", 4.00, 1), new Toys("Jingle Mouse", "Cat", 8.00, 1), new Toys("Corner Scratch Post", "Cat", 25.00, 2), new Toys("Laser Pointer", "Cat", 50.00, 2), 
				new Toys("Quarter Zip", "Cat", 70.00, 3), new Toys("Legendary Airpods", "Cat", 90.00, 4)};

	}
	
	// Put in drawing surface/console
	/*public boolean checkIfSelec() {
		
		
		return false;
		
	}*/
	
	public void buyFood(Food f, Pet p) {
		double m = p.getMoney();
		
		p.setMoney(m - f.getPrice());
		
		f.feedPet(p);
		
	}
	
	public void buyToys(Toys t, Pet p) {
		double m = p.getMoney();
		
		p.setMoney(m - t.getPrice());
		
		p.setToys(t);
	}

	public void vetVisit(Pet p) {
		double m = p.getMoney();
		p.setHealth(10);
		p.setMoney(m -= 20);
		

		System.out.println("Went to the vet");
	}
	
	public Toys[] getDogToys() {
		return dog;
	}
	
	public Toys[] getFishToys() {
		return fish; 
	}
	
	public Toys[] getCatToys() {
		return cat;
	}
	
	public Food[] getDogFood() {
		return d;
	}
	
	public Food[] getCatFood() {
		return ca;
	}
	
	public Food[] getFishFood() {
		return fi;
	}
	
	

}
