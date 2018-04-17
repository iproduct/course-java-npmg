package arrays_11i;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class WordCountTupple  implements Comparable<WordCountTupple> {
	String word;
	int count;
	
	@Override
	public String toString() {
		return String.format("WordCountTupple [word=%s, count=%s]", word, count);
	}

	@Override
	public int compareTo(WordCountTupple o) {
		return this.count < o.count ? 1 : this.count == o.count ? 0 : -1;
	}

	
}

public class WordsIndexing {

	private static int findIndex(
			WordCountTupple[] array, int count, String element) {
		for(int i = 0;  i < count; i++) {
			if(array[i].word.equals(element)) {
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
		WordCountTupple[] tupples = new WordCountTupple[words.length];
		int counter = 0;
		for(String word: words) {
			int index = findIndex(tupples, counter, word);
			if (index < 0) { // new word
				tupples[counter] = new WordCountTupple();
				tupples[counter].word = word;
				tupples[counter].count = 1;
				counter++;
			} else { // repeated word
				tupples[index].count ++;
			}
		}
		
		// 4. Print words & counts
		for(int i =0; i < counter; i++) {
			System.out.println(	String.format(
					"%s -> %d", tupples[i].word, tupples[i].count));
		}
		
		// 5. Sort by count
		WordCountTupple[] results = Arrays.copyOf(tupples, counter);
		Arrays.sort(results);
		for(int i =0; i < counter; i++) {
			System.out.println(	results[i]);
		}
	}

}
