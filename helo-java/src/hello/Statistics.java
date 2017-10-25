package hello;
public class Statistics {
	public static final int NUM_ITERATIONS = 100000;
	public static void main(String[] args) {
		
		long sum = 0;
		for (int i = 0; i < NUM_ITERATIONS; i++) {
			double r = 0;
			while (r < 0.99d) {
				r = Math.random();
				sum ++;
			}
//			System.out.println(sum);
		}
		System.out.println("Average: " + ((double)sum) / NUM_ITERATIONS);
	}
}