package properties;

import pets.Pet;

public class Activities {
	Pet pet;
	
	public Activities(Pet pet) {
		this.pet = pet;
	}
	
	public void sleep(int amount) {
		int currentRest = pet.getRest();
		if(amount == 1) {
			pet.setRest(currentRest + 3);
		}
		else if(amount == 2) {
			pet.setRest(currentRest + 5);
		}
		if(amount == 5) {
			pet.setRest(currentRest + 8);
		}
	}
	
	public void play() {
		
	}
	
	public void clean() {
		
	}
	
	
	
	// Clean or dirty or smth

}
