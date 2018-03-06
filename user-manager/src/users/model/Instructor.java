package users.model;

public class Instructor extends User {

	public Instructor() {
		super();
	}

	public Instructor(String name, String email, String password) {
		super(name, email, password, Role.INSTRUCTOR);
	}

	@Override
	public String getWelcomeMessage() {
		return "Welcome " + getName() + " (" + getEmail() + ") in role Instructor.";
	}

}
