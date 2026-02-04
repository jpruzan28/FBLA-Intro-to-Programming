package DrawingSurface;

import pets.Pet;
import java.util.TimerTask;

public class ReductionTimer extends TimerTask{
	
	Pet pet;
	int ogHunger;
	int ogHealth;
	int ogEmotion;
	int ogRest;
	int ogHygiene;
	
	public ReductionTimer(Pet pet) {
		this.pet = pet;
		ogHunger = pet.getHunger();
		ogHealth = pet.getHealth();
		ogEmotion = pet.getEmotion();
		ogRest = pet.getRest();
		ogHygiene = pet.getHygiene();
		
		pet.setHunger(ogHunger--);
		
	} public void reduceHunger() {
		
	}
}
