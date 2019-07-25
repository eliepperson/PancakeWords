/* PancakeWords.java 
 * 
 * PancakeWords.java takes as input an integer and outputs "pancake words" that are the same length as that integer. Pancake words have the following qualities:
 * 1. They are words that can be found in a dictionary (e.g., a text file, such as the one provided, which contain a list of words). 
 * 2. If you remove the last letter of a pancake word, the resulting word will also be a pancake word. 
 * 
 * See README for more info
 * 
 * Eli Epperson 
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class PancakeWords {

	public static ArrayList<String> getPancakeWords(ArrayList<String> currentPancakes, ArrayList<ArrayList<String> >dic) {
		ArrayList<String> results = new ArrayList<String>();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		for (int i=0; i<currentPancakes.size(); i++) {
			String pancakeAtIndex = currentPancakes.get(i);
			String firstLetter = String.valueOf(pancakeAtIndex.charAt(0));
			
			// Get the position in the alphabet of the first letter of the word
			// at index i of currentPancakes. 
			int index = alphabet.indexOf(firstLetter);
		
			// Determine if the result of adding a letter to the end of a
			// pancake word results in a dictionary word. 
			for (int j=0; j<26; j++) {
				String test = currentPancakes.get(i) + String.valueOf(alphabet.charAt(j));
				
				if (dic.get(index).contains(test)) {
					results.add(test);
				}
			}
		}
		return results;
		
	}
	
	public static void main(String[] args) {
		String input;
		Scanner scan = new Scanner(System.in);
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		System.out.println("Enter height of pancake word.");
		input = scan.nextLine();
		
		System.out.println("Finding pancake words...");

		ArrayList<String> pancakeWords = new ArrayList<String>();
		
		// Populate pancakeWords with each letter of the alphabet,
		// assuming that each letter can be a word on its own.
		
		for (int i=0; i<26; i++) {
			pancakeWords.add(String.valueOf(alphabet.charAt(i)));
		}
		
		String desktop = System.getProperty ("user.home") + "/Desktop/";
		File inputFile = new File(desktop + "words_alpha.txt");
		Scanner in = null;
		
		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException fnf) {
			System.out.println("Could not open input file.");
		}
		
		// An ArrayList of ArrayLists. The outer ArrayList is of size 26.
		// Each of the 26 inner ArrayLists corresponds to a respective letter
		// of the alphabet. 
	   	ArrayList<ArrayList<String> > dictionary =  
    			new ArrayList<ArrayList<String> >(26); 
	   	
	   	// Populate dictionary with empty ArrayList<String> objects
	   	for (int i=0; i<26; i++) {
	   		ArrayList<String> singleLetterArray = new ArrayList<String>();
	   		dictionary.add(i, singleLetterArray);
	   	}
		
		// Populate dictionary 
	   	int letterCount = -1; 
		while (in.hasNext()) {
			String word = in.next();
			
			// Do not add single letter words to dictionary
			if (word.length() == 1) {
				letterCount++;
			
			} else {
				dictionary.get(letterCount).add(word);
			}
		}
		
		for (int i=0; i<Integer.parseInt(input)-1; i++) {
			pancakeWords = getPancakeWords(pancakeWords, dictionary);
		}
		
		System.out.println("Pancake words of length "+ input+ " are:\n"+pancakeWords.toString());
		scan.close();
	}

}
