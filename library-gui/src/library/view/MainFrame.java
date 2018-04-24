package library.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import library.model.Book;

public class MainFrame extends JFrame {
	private JLabel label;
	private JPanel buttonPanel = new JPanel();
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnReset = new JButton("Reset");
	private JButton btnCancel = new JButton("Cancel");
	private JPanel mainPanel = new JPanel();
	private JTextField jtfTitle = new JTextField(20);
	private JTextField jtfAuthors = new JTextField(20);
	private JTextField jtfPublisher = new JTextField(20);
	private JTextField jtfYear = new JTextField(20);
	private JPanel resultsPanel = new JPanel();
	private JTextArea jtaResults = new JTextArea(15, 60);
	private Box centralPanel = Box.createVerticalBox();

	private class AddBookListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Book book = new Book();
			book.setTitle(jtfTitle.getText());
			book.setAuthors(jtfAuthors.getText());
			book.setPublisher(jtfPublisher.getText());
			try {
				book.setYear(Integer.parseInt(jtfYear.getText()));
				jtfYear.setBorder(new LineBorder(Color.GRAY));
			} catch (NumberFormatException ex) {
				jtfYear.setBorder(new LineBorder(Color.RED));
			}
			System.out.println(book);
		}
	}

	public MainFrame() throws HeadlessException {
		super("Library Manager");

		add(BorderLayout.NORTH, new JButton("Main Menu"));
		// add(BorderLayout.WEST, new JButton("West"));
		// add(BorderLayout.EAST, new JButton("East"));

		// Build buttonPanel
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(btnSubmit);
		buttonPanel.add(btnReset);
		buttonPanel.add(btnCancel);
		add(BorderLayout.SOUTH, buttonPanel);		

		// Build mainPanel
		mainPanel.setLayout(new GridLayout(4, 2));
		mainPanel.setBorder(new MatteBorder(20, 50, 20, 50, new Color(0, 0, 0, 0)));
		makeField("Title:", jtfTitle, mainPanel);
		makeField("Authors:", jtfAuthors, mainPanel);
		makeField("Publisher:", jtfPublisher, mainPanel);
		makeField("Year:", jtfYear, mainPanel);

		btnSubmit.addActionListener(new AddBookListener());
		
		//Results panel
		resultsPanel.add(jtaResults);
		centralPanel.add(mainPanel);
		centralPanel.add(resultsPanel);
		add(centralPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		// setBounds(new Rectangle(300, 200, 600, 400));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class ChangeLabelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText("Books data here ...");
		}
	}

	private void makeField(String fieldName, Component component, Container container) {
		Box panel = Box.createVerticalBox();
		panel.add(Box.createVerticalGlue());
		component.setMaximumSize(new Dimension(500, 20));
		panel.add(component);
		panel.add(Box.createVerticalGlue());
		container.add(new JLabel(fieldName));
		container.add(panel);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
