package DrawingSurface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import pets.Pet;

public class Sprite extends JPanel {

    Pet pet;
    String petType;
    int emotion;

    private BufferedImage cat1, cat2, cat3;
    private BufferedImage dog1, dog2, dog3;
    private BufferedImage fish1, fish2, fish3;

    private Image happyCat, unhappyCat, neutralCat;
    private Image happyDog, unhappyDog, neutralDog;
    private Image happyFish, unhappyFish, neutralFish;

    public Sprite(Pet pet) {
        this.pet = pet;
        setOpaque(false); // transparent so background shows through

        try {
            cat1 = ImageIO.read(new File("Images/Pet_Sprites/cat.neutral.png"));
            cat1 = makeTransparent(cat1, Color.WHITE);
            cat2 = ImageIO.read(new File("Images/Pet_Sprites/cat.happy.png"));
            cat2 = makeTransparent(cat2, Color.WHITE);
            cat3 = ImageIO.read(new File("Images/Pet_Sprites/cat.unhappy.png"));
            cat3 = makeTransparent(cat3, Color.WHITE);
            dog1 = ImageIO.read(new File("Images/Pet_Sprites/dog.neutral.png"));
            dog1 = makeTransparent(dog1, Color.WHITE);
            dog2 = ImageIO.read(new File("Images/Pet_Sprites/dog.happy.png"));
            dog2 = makeTransparent(dog2, Color.WHITE);
            dog3 = ImageIO.read(new File("Images/Pet_Sprites/dog.unhappy.png"));
            dog3 = makeTransparent(dog3, Color.WHITE);
            fish1 = ImageIO.read(new File("Images/Pet_Sprites/fish.neutral.png"));
            fish1 = makeTransparent(fish1, Color.WHITE);
            fish2 = ImageIO.read(new File("Images/Pet_Sprites/fish.happy.png"));
            fish2 = makeTransparent(fish2, Color.WHITE);
            fish3 = ImageIO.read(new File("Images/Pet_Sprites/fish.unhappy.png"));
            fish3 = makeTransparent(fish3, Color.WHITE);

            // Scale all images to 500x500
            neutralCat  = cat1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            happyCat    = cat2.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            unhappyCat  = cat3.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            neutralDog  = dog1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            happyDog    = dog2.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            unhappyDog  = dog3.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            neutralFish = fish1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            happyFish   = fish2.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            unhappyFish = fish3.getScaledInstance(500, 500, Image.SCALE_SMOOTH);

        } catch (IOException e) {
            System.out.println("Sprite image not found: " + e.getMessage());
        }
}
    
    public BufferedImage makeTransparent(BufferedImage image, Color bgColor) {
        BufferedImage result = new BufferedImage(
            image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB
        );

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                Color c = new Color(pixel);

                // If pixel matches background color, make it transparent
                if (c.getRed() == bgColor.getRed() &&
                    c.getGreen() == bgColor.getGreen() &&
                    c.getBlue() == bgColor.getBlue()) {
                    result.setRGB(x, y, 0x00000000); // fully transparent
                } else {
                    result.setRGB(x, y, pixel);
                }
            }
        }
        return result;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        petType = pet.getType();
        emotion = pet.getEmotion();

        if (petType.equalsIgnoreCase("cat")) {
            if (emotion >= 8) {
                g.drawImage(happyCat, 0, 0, getWidth(), getHeight(), this);
            } else if (emotion <= 3) {
                g.drawImage(unhappyCat, 0, 0, getWidth(), getHeight(), this);
            } else {
                g.drawImage(neutralCat, 0, 0, getWidth(), getHeight(), this);
            }

        } else if (petType.equalsIgnoreCase("dog")) {
            if (emotion >= 8) {
                g.drawImage(happyDog, 0, 0, getWidth(), getHeight(), this);
            } else if (emotion <= 3) {
                g.drawImage(unhappyDog, 0, 0, getWidth(), getHeight(), this);
            } else {
                g.drawImage(neutralDog, 0, 0, getWidth(), getHeight(), this);
            }

        } else if (petType.equalsIgnoreCase("fish")) {
            if (emotion >= 8) {
                g.drawImage(happyFish, 0, 0, getWidth(), getHeight(), this);
            } else if (emotion <= 3) {
                g.drawImage(unhappyFish, 0, 0, getWidth(), getHeight(), this);
            } else {
                g.drawImage(neutralFish, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}