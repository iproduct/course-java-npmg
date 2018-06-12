package bookstore.model;

import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book> {
	private long id;
	private String title;
	private String authors;
	private String publisher;
	private int year;
	private double price;
	
	public Book() {
	}

	public Book(String title, String authors) {
		this.title = title;
		this.authors = authors;
	}
	
	public Book(String title, String authors, String publisher, 
			int year, double price) { //Full constructor
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.year = year;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=").append(id)
		.append(", title=").append(title)
		.append(", authors=").append(authors)
		.append(", publisher=").append(publisher)
		.append(", year=").append(year)
		.append(", price=").append(price).append("]");
		
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Book other) {
		return this.title.compareToIgnoreCase(other.title);
//		return (int) Math.signum(this.price - other.price);
	}

	public static void main(String[] args) {
		List<Book> bookstore = new ArrayList<Book>();
		bookstore.add(new Book("Thinking in Java", "Bruce Eckel", 
				"Prentice Hall", 2018, 22.5));
		bookstore.add(new Book("UML Distilled", "Martin Fowler", 
				"Prentice Hall", 2018, 21.80));
		bookstore.add(new Book("Winnie The Pooh", "A. Miln", 
				"Prosveta", 2018, 8.2));
		bookstore.add(new Book("The Little Prince", "A. Exuperie", 
				"Prosveta", 2018, 20.5D));
		bookstore.add(new Book("Minecraft Userbook", "Bergson", 
				"Wesley", 2018, 25.5D));
		
		for(Book b : bookstore) {
			System.out.println(b);
		}
		
		bookstore.sort(null);
		
		System.out.println("\nAfter sorting by title:");
		
		for(Book b : bookstore) {
			System.out.println(b);
		}
		
		int index = bookstore.indexOf(new Book("Thinking in Java", null));
		System.out.println(index);
	}

}
