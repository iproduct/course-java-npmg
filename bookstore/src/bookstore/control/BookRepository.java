package bookstore.control;

import java.util.ArrayList;
import java.util.List;

import bookstore.model.Book;

public class BookRepository {
	private List<Book> books = new ArrayList<Book>();
	
	public void add(Book book) {
		books.add(book);
	}
	
	public void printBooks() {
		for(Book b: books) {
			System.out.println(b);
		}
	}
	
	public void sort() {
		books.sort(null);
	}
	
//	public Book findFastByTitle(String title) {
//		Book searchBook = new Book();
//		searchBook.setTitle(title);
//		int index = books.indexOf(searchBook);
//		return books.get(index);
//	}
	
	public Book findBookByTitle(String title) {
		for(int i = 0; i < books.size(); i++) {
			Book current = books.get(i);
			if (current.getTitle().equals(title)) {
				return current;
			}
		}
		return null;	
	}

	public static void main(String[] args) {
		BookRepository repo = new BookRepository();
		
		repo.add(new Book("Thinking in Java", "Bruce Eckel", 
				"Prentice Hall", "Technical", 22.5));
		repo.add(new Book("UML Distilled", "Martin Fowler", 
				"Prentice Hall", "Technical", 21.80));
		repo.add(new Book("Winnie The Pooh", "A. Miln", 
				"Prosveta", "Children", 8.2));
		repo.add(new Book("The Little Prince", "A. Exuperie", 
				"Prosveta", "Children", 20.5D));
		repo.add(new Book("Minecraft Userbook", "Bergson", 
				"Wesley", "Gaming", 25.5D));
		
		repo.printBooks();
		repo.sort();
		System.out.println("\nSorted books:");
		repo.printBooks();

	}

}
