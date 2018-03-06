package library;

import java.util.Date;

abstract public class User extends Person implements CanCongratulate {
	private String email;
	private String password;
	
	public User() {
	}
	
	public User(long anSsn, String name, Date birthDate, String address, 
			String email, String password) {
		super(anSsn, name, birthDate, address);
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("User [email=").append(email).append(", password=").append(password).append("]");
		return builder.toString();
	}
	
//	abstract public String congratulate();
		
//	public static void main(String[] args) {
//		User u = new User();
//	}
		
}
