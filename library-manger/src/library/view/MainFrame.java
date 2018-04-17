package library.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import library.model.Book;

class ChangeButtonTextListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		((JButton) e.getSource()).setText("Welcome again !!!");
	}
}

public class MainFrame extends JFrame {
	private JTextField jtfTitle = new JTextField(20);
	private JTextField jtfAuthors = new JTextField(20);
	private JTextField jtfYear = new JTextField(20);
	private JTextField jtfPublisher = new JTextField(20);
	private JButton btnAddBook = new JButton("Add Book");
	private boolean isOddMessage = false;
	private JPanel mainPanel = new JPanel();	
	private JPanel buttonPanel = new JPanel();
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnReset = new JButton("Reset");
	private JButton btnCancel = new JButton("Cancel");

	private class AddBookListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Book book = new Book();
			boolean error = false;
			book.setTitle(jtfTitle.getText());
			String[] authors = jtfAuthors.getText().split(",");
			for(int i = 0; i < authors.length; i++) {
				authors[i] = authors[i].trim();
			}
			book.setAuthors(authors);
			book.setPublisher(jtfPublisher.getText());
			try {
				book.setYear(Integer.parseInt(jtfYear.getText()));
			} catch (NumberFormatException ex)  {
				jtfYear.setBorder(new LineBorder(Color.RED));
				error = true;
			}
			if(error) return;
			jtfYear.setBorder(new LineBorder(Color.GRAY));
			
		}
	}

	public MainFrame() throws HeadlessException {
		super("Library Manager");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);

		mainPanel.setLayout(new GridLayout(4, 2));
		mainPanel.setBorder(new MatteBorder(30, 30, 30, 30, new Color(0, 0, 0, 0)));
		makeField("Title: ", jtfTitle, mainPanel);
		makeField("Authors: ", jtfAuthors, mainPanel);
		makeField("Year: ", jtfYear, mainPanel);
		makeField("Publisher: ", jtfPublisher, mainPanel);

		add(mainPanel);
		
		buttonPanel.add(btnSubmit);
		buttonPanel.add(btnReset);
		buttonPanel.add(btnCancel);
		add(BorderLayout.SOUTH, buttonPanel);

		btnSubmit.addActionListener(new AddBookListener());

		
		
		
		
//		add(BorderLayout.WEST, new JButton("West"));
//		add(BorderLayout.EAST, new JButton("East"));
//		add(BorderLayout.NORTH, new JButton("North"));

		// setBounds(new Rectangle(300, 200, 600, 400));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void makeField(String labelText, JComponent component, Container container) {
		container.add(new JLabel(labelText));
		Box panel = Box.createVerticalBox();
		panel.add(Box.createVerticalGlue());
		component.setMaximumSize(new Dimension(500, 20));
		panel.add(component);
		panel.add(Box.createVerticalGlue());

		container.add(panel);
	}


	public static void main(String[] args) {
		new MainFrame();

	}

}
