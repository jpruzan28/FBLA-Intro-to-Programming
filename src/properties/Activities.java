package properties;

import pets.Pet;

public class Activities {
	Pet pet;
	
	public Activities(Pet pet) {
		this.pet = pet;
	}
	
	public void sleep(String amount) {
		int currentRest = pet.getRest();
		if(amount.equals("1")) {
			pet.setRest(currentRest + 3);
			System.out.println("Slept for 3");
		}
		else if(amount.equals("2")) {
			pet.setRest(currentRest + 5);

			System.out.println("Slept for 5");
		}
		else if(amount.equals("5")) {
			pet.setRest(currentRest + 8);

			System.out.println("Slept for 8");
		}
	}
	
	public void play(Toys toy) {
		
		int version = toy.getVersion();
		int currentEmotion = pet.getEmotion();
		int currentHunger = pet.getHunger();
		int currentRest = pet.getRest();
		int currentHygiene = pet.getHygiene();
		
		// Hunger and rest --
		int hrFactor;
		// Emotion and hygiene ++
		int ehFactor;
		
		if(pet.getType().equals(toy.getType())) {
			
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
		
		pet.setEmotion(currentEmotion + ehFactor);
		pet.setHunger(currentHunger - hrFactor);
		pet.setRest(currentRest - hrFactor);
		pet.setHygiene(currentHygiene - ehFactor);
		
		
	}
	
	public void clean() {
		pet.setHygiene(10);

		System.out.println("Squeaky clean :)");
	}
	

}
