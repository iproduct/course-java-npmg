package store.entity;

public class User {
	private static long nextId = 0;
	private long id = nextId++;
	private String username;
	private String email;
	private String fName;
	private String lName;
	private String password;
	private Role role;

	public User() {
	}

	public User(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User(String username, String email, String fName, 
			String lName, String password) {
		this.username = username;
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.role  = Role.CUSTOMER;
	}

	public User(String username, String email, String fName, 
			String lName, String password, Role role) {
		super();
		this.username = username;
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.role = role;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (id != other.id)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return String.format(
		"id: %s \nusername: %s\nemail: %s\nfirst: %s\nlast: %s\npassword: %s\nrole: %s\n\n", 
			id,	username, email, fName, lName, password, role);
	}
	
	

	public static void main(String[] args) {
		User user1 = new User("george", "george@abv.bg", "George", "Nikolov", "george");
		User user2 = new User("petar", "petar@gmail.com", "Petar", "Atanasov", 
				"petar123", Role.ADMIN);
		System.out.println(user1);
		System.out.println(user2);

	}

}
