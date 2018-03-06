package users.model;

public class Admin extends User {

	public Admin() {
	}

	public Admin(String name, String email, String password) {
		super(name, email, password, Role.ADMIN);
	}

	@Override
	public String getWelcomeMessage() {
		return "Welcome " + getName() + " (" + getEmail() + ") in role Admin.";
	}

}
