package users.model;

public class Student extends User {
	private long sid;

	public Student() {
	}

	public Student(String name, String email, String password, long sid) {
		super(name, email, password, Role.STUDENT);
		this.sid = sid;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [sid=").append(sid).append(", name =").append(getName()).append(", email =")
				.append(getEmail()).append(", password=").append(getPassword()).append(", role =").append(getRole())
				.append("]");
		return builder.toString();
	}

	
	public String getWelcomeMessage() {
		return "Welcome " + getName() + " (" + getEmail() + ") in role Student.";
	}

	public static void main(String[] args) {
		Student s1 = new Student("Trayan Iliev", "trayan@abv.bg", "trayan", 15);
		System.out.println(s1);
		System.out.println(s1.getWelcomeMessage());

	}

}