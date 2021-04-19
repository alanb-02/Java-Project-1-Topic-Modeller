BASICS:
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-	This project will create a GUI base topic modeller. The purpose of this is to detect whetehr a set of documents are "about" the saem topic or not.
-	The tool should analyse the words in each document - and decide what the most common words are in each document.
-	Stop words should be exluded fro the analysis - {the, a, of, he, she, etc....} - http://www.lextek.com/manuals/onix/stopwords1.html .
-	The basic overlap of the top 10 words in each document should grade the likelihood of it being about the same topic should be produced - 7/10 = 70% means the chance that the same topic is very likely and if 4/10 = 40% then the topics must not be the same.

CLASSES:
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-	Control:
	>	Instatitiates the GUI window.

-	TopicModelGUI:
	>	Creates a window that contains mainly 3 Jbuttons - 2x selecting files + 1x displaying more details.
	>	The window generated conatins 2 panels that uses BorderLayout.
	>	chooseFile (method) opens the JFileChooser to allow the user to select the documents to compare by taking in the button number integer. 
	>	Event handler deals with the buttons and what happens when the user select the buttons in the window.

-	FileProcessor:
	>	openFile (method) opens the files by assigning the chosen file paths.
	> 	setFiles (method) takes in the paths of the files as trings and assigns them to the attributes of the class.
	>	readFile (method) reads every word in the 2 files and adds them to lists, using Scanners. Then the punctuations, numbers, are removes from the words. Then the words are lowercased.
	> 	removeStopWords (method) removes the stop words from the 2 lists of words from the 2 files. The stopwords are conatined in an array, which is then converted to a list. 
	>	printFinalString (method) open JOptionPanel to display the common words between the 2 files.

-	ModelCalculator:
	>	This class is used for the topic modelling part of the program. This includes finding the 10 most common words in the 2 altered lists of the files' words, and then comparing the 2 lists to see how many words match between the 2 lists.
	>	Then the percentage similarity is then calulated and sidplayed witha message, and dispaly more details.
	>	commonInList (method) to calculate the top 10 most occurring words in the lists by taking in the file lists one ata a time. Then a new HashMap(String, integer) is created to hold the words from the list and its occurances. This is then sorted in descending order, and the new list will have the value strings from the hashmap in them. Then find the 10 ten occuring words from that list and return it.
	>	comparingLists (method) compareS the two list and finds the common words between the two lists. If there are empty values in the list, they are removed. The total number of matches is calculated.
	>	calculatePercent (method) to calculate the percentage of sismilarity. This is done by dividing the number of words from compared list from the above method and then multiplying the result by 100.0 . Then the result is dispalyed, whetehr they are sililar or not.
	>	moreDetails (methods) displays teh common words of teh 2 lists as a JOptionPane - FOR MORE DETAILS BUTTON.

CORE FUNCTIONALITY:
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-	The core functionality will take in 2 files and put their contents (words) into a list, which is the altered to remove unnecassery stopwords. 
-	Then the occurances of the words in the lists are taken in as the values of a hashmap, which is then sorted in decsending order. 
-	Then the key Strings from this sorted HasMap is put into a new list with the order kept same. 
-	Then the soted new lists are compared to see how many words match, and those matching words are put into a new list. 
-	Then the percentage is calulated via a simple calulation and dispalyed similar or not.

OPTIONAL FUNCTIONALITY:
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-	Buttons change colour between red and green depending on whether the user selects a file or not.
-	FileChooser allows the user to selec the desired file.
-	The common words between the two documents are displayed when the user clicks the more details button.

IMPROVEMENTS TO ADD:
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-	Addition of the file name to the window once it is selected.
-	Ability to searc though the documents for words.
-	Extra exception handling.