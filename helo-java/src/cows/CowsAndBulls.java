package cows;

import java.util.Arrays;
import java.util.Random;

public class CowsAndBulls {
	public static int DIGITS = 4;
	public static int TRIES = 6;
	
	private static Random rand = new Random();

	public static void main(String[] args) {
		int[] chosenNumber = new int[DIGITS];
		chosenNumber[0] = rand.nextInt(9) + 1;
		for(int i = 1; i < DIGITS; i++) {
			chosenNumber[i] = rand.nextInt(10);
		}
		System.out.println(Arrays.toString(chosenNumber));
	}
	
	
	public static String numberToString(int[] digits) {
		StringBuilder result = new StringBuilder();
		for(int digit: digits) {
			result.append(digit);
		}
		return result.toString();
	}

}
