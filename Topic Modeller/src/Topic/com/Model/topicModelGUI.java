package Topic.com.Model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
	JPanel panel1, panel2, panel3;
	
	// constructors
	topicModelGUI(String title){
		
		super(title);
		JFrame frame = new JFrame();	
		setSize(450,500);
		setVisible(true);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		// label for selecting the first file
		label1 = new JLabel("Select document / file 1:");
		label1.setToolTipText("Document 1");
		label2 = new JLabel("Select document / file 2:");
		label2.setToolTipText("Document 2");
		label3 = new JLabel("***************** FILE SELECTION *****************");
		
		chFile_B1 = new JButton("Select");
		chFile_B1.setToolTipText("Select a file");
		chFile_B2 = new JButton("Select");
		chFile_B2.setToolTipText("Select a file");
		
		panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.setBackground(Color.lightGray);
		panel1.add(Box.createRigidArea(new Dimension(0,15)));
		panel1.add(label3);
		panel1.add(Box.createRigidArea(new Dimension(0,20)));
		panel1.add(label1); 
		panel1.add(chFile_B1);
		panel1.add(Box.createRigidArea(new Dimension(0,10)));
		panel1.add(label2);
		panel1.add(chFile_B2);
		label3.setAlignmentX(Component.CENTER_ALIGNMENT);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		chFile_B1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		chFile_B2.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(panel1);
		
		
		
		
		
		// need to add compare button and view common words button
	}
}
