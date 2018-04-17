package broenka;

import java.util.Arrays;
import java.util.Scanner;

public class Broenka {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Number participants: ");
		int n = sc.nextInt();
		System.out.print("Number words: ");
		int m = sc.nextInt();
		
		int[] participants = new int[n];
		int rest = n;
		int current = 0;
		for(int i = 0; i < participants.length; i++)
			participants[i] = i;
		
		while(rest > 1) {
			int nextToRemove = (current - 1 + m) % rest;
			remove(participants, rest, nextToRemove);
			current = nextToRemove;
			rest--;
		}
		
		System.out.println("Last participnt: " + (participants[current] + 1));
		
	}

	private static void remove(int[] p, int rest, int i) {
		for(int j = i; j < rest - 1; j++ )
			p[j] = p[j+1];
		System.out.println(Arrays.toString(p));
	}
}
