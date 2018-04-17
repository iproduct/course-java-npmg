package library.view;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class ShowButtonListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		((JButton)e.getSource()).setText("New text");	
	}
}

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

	public MainFrame() throws HeadlessException {
		super("Library Manager");
		
		add(BorderLayout.NORTH, new JButton("Main Menu"));
		add(BorderLayout.WEST, new JButton("West"));
		add(BorderLayout.EAST, new JButton("East"));
		
		//Build buttonPanel
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(btnSubmit);
		buttonPanel.add(btnReset);
		buttonPanel.add(btnCancel);
		add(BorderLayout.SOUTH, buttonPanel);
		
		//Build mainPanel
		mainPanel.setLayout(new GridLayout(4,2));
		makeField("Title:", jtfTitle, mainPanel);
		makeField("Authors:", jtfAuthors, mainPanel);
		makeField("Publisher:", jtfPublisher, mainPanel);
		makeField("Year:", jtfYear, mainPanel);
		add(mainPanel);
		
		btnSubmit.addActionListener(new ChangeLabelListener());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
//		setBounds(new Rectangle(300, 200, 600, 400));
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
		container.add(new JLabel(fieldName));
		container.add(component);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
