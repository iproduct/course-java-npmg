package library;

import java.util.Date;

public class Person {
	long ssn; // Social Security Number
	String name; //null by default
	Date birthDate;
	String address;
	
	public Person() {
	}
	
	public Person(long anSsn, String name, Date birthDate, String address) {
		ssn = anSsn;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Person [ssn=" 
				+ String.format("SSN: %010d\n", ssn)
				+ ", name=" + name + ", birthDate=" + birthDate 
				+ ", address=" + address + "]";
	}

	public static void main(String[] args) {
		Person p1 = new Person(1234567890, "Ivan Petrov", new Date(), "Sofia 1000");
		Person p2 = new Person(42303466, "Dimitar Atanasov", new Date(), "Provdiv");

		System.out.println(p1);
		System.out.println(p2);
		
//		System.out.printf("SSN: %010d\n", p1.ssn);
//		System.out.println("Name: " + p1.name);
//		
//		System.out.printf("SSN: %010d\n", p2.ssn);
//		System.out.println("Name: " + p2.name);


	}

}
