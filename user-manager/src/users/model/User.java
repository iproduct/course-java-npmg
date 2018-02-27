package users.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String email;
	private String password;
	private String role;
	
	public User() {
	}
	
	public User(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [email=").append(email).append(", password=").append(password).append(", role=")
				.append(role).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	public static void main(String[] args) {
		User user = new User("john@abv.bg", "john", "admin");
		User user2 = new User("bill@gmail.com", "bill", "student");
		User user3 = new User("jessica@gmail.com", "jessica", "instructor");
		System.out.println(user);
		
		List<User> users = new ArrayList<User>();
		
		users.add(user);
		users.add(user2);
		users.add(user3);
		
//		System.out.println(users);
		
		for(User u : users) {
			System.out.println(u);
		}

	}

}
