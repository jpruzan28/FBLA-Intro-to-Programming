package DrawingSurface;
import VirtualPet.main;

import pets.Pet;
import properties.*;
import java.util.TimerTask;

public class ReductionTimer{
	
	Pet pet;
	Emotion emotionC;
	private main mainWindow;
	private int ogHunger;
	private int ogHealth;
	private int ogEmotion;
	private int ogRest;

	int ogHygiene;
	
	public ReductionTimer(Pet pet, main mainWindow) {
		this.pet = pet;
		this.mainWindow = mainWindow;
		
		emotionC = new Emotion(pet);
		
		ogHunger = pet.getHunger();
		ogHealth = pet.getHealth();
		ogEmotion = pet.getEmotion();
		ogHygiene = pet.getHygiene();
		ogRest = pet.getRest();
	}
		

	 public class reduceHunger extends TimerTask { 
		 @Override
		public void run() {
			 if (ogHunger>=0) {
			pet.setHunger(ogHunger--);
			System.out.println(ogHunger);
			
			 }
		}
	}
	 

	 public class reduceHygiene extends TimerTask { 
		 @Override
		public void run() {
			if(ogHygiene>=0) {
				pet.setHygiene(ogHygiene--);
			
			}
			if(pet.getHygiene()<=0) {
				mainWindow.gameOver();
				}
			
		 }
		 
	 }
	 
	 public class reduceEmotion extends TimerTask { 
		 @Override
		public void run() {
			 if (ogEmotion>=0) {
				 pet.setEmotion(ogEmotion--);
			 }
			 
			 if(pet.getEmotion()<=0) {
				 mainWindow.gameOver();
			 }
			 
			 emotionC.calculatingEmotion();
		}
	 }	

		public class reduceRest extends TimerTask {
			@Override
			public void run() {
				if (ogRest >= 0) {
					pet.setRest(ogRest--);
				}
				if(pet.getRest() <= 0) {
					mainWindow.gameOver();
				}
			}
		}
		
		public class salary extends TimerTask {
			@Override
			public void run() {
				pet.setMoney(pet.getMoney()+10);
				mainWindow.updateMoneyDisplay();
			}
		}
		
		public class bonus extends TimerTask {
			@Override
			public void run() {
				if(pet.getHealth() == 10) {
					pet.setMoney(pet.getMoney()+5);
				}
				
				if(pet.getEmotion() == 10) {
					pet.setMoney(pet.getMoney()+5);
				}
				mainWindow.updateMoneyDisplay();
			}
		}
		
		public class updateHealth extends TimerTask {
			@Override
			public void run() {
				Health petHealth = new Health(pet);
				
				petHealth.addHungerToHealth(pet.getHunger());
				petHealth.addRestToHealth(pet.getRest());
				petHealth.addHygieneToHealth(pet.getHygiene());
				
				petHealth.remindVetVisit();
				
				if(pet.getHealth()<=0) {
					mainWindow.gameOver();
				}
			}
		}
}

