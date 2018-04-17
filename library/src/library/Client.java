package library;

import java.util.Date;

public class Client extends User {

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(long anSsn, String name, Date birthDate, String address, String email, String password) {
		super(anSsn, name, birthDate, address, email, password);
	}

	@Override
	public String congratulate() {
		return "Welcome " + getName() + " [" + getEmail() + "], in role Client.";
	}

}
