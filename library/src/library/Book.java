package library;

public class Book {
	private static long counter = 0; 
	private long id = counter++;
	private String title;
	private String[] authors;
	private int year;
	private String publisher;
	
	public Book() {
	}

//	public Book(long id) {
//		this.id = id;
//	}

	public Book(String title, String[] authors, int year, String publisher) {
		super();
		this.title = title;
		this.authors = authors;
		this.year = year;
		this.publisher = publisher;
	}

	public static long getCounter() {
		return counter;
	}

	public static void setCounter(long counter) {
		Book.counter = counter;
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

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book(25);
		Book b3 = new Book();
		System.out.println(b1.id);
		System.out.println(b2.id);
		System.out.println(b3.id);
		

	}

}
