package library;

import java.util.Date;

public class Librarian extends User {

	public Librarian() {
		super();
	}

	public Librarian(long anSsn, String name, Date birthDate, String address, String email, String password) {
		super(anSsn, name, birthDate, address, email, password);
	}

	public String congratulate() {
		return "Welcome " + getName() + " [" + getEmail() + "], in role Librarian.";
	}

}
