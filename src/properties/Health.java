
package properties;
import javax.swing.JOptionPane;

import pets.Pet;

public class Health {
	// Fields
	private Pet pet;

	// Constructors
	public Health(Pet pet) {
		this.pet = pet;
	}

	// Methods
	

	// Affect emotion when health goes down
	public void addHungerToHealth(int totalHunger) {
		int totalHealth = pet.getHealth();

		int newHealth;
		if (totalHealth <= 2) {
			newHealth = totalHealth;
        } 
		else {
			if(totalHunger == 0) {
				newHealth = totalHealth - 5;
			}
			else if (totalHunger <= 2) {
				newHealth = totalHealth - 3;
			}
			else if (totalHunger <= 4) {
				newHealth = totalHealth - 2;
			} 
			else {
				newHealth = totalHealth + 2;
			}
			
		}
		
		pet.setHealth(newHealth);
	}

	public void addRestToHealth(int totalRest) {
		int totalHealth = pet.getHealth();
		int newHealth;

		if (totalHealth <= 2) {
			newHealth = totalHealth;
		} else {
			if(totalRest == 0) {
				newHealth = totalHealth - 5;
			}
			else if (totalRest <= 4) {
				newHealth = totalHealth - 1;
			} 
			else if(totalRest <= 7) {
				newHealth = totalHealth + 2;
			}
			else {
				newHealth = totalHealth + 3;
			}
		}
		
		pet.setHealth(newHealth);

	}


	public void addHygieneToHealth(int totalHygiene) { 
		int totalHealth = pet.getHealth();
		int newHealth;

		if (totalHealth <= 2) { //if that's true, the user can only improve health by going to vet
			newHealth = totalHealth;
		} else {
			if(totalHygiene == 0) {
				newHealth = totalHealth - 5;
			}
			else if (totalHygiene <= 4) {
				newHealth = totalHealth - 1;
			} else {
				newHealth = totalHealth + 2;
			}
		}
	}
	

	
	public void remindVetVisit() { //maybe put this in future time class, checks every time health is changed
		int totalHealth = pet.getHealth();

		if (totalHealth <= 2) {
		    JOptionPane.showMessageDialog(null, "URGENT! You need to take your pet to the vet immediatley");
		}
	}
	

}
