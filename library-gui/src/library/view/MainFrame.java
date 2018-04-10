package library.view;
import java.awt.BorderLayout;
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
	private JTextField jtfTitle = new JTextField(20);
	private JPanel panel = new JPanel();
	private JButton btnShow = new JButton("Show Books");

	public MainFrame() throws HeadlessException {
		super("Library Manager");
		label = new JLabel("Sample application.", SwingConstants.CENTER);
		add(label);
		add(BorderLayout.NORTH, new JButton("Main Menu"));
		add(BorderLayout.WEST, new JButton("West"));
		add(BorderLayout.EAST, new JButton("East"));
		add(BorderLayout.SOUTH, btnShow);
		btnShow.addActionListener(new ChangeLabelListener());
		
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

	public static void main(String[] args) {
		new MainFrame();
	}

}
