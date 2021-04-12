package com.topic.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModelCalculator {
	
	// attributes
	private List<String> f1_List, f2_List, comp_List;
	private int similarity_Percent;
	
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

	public List<String> getComp_List() {
		return comp_List;
	}

	public void setComp_List(List<String> comp_List) {
		this.comp_List = comp_List;
	}

	public int getSimilarity_Percent() {
		return similarity_Percent;
	}

	public void setSimilarity_Percent(int similarity_Percent) {
		this.similarity_Percent = similarity_Percent;
	}
	
	// method to calculate the top 10 most occurring words in the lists
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
		/* displaying the elements of the arraylist
		for (Map.Entry<String, Integer> m : list_TMap.entrySet()) {
            System.out.println("Frequency of " + m.getKey() + " is " + m.getValue());
		}*/
		// hashmap will be sorted in descending order of occurrences
		Map<String, Integer> sorted_Map = list_TMap.entrySet().stream().sorted(Comparator.comparingInt(e -> -e.getValue())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(a, b) -> { throw new AssertionError(); },LinkedHashMap::new));
		// sorted_Map.entrySet().forEach(System.out::println);
		// list will hold the sorted map
		List<String> key_List = new ArrayList<String>(sorted_Map.keySet());
		
		// list will hold the top 10 most occurring words in the above list
		List<String> common_Word_List = new ArrayList<String>();
		
		// for loop to assign the top 10 words into the new list
		for(int i = 0; i < 10; i++) {
			common_Word_List.add(key_List.get(i)); 
		}
		System.out.println(common_Word_List);
		
		return common_Word_List;
	}
	
	
	

	
}
