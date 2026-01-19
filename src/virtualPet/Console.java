package virtualPet;
import pets.Pet;

import java.util.Scanner;

public class Console {
	Pet userPet;
	Scanner scan;
	//ELLIE: we should probably have a loop for console that's always asking what action
	// the user wants to make and then does the change, so it's like pressing a button
	// but you're writing the action you want to do
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
