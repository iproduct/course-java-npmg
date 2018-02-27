package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import library.Admin;
import library.Client;
import library.Librarian;
import library.User;

public class UserRepository {
	private List<User> users = new ArrayList<User>();

	public static void main(String[] args) {
		User c1 = new Client(11111111111L, "John Smith", new Date(), "London", "john@gmail.com", "john");
		User c2 = new Client(22222222222L, "Ivan Petrov", new Date(), "Sofia 1000", "ivan@gmail.com", "ivan");
		User l1 = new Librarian(33333333333L, "Dimitar Petrov", new Date(), "Sofia 1000", "dimitar@gmail.com", "dimitar");
		User a1 = new Admin(444444444444L, "John Petrov", new Date(), "New York", "johnp@gmail.com", "johnp");
		
		UserRepository repo = new UserRepository();
		repo.users.add(c1);
		repo.users.add(c2);
		repo.users.add(l1);
		repo.users.add(a1);
		
		for(User u: repo.users) {
			System.out.println(u.congratulate());
		}
		
	}

}
