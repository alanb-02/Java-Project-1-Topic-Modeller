package com.topic.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TopicModelGUI extends JFrame implements ActionListener{
	
	// attributes
	JFileChooser ch_file1;
	JLabel label1, label2, label3; 
	JButton chFile_B1, chFile_B2, compare_B, details_B;
	JPanel panel1, panel2;
	private File file_1, file_2;
	private List<String> final_List;
	
	// constructors
	public TopicModelGUI(List<String> final_List) {
		this.final_List = final_List;
	}
	
	// getting and setting the 2 documents
	public File getFile_1() {
		return file_1;
	}
	public void setFile_1(File file_1) {
		this.file_1 = file_1;
	}
	public File getFile_2() {
		return file_2;
	}
	public void setFile_2(File file_2) {
		this.file_2 = file_2;
	}
	public List<String> getFinal_List() {
		return final_List;
	}
	public void setFinal_List(List<String> final_List) {
		this.final_List = final_List;
	}
	
	
	// constructors
	TopicModelGUI(String title){
		
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
		chFile_B1.addActionListener((ActionListener) this);
		chFile_B2 = new JButton("Select");
		chFile_B2.setToolTipText("Select a file");
		chFile_B2.setBackground(Color.white);
		chFile_B2.addActionListener((ActionListener) this);
		// creating the buttons to compare_B and to display the common words
		compare_B = new JButton("Compare");
		compare_B.setToolTipText("Find the Topic");
		compare_B.setBackground(Color.gray);
		compare_B.addActionListener((ActionListener) this);
		details_B = new JButton("Details");
		details_B.setToolTipText("The common words");
		details_B.setBackground(Color.gray);
		details_B.addActionListener((ActionListener) this);
		
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
		panel1.add(compare_B);
		panel1.add(Box.createRigidArea(new Dimension(0,10)));
		// aligns all the components in the panel to the center
		label3.setAlignmentX(Component.CENTER_ALIGNMENT);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		chFile_B1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		chFile_B2.setAlignmentX(Component.CENTER_ALIGNMENT);
		compare_B.setAlignmentX(Component.CENTER_ALIGNMENT);
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
		panel2.add(details_B);
		panel2.add(Box.createRigidArea(new Dimension(0,10)));
		details_B.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(panel2);
		
		// makes all the components of the GUI visible
		setVisible(true);
	}
	
	// method that opens the file chooser and allows the user to select the file
	public File chooseFile(int button_num) {
		// creating the file chooser
		JFileChooser fileChooser = new JFileChooser();
		// setting the current directory
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		// showing the dialog
		int result = fileChooser.showOpenDialog(TopicModelGUI.this);
		// checks if the users selects a file
		if(result == JFileChooser.APPROVE_OPTION) {
			// assigning the selected file (including path)
		    File selectedFiles = fileChooser.getSelectedFile();
		    // assigning the files depending on the button selected
		    if(button_num == 1) {
		    	this.file_1 = selectedFiles;
		    	chFile_B1.setBackground(Color.green);
		    	return this.file_1;
		    }
		    else if(button_num == 2) {
		    	this.file_2 = selectedFiles;
		    	chFile_B2.setBackground(Color.green);
		    	return this.file_2;
		    }
		}
		// if the no file is selected, pop up message appears
		else if(result == JFileChooser.CANCEL_OPTION){
			JOptionPane.showMessageDialog(this, "Not a valid file selection !!!");
			// assigning the files as null with relation to the button pressed and if no file is selected
			if(button_num == 1) {
				// change color of button to red if no file is chosen
				chFile_B1.setBackground(Color.red);
				this.file_1 = null;
				return this.file_2;
			}
			else if(button_num == 2) {
				// change color of button to red if no file is chosen
				chFile_B2.setBackground(Color.red);
				this.file_2 = null;
				return this.file_2;
			}
		}
		 return this.file_1;
	}
	
	// event handler - for selecting the 2 files and more details
	public void actionPerformed(ActionEvent e) {
		// file chooser 1
		if(e.getSource() == chFile_B1) {
			// choosing the first file
			chooseFile(1);
			// print the file path
			System.out.print(this.file_1);
		}
		// file chooser 2
		else if(e.getSource() == chFile_B2) {
			// choosing the second file
			chooseFile(2);
			// printing the file path
			System.out.print(getFile_2());
		}
		// button to compare files
		else if(e.getSource() == compare_B) {
			// getting the file paths for the 2 files
			String path1 = this.file_1.getAbsolutePath();
			String path2 = this.file_2.getAbsolutePath();
			// file processor object to take the 2 file paths
			FileProcessor file_Process1  = new FileProcessor(path1, path2);
			try {
				// reading the file
				file_Process1.readFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}               
		// button for more details
		else if(e.getSource() == details_B) {
			// pop up to show the common words among the 2 files 
			if(this.final_List != null) {
				moreDetails();
			}
			else {
				JOptionPane.showMessageDialog(null, "!!!You have to first compare the 2 files!!!");
			}
			
		}
	}
	
	
	public List<String> retrieveFinalList(List<String> f_List1) {
		this.final_List = f_List1;
		
		return this.final_List;
		
	}
	
	// method to display the common words of the 2 lists in a option pane
	public void moreDetails() {
		// string builder to convert the contents of the list into a string
		StringBuilder strbuild = new StringBuilder();
		// for loop adds the seperate words in the list into a string
		for(String wrds : this.final_List) {
			strbuild.append(wrds);
			strbuild.append("\n");
		}
		// creating the string to asign the string builder
		String str = strbuild.toString();
		// pop up to show the contents of teh list
		JOptionPane.showMessageDialog(this,"The common words are: \n" + str);
	}	
}
