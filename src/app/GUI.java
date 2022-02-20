package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GUI {

	private JFrame frame;
	private JPanel panel_addStudent;
	private JPanel panel_edit;
	private JPanel panel_view;
	private JLabel lbl_schoolName;
	private JLabel lbl_grade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		panel_addStudent = new JPanel();
		frame.getContentPane().add(panel_addStudent, "panel_addStudent");
		panel_addStudent.setLayout(null);
		
		JLabel lbl_title = new JLabel("Create Student");
		lbl_title.setBounds(174, 12, 107, 17);
		panel_addStudent.add(lbl_title);
		
		JLabel lbl_firstName = new JLabel("First Name:");
		lbl_firstName.setBounds(12, 35, 107, 17);
		panel_addStudent.add(lbl_firstName);
		
		JLabel lbl_lastName = new JLabel("Last Name:");
		lbl_lastName.setBounds(12, 70, 107, 17);
		panel_addStudent.add(lbl_lastName);
		
		JLabel lbl_age = new JLabel("Age:");
		lbl_age.setBounds(12, 109, 107, 17);
		panel_addStudent.add(lbl_age);
		
		lbl_schoolName = new JLabel("School Name");
		lbl_schoolName.setBounds(12, 148, 107, 17);
		panel_addStudent.add(lbl_schoolName);
		
		lbl_grade = new JLabel("Grade:");
		lbl_grade.setBounds(12, 187, 107, 17);
		panel_addStudent.add(lbl_grade);
		
		panel_edit = new JPanel();
		frame.getContentPane().add(panel_edit, "panel_edit");
		panel_edit.setLayout(null);
		
		panel_view = new JPanel();
		frame.getContentPane().add(panel_view, "panel_view");
		panel_view.setLayout(null);
	}
}
