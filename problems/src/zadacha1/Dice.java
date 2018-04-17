package zadacha1;

import java.util.Random;

public class Dice {

	public static void main(String[] args) {
		Random rand = new Random();
		int throw1 = rand.nextInt(6) + 1;
	}

}
