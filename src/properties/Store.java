package properties;
import javax.swing.JOptionPane;

import DrawingSurface.DrawingSurface;
import pets.Pet;

public class Store {

	private Food[] dogFood;  
	private Food[] fishFood;
	private Food[] catFood;
	
	
	private Toy[] dogToys;
	private Toy[] fishToys;
	private Toy[] catToys;
	
	

	public Store() {
		
		// Food Arrays
		dogFood = new Food[] {new Food("Kibble Crunch", "Dog", 10.00, 1), new Food("Salmon Delight", "Dog", 50.00, 2),
				new Food("Gold Nuggets", "Dog", 100.00, 3)};
		
		fishFood = new Food[] {new Food("Flakes", "Fish", 10.00, 1), new Food("Algae Crisps", "Fish", 20.00, 2),
				 new Food("Abyss Infusion", "Fish", 100.00, 3)};
		
		catFood = new Food[] {new Food("Fish Kibble", "Cat", 10.00, 1),
				new Food("Turkey Treats", "Cat", 50.00, 2), new Food("A Golden Rat", "Cat", 100.00, 3)};
		
		
		// Toy Arrays
		dogToys = new Toy[] {new Toy("Used Ball", "Dog", 4.00, 1, "Images/Toy_Icons/used_ball.png"), new Toy("Chew Wand", "Dog", 25.00, 2, "Images/Toy_Icons/enchanted_wand.png"),
				new Toy("Gold Bone", "Dog", 90.00, 3, "Images/Toy_Icons/golden_bone.png")};
		
		fishToys = new Toy[] {new Toy("Drift Ball", "Fish", 4.00, 1, "Images/Toy_Icons/drift_ball.png"), new Toy("Bubble Maker", "Fish", 25.00, 2, "Images/Toy_Icons/bubble_machine.png"),
				new Toy("Super Speaker", "Fish", 90.00, 3, "Images/Toy_Icons/plat_speaker.png")};
		
		catToys = new Toy[] {new Toy("Plain Sock", "Cat", 4.00, 1, "Images/Toy_Icons/plain_sock.png"), new Toy("Laser Pointer", "Cat", 50.00, 2, "Images/Toy_Icons/laser_pointer.png"), 
				new Toy("Rad Airpods", "Cat", 90.00, 3, "Images/Toy_Icons/earbud.png")};

	}
	
	
	public void buyFood(Food f, Pet p) {
		double m = p.getMoney();
		
		if(m < f.getPrice()) {
			DrawingSurface.errorMessage("Too expensive");
		}
		
		else {
			p.setMoney(m - f.getPrice());
			p.addExpenses(f.getPrice());
			p.addFood(f);
			f.feedPet(p);
			
			JOptionPane.showMessageDialog(
		            null, 
		           "You Bought "  + f.getName(), 
		            "Congrats", 
		            JOptionPane.INFORMATION_MESSAGE
		        );
		}
	}
	
	public void buyToys(Toy t, Pet p) {
		double m = p.getMoney();
		
		if(m < t.getPrice()) {
			DrawingSurface.errorMessage("Too expensive");
		}
		
		else {
			p.setMoney(m - t.getPrice());	
			p.addExpenses(t.getPrice()); 
			p.setToys(t);
			
			JOptionPane.showMessageDialog(
		            null, 
		           "You Bought "  + t.getName(), 
		            "Congrats", 
		            JOptionPane.INFORMATION_MESSAGE
		        );
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
			p.addVetVisit();

			return true;
		}
	}
	
	
	// Getters
	public Toy[] getDogToys() {
		return dogToys;
	}
	
	public Toy[] getFishToys() {
		return fishToys; 
	}
	
	public Toy[] getCatToys() {
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
