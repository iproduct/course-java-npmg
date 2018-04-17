package library;

import java.util.Date;

public class Admin extends User {

	public Admin() {
		super();
	}

	public Admin(long anSsn, String name, Date birthDate, String address, String email, String password) {
		super(anSsn, name, birthDate, address, email, password);
	}

	@Override
	public String congratulate() {
		return "Welcome " + getName() + " [" + getEmail() + "], in role Admininstrator.";
	}

}
