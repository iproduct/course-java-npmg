package users.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import users.model.Admin;
import users.model.CanWelcome;
import users.model.Instructor;
import users.model.Student;
import users.model.User;

public class UserRepo {
//	private List<CanWelcome> users = new ArrayList<CanWelcome>();
	private User[] users;
	
//	public void addUser(CanWelcome user) {
//		users.add(user);
//	}
	
	public void welcomeAll() {
		for(CanWelcome user: users) {
			System.out.println(user.getWelcomeMessage());
		}
	}

	public static void main(String[] args) {
		UserRepo repo = new UserRepo();
		
		User user1 = new Admin("John Smith", "john@abv.bg", "john");
		User user2 = new Student("Bill Gates", "bill@gmail.com", "bill", 12);
		User user3 = new Student("Ivan Petrov", "ivan@gmail.com", "ivan", 12);
		User user4 = new Instructor("Jessika Parker", "smith.jessica@gmail.com", "jessica");
			
//		repo.addUser(user1);
//		repo.addUser(user2);
//		repo.addUser(user3);
//		repo.addUser(user4);
		
		repo.users = new User[] { user1, user2, user3, user4 };
		
		Arrays.sort(repo.users);
		
		repo.welcomeAll();

	}

}
