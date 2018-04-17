package toto;

import java.util.Random;

public class Drawing {
	public static final int MAX_NUMBER = 9;

	private static int[] numbers = new int[7];
	private static Random rand = new Random();

	public static void main(String[] args) {
		for(int i = 0;  i < numbers.length; i++) {		
			boolean found;
			do {
				// draw number
				numbers[i] = rand.nextInt(MAX_NUMBER) + 1;
				// test not found
				found = false;
				for(int j = 0; j < i; j++) {
					if(numbers[j] == numbers[i]) 
						found = true;
				}
			} while(found);
		}
		
		for(int  num: numbers) {
			System.out.println(num);
		}
		
		System.out.println("Osnowni:");
		for(int i = 0;  i < numbers.length - 2; i++) {
			System.out.println((i+1) + ". " + numbers[i]);
		}
		
		System.out.println("Dopalnitelni:");
		for(int i = numbers.length - 2;  i < numbers.length; i++) {
			System.out.println((i - numbers.length + 3) + ". " + numbers[i]);
		}

	}

}
