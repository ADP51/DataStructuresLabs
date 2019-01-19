package Default;

import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {
	private TreeMap<String, Integer> dictionary = new TreeMap<String, Integer>();

	public void insertFromFile(Scanner inFile) {
		String word;
		while (inFile.hasNextLine()){
			word = inFile.next();
			word.replaceAll("^\\s","");
			word.toLowerCase();
			dictionary.put(word, 1);
		}
	}


}
