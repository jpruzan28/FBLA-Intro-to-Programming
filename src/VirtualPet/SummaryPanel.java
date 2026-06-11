package VirtualPet;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import pets.Pet;
import properties.*;

import java.awt.*;
import java.util.ArrayList;

// 1. Change from JFrame to JPanel
public class SummaryPanel extends JPanel {
	
	private Pet pet; 

    public SummaryPanel(Pet pet) {
    	this.pet = pet; 
    	
        // 2. Set layout of THIS panel to BorderLayout
        setLayout(new BorderLayout());

        // Create the internal panel that holds everything (GridBagLayout)
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        // General pet information 
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3; gbc.weighty = 0.1;
        mainPanel.add(createImagePlaceholder(), gbc);

        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.7;
        mainPanel.add(createTextBlock("Game Overview", 
                "User: " + pet.getOwner() + 
                "\nDuration: ?" +
                "\nPet Name: " + pet.getName() + 
                "\nPet Status: " + calculateEmotion(pet.getEmotion())), gbc);

        // --- ROW 1: TEXT BLOCK 2 (Full Width) ---
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; gbc.weightx = 1.0; gbc.weighty = 0.1;
        mainPanel.add(createTextBlock("Campaign Notes", 
                "During this session, you successfully defended the northern outpost.\n" +
                "Unlocked Tier 3 modifications and earned the 'Unstoppable' badge."), gbc);

        // Pet statuses (table) 
        gbc.gridy = 2; gbc.weighty = 0.2;
        String[] cols1 = {"Status", "Amount"};
        Object[][] data1 = {{"Health", pet.getHealth()+"/10"}, {"Hunger", pet.getHunger()+"/10"}, {"Hygiene", pet.getHygiene()+"/10"}, {"Rest", pet.getRest()+"/10"}};
        mainPanel.add(createTableComponent("Final Statuses", cols1, data1), gbc);

        // --- ROW 3: TABLE 2 (Medium) ---
        gbc.gridy = 3; gbc.weighty = 0.3;
        String[] cols2 = {"Item", "Price", "Type"};
        
        int numToys = pet.getToysArr().length;
        int numFoods = pet.getFood().size();
        int vetVisits = pet.getVetVisits(); 
        int receiptLength = numToys+numFoods+vetVisits;
        Object[][] data2 = new Object[receiptLength][3];
        
        // Adding toys to the receipt table
        for(int t = 0; t < numToys; t++) {
        	Toy toy = pet.getToysArr()[t];
        	data2[t][0] = toy.getName();
        	data2[t][1] = "$" +toy.getPrice();
        	data2[t][2] = toy.getType() + " Toy"; 
        }
        
        // Adding food to the receipt table
        for(int f = numToys; f < numToys+numFoods; f++) {
        	Food food = pet.getFood().get(f); 
        	data2[f][0] = food.getName();
        	data2[f][1] = "$" +food.getPrice();
        	data2[f][2] = food.getType() + " Food";

        }
        
        // Adding vet visits to the receipt table
        for(int v = numToys+numFoods; v < receiptLength; v++) {
        	data2[v][0] = "Vet Visit";
            data2[v][1] = "$20";
            data2[v][2] = "Vet Visit";

        }
        	
        mainPanel.add(createTableComponent("Pet Statuses", cols2, data2), gbc);

        // --- ROW 4: TABLE 3 (Large) ---
        gbc.gridy = 4; gbc.weighty = 0.4;
        String[] cols3 = {"Icon", "Toy", "Type", "Match"};
        Object[][] data3 = {{"Iron Ore", "Common", "45"}, {"Enchanted Ruby", "Rare", "2"}};
        mainPanel.add(createToyTableWithImages("Toys Summary", cols3, pet.getToysArr(), pet.getToysArr().length), gbc);

        // 3. Wrap everything in a primary scroll pane
        JScrollPane rootScrollPane = new JScrollPane(mainPanel);
        rootScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        // 4. Add the scroll pane directly to THIS panel instance
        add(rootScrollPane, BorderLayout.CENTER);
    }

    // --- Keep helper methods (createImagePlaceholder, createTextBlock, createTableComponent) identical ---
    private JComponent createImagePlaceholder() {
        JLabel imageLabel = new JLabel(" [ GAME LOGO ] ", SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(150, 120));
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.DARK_GRAY);
        imageLabel.setForeground(Color.LIGHT_GRAY);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        return imageLabel;
    }

    private JPanel createTextBlock(String title, String text) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title, TitledBorder.LEFT, TitledBorder.TOP));
        JTextArea textArea = new JTextArea(text);
        textArea.setEditable(false);
        textArea.setBackground(panel.getBackground());
        panel.add(textArea, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createTableComponent(String title, String[] columns, Object[][] data) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title, TitledBorder.LEFT, TitledBorder.TOP));
        JTable table = new JTable(data, columns);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(tableScrollPane.getPreferredSize().width, 100));
        panel.add(tableScrollPane, BorderLayout.CENTER);
        return panel;
    }
    
    /**
     * NEW METHOD: Generates a panel containing a table that displays graphics/icons.
     */
    private JPanel createToyTableWithImages(String title, String[] columns, Toy[] toys, int numToys) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), title, TitledBorder.LEFT, TitledBorder.TOP));

        // 1. Define column headers
        //String[] columns = {"Icon", "Toy", "Type", "Match"};

        // 2. Load your image assets (make sure paths point to your actual project files)
        ArrayList<ImageIcon> toyImages = new ArrayList<>(); 
        
        for(int i = 0; i < toyImages.size(); i++) {
        	toyImages.add(new ImageIcon(toys[i].getIcon())); 
        }

        // 3. Match row objects to your columns (Row 0 is the ImageIcon type)
        Object[][] data = new Object[numToys][4]; 
        
        for(int i = 0; i < data.length; i++) {
        	data[i][0] = toyImages.get(i);
        	data[i][1] = toys[i].getName();
        	data[i][2] = toys[i].getType();
        	
        	if(toys[i].getType().equals(pet.getType()))
        		data[i][3] = "True";
        	else 
        		data[i][3] = "False";
        }

        // 4. Custom model to tell Swing to render Column 0 as a graphic, not text
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0) {
                    return ImageIcon.class; 
                }
                return Object.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        JTable table = new JTable(model);
        
        // 5. Increase row height so your game sprites aren't squished down
        table.setRowHeight(40); 
        
        // Match the width of the first column to comfortably frame a small sprite
        table.getColumnModel().getColumn(0).setPreferredWidth(50);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(tableScrollPane.getPreferredSize().width, 150));
        panel.add(tableScrollPane, BorderLayout.CENTER);

        return panel;
    }
    
    public String calculateEmotion(int emotion) {
    	if(emotion <= 3) 
    		return "Sad";
    	else if(emotion >= 8) 
    		return "Happy";
    	else 
    		return "Content"; 
    }
}
