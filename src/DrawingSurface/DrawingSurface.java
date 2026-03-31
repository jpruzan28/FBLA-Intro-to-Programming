package DrawingSurface;

import VirtualPet.*; 

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import pets.Pet;
import java.util.TimerTask;

public class DrawingSurface implements ActionListener {
    private JButton work, food, sleep, clean, vet, play, store;
    private Bar health, hunger, hygiene, rest, emotion;
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
   // private JPanel workScreen;
    private JPanel gameOverScreen;
    
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
        storePanel = new StorePanel(cardLayout, cardPanel, pet);
        storePanelFood = new StorePanelFood(cardLayout, cardPanel, pet);
       // workScreen = new WorkApp(cardLayout);
        gameOverScreen = new GameOverPanel(cardLayout, cardPanel, pet);

        // JLayeredPane replaces the default content pane
        homeScreen.setLayout(new BorderLayout());
        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
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
       // cardPanel.add(workScreen, "Work");
        cardPanel.add(gameOverScreen, "GameOver"); 
    }
    
    // Adds a background to the bottom layer
    public void addBackground() {
        backgroundPanel = new BackgroundPanel("Images/Pet_Sprites/Untitled14.png", bars);
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
        double totalBarsWidth = 5 * rectWidth;
        double gap = (width - totalBarsWidth) / (5 + 1);
        int y = height / 20;

        double x1 = gap;
        double x2 = gap * 2 + rectWidth;
        double x3 = gap * 3 + rectWidth * 2;
        double x4 = gap * 4 + rectWidth * 3;
        double x5 = gap * 5 + rectWidth * 4;
        
        health  = new Bar(pet, "Health",  x1, y, rectWidth, barHeight);
        hunger  = new Bar(pet, "Hunger",  x2, y, rectWidth, barHeight);
        hygiene = new Bar(pet, "Hygiene", x3, y, rectWidth, barHeight);
        rest    = new Bar(pet, "Rest",    x4, y, rectWidth, barHeight);
        emotion = new Bar(pet, "Emotion", x5, y, rectWidth, barHeight);

        bars = new Bar[] {health, hunger, hygiene, rest, emotion};
    }

    // Money label - top left
    public void addMoneyLabel() {
        moneyLabel = new JLabel("Total Currency: $" + String.format("%.2f", pet.getMoney()));
        moneyLabel.setFont(new Font("Inconsolata", Font.BOLD, 24));
        moneyLabel.setForeground(Color.BLACK);
        moneyLabel.setBounds(300, 100, 320, 40);
        layeredPane.add(moneyLabel, JLayeredPane.PALETTE_LAYER);
    }

    // Expenses label - center of screen
    public void addExpensesLabel() {
        expensesLabel = new JLabel("Total Spent: $" + String.format("%.2f", pet.getExpenses()));
        expensesLabel.setFont(new Font("Inconsolata", Font.BOLD, 24));
        expensesLabel.setForeground(Color.BLACK);
        // Centers it in the middle of the screen
        expensesLabel.setBounds(850, 100, 350, 40);
        layeredPane.add(expensesLabel, JLayeredPane.PALETTE_LAYER);
    }

    // Called by ReductionTimer to update money display
    public void updateMoneyDisplay() {
        SwingUtilities.invokeLater(() -> {
            moneyLabel.setText("Total Currency: $" + String.format("%.2f", pet.getMoney()));
            expensesLabel.setText("Total Spent: $" + String.format("%.2f", pet.getExpenses()));  
        });
    }
    
    // Clock label - top right
    public void addClockLabel() {
        clockLabel = new JLabel("00:00:00");
        clockLabel.setFont(new Font("Inconsolata", Font.BOLD, 24));
        clockLabel.setForeground(Color.BLACK);
        clockLabel.setBounds(width - 350, 50, 320, 40);
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
                    clockLabel.setText(String.format("%02d:%02d:%02d", hrs, mins, secs));
                });
            }
        }, 0, 1000);
    }
    
    // Called by ReductionTimer when a stat hits 0
    public void gameOver() {
        if (isGameOver) return; 
        isGameOver = true;

        SwingUtilities.invokeLater(() -> {
            cardPanel.remove(gameOverScreen);
            gameOverScreen = new GameOverPanel(cardLayout, cardPanel, pet);
            cardPanel.add(gameOverScreen, "GameOver");
            cardLayout.show(cardPanel, "GameOver");
        });
    }
    
    public void drawSprite() {
        sprite = new Sprite(pet);
        
        int spriteWidth = 650;
        int spriteHeight = 650;
        int spriteX = (width - spriteWidth) / 2;
        int spriteY = (height - spriteHeight) / 2;
        
        sprite.setBounds(spriteX-150, spriteY+185, spriteWidth, spriteHeight);
        sprite.setOpaque(false);
        
        // put on MODAL_LAYER which is above PALETTE_LAYER
        layeredPane.add(sprite, JLayeredPane.MODAL_LAYER);
    }
    
    public void addButtons() {
        work  = new JButton("Work");
        food  = new JButton("Food Store");
        sleep = new JButton("Sleep");
        clean = new JButton("Clean");
        vet   = new JButton("Vet");
        play  = new JButton("Play");
        store = new JButton("Toy Store");
        
        work.setBounds(90,  460, 120, 40);
        food.setBounds(90, 100, 120, 40);
        sleep.setBounds(90, 160, 120, 40);
        clean.setBounds(90, 220, 120, 40);
        vet.setBounds(90, 280, 120, 40);
        play.setBounds(90,  340, 120, 40);
        store.setBounds(90,  400, 120, 40);
        
        work .setToolTipText("Answer questions to make money. Increases Total Savings. $10 per question right");
        food .setToolTipText("Food store to buy and feed food. Increases Hunger bar");
        sleep.setToolTipText("Pet sleeps for certain amount of time. Increases Rest bar");
        clean.setToolTipText("Cleans pet. Increases Hygiene bar");
        vet  .setToolTipText("Cures pet. Increases Health bar");
        play .setToolTipText("Pick toy you own for pet to play with. Increases Emotion bar");
        store.setToolTipText("Toy store to buy toys");

        work .addActionListener(this);
        food .addActionListener(this);
        sleep.addActionListener(this);
        clean.addActionListener(this);
        vet  .addActionListener(this);
        play .addActionListener(this);
        store.addActionListener(this);
      
        layeredPane.add(work,  JLayeredPane.PALETTE_LAYER);
        layeredPane.add(food,  JLayeredPane.PALETTE_LAYER);
        layeredPane.add(sleep, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(clean, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(vet,   JLayeredPane.PALETTE_LAYER);
        layeredPane.add(play,  JLayeredPane.PALETTE_LAYER);
        layeredPane.add(store, JLayeredPane.PALETTE_LAYER);
    }
    
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String bPressed = button.getText();
        
        if (bPressed.equals("Work")) {
       // 	cardLayout.show(cardPanel, "Work");

        } else if (bPressed.equals("Food Store")) {
            cardLayout.show(cardPanel, "FStore");

        } else if (bPressed.equals("Toy Store")) {
            cardLayout.show(cardPanel, "Store");

        } else {
            Button newButton = new Button(pet, bPressed);
            newButton.actionPerformed();
        }
    }
}