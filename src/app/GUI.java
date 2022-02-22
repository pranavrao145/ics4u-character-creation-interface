package app;

import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

  private JFrame frame;
  private JPanel panel_addStudent, panel_edit, panel_view;
  private JLabel lbl_schoolName, lbl_grade;
  private JTextField textField_name, textField_schoolName;
  private JComboBox<Integer> comboBox_age, comboBox_grade;

  public GUI() { initialize(); }

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

    JLabel lbl_name = new JLabel("Name:");
    lbl_name.setBounds(12, 48, 107, 17);
    panel_addStudent.add(lbl_name);

    JLabel lbl_age = new JLabel("Age:");
    lbl_age.setBounds(12, 91, 107, 17);
    panel_addStudent.add(lbl_age);

    lbl_schoolName = new JLabel("School Name:");
    lbl_schoolName.setBounds(12, 138, 107, 17);
    panel_addStudent.add(lbl_schoolName);

    lbl_grade = new JLabel("Grade:");
    lbl_grade.setBounds(12, 185, 107, 17);
    panel_addStudent.add(lbl_grade);

    textField_name = new JTextField();
    textField_name.setBounds(62, 46, 114, 21);
    panel_addStudent.add(textField_name);
    textField_name.setColumns(10);

    comboBox_age = new JComboBox<Integer>();
    comboBox_age.setBounds(62, 86, 31, 26);
    panel_addStudent.add(comboBox_age);

    textField_schoolName = new JTextField();
    textField_schoolName.setBounds(106, 136, 114, 21);
    panel_addStudent.add(textField_schoolName);
    textField_schoolName.setColumns(10);

    comboBox_grade = new JComboBox<Integer>();
    comboBox_grade.setBounds(62, 180, 31, 26);
    panel_addStudent.add(comboBox_grade);

    panel_edit = new JPanel();
    frame.getContentPane().add(panel_edit, "panel_edit");
    panel_edit.setLayout(null);

    panel_view = new JPanel();
    frame.getContentPane().add(panel_view, "panel_view");
    panel_view.setLayout(null);
  }

  public JFrame getFrame() { return frame; }
}
