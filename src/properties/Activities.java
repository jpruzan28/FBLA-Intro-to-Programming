package properties;

import pets.Pet;

public class Activities {
	Pet pet;
	
	public Activities(Pet pet) {
		this.pet = pet;
	}
	
	public void sleep(String amount) {
		int currentRest = pet.getRest();
		if(amount.equals("  1  ")) {
			pet.setRest(currentRest + 3);
		}
		else if(amount.equals("  2  ")) {
			pet.setRest(currentRest + 5);

		}
		else if(amount.equals("  5  ")) {
			pet.setRest(currentRest + 8);

		}
	}
	
	public void play(Toy toy) {
		
		int version = toy.getVersion();
		int currentEmotion = pet.getEmotion();
		int currentNutrition = pet.getNutrition();
		int currentRest = pet.getRest();
		int currentHygiene = pet.getHygiene();
		
		// Nutrition and rest --
		int nutritionFactor;
		int emotionFactor;
		// Emotion and hygiene ++
		int hygieneFactor;
		int restFactor;
		
		if(pet.getType().equals(toy.getType())) {
			
			if(version == 1) {
				nutritionFactor = 3;
				restFactor = 3;
				emotionFactor = 4;
				hygieneFactor = 2;
			}
			else if(version == 2) {
				nutritionFactor = 5;
				restFactor = 5;
				emotionFactor = 6;
				hygieneFactor = 4;
			}
			else if(version == 3){
				nutritionFactor = 7;
				restFactor = 7;
				emotionFactor = 8;
				hygieneFactor = 6;
			}
			else {
				nutritionFactor = 8;
				restFactor = 9;
				emotionFactor = 8;
				hygieneFactor = 8;
			}
		}
		
		else {
			if(version == 1) {
				nutritionFactor = 2;
				restFactor = 2;
				emotionFactor = 3;
				hygieneFactor = 1;
			}
			else if(version == 2) {
				nutritionFactor = 3;
				restFactor = 3;
				emotionFactor = 4;
				hygieneFactor = 2;

			}
			else if(version == 3){
				nutritionFactor = 4;
				restFactor = 4;
				emotionFactor = 5;
				hygieneFactor = 3;
			}
			else {
				nutritionFactor = 4;
				restFactor = 4;
				emotionFactor = 5;
				hygieneFactor = 4;
			}
		}
		
		pet.setEmotion(currentEmotion + emotionFactor);
		pet.setNutrition(currentNutrition - nutritionFactor);
		pet.setRest(currentRest - restFactor);
		pet.setHygiene(currentHygiene - hygieneFactor);
		
		
	}
	
	public void clean() {
		pet.setHygiene(10);

	}
	

}
