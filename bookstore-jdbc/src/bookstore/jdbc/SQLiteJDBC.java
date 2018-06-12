package bookstore.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteJDBC {
	public static void main(String args[]) {
		Connection c = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:bookstore.db");

			Statement stmt = c.createStatement();
			String sql = "DROP TABLE IF EXISTS BOOKS ";
			stmt.executeUpdate(sql);
		
			sql = "CREATE TABLE BOOKS " 
					+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
					+ " TITLE      CHAR(120)  NOT NULL, " 
					+ " AUTHORS    CHAR(120)  NOT NULL, " 
					+ " YEAR       INT, "
					+ " PUBLISHER  CHAR(80), " 
					+ " PRICE     REAL)";
			stmt.executeUpdate(sql);
		
			System.out.println("Opened database successfully.");
			
			sql = "INSERT INTO BOOKS (TITLE, AUTHORS, YEAR, PUBLISHER, PRICE)" +
			    " VALUES ('Thinking in Java', 'Bruce Eckel', 2012, 'Prentice Hall', 35.50)";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Finishing program.");
	}
}