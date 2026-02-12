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
		int hungerFactor;
		int emotionFactor;
		// Emotion and hygiene ++
		int hygieneFactor;
		int restFactor;
		
		if(pet.getType().equals(toy.getType())) {
			
			if(version == 1) {
				hungerFactor = 3;
				restFactor = 3;
				emotionFactor = 4;
				hygieneFactor = 2;
			}
			else if(version == 2) {
				hungerFactor = 5;
				restFactor = 5;
				emotionFactor = 6;
				hygieneFactor = 4;
			}
			else if(version == 3){
				hungerFactor = 7;
				restFactor = 7;
				emotionFactor = 8;
				hygieneFactor = 6;
			}
			else {
				hungerFactor = 8;
				restFactor = 9;
				emotionFactor = 8;
				hygieneFactor = 8;
			}
		}
		
		else {
			if(version == 1) {
				hungerFactor = 2;
				restFactor = 2;
				emotionFactor = 3;
				hygieneFactor = 1;
			}
			else if(version == 2) {
				hungerFactor = 3;
				restFactor = 3;
				emotionFactor = 4;
				hygieneFactor = 2;

			}
			else if(version == 3){
				hungerFactor = 4;
				restFactor = 4;
				emotionFactor = 5;
				hygieneFactor = 3;
			}
			else {
				hungerFactor = 4;
				restFactor = 4;
				emotionFactor = 5;
				hygieneFactor = 4;
			}
		}
		
		pet.setEmotion(currentEmotion + emotionFactor);
		pet.setHunger(currentHunger - hungerFactor);
		pet.setRest(currentRest - restFactor);
		pet.setHygiene(currentHygiene - hygieneFactor);
		
		
	}
	
	public void clean() {
		pet.setHygiene(10);

		System.out.println("Squeaky clean :)");
	}
	

}
