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
		else if(amount == 5) {
			pet.setRest(currentRest + 8);
		}
	}
	
	public void play(String toy) {
		// Low energy = $0-19
		// Mid energy = $20-35
		// High energy = $36-120
		
		// Add type distinction
		
		String[] lowEnergy = null;
		String[] midEnergy = null;
		String[] highEnergy = null;
		
		int energy = 0;
		
		for(String t: lowEnergy) {
			if(toy.equals(t)) {
				energy = 3;
			}
		}
		
		if(energy != 3) {
			for(String t: midEnergy) {
				if(toy.equals(t)) {
					energy = 5;
				}
			}
		}
		else if(energy != 3 && energy != 5) {
			for(String t: highEnergy) {
				if(toy.equals(t)) {
					energy = 8;
				}
			}
		}
		
		pet.setEmotion(pet.getEmotion()+energy);
		pet.setRest(pet.getRest()-energy);
	}
	
	public void clean() {
		pet.setHygiene(10);
	}
	
	
	
}
