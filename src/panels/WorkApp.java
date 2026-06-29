package panels;

import java.awt.*;
import java.util.Random;

import javax.swing.*;
import org.json.JSONArray;
import org.json.JSONObject;
import DrawingSurface.AIQuestionGenerator;
import DrawingSurface.DrawingSurface;
import pets.Pet;

public class WorkApp extends JDialog {

    JLabel question;
    JButton[] answers;
    JLabel feedback;
    String correctAnswer;
    
    Pet pet;

    public WorkApp(JFrame parent, Pet pet, DrawingSurface drawingSurface) {
        super(parent, "Work", true);
        setSize(1200, 800);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.pet = pet;

        answers = new JButton[4];

        initUI();
        loadQuestion();
    }

    public void initUI() {
        // Question at the top
        question = new JLabel("Loading question...", SwingConstants.CENTER);
        question.setFont(new Font("Arial", Font.BOLD, 32));
        question.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        add(question, BorderLayout.NORTH);

        // Answer buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        for (int i = 0; i < 4; i++) {
            answers[i] = new JButton();
            answers[i].setFont(new Font("SansSerif", Font.BOLD, 26));
            int index = i;
            answers[i].addActionListener(e -> checkAnswer(answers[index].getText(), answers[index]));
            buttonPanel.add(answers[i]);
        }
        add(buttonPanel, BorderLayout.CENTER);

        // Feedback at the bottom
        JPanel bottomPanel = new JPanel();
        feedback = new JLabel(" ");
        feedback.setFont(new Font("Arial", Font.BOLD, 20));
        bottomPanel.add(feedback);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void checkAnswer(String selected, JButton clicked) {
        String cleaned = selected.replaceAll("<[^>]*>", "").trim();
        if (cleaned.equals(correctAnswer)) {
            feedback.setText("Correct! You earned $20");
            feedback.setForeground(Color.GREEN.darker());
            clicked.setBackground(Color.GREEN);
            pet.setMoney(pet.getMoney() + 20);
        } else {
            feedback.setText("Wrong! The answer was: " + correctAnswer + " You earned $0");
            feedback.setForeground(Color.RED);
            clicked.setBackground(Color.RED);
        }

        for (JButton btn : answers) {
            btn.setEnabled(false);
        }

        Timer timer = new Timer(2000, e -> dispose());
        timer.setRepeats(false);
        timer.start();
    }

    public void loadQuestion() {
        question.setText("Loading question...");
        for (JButton btn : answers) {
            btn.setEnabled(true);
        }
        feedback.setText(" ");

        SwingWorker<String, Void> worker = new SwingWorker<>() {
            @Override
            protected String doInBackground() {
                String[] topics = {
                    "budgeting", "saving money", "credit cards",
                    "investing", "debt management", "emergency funds"
                };
                Random rand = new Random();
                String topic = topics[rand.nextInt(topics.length)];
                return AIQuestionGenerator.generateQuestion(topic, "medium");
            }

            @Override
            protected void done() {
                try {
                    String result = get();
                    JSONObject json = new JSONObject(result);
                    question.setText("<html><center>" + json.getString("question") + "</center></html>");
                    JSONArray options = json.getJSONArray("options");
                    for (int i = 0; i < 4; i++) {
                    	answers[i].setText("<html><center>" + options.getString(i) + "</center></html>");                    }
                    correctAnswer = json.getString("answer");
                } catch (Exception e) {
                    //e.printStackTrace();
                    try {
                        String fallback = "{\"question\": \"What is the best way to build an emergency fund?\", " +
                               "\"options\": [" +
                               "\"Invest all your money in stocks\", " +
                               "\"Save 3-6 months of expenses in a separate account\", " +
                               "\"Spend your extra money on things you enjoy\", " +
                               "\"Lend money to friends and family\"], " +
                               "\"answer\": \"Save 3-6 months of expenses in a separate account\"}";
                        JSONObject json = new JSONObject(fallback);
                        question.setText("<html><center>" + json.getString("question") + "</center></html>");
                        JSONArray options = json.getJSONArray("options");
                        for (int i = 0; i < 4; i++) {
                        	answers[i].setText("<html><center>" + options.getString(i) + "</center></html>");                        }
                        correctAnswer = json.getString("answer");
                    } catch (Exception ex) {
                        question.setText("Error loading question, try again.");
                    }
                }
            }
        };
        worker.execute();
        
     }
}