import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.FocusManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MyPanel extends JPanel implements ActionListener{
	
	JTextField searchBar;
	JButton button;
	JPanel innerTop;
	JPanel innerMain;
	JPanel innerMainTwo;
	JScrollPane scrollPane;
	JCheckBox checkBox;
	JButton delete;
	
	MyPanel() {
		
		//create a search bar
		searchBar = new JTextField();
		searchBar.setPreferredSize(new Dimension(250,40));
		searchBar.setFont(new Font("Consolas", Font.PLAIN, 22));
		searchBar.setHorizontalAlignment(JTextField.CENTER);
		
		//create the "Add Task" button
		button = new JButton("Add Task");
		button.addActionListener(this);
		button.setPreferredSize(new Dimension(100,40));
		button.setBackground(Color.WHITE);
		
		//Top half of panel that includes the search bar and "Add Task" button
		innerTop = new JPanel();
		innerTop.setBackground(Color.decode("#d2601a"));
		innerTop.setPreferredSize(new Dimension(100,100));
		innerTop.setLayout(new GridBagLayout());
		innerTop.add(searchBar);
		innerTop.add(button);
		
		//Bottom half that includes list of tasks
		innerMain = new JPanel();
		innerMain.setBackground(Color.WHITE);
		innerMain.setLayout(new BoxLayout(innerMain, BoxLayout.Y_AXIS));
		
		//Add scrollable interface
		scrollPane = new JScrollPane(innerMain);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(550,600));
		this.setMaximumSize(new Dimension(550,600));
		this.setMinimumSize(new Dimension(550,600));
		this.setLayout(new BorderLayout());
		this.add(innerTop,BorderLayout.NORTH);
		this.add(scrollPane,BorderLayout.CENTER);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		/*If "Add Task" is pressed, save the text and display it in a
		newly created checkBox (including a delete button)*/
		if (e.getSource() == button) {
            String text = searchBar.getText();

            if (!text.isEmpty()) {
            	
            	//Create a checkBox upon pressing button
                JCheckBox checkBox = new JCheckBox(text);
                checkBox.setHorizontalAlignment(JCheckBox.LEFT);
                checkBox.setPreferredSize(new Dimension(300, 70));
                checkBox.setBackground(Color.decode("#fff1e1"));
                checkBox.setFocusable(false);
                checkBox.setFont(new Font("Arial", Font.PLAIN, 20));
                
                //Create a delete button for each checkBox
                JButton delete = new JButton("Delete");
                delete.setBackground(new Color(231, 76, 60));
                delete.setForeground(Color.WHITE);
                delete.setFocusPainted(false);
                
                //Group the checkBox and delete button into new panel
                JPanel checkBoxPanel = new JPanel(new BorderLayout());
                checkBoxPanel.add(checkBox, BorderLayout.CENTER);
                checkBoxPanel.add(delete, BorderLayout.EAST);
                checkBoxPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
                checkBoxPanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, 70));
                
                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Remove the checkBox and corresponding text from the list
                        innerMain.remove(checkBoxPanel);
                        innerMain.revalidate();
                        innerMain.repaint();
                    }
                });
   
                innerMain.add(checkBoxPanel);
                searchBar.setText("");
                this.revalidate();
                this.repaint();
            }
				
		}
	}
	
}
