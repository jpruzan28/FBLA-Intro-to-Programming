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
	
	public void play(Toys toy, Pet p) {
		
		int version = toy.getVersion();
		int currentEmotion = p.getEmotion();
		int currentHunger = p.getHunger();
		int currentRest = p.getRest();
		int currentHygiene = p.getHygiene();
		
		// Hunger and rest --
		int hrFactor;
		// Emotion and hygiene ++
		int ehFactor;
		
		if(p.getType().equals(toy.getType())) {
			
			if(version == 1) {
				hrFactor = 3;
				ehFactor = 2;
			}
			else if(version == 2) {
				hrFactor = 5;
				ehFactor = 4;
			}
			else if(version == 3){
				hrFactor = 7;
				ehFactor = 6;
			}
			else {
				hrFactor = 8;
				ehFactor = 8;
			}
		}
		
		else {
			if(version == 1) {
				hrFactor = 2;
				ehFactor = 1;
			}
			else if(version == 2) {
				hrFactor = 3;
				ehFactor = 2;
			}
			else if(version == 3){
				hrFactor = 4;
				ehFactor = 3;
			}
			else {
				hrFactor = 4;
				ehFactor = 4;
			}
		}
		
		p.setEmotion(currentEmotion + ehFactor);
		p.setHunger(currentHunger - hrFactor);
		p.setRest(currentRest - hrFactor);
		p.setHygiene(currentHygiene + ehFactor);
		
		
	}
	
	public void clean() {
		pet.setHygiene(10);
	}
	

}
