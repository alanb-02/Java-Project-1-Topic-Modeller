package com.topic.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {
	
	// attributes
	// private ArrayList file_ArrayL1, file_ArrayL2;
	private String filename1, filename2;
	private File edited_File1, edited_File2;
	
	// constructor
	public FileProcessor(String filename1, String filename2) {
		this.filename1 = filename1;
		this.filename2 = filename2;
	}

	// getter and setter for private attributes

	public String getFilename1() {
		return filename1;
	}

	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}

	public String getFilename2() {
		return filename2;
	}

	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}

	public File getEdited_File1() {
		return edited_File1;
	}

	public void setEdited_File1(File edited_File1) {
		this.edited_File1 = edited_File1;
	}

	public File getEdited_File2() {
		return edited_File2;
	}

	public void setEdited_File2(File edited_File2) {
		this.edited_File2 = edited_File2;
	}
	
	
	// method to open files
	public void openFile() {
		edited_File1 = new File(filename1);
		edited_File2 = new File(filename2);
	}
	
	@SuppressWarnings("resource")
	public List<String> readFile() {
		//String line = "";
		List<String> wordList1 = new ArrayList<String>();
		List<String> wordList2 = new ArrayList<String>();
		
		try {
			Scanner filescan1 = new Scanner(edited_File1);
			Scanner filescan2 = new Scanner(edited_File2);
			while(filescan1.hasNext() || filescan2.hasNext()) {
				String words1 = filescan1.next();
				String words2 = filescan2.next();
				return wordList1;
			}
			filescan1.close();
			filescan2.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Could not find the file");
			e.printStackTrace();
		}
		return wordList2;
	}
}
