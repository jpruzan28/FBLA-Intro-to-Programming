package VirtualPet;

import java.awt.*;
import javax.swing.*;

import org.json.JSONObject;
import org.json.JSONArray;

import DrawingSurface.AIQuestionGenerator;

public class WorkApp extends JPanel {
	/*A JLabel for the question
	An array of 4 JButtons for the answers
	A JLabel for feedback (correct/wrong)
	A JButton to load the next question
	A String to track the correct answer*/
	
	JPanel homeScreen;
	CardLayout cardLayout;

	JLabel question; 
	JButton[] answers;
	JLabel feedback;
	String correctAnswer;
	
	public WorkApp(JPanel homeScreen, CardLayout cardLayout) {
		super();
		this.setLayout(new BorderLayout());
		
		initUI(); 
		loadQuestion();
	}
	
	public void initUI() {
		// Question at the top
		question = new JLabel("Loading question...", SwingConstants.CENTER);
		question.setFont(new Font("Arial", Font.BOLD, 16));
		add(question, BorderLayout.NORTH);	
		
		// Answer buttons
		JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
		for (int i = 0; i < 4; i++) {
		    answers[i] = new JButton();
		    int index = i;
		    answers[i].addActionListener(e -> checkAnswer(answers[index].getText()));
		    buttonPanel.add(answers[i]);
		}
		add(buttonPanel, BorderLayout.CENTER);
		
		// Feedback
		JPanel bottomPanel = new JPanel();
		feedback = new JLabel(" ");
		feedback.setFont(new Font("Arial", Font.BOLD, 14));
		bottomPanel.add(feedback);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
	public void checkAnswer(String selected) {
		if (selected.equals(correctAnswer)) {
		      feedback.setText("✓ Correct!");
		      feedback.setForeground(Color.GREEN.darker());
		   }	
		
		else {
	        feedback.setText("✗ Wrong! The answer was: " + correctAnswer);
	        feedback.setForeground(Color.RED);
	    }
		    
	    // Disable all buttons so they can't answer again
	    for (JButton btn : answers) {
	        btn.setEnabled(false);
	    }
		    
	    // Wait 2 seconds then go back to main screen
	    Timer timer = new Timer(2000, e -> cardLayout.show(homeScreen, "home"));
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
	            return AIQuestionGenerator.generateQuestion("financial responsibility", "medium");
	        }

	        @Override
	        protected void done() {
	            try {
	                String result = get();
	                JSONObject json = new JSONObject(result);
	                question.setText("<html><center>" + json.getString("question") + "</center></html>");
	                JSONArray options = json.getJSONArray("options");
	                for (int i = 0; i < 4; i++) {
	                    answers[i].setText(options.getString(i));
	                }
	                correctAnswer = json.getString("answer");
	            } catch (Exception e) {
	                question.setText("Error loading question, try again.");
	                e.printStackTrace();
	            }
	        }
	    };
	    worker.execute();
	}


}
