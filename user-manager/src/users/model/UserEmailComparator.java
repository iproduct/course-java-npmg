package users.model;

import java.util.Comparator;

public class UserEmailComparator implements Comparator<User> {

	@Override
	public int compare(User u1, User u2) {
		return u1.getEmail().compareToIgnoreCase(u2.getEmail());
	}
	
}
