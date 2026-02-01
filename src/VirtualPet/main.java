package VirtualPet;
import DrawingSurface.*;
import DrawingSurface.Button;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Color;
import java.awt.Container;
import java.util.Scanner;
import javax.swing.*;


public class main extends JFrame{
	
	public main() {
	    Container c = getContentPane();
	    c.setBackground(Color.WHITE);
	    Button buttons = new Button();
	    c.add(buttons, BorderLayout.CENTER);
	}
	

	public static void main(String[] args) {
	    main w = new main();
	    w.setBounds(300, 300, 400, 400);
	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    w.setVisible(true);
		
	}
}
