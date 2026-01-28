package DrawingSurface;
import properties.*;
import javax.swing.*;
import java.awt.event.*;

public class Button extends JPanel implements ActionListener{
	public JButton feed, rest, clean, vet, play, store;
	
	public Button() {
	feed = new JButton("Feed"); 
  feed.addActionListener(this);
  //panel.add(feed); add panel later(?) panel.add(feed);
  
  
  rest = new JButton("rest");
//  button2.addActionListener(this);
  
  clean = new JButton("clean");
//button2.addActionListener(this);
  
  vet = new JButton("vet");
//button2.addActionListener(this);
  
  play = new JButton("play");
//button2.addActionListener(this);
  
  store = new JButton("store");
//button2.addActionListener(this);
  

	}
		public void actionPerformed(ActionEvent e) {
    JButton button = (JButton)e.getSource(); //returns the object that fired the event, but casted as a JButton, and instantiates it
    
    //if statements for incrementing stuff goes here
		}
}
