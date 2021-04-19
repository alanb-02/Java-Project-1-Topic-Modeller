package com.topic.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileProcessor {
	
	/******************
	 * Class: class deals with reading through the files and putting them into lists
	 * Author: Alan Byju
	 * Date 07/04/2021
	 ******************/
	
	// attributes
	// 2 paths of the file to compare
	// the files 
	private String filename1, filename2;
	private File edited_File1, edited_File2;
	private String final_List;

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
	
	// method takes in the file paths and sets the attributes
	public void setFiles(String filename1, String filename2) {
		this.filename1 = filename1;
		this.filename2 = filename2;
	}
	
	// method reads the contents of the file and add each word to the list
	public List<String> readFile() throws IOException {
		// opens the file
		openFile();
		// creates 2 list to hold the words from the files
		List<String> wordList1 = new ArrayList<String>();
		List<String> wordList2 = new ArrayList<String>();
		
		try {
			// using the scanner methods for the files
			Scanner filescan1 = new Scanner(edited_File1);
			Scanner filescan2 = new Scanner(edited_File2);
			
			// while there is word next in the file
			while(filescan1.hasNext()) {
				// assigning the words from the file as a string
				String words1 = filescan1.next();
				// removing the punctuation 
				words1 = words1.replaceAll("\\p{Punct}", "");
				// removing the numbers
				words1 = words1.replaceAll("\\d","");
				// making all characters of the string lowercase
				words1 = words1.toLowerCase();
				// adding the word to the list
				wordList1.add(words1);
				
			}
			// while there is word next in the file
			while(filescan2.hasNext()) {
				// assigning the words from the file as a string
				String words2 = filescan2.next();
				// removing the punctuation 
				words2 = words2.replaceAll("\\p{Punct}", "");
				// removing the numbers
				words2 = words2.replaceAll("\\d","");
				// making all characters of the string lowercase
				words2 = words2.toLowerCase();
				// adding the word to the list
				wordList2.add(words2);
			}
			
			// removing the stop words from the file lists
			removeStopWords(wordList1);
			removeStopWords(wordList2);
			ModelCalculator model_calc = new ModelCalculator(wordList1, wordList2);
			// changing the list to common words 
			wordList1 = model_calc.commonInList(wordList1);
			// changing the list to common words 
			wordList2 = model_calc.commonInList(wordList2);
			// comparing the common word of the 2 lists
			this.final_List = model_calc.comparingLists(wordList1, wordList2);
			
			// closing the scanner
			filescan1.close();
			filescan2.close();
		}
		// exception if files are not found
		catch(FileNotFoundException e){
			System.out.println("Could not find the file");
			e.printStackTrace();
		}
		return wordList2;
	}
	
	// method to remove the stop words from the file lists
	public void removeStopWords(List<String> arr) throws IOException{
		// the line below was to take the stop words straight from a file, but since the file path would be different when you review the code
		// List<String> stop_Words_List = Files.readAllLines(Paths.get("C:\\Users\\mathe\\OOP-ca2-TM\\Topic Modeller\\src\\stop-words.txt"));
		// array that contains all the stop words
		String[] array={"a","about","above","after","again","against", "ain", "aint", "all","am","an","and","any","are","aren","arent","as","at","be","because","been","before","being","below","between","both","but","by","can","couldn","couldn't","d","did","didn","didn't","do","does","doesn","doesn't","doing","don","don't","down","during","each","few","for","from","further","had","hadn","hadn't","has","hasn","hasn't","have","haven","haven't","having","he","her","here","hers","herself","him","himself","his","how","i","if","in","into","is","isn","isn't","it","it's","its","itself","just","ll","m","ma","me","mightn","mightn't","more","most","mustn","mustn't","my","myself","needn","needn't","no","nor","not","now","o","of","off","on","once","only","or","other","our","ours","ourselves","out","over","own","re","s","same","shan","shan't","she","she's","should","should've","shouldn","shouldn't","so","some","such","t","than","that","that'll","the","their","theirs","them","themselves","then","there","these","they","this","those","through","to","too","under","until","up","ve","very","was","wasn","wasn't","we","were","weren","weren't","what","when","where","which","while","who","whom","why","will","with","won","won't","wouldn","wouldn't","y","you","you'd","you'll","you're","you've","your","yours","yourself","yourselves","could","he'd","he'll","he's","here's","how's","i'd","i'll","i'm","i've","let's","ought","she'd","she'll","that's","there's","they'd","they'll","they're","they've","we'd","we'll","we're","we've","what's","when's","where's","who's","why's","would","able","abst","accordance","according","accordingly","across","act","actually","added","adj","affected","affecting","affects","afterwards","ah","almost","alone","along","already","also","although","always","among","amongst","announce","another","anybody","anyhow","anymore","anyone","anything","anyway","anyways","anywhere","apparently","approximately","arent","arise","around","aside","ask","asking","auth","available","away","awfully","b","back","became","become","becomes","becoming","beforehand","begin","beginning","beginnings","begins","behind","believe","beside","besides","beyond","biol","brief","briefly","c","ca","came","cannot","can't","cause","causes","certain","certainly","co","com","come","comes","contain","containing","contains","couldnt","date","different","done","downwards","due","e","ed","edu","effect","eg","eight","eighty","either","else","elsewhere","end","ending","enough","especially","et","etc","even","ever","every","everybody","everyone","everything","everywhere","ex","except","f","far","ff","fifth","first","five","fix","followed","following","follows","former","formerly","forth","found","four","furthermore","g","gave","get","gets","getting","give","given","gives","giving","go","goes","gone","got","gotten","h","happens","hardly","hed","hence","hereafter","hereby","herein","heres","hereupon","hes","hi","hid","hither","home","howbeit","however","hundred","id","ie","im","immediate","immediately","importance","important","inc","indeed","index","information","instead","invention","inward","itd","it'll","j","k","keep","keeps","kept","kg","km","know","known","knows","l","largely","last","lately","later","latter","latterly","least","less","lest","let","lets","like","liked","likely","line","little","'ll","look","looking","looks","ltd","made","mainly","make","makes","many","may","maybe","mean","means","meantime","meanwhile","merely","mg","might","million","miss","ml","moreover","mostly","mr","mrs","much","mug","must","n","na","name","namely","nay","nd","near","nearly","necessarily","necessary","need","needs","neither","never","nevertheless","new","next","nine","ninety","nobody","non","none","nonetheless","noone","normally","nos","noted","nothing","nowhere","obtain","obtained","obviously","often","oh","ok","okay","old","omitted","one","ones","onto","ord","others","otherwise","outside","overall","owing","p","page","pages","part","particular","particularly","past","per","perhaps","placed","please","plus","poorly","possible","possibly","potentially","pp","predominantly","present","previously","primarily","probably","promptly","proud","provides","put","q","que","quickly","quite","qv","r","ran","rather","rd","readily","really","recent","recently","ref","refs","regarding","regardless","regards","related","relatively","research","respectively","resulted","resulting","results","right","run","said","saw","say","saying","says","sec","section","see","seeing","seem","seemed","seeming","seems","seen","self","selves","sent","seven","several","shall","shed","shes","show","showed","shown","showns","shows","significant","significantly","similar","similarly","since","six","slightly","somebody","somehow","someone","somethan","something","sometime","sometimes","somewhat","somewhere","soon","sorry","specifically","specified","specify","specifying","still","stop","strongly","sub","substantially","successfully","sufficiently","suggest","sup","sure","take","taken","taking","tell","tends","th","thank","thanks","thanx","thats","that've","thence","thereafter","thereby","thered","therefore","therein","there'll","thereof","therere","theres","thereto","thereupon","there've","theyd","theyre","think","thou","though","thoughh","thousand","throug","throughout","thru","thus","til","tip","together","took","toward","towards","tried","tries","truly","try","trying","ts","twice","two","u","un","unfortunately","unless","unlike","unlikely","unto","upon","ups","us","use","used","useful","usefully","usefulness","uses","using","usually","v","value","various","'ve","via","viz","vol","vols","vs","w","want","wants","wasnt","way","wed","welcome","went","werent","whatever","what'll","whats","whence","whenever","whereafter","whereas","whereby","wherein","wheres","whereupon","wherever","whether","whim","whither","whod","whoever","whole","who'll","whomever","whos","whose","widely","willing","wish","within","without","wont","words","world","wouldnt","www","x","yes","yet","youd","youre","z","zero","a's","ain't","allow","allows","apart","appear","appreciate","appropriate","associated","best","better","c'mon","c's","cant","changes","clearly","concerning","consequently","consider","considering","corresponding","course","currently","definitely","described","despite","entirely","exactly","example","going","greetings","hello","help","hopefully","ignored","inasmuch","indicate","indicated","indicates","inner","insofar","it'd","keep","keeps","novel","presumably","reasonably","second","secondly","sensible","serious","seriously","sure","t's","third","thorough","thoroughly","three","well","wonder"};
		// list for the stop words
		List<String> stop_Words_List = new ArrayList<String>();
		
		// for loop adds the values from the array to the list
		for(String w:array) {
			stop_Words_List.add(w);
		}
		// iterator for the word in the file
		Iterator<String> itr = arr.iterator();
		
		while(itr.hasNext()) {
			// assigning the next iterator value 
			String word = itr.next();
			// if the word from the stop words list matches the word in the arr list
			// remove the word from the arr list
			if(stop_Words_List.contains(word)) {
				itr.remove(); 
			}
		}
	}
	
	// method to open panel to display the common words 
	public void printFinalString() {
		JOptionPane.showMessageDialog(null, "The matching words are: \n" + this.final_List);
	}
}
