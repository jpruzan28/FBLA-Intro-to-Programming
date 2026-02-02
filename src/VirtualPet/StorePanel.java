package VirtualPet;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StorePanel extends JPanel {
    
    public StorePanel(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(new BorderLayout());
        setBackground(Color.gray);
        
        // Add store title
        JLabel titleLabel = new JLabel("Welcome to the Pet Store!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);
        
        // Add store items panel
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(3, 2, 10, 10));
        itemsPanel.setBackground(Color.WHITE);
        
        
    }
    
}    
