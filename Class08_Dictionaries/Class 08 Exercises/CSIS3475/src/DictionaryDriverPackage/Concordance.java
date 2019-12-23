package DictionaryDriverPackage;

import java.util.Iterator;
import java.util.Scanner;

import DictionaryPackage.*;
import ListWithIteratorsPackage.*;

/**
 * A class that represents a concordance.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Uses one of the dictionary implementations, and needs AListWithIterator or 
 * LListWithIterator for the line list
 */
public class Concordance {
	
	private DictionaryInterface<String, ListWithIteratorInterface<Integer>> wordTable;

	public Concordance() {
		wordTable = new SortedVectorDictionary<>();
//		wordTable = new SortedArrayDictionary<>();
//		wordTable = new SortedLinkedDictionary<>();
//		wordTable = new SortedListDictionary<>();
	} 

	// Segment 20.20
	/**
	 * Reads a text file of words and creates a concordance.
	 * 
	 * @param data A text scanner for the text file of data.
	 */
	public void readFile(Scanner data) {
		int lineNumber = 1; // keep track of which line number we are on
 
		while (data.hasNext()) {
			String line = data.nextLine();
			line = line.toLowerCase();

			// read tokens delimited by white space
			
			Scanner lineProcessor = new Scanner(line);
			lineProcessor.useDelimiter("\\W+");
			
			while (lineProcessor.hasNext()) {
				String nextWord = lineProcessor.next();
				
				// look up the word in the existing dictionary, and find its list of lines
				
				ListWithIteratorInterface<Integer> lineList = wordTable.getValue(nextWord);
				
				// if there is no line list, add one, then add the word and linelist to dictionary

				if (lineList == null) { 
					// Create new list for new word; add list and word to index
					lineList = new AListWithIterator<Integer>();
//					lineList = new LListWithIterator<Integer>();
					wordTable.add(nextWord, lineList);
				} 

				// Add line number to end of list so list is sorted
				
				lineList.add(lineNumber);
			} 
			lineProcessor.close();
			lineNumber++;
		} 

		data.close();
	} 
	
	/**
	 *  Displays words and the lines in which they occur.
	 */
	public void display() {
		
		// Dictionary allows us to iterate through all keys and values.
		// We just need a type for each
		
		// notice how use of ListWithIteratorInterface allows us to not care what type of list is used
		
		Iterator<String> keyIterator = wordTable.getKeyIterator();
		Iterator<ListWithIteratorInterface<Integer>> valueIterator = wordTable.getValueIterator();
		while (keyIterator.hasNext()) {
			// Display the word
			System.out.print(keyIterator.next() + " ");

			// Get line numbers and iterator
			ListWithIteratorInterface<Integer> lineList = valueIterator.next();
			Iterator<Integer> lineListIterator = lineList.getIterator();

			// Display line numbers
			while (lineListIterator.hasNext()) {
				System.out.print(lineListIterator.next() + " ");
			} 

			System.out.println();
		} 
	} 

	/**
	 * Gets a list of all line numbers associated with the word
	 * @param word
	 * @return
	 */
	public ListWithIteratorInterface<Integer> getLineNumbers(String word) {
		return wordTable.getValue(word);
	} 
} 
