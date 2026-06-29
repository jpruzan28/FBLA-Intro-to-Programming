package DrawingSurface;

import java.awt.*;

import javax.swing.*;

import panels.*;

import java.awt.event.*;
import pets.Pet;
import java.util.TimerTask;

public class DrawingSurface implements ActionListener {
    private JButton work, food, sleep, clean, vet, play, store, exit;
    private Bar health, nutrition, hygiene, rest, emotion;
    private Sprite sprite;
    private Bar[] bars;
    private Pet pet;
    
    private int width;
    private int height; 

    private int seconds = 0;
    private boolean isGameOver = false;  // ← fixed, now a field not a local variable
    
    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    private JPanel homeScreen; 
    private JPanel storePanel;
    private JPanel storePanelFood;
    private JPanel summaryPanel;
    
    private JDialog workPopUp;

    
    private JLabel moneyLabel;
    private JLabel clockLabel;
    private JLabel expensesLabel;  // ← new
        
    // Creates layers so the background can be on the bottom with buttons on top
    private BackgroundPanel backgroundPanel;
    private JLayeredPane layeredPane;

    
    public DrawingSurface(CardLayout cardLayout, JPanel cardPanel, int width, int height, Pet pet) {
        
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        this.pet = pet; 
        
        this.width = width;
        this.height = height;
        
        if (this.pet == null) {
            System.out.println("Pet is null");
        }
    
        homeScreen = new JPanel();
        storePanel = new StorePanel(cardLayout, cardPanel, pet, this);
        storePanelFood = new StorePanelFood(cardLayout, cardPanel, pet, this);
        summaryPanel = new SummaryPanel(cardLayout, cardPanel, pet);

        // Creates work popup
   /*     JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(null);
        WorkApp workPopUp = new WorkApp(frame);
        workPopUp.setVisible(true);*/
        
        // JLayeredPane replaces the default content pane
        homeScreen.setLayout(new BorderLayout());
        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.setPreferredSize(new Dimension(width, height));
        homeScreen.add(layeredPane, BorderLayout.CENTER);

        createBars();
        addBackground(); 
        addButtons();
        addMoneyLabel();
        addExpensesLabel();  
        createCardLayout();
        addClockLabel();
        startClock();
        drawSprite();
    }
    
    
    public void createCardLayout() {
        cardPanel.add(homeScreen, "Home");
        cardPanel.add(storePanel, "Store");
        cardPanel.add(storePanelFood, "FStore");
        cardPanel.add(summaryPanel, "GameOver"); 
    }
    
