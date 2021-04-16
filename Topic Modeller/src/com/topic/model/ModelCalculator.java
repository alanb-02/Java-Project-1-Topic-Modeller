package com.topic.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

public class ModelCalculator {
	
	// attributes
	private List<String> f1_List, f2_List;
	private double similarity_Percent;
	
	// constructor 
	public ModelCalculator(List<String> f1_List, List<String> f2_List) {
		this.f1_List = f1_List;
		this.f2_List = f2_List;
	}

	public List<String> getF1_List() {
		return f1_List;
	}

	public void setF1_List(List<String> f1_List) {
		this.f1_List = f1_List;
	}

	public List<String> getF2_List() {
		return f2_List;
	}

	public void setF2_List(List<String> f2_List) {
		this.f2_List = f2_List;
	}
	
	public double getSimilarity_Percent() {
		return similarity_Percent;
	}

	public void setSimilarity_Percent(double similarity_Percent) {
		this.similarity_Percent = similarity_Percent;
	}
	
	// method to calculate the top 20 most occurring words in the lists
	public List<String> commonInList(List<String> lists) {
		// hashmap to hold the word as the key and the number of occurrences as the value
		Map<String, Integer> list_TMap = new HashMap<String, Integer>();
		
		// for loop to assign the values of the list to the map
		for(String i : lists) {
			// assigning
            Integer j = list_TMap.get(i);
            //calculating the occurrences
            list_TMap.put(i, (j == null) ? 1 : j + 1);
        }
		
		// hashmap will be sorted in descending order of occurrences
		Map<String, Integer> sorted_Map = list_TMap.entrySet().stream().sorted(Comparator.comparingInt(e -> -e.getValue())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(a, b) -> { throw new AssertionError(); },LinkedHashMap::new));

		// list will hold the sorted map
		List<String> key_List = new ArrayList<String>(sorted_Map.keySet());
		// list will hold the top 20 most occurring words in the above list
		List<String> common_Word_List = new ArrayList<String>();
		
		// for loop to assign the top 20 words into the new list
		for(int i = 0; i < 20; i++) {
			common_Word_List.add(key_List.get(i)); 
		}
		System.out.println(common_Word_List);
		return common_Word_List;
		
	}
	
	// method to compare the two list and finding the common words between the two lists
	public List<String> comparingLists(List<String> m_Lists1, List<String> m_Lists2) {
		System.out.println("--------------------------------------------------------------------------------------------------------------------\n");
		
		// assign the common strings in between the two lists in the first list
		m_Lists1.retainAll(m_Lists2);
		// filtering the empty values in the list
		Stream <String> stream = m_Lists1.stream();
		// negating the values using predicate
		Predicate<String> empty = String::isEmpty;
		Predicate<String> emptyWrds = empty.negate();
		// assigning the removal to the list 
		m_Lists1 = stream.filter(emptyWrds).collect(Collectors.toList());
		
		// getting the number of common words
		int total = m_Lists1.size();
		System.out.println(m_Lists1);
		System.out.println(total);
		// method to calculate the percentage and takes in the number of common words
		calculatePercent(total);
		
		return m_Lists1;
	}
	
	
	// method to calculate the percentage of similarity
	public void calculatePercent(int total) {
		// convert into a double
		double total1 = total;
		// calculation
		this.similarity_Percent = (total1 / 20) * 100.0;
		
		//if percent == 40% or more the the files are similar
		if(this.similarity_Percent >= 40.0) {
			JOptionPane.showMessageDialog(null, "Similar topics. \n" + "Similarity percent: " + this.similarity_Percent + "%");
		}
		//if percent  == less than 40% the files are not similar
		else if(this.similarity_Percent < 40.0) {
			JOptionPane.showMessageDialog(null, "Not similar topics. \n" + "Similarity percent: " + this.similarity_Percent + "%");
		}
	}
	
}
