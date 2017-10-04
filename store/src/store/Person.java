package store;

public class Person {
	long ssn;
	String name; // default null
	int age;
	String address;
	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.ssn = 0423111234;
		p1.name = "Petar Dimitrov";
		System.out.println("SSN: " + p1.ssn);
		System.out.println("Name: " + p1.name);
	}

}
