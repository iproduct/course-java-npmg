package users.control;

import java.util.ArrayList;
import java.util.List;

import users.model.Admin;
import users.model.CanWelcome;
import users.model.Instructor;
import users.model.Student;
import users.model.User;

public class UserRepo {
	private List<CanWelcome> users = new ArrayList<CanWelcome>();
	
	public void addUser(CanWelcome user) {
		users.add(user);
	}
	
	public void welcomeAll() {
		for(CanWelcome user: users) {
			System.out.println(user.getWelcomeMessage());
		}
	}

	public static void main(String[] args) {
		UserRepo repo = new UserRepo();
		
		CanWelcome user1 = new Admin("John Smith", "john@abv.bg", "john");
		CanWelcome user2 = new Student("Bill Gates", "bill@gmail.com", "bill", 12);
		CanWelcome user3 = new Student("Ivan Petrov", "ivan@gmail.com", "ivan", 12);
		CanWelcome user4 = new Instructor("Jessika Parker", "jessica@gmail.com", "jessica");

		
		repo.welcomeAll();

	}

}
