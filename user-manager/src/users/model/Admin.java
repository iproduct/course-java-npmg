package users.model;

public class Admin extends User {

	@Override
	public String getWelcomeMessage() {
		return "Welcome " + getName() + " (" + getEmail() + ") in role Admin.";
	}

}
