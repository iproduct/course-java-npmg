package arrays_11a;

import java.util.Arrays;
import java.util.Scanner;

public class DoubleArray {
	
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
		Scanner sc = new Scanner(System.in);
		System.out.print("Input number of elements: ");
		int n = sc.nextInt();
		double[] a = new double[n];
		for(int i = 0; i < a.length; i++) {
			System.out.print("Input elements[" + i + "]:");
			a[i] = sc.nextDouble();
		}
		System.out.println(Arrays.toString(a));
		int minIndex = getMinIndex(a);
		System.out.printf("Min element is: a[%d] = %f\n", minIndex, a[minIndex]);

	}

}
