package DrawingSurface;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pets.Pet;

import javax.swing.ImageIcon;

public class Sprite extends JPanel{
	
	Pet pet;
	String petType;
	
	int emotion;
	
	private Image cat1, cat2, cat3, dog1, dog2, dog3, fish1, fish2, fish3;
	private Image happyCat, unhappyCat, neutralCat;
	private Image happyDog, unhappyDog, neutralDog;
	private Image happyFish, unhappyFish, neutralFish;
	
	public Sprite(Pet pet) {
		
		this.pet = pet;
		petType = pet.getType();
		
		emotion = pet.getEmotion();
		
		cat3 = (new ImageIcon("cat.unhappy.jpg")).getImage();
		cat2 = (new ImageIcon("cat.happy.jpg")).getImage();
		cat1 = (new ImageIcon("cat.neutral.jpg")).getImage();
		dog3 = (new ImageIcon("dog.unhappy.jpg")).getImage();
		dog2 = (new ImageIcon("dog.happy.jpg")).getImage();
		dog1 = (new ImageIcon("dog.neutral.jpg")).getImage();
		fish3 = (new ImageIcon("fish.unhappy.jpg")).getImage();
		fish2 = (new ImageIcon("fish.happy.jpg")).getImage();
		fish1 = (new ImageIcon("fish.neutral.jpg")).getImage();
		
		neutralCat = cat1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		happyCat = cat2.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		unhappyCat = cat3.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		neutralDog = dog1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		happyDog = dog2.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		unhappyDog = dog3.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		neutralFish = fish1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		happyFish = fish2.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		unhappyFish = fish3.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
	}
	
	
	 public void paintComponent(Graphics g)
	  {

			super.paintComponent(g);
		 
//if statements here
		 if (petType.equalsIgnoreCase("cat")) {
			 if(emotion >= 7) {
				 g.drawImage(happyCat, 0, 0, null);
				 System.out.println(emotion);
			 }
			 else if(emotion <= 3) {
				 g.drawImage(unhappyCat, 0, 0, null);
				 System.out.println(emotion);
			 }
			 else {
				 g.drawImage(neutralCat, 0, 0, null);
				 System.out.println(emotion);
			 }
			 else if(emotion <= 3) {
				 g.drawImage(unhappyCat, 0, 0, null);
				 System.out.println(emotion);
			 }
			 else {
				 g.drawImage(neutralCat, 0, 0, null);
				 System.out.println(emotion);
			 }
		 }
		 else if (petType.equalsIgnoreCase("dog")) {
			 if(emotion >= 7) {
				 g.drawImage(happyDog, 0, 0, null);
				 System.out.println(emotion);
			 }
			 else if(emotion <= 3) {
				 g.drawImage(unhappyDog, 0, 0, null);
			 }
			 else {
				 g.drawImage(neutralDog, 0, 0, null);
			 }		
		 }
		 else if (petType.equalsIgnoreCase("fish")) {
		 
			 if(emotion >= 7) {
				 g.drawImage(happyFish, 0, 0, null);
			 }
			 else if(emotion <= 3) {
				 g.drawImage(unhappyFish, 0, 0, null);
			 }
			 else {
				 g.drawImage(neutralFish, 0, 0, null);
			 }
		 }
	  }
}
