package users.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import users.model.Admin;
import users.model.CanWelcome;
import users.model.Instructor;
import users.model.Student;
import users.model.User;
import users.model.UserEmailComparator;

public class UserRepo {
	private List<User> users = new ArrayList<User>();
//	private User[] users;
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void welcomeAll() {
		for(CanWelcome user: users) {
			System.out.println(user.getWelcomeMessage());
		}
	}

	public static void main(String[] args) {
		UserRepo repo = new UserRepo();
		
		User user1 = new Admin("John Smith", "john@abv.bg", "john");
		User user2 = new Student("Bill Gates", "gates.bill@gmail.com", "bill", 12);
		User user3 = new Student("Ivan Petrov", "ivan@gmail.com", "ivan", 12);
		User user4 = new Instructor("Jessika Parker", "smith.jessica@gmail.com", "jessica");
			
		repo.addUser(user1);
		repo.addUser(user2);
		repo.addUser(user3);
		repo.addUser(user4);
		
		repo.users.sort(new UserEmailComparator());
		
//		repo.users = new User[] { user1, user2, user3, user4 };
		
//		Arrays.sort(repo.users , new UserEmailComparator());
		//		(u1,u2) -> u1.getEmail().compareToIgnoreCase(u2.getEmail()));
		
		repo.welcomeAll();

	}

}
