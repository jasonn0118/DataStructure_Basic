package DictionaryDriverPackage;

import java.util.Iterator;
import java.util.Scanner;

import ListWithIteratorsPackage.*;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * A driver that demonstrates the class Concordance.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 */
public class ConcordanceDemo {
	public static void main(String[] args) {

//		System.out.println("Current relative path is: " + System.getProperty("user.dir"));
//		Concordance wordIndex = new Concordance();
		CompletedConcordance wordIndex = new CompletedConcordance();

		String fileName = "DataFiles\\ConcordanceData.txt"; // could be read
		try {
			Scanner textReader = new Scanner(new File(fileName));
			wordIndex.readFile(textReader);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
			return;
		}

		System.out.println("Here is the concordance for the text read from the data file:");
		wordIndex.display();

		System.out.println("\nTest getLineNumbers(\"learning\")");

		ListWithIteratorInterface<Integer> lineList = wordIndex.getLineNumbers("learning");

		Iterator<Integer> listIterator = lineList.getIterator();
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		} 
		System.out.println();

		System.out.println("\n\nDone!");
	} 
} 

/*
 Here is the concordance for the text read from the data file:
 is 1 2
 labor 1
 learning 1 2
 lost 1
 perilous 2
 thought 1 2
 without 1 2
 
 Test getLineNumbers("learning")
 1 2
 
 
 Done!
 */
