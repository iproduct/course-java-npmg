package arrays_11a;

import java.util.Arrays;
import java.util.Scanner;

public class StringInput {
	
	public static int findIndex(
			String[] array, int arrayLength, String element) {
		for(int i = 0; i < arrayLength; i++) {
			if(array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input text: ");
		String line = sc.nextLine();
		System.out.println(line);
		String[] words = line.split("[,;\\-\\.!? ] *");
		System.out.println("Words: " + Arrays.toString(words));
		String[] uniqueWords = new String [words.length];
		int uniqueWordsCount = 0;
		for(String word : words) {
			if( findIndex(uniqueWords, uniqueWordsCount, word) < 0) {
				uniqueWords[uniqueWordsCount++] = word;
			}
		}
		System.out.println("Uniques words: " + Arrays.toString(words));

	}

}
