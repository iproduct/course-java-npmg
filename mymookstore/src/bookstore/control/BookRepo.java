package bookstore.control;

import java.util.ArrayList;
import java.util.List;

import bookstore.model.Book;

public class BookRepo {
	private List<Book> books = new ArrayList<Book>();
	
	public void add(Book book) {
		books.add(book);
	}
	
	public void print() {
		for(Book b: books) {
			System.out.println(b);
		}
	}
	
	public void sortByTitle() {
		books.sort(null);
	}
	
	public Book findByTitle(String title) {
		return books.get(
				books.indexOf(new Book(title)));
	}

	public static void main(String[] args) {
		BookRepo repo = new BookRepo();
		repo.add(new Book("Thinking in Java", "Bruce Eckel", "Prentice Hall"));
		repo.add(new Book("UML Distilled", "Martin Fawler", "Wesley"));
		repo.add(new Book("Winie the Pooh", "A. Miln", "Prosveta"));
		repo.add(new Book("Robinzon Cruzo", "Daniel Defo", "Prosveta"));
		repo.print();
		repo.sortByTitle();
		repo.print();
		System.out.println("Found book by title:" + 
				repo.findByTitle("Robinzon Cruzo"));
		

	}

}
