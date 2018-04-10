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
import javax.swing.border.MatteBorder;

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

	private class ChangeLabelTextListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			isOddMessage = !isOddMessage;
			// lblTitle.setText(isOddMessage ? "Welcome again !!!": "Welcome to Library
			// Manager!");
		}
	}

	public MainFrame() throws HeadlessException {
		super("Library Manager");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);

		mainPanel.setLayout(new GridLayout(4, 2));
		mainPanel.setBorder(new MatteBorder(30, 30, 30, 30, new Color(0, 0, 0, 0)));
		addField("Title: ", jtfTitle, mainPanel);
		addField("Authors: ", jtfAuthors, mainPanel);
		addField("Year: ", jtfYear, mainPanel);
		addField("Publisher: ", jtfPublisher, mainPanel);

		add(mainPanel);

		btnAddBook.addActionListener(new ChangeLabelTextListener());

		add(BorderLayout.SOUTH, btnAddBook);
		add(BorderLayout.WEST, new JButton("West"));
		add(BorderLayout.EAST, new JButton("East"));
		add(BorderLayout.NORTH, new JButton("North"));

		// setBounds(new Rectangle(300, 200, 600, 400));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void addField(String label, JComponent component, Container container) {
		container.add(new JLabel(label));
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
