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
	
	private Pet pet;
	private String petType;
	
	private Image cat1, cat2, cat3, dog1, dog2, dog3, fish1, fish2, fish3;
	private Image happyCat, unhappyCat, neutralCat;
	private Image happyDog, unhappyDog, neutralDog;
	private Image happyFish, unhappyFish, neutralFish;
	
	public Sprite(Pet pet) {
		
		this.pet = pet;
		petType = pet.getType();
		
		cat3 = (new ImageIcon("cat.unhappy.jpg")).getImage();
		cat2 = (new ImageIcon("cat.happy.jpg")).getImage();
		cat1 = (new ImageIcon("cat.neutral.jpg")).getImage();
		dog3 = (new ImageIcon("dog.unhappy.jpg")).getImage();
		dog2 = (new ImageIcon("dog.happy.jpg")).getImage();
		dog1 = (new ImageIcon("dog.neutral.jpg")).getImage();
		fish3 = (new ImageIcon("fish.unhappy.jpg")).getImage();
		fish2 = (new ImageIcon("dog.happy.jpg")).getImage();
		fish1 = (new ImageIcon("dog.neutral.jpg")).getImage();
		
		neutralCat = cat1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		happyCat = cat2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		unhappyCat = cat3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		neutralDog = dog1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		happyDog = dog2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		unhappyDog = dog3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		neutralFish = fish1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		happyFish = fish2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		unhappyFish = fish3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	}
	
	
	 public void paintComponent(Graphics g)
	  {

//	    super.paintComponent(g); good for something idk
//if statements here
		 if (petType.equalsIgnoreCase("cat")) {
		 g.drawImage(neutralCat, 0, 0, null);
		 }
		 else if (petType.equalsIgnoreCase("dog")) {
		 g.drawImage(neutralDog, 0, 0, null);
		 }
		 else if (petType.equalsIgnoreCase("fish")) {
		 g.drawImage(neutralFish, 0, 0, null);
		 }
	  }
}
