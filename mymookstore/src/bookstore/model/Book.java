package bookstore.model;

public class Book implements Comparable<Book> {
	private static long nextId = 0;
	
	private long id  = nextId++;
	private String title;
	private String authors;
	private String publisher;

	public Book() {
	}

	public Book(String title) {
		this.title = title;
	}
	
	public Book(String title, String authors, String publisher) {
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=").append(id)
			.append(", title=").append(title)
			.append(", authors=").append(authors)
			.append(", publisher=").append(publisher).append("]");
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Book other) {
		return getTitle().compareToIgnoreCase(other.getTitle());
	}

}
