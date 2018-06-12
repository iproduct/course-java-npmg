package bookstore.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bookstore.model.Book;


public class SQLiteJDBC {
	private Connection connection;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connection != null) {
			return connection;
		} else {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:bookstore.db");
			System.out.println("Opened database successfully");
			return connection;
		}
	}
	
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		try {
			Connection connnection = getConnection();
			Statement stmt = connection.createStatement();
			String sql= "SELECT * FROM BOOK;";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while(rs.next()) {
	        	Book b = new Book();
	        	b.setId(rs.getInt("ID"));
	        	b.setTitle(rs.getString("TITLE"));
	        	b.setAuthors(rs.getString("AUTHORS"));
	        	b.setYear(rs.getInt("YEAR"));
	        	b.setPublisher(rs.getString("PUBLISHER"));
	        	b.setPrice(rs.getDouble("PRICE"));
	        	books.add(b);
	        	System.out.print(b);
	        }
	        
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public static void main(String args[]) {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:bookstore.db");
			System.out.println("Opened database successfully");
			
			Statement stmt = c.createStatement();
	        String sql = "DROP TABLE IF EXISTS BOOK"; 
	        stmt.executeUpdate(sql);
		     
	        sql = "CREATE TABLE BOOK " +
		             "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
		             " TITLE          CHAR(120)    NOT NULL, " + 
		             " AUTHORS        TEXT     NOT NULL, " + 
		             " PUBLISHER      CHAR(50), " + 
		             " YEAR           INT," + 
		             " PRICE          REAL)"; 
	        stmt.executeUpdate(sql);

	        sql = "INSERT INTO BOOK (TITLE, AUTHORS, PUBLISHER, YEAR, PRICE)" +
	        " VALUES ('Thinking in Java', 'Bruce Eckel', 'Prentice Hall', 2012, 35.50)";
	        stmt.executeUpdate(sql);
	        
	        sql = "INSERT INTO BOOK (TITLE, AUTHORS, PUBLISHER, YEAR, PRICE)" +
	        " VALUES ('Alice in the Wonderland', 'Luice Carol', 'ABC Publishing', 1970, 15)";
	        stmt.executeUpdate(sql);
	        
	        sql = "INSERT INTO BOOK (TITLE, AUTHORS, PUBLISHER, YEAR, PRICE)" +
	        " VALUES ('UML', 'Ivor Jacobsen', 'Prentice Hall', 2010, 33.70)";
	        stmt.executeUpdate(sql);
	        
	        sql= "SELECT * FROM BOOK;";
	        ResultSet results = stmt.executeQuery(sql);
	        
	        while(results.next()) {
	        	System.out.printf("%d: %s - %s (%d) \n", 
	        			results.getInt("ID"),
	        			results.getString("TITLE"),
	        			results.getString("AUTHORS"),
	        			results.getInt("YEAR")
	        	);
	        }
	        
	        
	        stmt.close();
	        c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			System.out.println("Program finished.");
		}
		
		
		
	}
}