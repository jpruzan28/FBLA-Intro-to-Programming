package properties;

import pets.Pet;

public class Emotion {
	
	Pet pet;

	public Emotion(Pet pet) {
		this.pet = pet;
	}
	
	public void calculatingEmotion() {
		int currentEmotion = pet.getEmotion();
		int health = pet.getHealth();
		int hunger = pet.getHunger();
		int rest = pet.getRest();
		int hygiene = pet.getHygiene();
		
		if((health <= 3) || (hunger <= 3) || (rest <= 3) || (hygiene <= 3)) {
			pet.setEmotion(3);
		}
		else if((health >= 7) && (hunger >= 7) && (rest >= 7) && (hygiene >= 7)) {
			pet.setEmotion(currentEmotion + 7);
			
			
		}
	}
}
