package VirtualPet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	private BufferedImage image;
	
	public BackgroundPanel(String imagePath) {
		setLayout(null);
		setOpaque(false);
		
		try {
			image = ImageIO.read(new File(imagePath));
		}
		catch (IOException e) {
			System.out.println("Background image not found");
		}
	}
	
	public void paindComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
