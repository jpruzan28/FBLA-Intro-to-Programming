package VirtualPet;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pets.Pet;

public class GameOverPanel extends JPanel {

    public GameOverPanel(CardLayout cardLayout, JPanel cardPanel, Pet pet) {
        setLayout(new BorderLayout());
        setBackground(Color.orange);

        // Title
        JLabel titleLabel = new JLabel("GAME OVER! :<", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Rubik Mono One", Font.BOLD, 50));
        add(titleLabel, BorderLayout.NORTH);

        // Stats panel
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(3, 1, 10, 10));
        statsPanel.setBackground(Color.cyan);

        // 1. Final health
        JLabel healthLabel = new JLabel("Final Health: " + pet.getHealth() + "/10", SwingConstants.CENTER);

        // 2. Final hunger
        JLabel hungerLabel = new JLabel("Final Hunger: " + pet.getHunger() + "/10", SwingConstants.CENTER);

        // 3. Happiness based on emotion
        String happiness;
        if(pet.getEmotion() >= 8) {happiness = "Very Happy :) Amazing job!";}
        else if (pet.getEmotion() >= 5) {happiness = "Content :| Nice preventing your pet from feeling sad ";}
        
        else if (pet.getEmotion() >= 3) {happiness = "Sad :( It's okay though you tried your best";}
        
        else {happiness = "Very Unhappy >:[";}
        JLabel happinessLabel = new JLabel("During your run, the pet felt " + happiness, SwingConstants.CENTER);

        // Set font for all labels
        Font statFont = new Font("Arial", Font.BOLD, 28);
        healthLabel.setFont(statFont);
        hungerLabel.setFont(statFont);
        happinessLabel.setFont(statFont);

        // Add to stats panel
        statsPanel.add(healthLabel);
        statsPanel.add(hungerLabel);
        statsPanel.add(happinessLabel);

        add(statsPanel, BorderLayout.CENTER);
    }
}