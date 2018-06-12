package bookstore.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

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
				} finally {
					System.out.println("Finally works!");
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
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		String[] columns = {"ID", "TITLE", "AUTHORS", "YEAR", "PUBLISHER", "PRICE"};
		
		Object[][] data = {
				{1, "Thinking in Java", "Bruce Eckel", 2012, "Prentice Hall", 35.50},
				{2, "Thinking in Java", "Bruce Eckel", 2012, "Prentice Hall", 35.50},
				{3, "Thinking in Java", "Bruce Eckel", 2012, "Prentice Hall", 35.50}
		};
		
		table = new JTable(data, columns);
		scrollPane.setViewportView(table);
	}

}
