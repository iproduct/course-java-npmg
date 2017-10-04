package library;

import java.util.Date;

public class Person {
	long ssn; // Social Security Number
	String name; //null by default
	Date birthDate;
	String address;

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.ssn = 1234567890;
		p1.name = "Ivan Petrov";
		
		Person p2 = new Person();
		p2.ssn = 42303466;
		p2.name = "Dimitar Atanasov";

		System.out.printf("SSN: %010d\n", p1.ssn);
		System.out.println("Name: " + p1.name);
		
		System.out.printf("SSN: %010d\n", p2.ssn);
		System.out.println("Name: " + p2.name);


	}

}
