package DrawingSurface;
import VirtualPet.main;

import pets.Pet;
import java.util.TimerTask;

public class ReductionTimer{
	
	Pet pet;
	private main mainWindow;
	private int ogHunger;
	private int ogHealth;
	private int ogEmotion;
	private int ogRest;
	int ogHygiene;
	
	public ReductionTimer(Pet pet, main mainWindow) {
		this.pet = pet;
		ogHunger = pet.getHunger();
		ogHealth = pet.getHealth();
		ogEmotion = pet.getEmotion();
		ogRest = pet.getRest();
		ogHygiene = pet.getHygiene();
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
	 
	 public class reduceHealth extends TimerTask { 
		 @Override
		public void run() {
			 if (ogHealth>=0) {
			pet.setHealth(ogHealth--);
			 }
		}
		}
	 public class reduceHygiene extends TimerTask { 
		 @Override
		public void run() {
			 if (ogHygiene>=0) {
			pet.setHealth(ogHygiene--);
			 }
		}
		}
	 public class reduceEmotion extends TimerTask { 
		 @Override
		public void run() {
			 if (ogEmotion>=0) {
			pet.setHealth(ogEmotion--);
			 }
		}
		}	

		public class reduceRest extends TimerTask {
			@Override
			public void run() {
				if (ogHunger >= 0) {
					pet.setHealth(ogEmotion--);
				}
			}
		}
		
		public class salary extends TimerTask {
			@Override
			public void run() {
				pet.setMoney(pet.getMoney()+20);
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
	}

