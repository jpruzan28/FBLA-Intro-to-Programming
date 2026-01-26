/* System:1. hunger, rest, play, clean, vet visits affects health, 
*         2. hunger, rest, play, clean, health affects emotion
*         3. emotion affects final look/reaction (the pet's facial expressions) 
**/
package properties;
import pets.Pet;

public class Health {
	// Fields
	private int totalHealth;
	private Pet pet;

	// Constructors
	public Health(Pet pet) {
		this.pet = pet;
		// Out of 10 because 5 factors, each one adds 1 health if 1-4 and adds 2 health
		// if 5-10.
		totalHealth = pet.getHealth();

	}

	// Methods
	/*
	 * What I'm trying to do is for example first make a addHunger(int nutrients)
	 * method in the Pet class which adds the certain amount of nutrients the user
	 * chooses from the food class to a totalHunger integer (it's just called hunger
	 * in the Pet class). Then, we take that totalHunger integer and put it in this
	 * method, which will add to totalHealth!
	 */

	// Affect emotion when health goes down
	public void addHungerToHealth(int totalHunger) {
		if (totalHealth <= 2) {
		} else {
			if (totalHunger <= 4) {
				totalHealth += 1;
			} else {
				totalHealth += 2;
			}
		}
	}

	public void addRestToHealth(int totalRest) {
		if (totalHealth <= 2) {
		} else {
			if (totalRest <= 4) {
				totalHealth += 1;
			} else {
				totalHealth += 2;
			}
		}
	}

	public void addPlayToHealth(int totalPlay) {
		if (totalHealth <= 2) {
		} else {
			if (totalPlay <= 4) {
				totalHealth += 1;
			} else {
				totalHealth += 2;
			}
		}
	}

	public void addCleanToHealth(int totalHygiene) { 
		if (totalHealth <= 2) { //if that's true, the user can only improve health by going to vet
		} else {
			if (totalHygiene <= 4) {
				totalHealth += 1;
			} else {
				totalHealth += 2;
			}
		}
	}

	
	public void remindVetVisit() { //maybe put this in future time class, checks every time health is changed
		if (totalHealth <= 2) {
			System.out.println("URGENT: You need to bring your pet to the vet!");
		}
	}
	

	/* vet visits reminder when: 
	 * 1) have them whenever the health bar
	 * is really low, like at 1 or 2, and then the user NEEDS to bring it to the vet
	 * or else nothing the user does can make its health go up, which is like when a
	 * pet is under a bad condition over time it gets irreversible damage and needs 
	 * actual treatment. 
	 * 2) have them at set times throughout the game, because they can act like regular
	 * check ups. (We can also have like set times throughout the game when the pet
	 * catches a disease, but that's maybe for future stuff) ALSO: the user gets to
	 * CHOOSE if their pet goes to the vet, if they choose not to, the pet dies or
	 * smth
	 */

	public void updateHealth(Pet p) {
		p.setHealth(totalHealth);
	}
	
}


// Vet visit action is in Money class and will call a method in this class.

