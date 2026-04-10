package DrawingSurface;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ItemButton extends JButton {

    public ItemButton(String name, String cost, String level, String imagePath) {
        setName(name);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 200));
        
        // Creates the image on the left of the button
        try {
            BufferedImage img = ImageIO.read(new File(imagePath));
            Image scaled = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaled));
            imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            imageLabel.setOpaque(false);
            add(imageLabel, BorderLayout.WEST);
        } catch (IOException e) {
            System.out.println("Image not found: " + imagePath);
        }
        
        JPanel textPanel = new JPanel(new GridLayout(3, 1));
        textPanel.setOpaque(false);

        JLabel nameLabel  = new JLabel(name);
        JLabel costLabel  = new JLabel(cost);
        JLabel levelLabel = new JLabel(level);
        
        nameLabel.setFont(new Font("Arial", Font.BOLD,  13));
        costLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        levelLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        textPanel.add(nameLabel);
        textPanel.add(costLabel);
        textPanel.add(levelLabel);

        add(textPanel, BorderLayout.CENTER);
    }
}
