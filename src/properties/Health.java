
package properties;
import javax.swing.JOptionPane;

import pets.Pet;


/** Blueprint for monitoring and handling all health related functions 
 * 
 * @author Ellie Lo, Jasmine Pruzan, Ishaan Bhalerao
 * @version 6/26/26
 */
public class Health {
	// Fields
	private Pet pet;

	// Constructors
	public Health(Pet pet) {
		this.pet = pet;
	}

	// Methods
	

	/**
	 * 
	 * method demonstrating how other status bars affect the health
	 * 
	 * @param totalHunger is the pet's current hunger level
	 */
	public void addNutritionToHealth(int totalHunger) {
		int totalHealth = pet.getHealth();

		int newHealth;
		if (totalHealth <= 2) {
			newHealth = totalHealth;
        } 
		else {
		 if (totalHunger == 0) {
	            newHealth = totalHealth - 3;
	        } else if (totalHunger <= 3) {
	            newHealth = totalHealth - 2;
	        } else if (totalHunger <= 7) { 
	            newHealth = totalHealth - 1;
	        } else {
	            newHealth = totalHealth + 1;
	        }
	    }
	    pet.setHealth(newHealth);
	}
	


	/**
	 * 
	 * method to change health status based on rest
	 * @param totalRest
	 */
	public void addRestToHealth(int totalRest) {
	    int totalHealth = pet.getHealth();
	    int newHealth;

	    if (totalHealth <= 2) {
	        newHealth = totalHealth;
	    } else {
	        if (totalRest == 0) {
	            newHealth = totalHealth - 3;
	        } else if (totalRest <= 3) {
	            newHealth = totalHealth - 2;
	        } else if (totalRest <= 6) {
	            newHealth = totalHealth - 1;
	        } else {
	            newHealth = totalHealth + 1; 
	        }
	    }
	    pet.setHealth(newHealth);
	}


	
	
	/**
	 * 
	 * method to change health status based on hygiene
	 * @param totalHygiene
	 */
	public void addHygieneToHealth(int totalHygiene) {
	    int totalHealth = pet.getHealth();
	    int newHealth;

	    if (totalHealth <= 2) {
	        newHealth = totalHealth;
	    } else {
	        if (totalHygiene == 0) {
	            newHealth = totalHealth - 3;
	        } else if (totalHygiene <= 3) {
	            newHealth = totalHealth - 2;
	        } else if (totalHygiene <= 6) {
	            newHealth = totalHealth - 1; 
	        } else {
	            newHealth = totalHealth + 1;
	        }
	    }
	    pet.setHealth(newHealth); 
	}
	
	
	/**
	 * 
	 * remind's the user to visit vet if pet is too low
	 * 
	 */
	public void remindVetVisit() { 
		int totalHealth = pet.getHealth();

		if (pet.getActive() && totalHealth <= 2 && totalHealth != 0) {
		    JOptionPane.showMessageDialog(null, "URGENT! You need to take your pet to the vet immediatley");
		}
	}
	
}
