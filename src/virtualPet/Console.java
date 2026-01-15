package virtualPet;
import pets.Pet;

import java.util.Scanner;

public class Console {
	Pet userPet;
	Scanner scan;
	
	public Console () {
		scan = new Scanner(System.in);
		
		System.out.print("What type of pet would you like? Type cat, dog, or fish: ");
		String type = scan.nextLine();
		
		System.out.print("What would you like to name your pet?");
		String name = scan.nextLine();
		
		userPet = new Pet(name,type);

	}
	
	public void store() {
		
	}

}
