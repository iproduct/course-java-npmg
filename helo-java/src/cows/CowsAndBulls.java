package cows;

import java.util.Random;
import java.util.Scanner;

public class CowsAndBulls {
	public static final int DIGITS = 4;
	public static final int TRIES = 6;

	private static Random rand = new Random();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] chosenNumber = new int[DIGITS];
		chosenNumber[0] = rand.nextInt(9) + 1;
		for (int i = 1; i < DIGITS; i++) {
			boolean unique;
			do {
				chosenNumber[i] = rand.nextInt(10);
				unique = true;
				for (int j = 0; j < i; j++) {
					if (chosenNumber[i] == chosenNumber[j]) {
						unique = false;
					}
				}
			} while (!unique);
		}
		System.out.println(numberToString(chosenNumber));
		
		// Read the guess
		boolean valid;
		System.out.print("Your guess:");
		int[] guessedNumber = new int[DIGITS];
		
		do {
			String guessStr = scanner.nextLine();
			char[] guessedDigits = guessStr.toCharArray();
			valid = true;
			
			for(int i = 0; i < DIGITS; i++) {
				if(Character.isDigit(guessedDigits[i])) {
					guessedNumber[i] = guessedDigits[i] - '0';
				} else {
					System.out.println("Invalid number: " + guessStr + ". Try again :)");
					valid = false;
					break;
				}
			} 
		} while ( !valid );
		
		System.out.println(numberToString(guessedNumber));
		
		
	}

	public static String numberToString(int[] digits) {
		StringBuilder result = new StringBuilder();
		for (int digit : digits) {
			result.append(digit);
		}
		return result.toString();
	}

}
