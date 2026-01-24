package virtualPet;
import pets.Pet;
import properties.*;

import java.util.Scanner;

public class Console {
	Pet userPet;
	Scanner scan;
	Money money;
	
	Activities activity;
	//ELLIE: we should probably have a loop for console that's always asking what action
	// the user wants to make and then does the change, so it's like pressing a button
	// but you're writing the action you want to do
	public Console () {
		money = new Money();
		scan = new Scanner(System.in);
		
		
		System.out.print("What type of pet would you like? Type cat, dog, or fish: ");
		String type = scan.nextLine();
		
		System.out.print("What would you like to name your pet?");
		String name = scan.nextLine();
		
		userPet = new Pet(name,type);
		activity = new Activities(userPet);

		
		// Repeats in a loop in order for action options to continue popping up
		System.out.println("Age: 0 \nHealth: 10 \nHunger: 10 \nEmotion: 10 \nRest: 10 \n");
		System.out.println("What would you like to do? ");
		System.out.print("Feed(1), Sleep(2), Play(3), Vet visit(4), Clean(5) Buy a toy(6)");
		
		int action = scan.nextInt();
		
		if (action == 1) {
			Food theFood;
			int version;
			
			String foodChoice;
			String fType;
			
			System.out.println("Cat food: " + money.getCFood());
			System.out.println("Dog food: " + money.getDFood());
			System.out.println("Fish food: " + money.getFFood());
			
			System.out.print("Which food would you like to buy? ");
			foodChoice = scan.nextLine();
			
			version = foodChoice.charAt((foodChoice.length())-1);
			
			
			if(foodChoice.charAt(0) == 'c') {
				theFood = new Food(version,"cat");
			}
			else if(foodChoice.charAt(0) == 'd') {
				theFood = new Food(version,"dog");
			}
			else if(foodChoice.charAt(0) == 'f') {
				theFood = new Food(version,"fish");
			}
			else {
				theFood = null;
			}
			
			theFood.feedPet(userPet);

		}
		else if(action == 2) {
			Activities act = new Activities(userPet);
			
			System.out.println("How much would you like your pet to sleep? 1, 2, or 5 hours: ");
			int sleepAmount = scan.nextInt(); 
			
			act.sleep(sleepAmount);
		}
		else if(action == 3) {
			System.out.print("What toy would you like to play with? " + userPet.getToys() + ": ");
			String toy = scan.nextLine();
			
			activity.play(toy);
		}
		else if(action == 4) {
			// Money add vetVisit();
		}		
		else if(action == 5) {
			activity.clean();
		}
		else if(action == 6) {
			// Money add buyToy();
		}

	}
	
	
	public void store() {
		
	}

}
