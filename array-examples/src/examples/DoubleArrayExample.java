package examples;

import java.util.Arrays;
import java.util.Scanner;

public class DoubleArrayExample {
	private static Scanner sc = new Scanner(System.in);
	
	public static double[] inputDoubleArray() {
		System.out.print("Input number of elements: ");
		int n = sc.nextInt();
		double[] a = new double[n];
		for(int i = 0; i < a.length; i++) {
			System.out.printf("Input element[%d]: ", i);
			a[i] = sc.nextDouble();
		}
		return a;
	}
	
	public static int getMinIndex(double[] a) {
		int minIndex = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] < a[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		double[] a = inputDoubleArray();
		System.out.println(Arrays.toString(a));
		int minInd = getMinIndex(a);
		System.out.printf("Min element is a[%d] = %f", minInd, a[minInd]);
	}

}
