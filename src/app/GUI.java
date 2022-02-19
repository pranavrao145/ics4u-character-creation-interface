package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class GUI {

	private JFrame frame;
	private JPanel panel_add;
	private JPanel panel_edit;
	private JPanel panel_view;

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
		
		panel_add = new JPanel();
		frame.getContentPane().add(panel_add, "panel_add");
		panel_add.setLayout(null);
		
		panel_edit = new JPanel();
		frame.getContentPane().add(panel_edit, "panel_edit");
		panel_edit.setLayout(null);
		
		panel_view = new JPanel();
		frame.getContentPane().add(panel_view, "panel_view");
		panel_view.setLayout(null);
	}

}