    // Adds a background to the bottom layer
    public void addBackground() {
        backgroundPanel = new BackgroundPanel("Images/Pet_Sprites/BackgroundImage.png", bars);
        backgroundPanel.setBounds(0, 0, width, height);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

        // Makes sure the background panel fully fits the home screen size
        homeScreen.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                layeredPane.setSize(homeScreen.getSize());
                backgroundPanel.setBounds(0, 0, homeScreen.getWidth(), homeScreen.getHeight());
                layeredPane.revalidate();
            }
        });
    }
    
    public void createBars() {
        double rectWidth = width / 8.0;
        double barHeight = 30;
        double totalBarsWidth = 4 * rectWidth;
        double gap = (width - totalBarsWidth) / (4 + 1);
        int y = height / 20;

        double x1 = gap;
        double x2 = gap * 2 + rectWidth;
        double x3 = gap * 3 + rectWidth * 2;
        double x4 = gap * 4 + rectWidth * 3;
       // double x5 = gap * 5 + rectWidth * 4;
        
        health  = new Bar(pet, "Health",  x1, y, rectWidth, barHeight);
        nutrition  = new Bar(pet, "Nutrition",  x2, y, rectWidth, barHeight);
        hygiene = new Bar(pet, "Hygiene", x3, y, rectWidth, barHeight);
        rest    = new Bar(pet, "Rest",    x4, y, rectWidth, barHeight);
      //  emotion = new Bar(pet, "Emotion", x5, y, rectWidth, barHeight);

        bars = new Bar[] {health, nutrition, hygiene, rest};
    }

    // Money label - top left
    public void addMoneyLabel() {
        moneyLabel = new JLabel("Balance: $" + String.format("%.2f", pet.getMoney()));
        moneyLabel.setFont(new Font("Inconsolata", Font.BOLD, 24));
        moneyLabel.setForeground(Color.BLACK);
        moneyLabel.setBounds(400, 100, 320, 40);
        layeredPane.add(moneyLabel, JLayeredPane.PALETTE_LAYER);
    }

    // Expenses label - center of screen
    public void addExpensesLabel() {
        expensesLabel = new JLabel("Expenses: $" + String.format("%.2f", pet.getExpenses()));
        expensesLabel.setFont(new Font("Inconsolata", Font.BOLD, 24));
        expensesLabel.setForeground(Color.BLACK);
        // Centers it in the middle of the screen
        expensesLabel.setBounds(850, 100, 350, 40);
        layeredPane.add(expensesLabel, JLayeredPane.PALETTE_LAYER);
    }

    // Called by ReductionTimer to update money display
    public void updateMoneyDisplay() {
//        SwingUtilities.invokeLater(() -> {
            moneyLabel.setText("Balance: $" + String.format("%.2f", pet.getMoney()));
            expensesLabel.setText("Expenses: $" + String.format("%.2f", pet.getExpenses()));  
        //});
    }
    
    // Clock label - top right
    public void addClockLabel() {
        clockLabel = new JLabel("Time: " + "00:00:00");
        clockLabel.setFont(new Font("Inconsolata", Font.BOLD, 24));
        clockLabel.setForeground(Color.BLACK);
        clockLabel.setBounds(630, 100, 350, 40);
        layeredPane.add(clockLabel, JLayeredPane.PALETTE_LAYER);
    }
        
    public void startClock() {
        java.util.Timer clockTimer = new java.util.Timer();
        clockTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    seconds++;
                    int hrs = seconds / 3600;
                    int mins = (seconds % 3600) / 60;
                    int secs = seconds % 60;
                    clockLabel.setText(String.format("Time: " + "%02d:%02d:%02d", hrs, mins, secs));
                });
            }
        }, 0, 1000);
    }
    
    // Called by ReductionTimer when a stat hits 0
    public void gameOver() {
        if (isGameOver) return; 
        isGameOver = true;

        SwingUtilities.invokeLater(() -> {
          /*  cardPanel.remove(summaryPanel);
            summaryPanel = new SummaryPanel(cardLayout, cardPanel, pet);
            
            cardPanel.add(summaryPanel, "GameOver");*/
            SummaryPanel castedSummary = (SummaryPanel)summaryPanel; 
        	castedSummary.setScreen2(); 
            cardLayout.show(cardPanel, "GameOver");
            
            pet.endGame(); 
        });
    }
    
    public void drawSprite() {
        sprite = new Sprite(pet);
        
        int spriteWidth = 650;
        int spriteHeight = 650;
        int spriteX = (width - spriteWidth) / 2;
        int spriteY = (height - spriteHeight) / 2;
        
        if (pet.getType() == "fish") {
        sprite.setBounds(spriteX-100, spriteY+300, spriteWidth, spriteHeight);
        sprite.setOpaque(false);
        } else {
            sprite.setBounds(spriteX-100, spriteY+250, spriteWidth, spriteHeight);
            sprite.setOpaque(false);
        }
        
        // put on MODAL_LAYER which is above PALETTE_LAYER
        layeredPane.add(sprite, JLayeredPane.MODAL_LAYER);
    }

    // takes in the height you want and scales it proportionally
    public static ImageIcon createScaledIcon(String imagePath, int targetHeight) {
        try {
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image originalImage = originalIcon.getImage();
            
            // Passing -1 as the width makes it automatically calculate 
            Image scaledImage = originalImage.getScaledInstance(-1, targetHeight, Image.SCALE_SMOOTH);
            
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            System.out.println("Could not load or scale image: " + imagePath);
            return null;
        }
    }
    
    // makes the button transparent
	public static void clearBackground(JButton button) { 
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setOpaque(false);
	}

    public void addButtons() {
    	
//    	ImageIcon icon = new ImageIcon("Images/Homescreen_Buttons/CleaningButton.png");
//    	Image scaled = icon.getImage().getScaledInstance(545, 500, Image.SCALE_SMOOTH);
//    	ImageIcon scaledIcon = new ImageIcon(scaled);

    	

    	ImageIcon cleanIcon = createScaledIcon("Images/Homescreen_Buttons/CleaningButton.png", 500);
    	ImageIcon sleepIcon = createScaledIcon("Images/Homescreen_Buttons/RestButton.png", 290);
    	ImageIcon feedIcon = createScaledIcon("Images/Homescreen_Buttons/FeedButton.png", 227);
    	ImageIcon playIcon = createScaledIcon("Images/Homescreen_Buttons/PlayButton.png", 200);
    	ImageIcon storeIcon = createScaledIcon("Images/Homescreen_Buttons/StoreButton.png", 655);
    	ImageIcon workIcon = createScaledIcon("Images/Homescreen_Buttons/WorkButton.png", 170);
    	ImageIcon vetIcon = createScaledIcon("Images/Homescreen_Buttons/VetButton.png", 170);
    	ImageIcon exitIcon = createScaledIcon("Images/Homescreen_Buttons/ExitButton.png", 150);
    
    	ImageIcon cleanGlowIcon = createScaledIcon("Images/Homescreen_Buttons/CleaningGlow.png", 500);
    	ImageIcon sleepGlowIcon = createScaledIcon("Images/Homescreen_Buttons/RestGlow.png", 290);
    	ImageIcon feedGlowIcon = createScaledIcon("Images/Homescreen_Buttons/FeedGlow.png", 227);
    	ImageIcon playGlowIcon = createScaledIcon("Images/Homescreen_Buttons/PlayGlow.png", 200);	
    	ImageIcon storeGlowIcon = createScaledIcon("Images/Homescreen_Buttons/StoreGlow.png", 655);
    	ImageIcon workGlowIcon = createScaledIcon("Images/Homescreen_Buttons/WorkGlow.png", 170);
    	ImageIcon vetGlowIcon = createScaledIcon("Images/Homescreen_Buttons/VetGlow.png", 170);
    	ImageIcon exitGlowIcon = createScaledIcon("Images/Homescreen_Buttons/ExitGlow.png", 150);
    	
        work  = new JButton(workIcon);
        food  = new JButton(feedIcon);
        sleep = new JButton(sleepIcon);
        clean = new JButton(cleanIcon);
        vet   = new JButton(vetIcon);
		play = new JButton(playIcon);
		store = new JButton(storeIcon);
		exit = new JButton(exitIcon);

		work.setBounds(1380, 130, workIcon.getIconWidth(), 170);
		food.setBounds(70, 760, feedIcon.getIconWidth(), 227);
		sleep.setBounds(670, 430, sleepIcon.getIconWidth(), 290);
		clean.setBounds(1250, 483, cleanIcon.getIconWidth(), 500);
		vet.setBounds(1380, 320, vetIcon.getIconWidth(), 170);
		play.setBounds(450, 460, playIcon.getIconWidth(), 200);
		store.setBounds(157, 134, storeIcon.getIconWidth(), 655);

		// Makes exit button outside of the restricted border
		exit.setMargin(new Insets(0, 0, 0, 0));
		// Clears any border space around the icon
		exit.setBorder(BorderFactory.createEmptyBorder());
		exit.setBounds(-5, -5, exitIcon.getIconWidth(), 150);
        
        clearBackground(food);
        clearBackground(sleep);
        clearBackground(clean);
        clearBackground(play);
        clearBackground(store);
        clearBackground(work);
        clearBackground(vet);
        clearBackground(exit);
        
        clean.setRolloverIcon(cleanGlowIcon);
        sleep.setRolloverIcon(sleepGlowIcon);
        food.setRolloverIcon(feedGlowIcon);
        vet.setRolloverIcon(vetGlowIcon);
        play.setRolloverIcon(playGlowIcon);
        store.setRolloverIcon(storeGlowIcon);
        work.setRolloverIcon(workGlowIcon);
        exit.setRolloverIcon(exitGlowIcon);
        
        work .setToolTipText("Answer questions to make money. Increases Total Savings. $10 per question right");
        food .setToolTipText("Food store to buy and feed food. Increases Hunger bar");
        sleep.setToolTipText("Pet sleeps for certain amount of time. Increases Rest bar");
        clean.setToolTipText("Cleans pet. (+Hygiene)");
        vet  .setToolTipText("Cures pet. Increases Health bar");
        play .setToolTipText("PLAY. Pick toy you own for pet to play with. Increases Emotion bar");
        store.setToolTipText("TOY STORE. Toy store to buy toys");
        exit.setToolTipText("End game");

        work .addActionListener(this);
        food .addActionListener(this);
        sleep.addActionListener(this);
        clean.addActionListener(this);
        vet  .addActionListener(this);
        play .addActionListener(this);
        store.addActionListener(this);
        exit.addActionListener(this);

     
        layeredPane.add(work,  JLayeredPane.PALETTE_LAYER);
        layeredPane.add(sleep, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(food, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(clean, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(vet,   JLayeredPane.PALETTE_LAYER);
        layeredPane.add(play,  JLayeredPane.PALETTE_LAYER);
        layeredPane.add(store, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(exit, JLayeredPane.PALETTE_LAYER);
    }
    
    public static void errorMessage(String problem) {
		if(problem.equals("Too expensive")) {
		    JOptionPane.showMessageDialog(null, "Sorry, this item is too expensive.");
		}
		else if(problem.equals("Toy overflow")) {
		    JOptionPane.showMessageDialog(null, "Sorry, you have reached the maximum number of toys. You cannot buy anymore.");
		}
	}
    
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        
        
        if (button == exit) {
        	SummaryPanel castedSummary = (SummaryPanel)summaryPanel; 
        	castedSummary.setScreen2(); 
			System.out.println("Changing to gameover/summary panel");
			cardLayout.show(cardPanel, "GameOver");

			pet.endGame();

		} else if (button == work) {
			// Creates work popup
			WorkApp workPopUp = new WorkApp(null, pet, this);
			workPopUp.setVisible(true);

		} else if (button == food) {
			cardLayout.show(cardPanel, "FStore");

		} else if (button == store) {
			cardLayout.show(cardPanel, "Store");

		} else {
			//since the buttons don't have names, use if statements to make them represent one
			String actionName = "";
			if (button == sleep)
				actionName = "Sleep";
			else if (button == clean)
				actionName = "Clean";
			else if (button == vet)
				actionName = "Vet";
			else if (button == play)
				actionName = "Play";

			if (!actionName.isEmpty()) {
				Button newButton = new Button(pet, actionName);
				newButton.actionPerformed();
			}
			updateMoneyDisplay();
		}
	}
}