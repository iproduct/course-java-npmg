package users.model;

public class Instructor extends User {

	@Override
	public String getWelcomeMessage() {
		return "Welcome " + getName() + " (" + getEmail() + ") in role Instructor.";
	}

}
