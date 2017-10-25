package hello;
import java.util.Date;

public class HelloJava {

	public static void main(String[] args) {
		System.out.println("Hello from Java!");
		Date now = new Date();
		System.out.println(now + ": " + "Hello Trayan, from Java!");
		double a = 5, b = 3, alpha = Math.PI / 2;
		double sinAlpha = Math.sin(alpha);
		System.out.println("sinAlpha = " + sinAlpha);
		double area = (1.0/2) * a * b * sinAlpha;
		System.out.println("Area = " + area);
	}

}
