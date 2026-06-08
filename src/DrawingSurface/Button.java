package DrawingSurface;
import properties.*;
import pets.Pet;
import javax.swing.*;


public class Button{
	private String buttonPressed;
	
	private Activities activity;
	private Pet pet;
	
	public Button(Pet pet, String buttonPressed) {
      
		this.buttonPressed = buttonPressed;
        this.pet = pet;
        if (this.pet == null) {
        	System.out.println("Pet is null");
        }
        
        this.activity = new Activities(pet);

	}
		
	public void actionPerformed() {	
	
		Store stores = new Store();

		if(buttonPressed.equals("Sleep")) {
			String sleepAmount = "";
			
			while(!(sleepAmount.equals("1")) && !(sleepAmount.equals("2")) && !(sleepAmount.equals("5"))) {
				sleepAmount = JOptionPane.showInputDialog("How many hours would you like your pet to sleep? 1, 2, or 5? ");

				if(!(sleepAmount.equals("1")) && !(sleepAmount.equals("2")) && !(sleepAmount.equals("5"))) {
				    JOptionPane.showMessageDialog(null, "Sorry that is not a valid option. Make sure to enter a number, not word.");

				}
			}
		    activity.sleep(sleepAmount);
		    JOptionPane.showMessageDialog(null, pet.getName() + " is sleeping deeply. ZZZ");


		}
		else if(buttonPressed.equals("Clean")) {
			activity.clean();
		    JOptionPane.showMessageDialog(null, pet.getName() + " is squeaky clean!");

		}
		else if(buttonPressed.equals("Vet")) {
		
			if(stores.vetVisit(pet)) {
	
			    JOptionPane.showMessageDialog(null, pet.getName() + " feels much healthier!");

			}
		}
		else if(buttonPressed.equals("Play")) {
			String ownedToys = pet.getToysStr();
			Toy chosenToy = null;
			
			if(ownedToys.equals("")) {
				JOptionPane.showMessageDialog(null, "Sorry, you don't own any toys. Go to the store to buy some!");
			}
			else {
				String chosenToyName = JOptionPane.showInputDialog("Which toy would you like to play with: " + ownedToys + "?");
				for(int i = 0; i < pet.getToysArr().length; i++) {
					if(pet.getToysArr()[i] == null) {
					}
					else if (chosenToyName.equals((pet.getToysArr()[i]).getName())) {
						chosenToy = pet.getToysArr()[i];
					}
				}
				
				activity.play(chosenToy);
				
				JOptionPane.showMessageDialog(null, pet.getName() + " is happy playing with " + chosenToy.getName() + "!");
			}
			
		}

		
	}
}
