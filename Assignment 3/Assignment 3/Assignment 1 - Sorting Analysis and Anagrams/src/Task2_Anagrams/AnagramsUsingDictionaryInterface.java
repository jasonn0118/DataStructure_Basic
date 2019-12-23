package Task2_Anagrams;
import java.util.*;

import DictionaryPackage.*;
import HashingPackage.*;

import java.io.*;

public class AnagramsUsingDictionaryInterface {
	public static void main(String[] args) throws IOException {
		
		// comment out one of these lines to test
		
//		DictionaryInterface<String, ArrayList<String>> anagrams = new HashedDictionary<String, ArrayList<String>>();
		DictionaryInterface<String, ArrayList<String>> anagrams = new HashMapDictionary<String, ArrayList<String>>();
		
		String[] testWords = {
				"thesis",
				"server",
				"sublet",
				"reverse",
				"retraced",
				"stripes",
				"evils",
				"nailset",
				"reliant",
				"demo",
				"deer",
				"rifles",
				"baritone",
				"pointer",
				"cobra",
				"strip",
				"sterling",
				"earliest",
				"rowth",
				"reshoot",
				"presplit",
				"teach",
				"scare",
				"bread",
				"outrage"
		};

		// get all anagrams for all words in the file.

		createAnagrams("src\\Task2_Anagrams\\dictionary.txt", anagrams);

		// display all anagrams for the list of test words to the console
		
		System.out.println("******** Showing anagrams for test words");
		
		// insert your code here to display the anagrams for the test words above.
		// the output should match anagramsTestWordsOutput.txt exactly
		Iterator<ArrayList<String>> testWordsList = anagrams.getValueIterator();
		for(String key: testWords) {
			System.out.println("Anagrams for "+key+" ["+anagrams.getValue(key)+"] ");
//			System.out.println(anagrams.getValue(key));
		}
		
		
		
		// insert your code here to write all keys and values to the anagrams.txt file.
		// use the iterators to do this.
		// the output should match anagramsAssignmentOutput.txt exactly
		
		
		// open the output file
		
		PrintWriter outputFile = new PrintWriter("src\\Task2_Anagrams\\anagrams.txt");		
		outputFile.println("********* Showing all keys and anagrams - total = " + anagrams.size());
		
		//Make iterator to get keys from anagrams Dictionary.
		Iterator<String> keyAndAnagramList = anagrams.getKeyIterator();
		Iterator<ArrayList<String>> valueAndAnagramList =anagrams.getValueIterator();
		while(keyAndAnagramList.hasNext()) {//until it exists.
			String keyElement = keyAndAnagramList.next();//get key from Iterator
//			ArrayList<String> values = valueAndAnagramList.
			outputFile.println(keyElement+" : "+anagrams.getValue(keyElement));
		}
		
		outputFile.close();
		
		// insert your code here to write all keys and values of the anagrams hash table to the file
		// the output should match the anagramsAssignmentOutput.txt file exactly
		
		

	}

	/**
	 * Sorts a word by its characters and places them in the output string
	 * @param word
	 * @return string of sorted letters based on the input
	 */
	private static String sortString(String word) {
		char[] wordCharacters = word.toCharArray();
		Arrays.sort(wordCharacters);
		return new String(wordCharacters);
	}

	/**
	 * Create a list of anagrams from a dictionary file and place into a Dictionary. An anagram has key which is a set
	 * of sorted characters, and a value consisting of an array of strings that are legal words in the dictionary that match
	 * the characters in the key.
	 * 
	 * anagramsMap for this assignment must use a hash table.
	 * @param fileName for dictionary words. Each word in the file should be on a separate line.
	 * @param anagramsMap resulting anagrams table
	 * @throws IOException
	 */
	private static void createAnagrams(String fileName, DictionaryInterface<String, ArrayList<String>> anagramsMap)
			throws IOException {
		
		// Insert your code here
		System.out.println("I'm in CreateAnagram method!");
		
		//Make File.
		File myFile = new File(fileName);
		Scanner myScan = new Scanner(myFile);
		ArrayList targetList; //create target arraylist.
		while(myScan.hasNextLine()) {
//			System.out.println("I'm in the While loop");
			targetList = new ArrayList<String>();		
			String stringValue = myScan.nextLine();//put value on the string
//			System.out.println("This is value String: "+stringValue);
			String stringKey = sortString(stringValue);//put sorted string value as a key.
//			System.out.println("This is key: "+stringKey);
		
			//Check the key exists or not.
			if(anagramsMap.contains(stringKey)) {
//				System.out.println("I'm in the if statement");
				targetList = anagramsMap.getValue(stringKey);//if key exists, get value from Dictionary.
//				System.out.println("AnagramsMap key: "+anagramsMap.getValue(stringKey));
			}
			
			//Adding values.
			targetList.add(stringValue);
			anagramsMap.add(stringKey, targetList);
			
			myScan.close();
			
			
			
		}
		System.out.println("This is end of method.");				

	}

}
