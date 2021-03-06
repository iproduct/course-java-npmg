package bookstore.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC {
	private Connection connection;
	
	public Connection getConnection() {
		if(connection != null) {
			return connection;
		} else {
			try {
				Class.forName("org.sqlite.JDBC");
				connection = DriverManager.getConnection("jdbc:sqlite:bookstore.db");
				return connection;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public Object[][] getData() throws SQLException {
		Connection con =  getConnection();
		Statement stmt = con.createStatement();
		
		// Get BOOKS table row count 
		ResultSet r = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM BOOKS");
		r.next();
		int rowCount = r.getInt("rowcount");
		r.close();
		
		// Select all books
		String sql = "SELECT * FROM BOOKS";
		ResultSet rs = stmt.executeQuery(sql);
		int columnCount = rs.getMetaData().getColumnCount();
		
		Object[][] data = new Object[rowCount][columnCount];
		
		int row = 0;
		while(rs.next()) {
			for(int i = 0; i < columnCount; i++) {
				data[row][i] = rs.getObject(i+1);
			}
			row++;
		}
		
		return data;
	}
	
	public static void main(String args[]) {
		Connection c = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:bookstore.db");

			Statement stmt = c.createStatement();
			String sql;
			
			// Drop and create DB
//			sql = "DROP TABLE IF EXISTS BOOKS ";
//			stmt.executeUpdate(sql);
//		
//			sql = "CREATE TABLE BOOKS " 
//					+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
//					+ " TITLE      CHAR(120)  NOT NULL, " 
//					+ " AUTHORS    CHAR(120)  NOT NULL, " 
//					+ " YEAR       INT, "
//					+ " PUBLISHER  CHAR(80), " 
//					+ " PRICE     REAL)";
//			stmt.executeUpdate(sql);
//		
//			System.out.println("Opened database successfully.");
//			
//			sql = "INSERT INTO BOOKS (TITLE, AUTHORS, YEAR, PUBLISHER, PRICE)" +
//			    " VALUES ('Thinking in Java', 'Bruce Eckel', 2012, 'Prentice Hall', 35.50)";
//			stmt.executeUpdate(sql);
//			
//	        sql = "INSERT INTO BOOKS (TITLE, AUTHORS, YEAR, PUBLISHER, PRICE)" +
//	        " VALUES ('Alice in the Wonderland', 'Luice Carol', 1970, 'ABC Publishing', 15)";
//	        stmt.executeUpdate(sql);
//	        
//	        sql = "INSERT INTO BOOKS (TITLE, AUTHORS, YEAR, PUBLISHER, PRICE)" +
//	        " VALUES ('UML', 'Ivor Jacobsen', 2010, 'Prentice Hall', 33.70)";
//	        stmt.executeUpdate(sql);
			
			// Update record in DB
			sql = "UPDATE BOOKS SET PRICE=120.50 WHERE ID=2";
			stmt.executeUpdate(sql);
			
			// Delete record in DB
//			sql = "DELETE FROM BOOKS WHERE ID=4";
//			stmt.executeUpdate(sql);
			
			// Select all books
			sql = "SELECT * FROM BOOKS";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.printf("| %d | %-25.25s | %-20.20s | %d | %6.2f |\n", 
					rs.getInt("ID"), 
					rs.getString("TITLE"),
					rs.getString("AUTHORS"),
					rs.getInt("YEAR"),
					rs.getDouble("PRICE")
				);
			}
			
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Finishing program.");
	}
}