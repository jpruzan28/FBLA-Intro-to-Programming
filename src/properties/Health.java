
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
		 if (totalHunger == 0) {
	            newHealth = totalHealth - 4;
	        } else if (totalHunger <= 3) {
	            newHealth = totalHealth - 3;
	        } else if (totalHunger <= 8) { //is only high if greater or equal to 6
	            newHealth = totalHealth - 1;
	        } else {
	            newHealth = totalHealth + 1;
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
	        if (totalRest == 0) {
	            newHealth = totalHealth - 4;
	        } else if (totalRest <= 3) {
	            newHealth = totalHealth - 2;
	        } else if (totalRest <= 7) {
	            newHealth = totalHealth - 1;
	        } else {
	            newHealth = totalHealth + 1; 
	        }
	    }
	    pet.setHealth(newHealth);
	}


	public void addHygieneToHealth(int totalHygiene) {
	    int totalHealth = pet.getHealth();
	    int newHealth;

	    if (totalHealth <= 2) {
	        newHealth = totalHealth;
	    } else {
	        if (totalHygiene == 0) {
	            newHealth = totalHealth - 4;
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
	
	public void remindVetVisit() { //maybe put this in future time class, checks every time health is changed
		int totalHealth = pet.getHealth();

		if (totalHealth <= 2) {
		    JOptionPane.showMessageDialog(null, "URGENT! You need to take your pet to the vet immediatley");
		}
	}
	

}
