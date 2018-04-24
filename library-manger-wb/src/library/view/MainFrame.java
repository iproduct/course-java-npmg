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
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import library.model.Book;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFormattedTextField;

class ChangeButtonTextListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		((JButton) e.getSource()).setText("Welcome again !!!");
	}
}

public class MainFrame extends JFrame {
	private JButton btnAddBook = new JButton("Add Book");
	private boolean isOddMessage = false;
	private JPanel mainPanel = new JPanel();	
	private JPanel buttonPanel = new JPanel();
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnReset = new JButton("Reset");
	private JButton btnCancel = new JButton("Cancel");
	private Box centralPanel = Box.createVerticalBox();
	private JPanel resultsPanel = new JPanel();
	private JTextArea jtaResults = new JTextArea(5, 60);
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnEdit = new JMenu("Edit");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmOpen = new JMenuItem("Open...");
	private final JMenuItem mntmClose = new JMenuItem("Close");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JSeparator separator = new JSeparator();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final JLabel lblYear = new JLabel("Year");
	private final JFormattedTextField formattedTextField;

	private class AddBookListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
//			Book book = new Book();
//			boolean error = false;
//			book.setTitle(jtfTitle.getText());
//			String[] authors = jtfAuthors.getText().split(",");
//			for(int i = 0; i < authors.length; i++) {
//				authors[i] = authors[i].trim();
//			}
//			book.setAuthors(authors);
//			book.setPublisher(jtfPublisher.getText());
//			try {
//				book.setYear(Integer.parseInt(jtfYear.getText()));
//			} catch (NumberFormatException ex)  {
//				jtfYear.setBorder(new LineBorder(Color.RED));
//				error = true;
//			}
//			if(error) return;
//			jtfYear.setBorder(new LineBorder(Color.GRAY));
//			System.out.println(book);
//			jtaResults.append(book.toString() + "\n");
//			resetFields();
		}
	}
	
	private class ResetFormListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			resetFields();
		}
	}

	public MainFrame() throws HeadlessException {
		super("Library Manager");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 400);
		
		buttonPanel.add(btnSubmit);
		buttonPanel.add(btnReset);
		buttonPanel.add(btnCancel);
		getContentPane().add(BorderLayout.SOUTH, buttonPanel);

		btnSubmit.addActionListener(new AddBookListener());
		btnReset.addActionListener(new ResetFormListener());

		centralPanel.add(mainPanel);
		
		JLabel lblTitle = new JLabel("Title");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAuthors = new JLabel("Authors");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblPublisher = new JLabel("Publisher");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		formattedTextField = new JFormattedTextField(new SimpleDateFormat("yyyy"));
		
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(lblYear)
							.addContainerGap())
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitle)
								.addComponent(lblAuthors)
								.addComponent(lblPublisher))
							.addGap(9)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
								.addComponent(textField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
								.addComponent(textField_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
								.addComponent(formattedTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
							.addGap(22))))
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthors)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPublisher)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYear)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		mainPanel.setLayout(gl_mainPanel);
		centralPanel.add(resultsPanel);
		resultsPanel.add(jtaResults);
		jtaResults.setEditable(false);
		
		getContentPane().add(centralPanel);
		
		
		
//		add(BorderLayout.WEST, new JButton("West"));
//		add(BorderLayout.EAST, new JButton("East"));
//		add(BorderLayout.NORTH, new JButton("North"));

		// setBounds(new Rectangle(300, 200, 600, 400));
		setLocationRelativeTo(null);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		
		mnFile.add(mntmOpen);
		
		mnFile.add(mntmClose);
		
		mnFile.add(separator);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnEdit);
		
		menuBar.add(mnHelp);
		setVisible(true);
	}

	private void makeField(String labelText, JComponent component, Container container) {
		Box panel = Box.createVerticalBox();
		panel.add(Box.createVerticalGlue());
		panel.add(Box.createVerticalGlue());

		container.add(panel);
	}

	private void resetFields() {
//		jtfTitle.setText("");
//		jtfAuthors.setText("");
//		jtfYear.setText("");
//		jtfPublisher.setText("");
	}

	public static void main(String[] args) {
		new MainFrame();

	}

}
