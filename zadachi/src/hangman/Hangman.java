package hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
	public static final int MAX_TRIES = 5;
	private static String word = "liberty";
	private static int tries = MAX_TRIES;
	private static boolean guessed = false;
	private static Scanner sc = new Scanner(System.in);
	private static char[] chars = new char[word.length()];

	public static void main(String[] args) {
		Arrays.fill(chars, '*');

		do {
			System.out.print("Guess a letter:");
			String guessStr = sc.nextLine();
			char ch = guessStr.charAt(0);
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == ch) {
					chars[i] = ch;
				}
			}
			System.out.println(new String(chars) + ", " + --tries + " tries left.");
			if (new String(chars).equals(word)) {
				guessed = true;
			}

		} while (!guessed && tries > 0);
		if (guessed) {
			System.out.println("Congratulations you win!");
		} else {
			System.out.println("Sorry you loose!");
		}
	}

}