package bookstore.jdbc;

import java.sql.*;

public class SQLiteJDBC {
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
	        			results.getInt(1),
	        			results.getString(3),
	        			results.getString(2),
	        			results.getInt(5)
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