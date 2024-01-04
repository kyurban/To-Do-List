import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	
	Box box;
	
	MyFrame() {
		
		MyPanel panel = new MyPanel();
		
		//Use box layout to center the panel within the JFrame
		box = new Box(BoxLayout.Y_AXIS);
		box.add(Box.createVerticalGlue());
		box.add(panel);
		box.add(Box.createVerticalGlue());
		
		this.setTitle("To-Do List");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#1d3c45"));
		this.setSize(750, 750);
		this.setMinimumSize(new Dimension(550,630));
		this.setVisible(true);
		this.add(box);
		
	}
}
