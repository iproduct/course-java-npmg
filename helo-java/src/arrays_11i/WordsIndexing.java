package arrays_11i;

import java.util.Arrays;
import java.util.Scanner;

class WordCountTupple {
	String word;
	int count;
}

public class WordsIndexing {

	private static int findIndex(
			String[] array, int count, String element) {
		for(int i = 0;  i < count; i++) {
			if(array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// 1. Input text
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input text:");
		String text = scanner.nextLine();
		System.out.println(text);
		
		// 2. Tokenizing text
		String[] words = text.split("[\\s,\\.!\\?\\-\\(\\):;]+");
		System.out.println(Arrays.toString(words));
		
		// 3. Compute unique words counts
		String[] uniqueWords = new String[words.length];
		int[] uniqueWordCounts = new int[words.length];
		int counter = 0;
		for(String word: words) {
			int index = findIndex(uniqueWords, counter, word);
			if (index < 0) { // new word
				uniqueWords[counter] = word;
				uniqueWordCounts[counter] = 1;
				counter++;
			} else { // repeated word
				uniqueWordCounts[index] ++;
			}
		}
		
		// 4. Print words & counts
		for(int i =0; i < counter; i++) {
			System.out.println(	String.format(
					"%s -> %d", uniqueWords[i], uniqueWordCounts[i]));
		}
	}

}
