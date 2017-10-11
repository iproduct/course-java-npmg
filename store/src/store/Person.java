package store;

public class Person {
	long ssn;
	String name; // default null
	int age;
	String address;

	public Person() {}
	
	public Person(long ssn, String name, int age, String address) {
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [ssn=" + String.format("%010d", ssn) + ", name=" + name + ", age=" + age + ", "
				+ "address=" + address + "]";
	}

	public static void main(String[] args) {
		Person p1 = new Person(423111234, "Petar Dimitrov", 17, "Sofia 1000");
		Person p2 = new Person(1234567890, "Ivan Petrov", 17, "Sofia 1000");

		// System.out.printf("SSN: %010d\n", p1.ssn);
		// System.out.println("Name: " + p1.name);
		//
		// System.out.printf("SSN: %010d\n", p2.ssn);
		// System.out.println("Name: " + p2.name);

		System.out.println(p1);
		System.out.println(p2);
	}

}
