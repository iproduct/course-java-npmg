package bookstore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import bookstore.jdbc.SQLiteJDBC;
import bookstore.model.Book;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BookstoreApp extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookstoreApp frame = new BookstoreApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookstoreApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String[] columns = {"ID", "TITLE", "AUTHORS", "YEAR", "PUBLISHER", "PRICE"};
		
//		Object[][] data = {
//				{1, "Thinking in Java", "Bruce Eckel", 2012, "Prentice Hall", 35.50},
//				{2, "Thinking in Java", "Bruce Eckel", 2012, "Prentice Hall", 35.50},
//				{3, "Thinking in Java", "Bruce Eckel", 2012, "Prentice Hall", 35.50}
//		};
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		SQLiteJDBC dao = new SQLiteJDBC();
		List<Book> data = dao.getBooks();
		
		TableModel model = new AbstractTableModel() {
		    public String getColumnName(int col) {
		        return columns[col].toString();
		    }
		    public int getRowCount() { return data.size(); }
		    public int getColumnCount() { return columns.length; }
		    public Object getValueAt(int row, int col) {
		        Book b = data.get(row);
		        switch(col) {
		        	case 0: return b.getId(); 
		        	case 1: return b.getTitle(); 
		        	case 2: return b.getAuthors(); 
		        	case 3: return b.getYear(); 
		        	case 4: return b.getPublisher(); 
		        	case 5: return b.getPrice();
		        }
		        return null;
		    }
		    public boolean isCellEditable(int row, int col) { 
		    	return false; 
		    }
//		    public void setValueAt(Object value, int row, int col) {
//		        rowData[row][col] = value;
//		        fireTableCellUpdated(row, col);
//		    }
		};
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}

}
