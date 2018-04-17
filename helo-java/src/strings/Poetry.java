package strings;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;

public class Poetry {
	public static final String NOUNS =
			"Java, program, interval, wizard, dream, feeling, wonder";
	public static final String ADJECTIVES =
			"green, famous, wonderful, best, super, awful, rich, boring";
	public static final String VERBS =
			"become, reset, enter, love, hate, restrict, start";
	public static final String PREPOSITIONS =
			"at, of, from, into, on";
	public static final String PUNCTUATION = ".,?!";
	
	private static String[] nouns = NOUNS.split(", ");
	private static String[] adj = ADJECTIVES.split(", ");
	private static String[] verbs = VERBS.split(", ");
	private static String[] preps = PREPOSITIONS.split(", ");
	private static char[]  punct = PUNCTUATION.toCharArray();
	
	
	private static Random rand = new Random();

	
	private static String getRandomElement(String[] array) {
		return array[rand.nextInt(array.length)];
	}
	
	// Overloaded method
	private static char getRandomElement(char[] array) {
		return array[rand.nextInt(array.length)];
	}
	
	private static String getLine() {
		return String.format("%s %s %s %s %s %s", 
				getRandomElement(adj),
				getRandomElement(nouns),
				getRandomElement(verbs),
				getRandomElement(preps),
				getRandomElement(adj),
				getRandomElement(nouns)
		);
	}
	
	public static String getStrofa() {
		StringBuilder resultBuilder = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			StringBuilder lineBuilder = new StringBuilder(getLine());
			lineBuilder
				.setCharAt(0, 
					Character.toUpperCase(lineBuilder.charAt(0)));
			resultBuilder
				.append(lineBuilder)
				.append(getRandomElement(punct))
				.append("\n");
		}
		return resultBuilder.toString();
	}
	
	public static void main(String[] args) {
		
//		System.out.println(Arrays.toString(nouns));
//		System.out.println(Arrays.toString(adj));
//		System.out.println(Arrays.toString(verbs));
//		System.out.println(Arrays.toString(preps));
		
		System.out.println(getStrofa());
		

	}

}
