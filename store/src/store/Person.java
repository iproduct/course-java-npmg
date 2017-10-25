package store;

/**
 * This class models a physical person data
 * @author Trayan Iliev
 * @version 1.0.0
 * @see java.lang.Object
 *
 */
public class Person {
	private long ssn;
	private String name; // default null
	private int age;
	private String address;

	/**
	 * No args constructor
	 */
	public Person() {}
	
	/** 
	 * Full constructor
	 * @param ssn social security number
	 * @param name person's name
	 * @param age person's age
	 * @param address person's address, including city, street, number. etc.
	 */
	public Person(long ssn, String name, int age, String address) {
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	/**
	 * {@inheritDoc} 
	 * Prints specific person's attributes.
	 */
	@Override
	public String toString() {
		return "Person [ssn=" + String.format("%010d", ssn) + ", name=" + name + ", age=" + age + ", "
				+ "address=" + address + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ssn ^ (ssn >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (ssn != other.ssn)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Person p1 = new Person(423111234, "Petar Dimitrov", 17, "Sofia 1000");
		Person p2 = new Person(1234567890, "Ivan Petrov", 17, "Sofia 1000");
		Person p3 = new Person(423111234, "Petar Dimitrov", 18, "Sofia 1000");

		/* System.out.printf("SSN: %010d\n", p1.ssn);
		 System.out.println("Name: " + p1.name);
		
		 System.out.printf("SSN: %010d\n", p2.ssn);
		 System.out.println("Name: " + p2.name); */

		System.out.println(p1);
		System.out.println(p3);
		System.out.println("p1 == p3: " + p1.equals(p3));
	}

}
