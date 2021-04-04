package Topic.com.Model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class topicModelGUI extends JFrame{
	
	// attributes
	JFileChooser ch_file1, ch_file2;
	JLabel label1, label2, label3; 
	JButton chFile_B1, chFile_B2, chFile_B3, chFile_B4;
	JPanel panel1, panel2;
	
	// constructors
	topicModelGUI(String title){
		
		super(title);
		setSize(450,500);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		// creating the 3 labels in the GUI
		label1 = new JLabel("Select document / file 1:");
		label1.setToolTipText("Document 1");
		label2 = new JLabel("Select document / file 2:");
		label2.setToolTipText("Document 2");
		label3 = new JLabel(" Find out more details: ");
		
		// creating the buttons to select files
		chFile_B1 = new JButton("Select");
		chFile_B1.setToolTipText("Select a file");
		chFile_B1.setBackground(Color.white);
		chFile_B2 = new JButton("Select");
		chFile_B2.setToolTipText("Select a file");
		chFile_B2.setBackground(Color.white);
		// creating the buttons to compare and to display the common words
		chFile_B3 = new JButton("Compare");
		chFile_B3.setToolTipText("Find the Topic");
		chFile_B3.setBackground(Color.gray);
		chFile_B4 = new JButton("Details");
		chFile_B4.setToolTipText("The common words");
		chFile_B4.setBackground(Color.white);
		
		// creates the panel that will hold the labels and buttons for choosing the file
		panel1 = new JPanel();
		panel1.setSize(434,250); // size of panel
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS)); // layout is set for the panel
		panel1.setAlignmentX(Component.CENTER_ALIGNMENT); // aligning the panel center to the center of frame
		panel1.setBackground(Color.lightGray);
		panel1.setBorder(BorderFactory.createTitledBorder("File Selection"));
		panel1.add(Box.createRigidArea(new Dimension(0,20)));
		panel1.add(label1); 
		panel1.add(chFile_B1);
		panel1.add(Box.createRigidArea(new Dimension(0,10)));
		panel1.add(label2);
		panel1.add(chFile_B2);
		panel1.add(Box.createRigidArea(new Dimension(0,20)));
		panel1.add(chFile_B3);
		panel1.add(Box.createRigidArea(new Dimension(0,10)));
		// aligns all the components in the panel to the center
		label3.setAlignmentX(Component.CENTER_ALIGNMENT);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		chFile_B1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		chFile_B2.setAlignmentX(Component.CENTER_ALIGNMENT);
		chFile_B3.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(panel1);
		
		// create panel to hold to the two buttons
		panel2 = new JPanel();
		add(Box.createRigidArea(new Dimension(0,20)));
		panel2.setSize(250,250);
		// box layout to make panels stack vertical 
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel2.setBackground(Color.lightGray);
		panel2.setBorder(BorderFactory.createTitledBorder("More Details"));
		panel2.add(Box.createRigidArea(new Dimension(0,15)));
		panel2.add(label3);
		panel2.add(chFile_B4);
		panel2.add(Box.createRigidArea(new Dimension(0,10)));
		chFile_B4.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(panel2);
		
		// makes all the components of the GUI visible
		setVisible(true);
		
	}
}
